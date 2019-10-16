package com.xds.recharge.common;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectLogs extends SysLog {

    private ThreadLocal<Long> startTime = new ThreadLocal();

    @Pointcut("execution(public * com.xds.recharge.controller.*.*(..))")
    public void AspectLogs(){}

    @Before("AspectLogs()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("CLASS_METHOD : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//        logger.info("ARGS : {}", Arrays.toString(joinPoint.getArgs()));
        Object[] args = joinPoint.getArgs();
        Object[] arguments  = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        logger.info("ARGS : {}", JSON.toJSONString(arguments));

    }

    @AfterReturning(returning = "ret", pointcut = "AspectLogs()")
    public void doAfterReturning(Object ret) throws Throwable {
        //处理完返回内容
        logger.info("SPEND TIME : {} ms", System.currentTimeMillis() - startTime.get());
        logger.info("RESPONSE : {}", JSON.toJSONString(ret));
        startTime.remove();
    }

}
