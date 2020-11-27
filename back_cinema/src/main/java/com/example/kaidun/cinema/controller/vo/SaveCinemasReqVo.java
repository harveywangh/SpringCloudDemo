package com.example.kaidun.cinema.controller.vo;

import com.example.kaidun.utils.common.vo.BaseRequestVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/19 13:47
 * @description:
 */
@Data
public class SaveCinemasReqVo extends BaseRequestVo {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
