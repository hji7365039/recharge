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
        if(request.getRequestURI().equals("/wx/getAccessToken")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
//        //检测用户是否登录
//        HttpSession session =request.getSession();
//        String status= (String) session.getAttribute("isLogin");
//        if(status==null || !status.equals("true"))
//        {
//            try{
//              response.sendRedirect("/wx/getAccessToken");
//              }catch (Exception e){}
//        }
    }

    @Override
    public void destroy() {

    }
}
