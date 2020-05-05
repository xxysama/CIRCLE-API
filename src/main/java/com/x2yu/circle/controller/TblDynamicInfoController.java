package com.x2yu.circle.controller;


import com.x2yu.circle.dto.DynamicInfoDto;
import com.x2yu.circle.entity.TblDynamicInfo;
import com.x2yu.circle.entity.TblUserFollow;
import com.x2yu.circle.mapper.TblDynamicInfoMapper;
import com.x2yu.circle.mapper.TblUserFollowMapper;
import com.x2yu.circle.service.*;
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
 * 动态信息表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
@RestController
@RequestMapping("api/dynamic/")
public class TblDynamicInfoController {

    @Autowired
    ITblDynamicInfoService dynamicInfoService;

    @Autowired
    ITblUserFollowService userFollowService;
    @Autowired
    ITblDynamicPicService dynamicPicService;
    @Autowired
    ISecUserService userService;
    @Autowired
    ITblUserLikeService userLikeService;


    @PostMapping("submit")
    @ApiOperation("提交动态信息并且返回该条动态的主键Id给前端")
    public Result submitDynamic(@RequestBody TblDynamicInfo dynamicInfo){

        try {
            // 提交
            dynamicInfoService.save(dynamicInfo);
            // 返回动态的主键id
            return ResultUtil.success(dynamicInfo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError();
        }
    }

    @GetMapping("list/scroll")
    @ApiOperation("滚动加载好友动态，每次加载2条")
    public List<DynamicInfoDto> listDynamicScroll(@RequestParam Integer userId, @RequestParam Integer index){

        // 首先获取当前用户好友id集合
        List<Integer> ids = userFollowService.getUserFollowIds(userId);
        ids.add(userId);


        //获取动态集合
        List<TblDynamicInfo> dynamicInfos = dynamicInfoService.listDynamicScroll(ids,index);


        return initDynamicInfoDto(dynamicInfos);
    }

    @GetMapping("count/{userId}")
    @ApiOperation("获取该用户好友动态总条数，加上自身动态")
    public Integer getDynamicCount(@PathVariable("userId") Integer userId){
        // 先获取好友ids
        List<Integer> ids = userFollowService.getUserFollowIds(userId);
        ids.add(userId);

        return dynamicInfoService.countDynamicByUserIds(ids);
    }


    public List<DynamicInfoDto> initDynamicInfoDto(List<TblDynamicInfo> dynamicInfos){
        List<DynamicInfoDto> dynamicInfoDtos = new ArrayList<>();

        dynamicInfos.forEach(dynamicInfo -> {

            DynamicInfoDto dynamicInfoDto = new DynamicInfoDto();

            dynamicInfoDto.setDynamicId(dynamicInfo.getId());
            dynamicInfoDto.setUserName(userService.getById(dynamicInfo.getUserId()).getUserName());
            dynamicInfoDto.setContent(dynamicInfo.getContent());
            dynamicInfoDto.setCreateTime(dynamicInfo.getCreatedTime());

            //图片集合
            dynamicInfoDto.setPictureList(dynamicPicService.getDynamicPics(dynamicInfo.getId()));

            dynamicInfoDto.setLikeNum(userLikeService.getDynamicLikeNUm(dynamicInfo.getId()));
            dynamicInfoDto.setReplyCount(1);

            dynamicInfoDtos.add(dynamicInfoDto);
        });

        return dynamicInfoDtos;
    }

}
