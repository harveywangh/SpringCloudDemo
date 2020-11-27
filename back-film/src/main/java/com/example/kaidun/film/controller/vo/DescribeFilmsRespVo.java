package com.example.kaidun.film.controller.vo;

import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/18 16:11
 * @description:
 */
@Data
public class DescribeFilmsRespVo {

    private String filmId;
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String filmScore;
    private String preSaleNum;
    private String boxOffice;
    private String filmTime;
    private String filmLength;
    private String mainImg;

}
