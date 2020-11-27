package com.example.kaidun.apigwzuul.filters;

import com.alibaba.fastjson.JSONObject;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.properties.JwtProperties;
import com.example.kaidun.utils.tools.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.JwtException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Administrator
 * @date: 2020/11/26 18:38
 * @description:
 */

public class JwtFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        // JWT工具类
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        JwtProperties jwtProperties = JwtProperties.getJwtProperties();


        RequestContext ctx = RequestContext.getCurrentContext();
        // 获取当前请求和返回值
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        // 提前设置请求继续，如果失败则修改此内容
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);

        //判断是否是登录，登录不需要验证JWT
        if (request.getServletPath().endsWith("/" + jwtProperties.getAuthPath())) {
            return null;
        }

        //测试-自定义 其他表头字段有效性
        /*final String requestHeaderType = request.getHeader("type");
        if(!"001".equals(requestHeaderType)){
            renderJson(ctx, response, BaseResponseVo.noLogin());
        }*/

        //1、验证tokrn有效性 -> 用户是否登陆过
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;


        //Bearer  header.payLoad.sign
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);

            //验证token是否过期,包含了验证jwt是否正确
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);//token是否过期
                if (flag) {
                    renderJson(ctx, response, BaseResponseVo.noLogin());
                } else {
                    //2、解析出JWT中的payLoad -> userId -> randomKey
                    String randomkey = jwtTokenUtil.getMd5KeyFromToken(authToken);
                    String userId = jwtTokenUtil.getUsernameFromToken(authToken);
                    //3、是否需要验签，以及验签的算法

                    //4、判断用户ID userid是否有效
                    //TODO
                    //查询验证是否有效
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                renderJson(ctx, response, BaseResponseVo.noLogin());
            }
        } else {
            //header没有带Bearer字段
            renderJson(ctx, response, BaseResponseVo.noLogin());
        }
        return null;
    }

    /**
     * 渲染json对象
     */
    public static void renderJson(RequestContext ctx, HttpServletResponse response, Object jsonObject) {
        // 设置终止请求
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        ctx.setSendZuulResponse(false);
        ctx.setResponseBody(JSONObject.toJSONString(jsonObject));
    }


}
