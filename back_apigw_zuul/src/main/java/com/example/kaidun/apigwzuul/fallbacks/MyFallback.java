package com.example.kaidun.apigwzuul.fallbacks;

import com.alibaba.fastjson.JSONObject;
import com.example.kaidun.utils.common.vo.BaseResponseVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : harvey
 * @program :
 * @description : 业务降级处理
 **/
//@Component
public class MyFallback implements FallbackProvider {

    /**
     * 针对哪一个路由进行业务降级 可以写return  * 代表所有路由的公共返回
     * @return
     */
    @Override
    public String getRoute() {
        return "hall-service";
    }


    /**
     * 降级时的处理方式
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            /**
             * 业务降级处理方式
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                BaseResponseVo responseVO
                        = BaseResponseVo.serviceException(
                        new CommonServiceException(404, "请求有问题，请联系管理员"));
                String result = JSONObject.toJSONString(responseVO);
                return new ByteArrayInputStream(result.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}