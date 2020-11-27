package com.example.kaidun.apigwzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: Administrator
 * @date: 2020/11/26 16:37
 * @description:
 */
@Slf4j
public class MyFilter extends ZuulFilter {

    /**
     * filterType 类型    pre ---xx---post  前置--xxx--后置
     *
     * @return
     */

    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * filter执行顺序
     * 排序 越大越靠后
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要拦截
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Filter  具体业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //ThreadLocal
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            log.info("headerName:{},headerValue:{}",headerName,request.getHeader(headerName));
        }
//        request.get


//        HttpServletResponse response = requestContext.getResponse();
        return null;
    }
}
