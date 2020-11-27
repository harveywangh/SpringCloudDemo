package com.example.kaidun.hall.controller.vo;

import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/19 16:08
 * @description:
 */
@Data
public class DescHallsReqVo extends BasePageVo {

    private String cinemaId;


    @Override
    public void checkParam() throws CommonServiceException {
        if ("".equals(cinemaId)) {
            throw new CommonServiceException(404, "id不能为空");
        }
        super.checkParam();
    }


}
