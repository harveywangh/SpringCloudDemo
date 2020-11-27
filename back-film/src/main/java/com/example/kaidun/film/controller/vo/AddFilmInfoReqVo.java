package com.example.kaidun.film.controller.vo;

import com.example.kaidun.utils.common.vo.BaseRequestVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/18 16:21
 * @description:
 */
@Data
public class AddFilmInfoReqVo extends BaseRequestVo {
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String mainImgAddress;
    private String filmScore;
    private String filmScorers;
    private String preSaleNum;
    private String boxOffice;
    private String filmTypeId;
    private String filmSourceId;
    private String filmCatIds;
    private String areaId;
    private String dateId;
    private String filmTime;
    private String directorId;
    private String actIds;
    private String roleNames;
    private String filmLength;
    private String biography;
    private String filmImgs;

    @Override
    public void checkParam() throws CommonServiceException {
        //TODO
    }
}
