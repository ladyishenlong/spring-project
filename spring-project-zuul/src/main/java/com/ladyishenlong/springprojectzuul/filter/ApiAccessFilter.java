package com.ladyishenlong.springprojectzuul.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 统计接口耗时的过滤器
 */
@Slf4j
@WebFilter(filterName = "ApiAccessFilter", urlPatterns = "/*")
public class ApiAccessFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long start = System.currentTimeMillis(); // 请求进入时间

        filterChain.doFilter(servletRequest, servletResponse);
        log.info("{} 请求耗时：{}", request.getRequestURL(),
                System.currentTimeMillis() - start);
    }
}
