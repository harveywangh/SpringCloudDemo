package com.example.kaidun.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.kaidun.hall.controller.vo.DescHallsRepsVo;
import com.example.kaidun.hall.controller.vo.DescHallsReqVo;
import com.example.kaidun.hall.controller.vo.SaveHallsReqVo;
import com.example.kaidun.utils.exception.CommonServiceException;

/**
 * @author: Administrator
 * @date: 2020/11/19 15:56
 * @description:
 */
public interface HallService {


    public IPage<DescHallsRepsVo> descHalls(DescHallsReqVo descHallsReqVo) throws CommonServiceException;

    public void saveHalls(SaveHallsReqVo saveHallsReqVo) throws CommonServiceException;
}
