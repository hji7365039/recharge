package com.xds.recharge.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xds.recharge.common.ResponseResult;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/*",filterName = "channelFilter")
public class MyFilter implements Filter {
    public ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        System.out.println(request.getRequestURI());
        //检查是否是登录页面
        if(request.getRequestURI().equals("/wx/getAccessToken")
                ||request.getRequestURI().indexOf(".")>=0
                ||request.getRequestURI().indexOf("base")>=0){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //检测用户是
            HttpSession session =request.getSession();
            System.out.println((String)session.getAttribute("openid"));
            if(session.getAttribute("openid")==null){
                try{
                    //response.sendRedirect("/base/unauthorized");
                    resultUnAuth(request,response);
                    return ;
                }catch (Exception e){}
            }else{
                String openid= (String)session.getAttribute("openid");
                if(openid.equals("")){
                    try{
                        //response.sendRedirect("/base/unauthorized");
                        resultUnAuth(request,response);
                        return ;
                    }catch (Exception e){}
                }

                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    private void resultUnAuth(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //设置响应头
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json");
        //设置返回的数据
        //写回给客户端
        /**ServiceStatus.USER_NOT_LOGIN.getValue()*/
        httpResponse.setStatus(200);
        PrintWriter out = httpResponse.getWriter();
        /**new Result<>(ServiceStatus.USER_NOT_LOGIN)*/
        out.write(objectMapper.writeValueAsString(ResponseResult.NoLogin("系统未登录")));
        //刷新和关闭输出流
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {

    }
}
