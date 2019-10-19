package com.xds.recharge.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "channelFilter")
public class MyFilter implements Filter {


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
        if(request.getRequestURI().equals("/wx/getAccessToken")||request.getRequestURI().indexOf(".")>=0||request.getRequestURI().equals("/base/queryBalance")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //检测用户是
            HttpSession session =request.getSession();
            System.out.println((String)session.getAttribute("openid"));
            if(session.getAttribute("openid")==null){
                try{
                    response.sendRedirect("/wx/getAccessToken");
                }catch (Exception e){}
            }else{
                String openid= (String)session.getAttribute("openid");
                if(openid.equals("")){
                    try{
                        response.sendRedirect("/wx/getAccessToken");
                    }catch (Exception e){}
                }

                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
