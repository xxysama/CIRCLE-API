package com.x2yu.circle.controller;


import com.x2yu.circle.dto.CircleInfoDto;
import com.x2yu.circle.dto.TopicPageDto;
import com.x2yu.circle.entity.TblCircleTopic;
import com.x2yu.circle.service.ITblCircleTopicService;
import com.x2yu.circle.service.ITblTopicInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 圈子话题关系表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-20
 */
@RestController
@RequestMapping("/circle/topic/")
public class TblCircleTopicController {

    @Autowired
    ITblCircleTopicService circleTopicService;
    @Autowired
    ITblTopicInfoService topicInfoService;


    @GetMapping("/{tid}")
    @ApiOperation("根据id获取指定话题信息")
    @ApiImplicitParam(name="tid",value = "话题id",required = true,dataType = "Integer")
    public CircleInfoDto getCircleTopicByCid(@PathVariable("tid") Integer tid){

    }


    @GetMapping("{cid}/{page}")
    @ApiOperation("不同圈子话题分页查询")
    @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "Integer")
    public TopicPageDto getCircleTopicByPage(@PathVariable("cid")Integer cid, @PathVariable("page") Integer page){

        Integer pageSize = 12; // 每页12个数据
        Integer current = page;// 默认第一页


    }
}
