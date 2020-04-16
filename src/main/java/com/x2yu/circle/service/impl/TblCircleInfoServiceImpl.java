package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblCircleInfo;
import com.x2yu.circle.mapper.TblCircleInfoMapper;
import com.x2yu.circle.service.ITblCircleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 圈子信息表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
@Service
public class TblCircleInfoServiceImpl extends ServiceImpl<TblCircleInfoMapper, TblCircleInfo> implements ITblCircleInfoService {

    @Autowired
    TblCircleInfoMapper circleInfoMapper;

    @Override
    public List<TblCircleInfo> getTopCircleInfo(Integer cid) {

        QueryWrapper<TblCircleInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id",cid)
                    .orderByDesc("hot")
                    .last("limit 4");

        return circleInfoMapper.selectList(queryWrapper);
    }
}
