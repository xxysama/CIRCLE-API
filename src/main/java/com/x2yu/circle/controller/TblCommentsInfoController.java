package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.dto.CommentsDto;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblCommentsInfo;
import com.x2yu.circle.entity.TblCommentsReply;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.service.ITblCommentsInfoService;
import com.x2yu.circle.service.ITblCommentsReplyService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 评论表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-29
 */
@RestController
@RequestMapping("/api/comments/")
public class TblCommentsInfoController {

    @Autowired
    ITblCommentsInfoService commentsInfoService;
    @Autowired
    ITblCommentsReplyService commentsReplyService;
    @Autowired
    ISecUserService userService;

    @GetMapping("book/{bid}")
    @ApiOperation("获取指定书籍评论")
    @ApiImplicitParam(name="bid",value = "书籍id",required = true,dataType = "Integer")
    public List<CommentsDto> getBookComments(@PathVariable("bid") Integer bid){

        QueryWrapper<TblCommentsInfo> wrapper = new QueryWrapper();
        wrapper
                .eq("topic_id",bid)
                .eq("topic_type","book");

        List<TblCommentsInfo> commentsInfos =  commentsInfoService.list(wrapper);


        return iniComment(commentsInfos);

    }

    @PostMapping("submit/book")
    @ApiOperation("提交评论")
    public Result submitComments(@RequestBody TblCommentsInfo commentsInfo){

        commentsInfo.setTopicType("book");

        try {
            commentsInfoService.save(commentsInfo);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.submitError();
        }
    }

    @PostMapping("reply")
    @ApiOperation("回复评论")
    public Result replyComments(@RequestBody TblCommentsReply commentsReply){

        try {
            commentsReplyService.save(commentsReply);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.submitError();
        }
    }



    // 填充数据
    private List<CommentsDto> iniComment(List<TblCommentsInfo> commentsInfos){


        List<CommentsDto> commentsDtos = new ArrayList<>();

        try {
            for(TblCommentsInfo commentsInfo:commentsInfos){

                // 获取评论用户
                SecUser user = userService.getById(commentsInfo.getFromUid());
                // 获取评论条数

                Integer replyCount = commentsReplyService.countReply(commentsInfo.getId());

                CommentsDto commentsDto = new CommentsDto();

                commentsDto.setUid(user.getUserId());
                commentsDto.setUserName(user.getUserName());
                // 头像初始化在这
                commentsDto.setCid(commentsInfo.getId());
                commentsDto.setLikeNum(commentsInfo.getLikeNum());
                commentsDto.setCommentsTime(commentsInfo.getCreatedTime());
                commentsDto.setContent(commentsInfo.getContent());
                commentsDto.setReplyCount(replyCount);

                commentsDtos.add(commentsDto);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return commentsDtos;
    }
}
