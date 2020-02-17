package com.x2yu.circle.service.impl;

import com.x2yu.circle.entity.TblCarouselInfo;
import com.x2yu.circle.mapper.TblCarouselInfoMapper;
import com.x2yu.circle.service.ITblCarouselInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 走马灯展示信息表 服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-17
 */
@Service
public class TblCarouselInfoServiceImpl extends ServiceImpl<TblCarouselInfoMapper, TblCarouselInfo> implements ITblCarouselInfoService {

    @Autowired
    TblCarouselInfoMapper carouselInfoMapper;

    @Override
    public List<TblCarouselInfo> getBookCarouselInfo() {
        return carouselInfoMapper.getBookCarouselInfo();
    }
}
