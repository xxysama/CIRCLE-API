package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.dto.CommentsReplyDto;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblCommentsReply;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.service.ITblCommentsReplyService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 评论回复表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-29
 */
@RestController
@RequestMapping("/api/reply/")
public class TblCommentsReplyController {

    @Autowired
    ITblCommentsReplyService replyService;
    @Autowired
    ISecUserService userService;

    @GetMapping("{commentId}")
    @ApiOperation("获取一条评论的回复")
    @ApiImplicitParam(name="bid",value = "书籍id",required = true,dataType = "Integer")
    public List<CommentsReplyDto> getCommentsReply(@PathVariable("commentId")Integer commentId){

        QueryWrapper<TblCommentsReply> wrapper = new QueryWrapper<>();
        wrapper.eq("reply_id",commentId);

        List<TblCommentsReply> commentsReplyList = replyService.list(wrapper);

        return iniCommentsReply(commentsReplyList);
    }


    private List<CommentsReplyDto> iniCommentsReply(List<TblCommentsReply> commentsReplyList){

        List<CommentsReplyDto> commentsReplyDtos = new ArrayList<>();

        for(TblCommentsReply commentsReply : commentsReplyList){
            CommentsReplyDto replyDto = new CommentsReplyDto();

            SecUser fromUser = userService.getById(commentsReply.getFromUid());
            replyDto.setFromUid(commentsReply.getFromUid());
            replyDto.setFromUserName(fromUser.getUserName());

            SecUser toUser = userService.getById(commentsReply.getToUid());
            replyDto.setToUid(commentsReply.getToUid());
            replyDto.setToUserName(toUser.getUserName());

            replyDto.setContent(commentsReply.getContent());
            replyDto.setReplyTime(commentsReply.getCreatedTime());

            commentsReplyDtos.add(replyDto);
        }

        return commentsReplyDtos;
    }
}
