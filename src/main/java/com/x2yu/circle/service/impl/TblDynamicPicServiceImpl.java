package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblDynamicPic;
import com.x2yu.circle.mapper.TblDynamicPicMapper;
import com.x2yu.circle.service.ITblDynamicPicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 动态图片关系表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
@Service
public class TblDynamicPicServiceImpl extends ServiceImpl<TblDynamicPicMapper, TblDynamicPic> implements ITblDynamicPicService {

    @Autowired
    TblDynamicPicMapper dynamicPicMapper;

    @Override
    public List<String> getDynamicPics(Integer dynamicId) {

        QueryWrapper<TblDynamicPic> wrapper = new QueryWrapper<>();
        wrapper.eq("dynamic_id",dynamicId);

        List<TblDynamicPic>list =  dynamicPicMapper.selectList(wrapper);

        return list.stream().map(TblDynamicPic::getPictureSrc).collect(Collectors.toList());
    }
}
