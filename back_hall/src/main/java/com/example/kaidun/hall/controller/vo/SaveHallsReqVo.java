package com.example.kaidun.hall.controller.vo;

import com.example.kaidun.utils.common.vo.BaseRequestVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/19 16:30
 * @description:
 */
@Data
public class SaveHallsReqVo extends BaseRequestVo {

    private String cinemaId;
    private String filmId;
    private String hallTypeId;
    private String beginTime;
    private String endTime;
    private String filmPrice;
    private String hallName;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
