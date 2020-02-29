package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblCommentsReply;
import com.x2yu.circle.mapper.TblCommentsReplyMapper;
import com.x2yu.circle.service.ITblCommentsReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论回复表 服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-29
 */
@Service
public class TblCommentsReplyServiceImpl extends ServiceImpl<TblCommentsReplyMapper, TblCommentsReply> implements ITblCommentsReplyService {

    @Autowired
    TblCommentsReplyMapper replyMapper;

    @Override
    public Integer countReply(Integer commentId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("comment_id",commentId);

        return replyMapper.selectCount(wrapper);
    }
}
