package com.example.kaidun.utils.common.vo;

import com.example.kaidun.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2020/11/18 13:46
 * @description:
 */
@Data
public class BasePageVo extends BaseRequestVo {

    private Integer nowPage = 1;
    private Integer pageSize = 10;



    @Override
    public void checkParam() throws CommonServiceException {
        if (nowPage == null || nowPage <= 0) {
            throw new CommonServiceException(404, "页码参数不能为空或者小于0 1111");
        }
        if (pageSize == null || pageSize <= 0) {
            throw new CommonServiceException(404, "当页条数参数不能为空或者小于0");
        }

    }
}
