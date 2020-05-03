package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblUserFollow;
import com.x2yu.circle.mapper.TblUserFollowMapper;
import com.x2yu.circle.service.ITblUserFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户关注表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-05-02
 */
@Service
public class TblUserFollowServiceImpl extends ServiceImpl<TblUserFollowMapper, TblUserFollow> implements ITblUserFollowService {

    @Autowired
    TblUserFollowMapper userFollowMapper;

    @Override
    public List<Integer> getUserFollowIds(Integer userId) {

        QueryWrapper<TblUserFollow> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);

        List<TblUserFollow> userFollows = userFollowMapper.selectList(wrapper);

        List<Integer> ids = userFollows.stream().map(TblUserFollow::getFollowId).collect(Collectors.toList());

        return ids;
    }
}
