package com.ladyishenlong.springprojectzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        StringBuffer url = request.getRequestURL();
        log.info("请求地址：{}", url);
        return null;
    }


}
