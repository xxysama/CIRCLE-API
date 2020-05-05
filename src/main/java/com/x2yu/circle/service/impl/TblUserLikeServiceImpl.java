package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblUserLike;
import com.x2yu.circle.mapper.TblUserLikeMapper;
import com.x2yu.circle.service.ITblUserLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户点赞关系表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-03-03
 */
@Service
public class TblUserLikeServiceImpl extends ServiceImpl<TblUserLikeMapper, TblUserLike> implements ITblUserLikeService {

    @Autowired
    TblUserLikeMapper likeMapper;

    @Override
    public boolean existUserLike(TblUserLike userLike) {

        QueryWrapper<TblUserLike> wrapper = new QueryWrapper();
        wrapper.eq("like_id",userLike.getLikeId())
                .eq("like_type",userLike.getLikeType())
                .eq("uid",userLike.getUid())
                .last("limit 1");

        if(likeMapper.selectList(wrapper).size()!= 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public TblUserLike getOneByDes(TblUserLike userLike) {
        QueryWrapper<TblUserLike> wrapper = new QueryWrapper<>();
        wrapper.eq("like_id",userLike.getLikeId())
                .eq("uid",userLike.getUid());
        return likeMapper.selectOne(wrapper);
    }

    @Override
    public Integer getBookCommentsLikeNum(Integer commentId) {
        QueryWrapper<TblUserLike> wrapper = new QueryWrapper();
        wrapper.eq("like_id",commentId)
                .eq("like_type","book")
                .eq("isvalid",true);
        return likeMapper.selectCount(wrapper);
    }

    @Override
    public Integer getDynamicLikeNUm(Integer dynamicId) {
        QueryWrapper<TblUserLike> wrapper = new QueryWrapper();
        wrapper.eq("like_id",dynamicId)
                .eq("like_type","dynamic")
                .eq("isvalid",true);
        return likeMapper.selectCount(wrapper);    }
}
