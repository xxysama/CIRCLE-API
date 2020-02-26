package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblAuthorInfo;
import com.x2yu.circle.mapper.TblAuthorInfoMapper;
import com.x2yu.circle.service.ITblAuthorInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 作者信息表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-26
 */
@Service
public class TblAuthorInfoServiceImpl extends ServiceImpl<TblAuthorInfoMapper, TblAuthorInfo> implements ITblAuthorInfoService {

    @Autowired
    TblAuthorInfoMapper authorInfoMapper;
    @Override
    public List<TblAuthorInfo> getAuthorBySearch(String des) {
        QueryWrapper<TblAuthorInfo> wrapper = new QueryWrapper<>();
        wrapper.like("author",des);

        return authorInfoMapper.selectList(wrapper);
    }

    @Override
    public TblAuthorInfo getAuthorByName(String author) {
        QueryWrapper<TblAuthorInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("author",author);
        return authorInfoMapper.selectOne(wrapper);
    }
}
