package com.example.apis.film.vo;

import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/18 16:09
 * @description: 根据单个ID查询影片信息
 */
@Data
public class DescribeFilmRespVo {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;

}
