package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.x2yu.circle.entity.TblDynamicInfo;
import com.x2yu.circle.mapper.TblDynamicInfoMapper;
import com.x2yu.circle.service.ITblDynamicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 动态信息表 服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
@Service
public class TblDynamicInfoServiceImpl extends ServiceImpl<TblDynamicInfoMapper, TblDynamicInfo> implements ITblDynamicInfoService {

    @Autowired
    TblDynamicInfoMapper dynamicInfoMapper;

    @Override
    public List<TblDynamicInfo> listDynamicScroll(List<Integer> ids, Integer index) {

        QueryWrapper<TblDynamicInfo> wrapper = new QueryWrapper<>();
        wrapper.in("user_id",ids)
                .orderByDesc("created_time")
                .last("limit " + index + ",2");

        return dynamicInfoMapper.selectList(wrapper);
    }

    @Override
    public Integer countDynamicByUserIds(List<Integer> ids) {

        QueryWrapper<TblDynamicInfo> wrapper = new QueryWrapper<>();
        wrapper.in("user_id",ids);
        return  dynamicInfoMapper.selectCount(wrapper);
    }
}
