package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.dto.CommentsReplyDto;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblCommentsReply;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.service.ITblCommentsReplyService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // 获取评论中针对回复得二次以及多次回复
        Map<String,Object> replyMap = new HashMap<>();
        for(TblCommentsReply commentsReply: commentsReplyList){
            replyMap.put("reply_id",commentsReply.getId());
        }

        List<TblCommentsReply> commentsReplyListSub = replyService.listByMap(replyMap);

        commentsReplyList.addAll(commentsReplyListSub);


        return iniCommentsReply(commentsReplyList);
    }


    @PutMapping("submitReply")
    @ApiOperation("提交评论回复")
    public Result submitCommentsReply (@RequestBody TblCommentsReply commentsReply){
        System.out.println(commentsReply.toString());
        try {
            replyService.save(commentsReply);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError();
        }
    }

    private List<CommentsReplyDto> iniCommentsReply(List<TblCommentsReply> commentsReplyList){

        List<CommentsReplyDto> commentsReplyDtos = new ArrayList<>();

        for(TblCommentsReply commentsReply : commentsReplyList){
            CommentsReplyDto replyDto = new CommentsReplyDto();

            SecUser fromUser = userService.getById(commentsReply.getFromUid());
            replyDto.setReplyId(commentsReply.getId());
            replyDto.setCommentId(commentsReply.getCommentId());
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
