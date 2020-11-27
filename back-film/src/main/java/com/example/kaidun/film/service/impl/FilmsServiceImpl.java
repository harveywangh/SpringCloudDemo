package com.example.kaidun.film.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.apis.film.vo.DescribeFilmRespVo;
import com.example.kaidun.film.controller.vo.AddFilmInfoReqVo;
import com.example.kaidun.film.controller.vo.DescribeActorsRespVo;
import com.example.kaidun.film.dao.entity.MoocFilmActorT;
import com.example.kaidun.film.dao.entity.MoocFilmInfoT;
import com.example.kaidun.film.dao.entity.MoocFilmT;
import com.example.kaidun.film.dao.mapper.MoocActorTMapper;
import com.example.kaidun.film.dao.mapper.MoocFilmActorTMapper;
import com.example.kaidun.film.dao.mapper.MoocFilmInfoTMapper;
import com.example.kaidun.film.dao.mapper.MoocFilmTMapper;
import com.example.kaidun.film.service.FilmsService;
import com.example.kaidun.utils.common.vo.BasePageVo;
import com.example.kaidun.utils.exception.CommonServiceException;
import com.example.kaidun.utils.tools.ToolUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: Administrator
 * @date: 2020/11/18 13:51
 * @description:
 */
@Slf4j
@Service
public class FilmsServiceImpl implements FilmsService {


    @Resource
    private MoocActorTMapper moocActorTMapper;

    @Resource
    private MoocFilmTMapper filmTMapper;


    @Resource
    private MoocFilmInfoTMapper filmInfoTMapper;

    @Resource
    MoocFilmActorTMapper filmActorTMapper;

    @Override
    public IPage<DescribeActorsRespVo> actorList(BasePageVo basePageVo) throws CommonServiceException {
        Page<DescribeActorsRespVo> page = new Page<>(basePageVo.getNowPage(), basePageVo.getPageSize());
        IPage<DescribeActorsRespVo> ipage = moocActorTMapper.selectActors(page);

        return ipage;
    }

    @Override
    public DescribeFilmRespVo describeFilmById(String filmId) throws CommonServiceException {

//        QueryWrapper<MoocFilmT> wrapper = new QueryWrapper();
//        wrapper.eq("UUID",filmId);
//        MoocFilmT obj = filmTMapper.selectOne(wrapper);

//        DescribeFilmRespVo describeFilmRespVo =new DescribeFilmRespVo();
        DescribeFilmRespVo describeFilmRespVo = filmTMapper.selectFilmById(filmId);
        return describeFilmRespVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addFilmInfo(AddFilmInfoReqVo saveFilmVo) throws CommonServiceException {
        try {
            //保存电影主表
            MoocFilmT filmT = new MoocFilmT();
            filmT.setFilmName(saveFilmVo.getFilmName());
            filmT.setFilmType(ToolUtils.str2Int(saveFilmVo.getFilmTypeId()));
            filmT.setImgAddress(saveFilmVo.getMainImgAddress());
            filmT.setFilmScore(saveFilmVo.getFilmScore());
            filmT.setFilmPresalenum(ToolUtils.str2Int(saveFilmVo.getPreSaleNum()));
            filmT.setFilmBoxOffice(ToolUtils.str2Int(saveFilmVo.getBoxOffice()));
            filmT.setFilmSource(ToolUtils.str2Int(saveFilmVo.getFilmSourceId()));
            filmT.setFilmCats(saveFilmVo.getFilmCatIds());
            filmT.setFilmArea(ToolUtils.str2Int(saveFilmVo.getAreaId()));
            filmT.setFilmDate(ToolUtils.str2Int(saveFilmVo.getDateId()));
           // filmT.setFilmTime(ToolUtils.str2LocalDateTime(saveFilmVo.getFilmTime() + " 00:00:00"));
            filmT.setFilmStatus(ToolUtils.str2Int(saveFilmVo.getFilmStatus()));
            filmTMapper.insert(filmT);

            //保存电影子表
            MoocFilmInfoT filmInfoT = new MoocFilmInfoT();
            filmInfoT.setFilmId(filmT.getUuid() + "");
            filmInfoT.setFilmEnName(saveFilmVo.getFilmEnName());
            filmInfoT.setFilmScore(saveFilmVo.getFilmSourceId());
            filmInfoT.setFilmScoreNum(ToolUtils.str2Int(saveFilmVo.getFilmScorers()));
            filmInfoT.setFilmLength(ToolUtils.str2Int(saveFilmVo.getFilmLength()));
            filmInfoT.setBiography(saveFilmVo.getBiography());
            filmInfoT.setDirectorId(ToolUtils.str2Int(saveFilmVo.getDirectorId()));
            filmInfoT.setFilmImgs(saveFilmVo.getFilmImgs());
            filmInfoTMapper.insert(filmInfoT);


            String[] actorIds = saveFilmVo.getActIds().split("#");
            String[] roleNames = saveFilmVo.getRoleNames().split("#");
            if (actorIds.length != roleNames.length) {
                throw new CommonServiceException(500, "演员和角色名数量不匹配");
            }

            for (int i = 0; i < actorIds.length; i++) {
                //保存演员映射表
                MoocFilmActorT filmActorT = new MoocFilmActorT();
                filmActorT.setFilmId(filmT.getUuid());
                filmActorT.setActorId(ToolUtils.str2Int(actorIds[i]));
//                filmActorT.setActorId(Integer.valueOf(actorIds[i]));
                filmActorT.setRoleName(roleNames[i]);
                filmActorTMapper.insert(filmActorT);
            }

        } catch (Exception e) {
            throw new CommonServiceException(500, e.getMessage());
        }
    }
}
