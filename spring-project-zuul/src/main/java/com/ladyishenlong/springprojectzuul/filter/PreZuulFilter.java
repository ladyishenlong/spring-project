package com.ladyishenlong.springprojectzuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Slf4j
@Component
public class PreZuulFilter extends ZuulFilter {

    /**
     * 前置过滤器。
     * 但是在 zuul 中定义了四种不同生命周期的过滤器类型：
     * 1、pre：请求在路由之前被调用,如:身份验证；
     * 2、route：请求在路由时被调用；
     * 3、post：路由到微服务之后执行(在route和error过滤器之后被调用)；
     * 4、error：处理请求发生错误时被调用；
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的优先级，数字越大，优先级越低。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器。
     * true：说明需要过滤；
     * false：说明不要过滤；
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //添加请求头
        requestContext.addZuulRequestHeader("test", "zuul test header");

        HttpServletRequest request = requestContext.getRequest();
        StringBuffer url = request.getRequestURL();
        log.info("请求地址：{}", url);


        //从security之中取出用户信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.info("----登录的用户名：{}----", auth.getName());
            requestContext.addZuulRequestHeader("username", auth.getName());
        }

        //以下是来获取更多信息
//        if (auth != null) {
//            log.info("----有用户：{}----", auth.getName());
//            Object principal = auth.getPrincipal();
//            if (principal instanceof UserDetails) {
//                //获得用户名，放入请求头之中，传给其他服务用户信息
//                log.info("用户1：{}", ((UserDetails) principal).getUsername());
//            }
//
//            if (principal instanceof Principal) {
//                log.info("用户2：{}", ((Principal) principal).getName());
//            }
//        } else log.info("----没有用户----");


        //要求请求的需要token
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            log.info("没有token");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


}
