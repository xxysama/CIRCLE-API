package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.dto.CircleInfoDto;
import com.x2yu.circle.dto.CircleTopicDto;
import com.x2yu.circle.dto.SimpleBookDto;
import com.x2yu.circle.dto.TopicPageDto;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblCircleTopic;
import com.x2yu.circle.entity.TblTopicInfo;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.service.ITblCircleTopicService;
import com.x2yu.circle.service.ITblTopicInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 圈子话题关系表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-20
 */
@RestController
@RequestMapping("api/circle/topic/")
public class TblCircleTopicController {

    @Autowired
    ITblCircleTopicService circleTopicService;
    @Autowired
    ITblTopicInfoService topicInfoService;
    @Autowired
    ISecUserService userService;


//    @GetMapping("/{tid}")
//    @ApiOperation("根据id获取指定话题信息")
//    @ApiImplicitParam(name="tid",value = "话题id",required = true,dataType = "Integer")
//    public CircleInfoDto getCircleTopicByCid(@PathVariable("tid") Integer tid){
//
//    }


    @GetMapping("{cid}/{page}")
    @ApiOperation("不同圈子话题分页查询")
    @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "Integer")
    public TopicPageDto getCircleTopicByPage(@PathVariable("cid")Integer cid, @PathVariable("page") Integer page){

        Integer pageSize = 12; // 每页12个数据
        Integer current = page;// 默认第一页

        Page<TblCircleTopic> pages = new Page<>(current,pageSize);
        QueryWrapper<TblCircleTopic> wrapper = new QueryWrapper();
        wrapper.eq("circle_id",cid);
        // 分页查询圈子话题关系对象集合
        IPage<TblCircleTopic> circleTopicIPage = circleTopicService.page(pages,wrapper);


        // 获取书籍id集合
        List<TblCircleTopic> circleTopics = circleTopicIPage.getRecords();
        // java8使用流获取话筒id集合
        List<Integer> ids = circleTopics.stream().map(p -> p.getTopicId()).collect(Collectors.toList());

        //填充分页对象
        List<CircleTopicDto> circleTopicDtos = iniCirCleTopDto(topicInfoService.listByIds(ids));

        // 填充分页数据
        TopicPageDto topicPageDto = initTopicPageDto(circleTopicIPage,circleTopicDtos);

        return  topicPageDto;
    }

    // 填充话题对象传输载体
    private List<CircleTopicDto> iniCirCleTopDto(List<TblTopicInfo> tblTopicInfos){

        List<CircleTopicDto> circleTopicDtos = new ArrayList<>();

        tblTopicInfos.stream().forEach(topicInfo -> {
                CircleTopicDto circleTopicDto = new CircleTopicDto();
                circleTopicDto.setTopicId(topicInfo.getId());
                circleTopicDto.setTopicTitle(topicInfo.getTopicTitle());
                circleTopicDto.setTopicAuid(topicInfo.getTopicAuid());

                //查询作者姓名
                SecUser user = userService.getById(topicInfo.getTopicAuid());
                circleTopicDto.setAuthorName(user.getUserName());

                circleTopicDto.setReplyCount(topicInfo.getReplyCount());
                circleTopicDto.setTopicContent(topicInfo.getTopicContent());
                circleTopicDto.setCreatedTime(topicInfo.getCreatedTime());
                circleTopicDto.setUpdateTime(topicInfo.getUpdateTime());

                circleTopicDtos.add(circleTopicDto);
        });

        return circleTopicDtos;
    }


    private TopicPageDto initTopicPageDto(IPage iPage,List<CircleTopicDto> circleTopicDtos){
        // 填充分页数据
        TopicPageDto topicPageDto = new TopicPageDto();
        topicPageDto.setRecords(circleTopicDtos);
        topicPageDto.setTotal(iPage.getTotal());
        topicPageDto.setCurrent(iPage.getCurrent());
        topicPageDto.setPages(iPage.getPages());

        return  topicPageDto;
    }
}
