package com.example.kaidun.hall.apis;

import com.example.apis.film.api.FilmFeignApis;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Administrator
 * @date: 2020/11/25 15:41
 * @description: film提供的接口服务
 */


@FeignClient(name = "film-service")
public interface FilmFeignApi extends FilmFeignApis {

}
