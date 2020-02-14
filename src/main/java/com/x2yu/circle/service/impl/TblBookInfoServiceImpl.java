package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.x2yu.circle.entity.TblBookInfo;
import com.x2yu.circle.mapper.TblBookInfoMapper;
import com.x2yu.circle.service.ITblBookInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 书籍信息表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-14
 */
@Service
public class TblBookInfoServiceImpl extends ServiceImpl<TblBookInfoMapper, TblBookInfo> implements ITblBookInfoService {

    @Autowired
    TblBookInfoMapper bookInfoMapper;
    @Override
    public List<TblBookInfo> getHomeBooks() {

        QueryWrapper<TblBookInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("public_time");

        return bookInfoMapper.getHomeBooks();
    }
}
