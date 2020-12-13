package com.example.kaidun.apigwzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : jiangzh
 * @description : 解决跨域问题
 **/
@Component
public class CorsFilter extends ZuulFilter {

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // 跨域
        HttpServletResponse response = ctx.getResponse();
        response.addHeader("Access-Control-Allow-Origin", "*"); //允许所有的来源  比如：生产环境一般admin.meeting.com域名访问
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");//允许来访的头信息  跨域一定要开启OPTIONS  需要OPTIONS探测
        response.setHeader("Access-Control-Allow-Headers","DNT,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Range,Authorization");//允许那些头跨域传过来
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /**
         * 核心点
         *
         * 跨域资源共享
         *   -这是HTTP协议规定的安全策略
         *   -配置资源共享的方式和目标方
         *
         * 比如：跨域
         *   前端：node+vue -> admin.com
         *   后端：springBoot ->  back.com
         *
         *   --》示例
         *   缺陷：如果出现跨域策略不足的情况，需要修改代码重新部署
         *   --》Nginx配置跨域 111
         */







        return null;
    }

}