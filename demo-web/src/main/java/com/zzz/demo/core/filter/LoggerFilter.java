package com.zzz.demo.core.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zyn on 2015/12/15.
 */
public class LoggerFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");
        chain.doFilter(request, response);

    }

    public void destroy() {
        System.out.println("destroy");

    }
}
