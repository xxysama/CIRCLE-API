package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.dto.DynamicInfoDto;
import com.x2yu.circle.dto.DynamicInfoDtoPage;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblDynamicInfo;
import com.x2yu.circle.entity.TblDynamicPic;
import com.x2yu.circle.entity.TblUserFollow;
import com.x2yu.circle.mapper.TblDynamicInfoMapper;
import com.x2yu.circle.mapper.TblUserFollowMapper;
import com.x2yu.circle.service.*;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @GetMapping("list/{page}")
    @ApiOperation("获取用户动态列表")
    @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "Integer")
    public DynamicInfoDtoPage getDynamicByPage(@PathVariable("page")Integer page){

        // 分页查询每页的数据量
        Integer pageSize = 5;

        Page<TblDynamicInfo> dynamicInfoPage = new Page<>(page,pageSize);
        IPage<TblDynamicInfo> dynamicInfoIPage =dynamicInfoService.page(dynamicInfoPage);

        return iniDynamicInfoDtoPage(dynamicInfoIPage);
    }

    @GetMapping("search/{page}")
    @ApiOperation("搜索获取用户动态列表")
    @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "Integer")
    public DynamicInfoDtoPage searchDynamicsByDes(@RequestParam(value = "beginDate",required = false)String beginDate,
                                                  @RequestParam(value = "endDate",required = false)String endDate,
                                                  @RequestParam("des") String des,
                                                  @PathVariable("page")Integer page){

        // 获取模糊搜索是否查询到用户id集合

        IPage<TblDynamicInfo> dynamicInfoIPage = dynamicInfoService.searchDynamicByDes(beginDate,endDate,des,page);

        return iniDynamicInfoDtoPage(dynamicInfoIPage);
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


    @DeleteMapping("delete")
    @ApiOperation("根据动态id删除用户动态")
    public Result deleteDynamicById(@RequestBody TblDynamicInfo dynamicInfo){
        Integer dynamicId = dynamicInfo.getId();

        try {
            // 删除七牛云图床图片

            // 先删除关联图片表中信息
            QueryWrapper<TblDynamicPic> wrapper = new QueryWrapper<>();
            wrapper.eq("dynamic_id",dynamicId);
            dynamicPicService.remove(wrapper);

            //删除动态信息
            dynamicInfoService.removeById(dynamicId);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError();
        }
    }



    public List<DynamicInfoDto> initDynamicInfoDto(List<TblDynamicInfo> dynamicInfos){
        List<DynamicInfoDto> dynamicInfoDtos = new ArrayList<>();

        dynamicInfos.forEach(dynamicInfo -> {

            DynamicInfoDto dynamicInfoDto = new DynamicInfoDto();

            dynamicInfoDto.setDynamicId(dynamicInfo.getId());
            dynamicInfoDto.setUserName(userService.getById(dynamicInfo.getUserId()).getUserName());
            dynamicInfoDto.setContent(dynamicInfo.getContent());
            dynamicInfoDto.setCreateTime(dynamicInfo.getCreatedTime());
            dynamicInfoDto.setUpdateTime(dynamicInfo.getUpdateTime());

            //图片集合
            dynamicInfoDto.setPictureList(dynamicPicService.getDynamicPics(dynamicInfo.getId()));

            dynamicInfoDto.setLikeNum(userLikeService.getDynamicLikeNUm(dynamicInfo.getId()));
            dynamicInfoDto.setReplyCount(1);

            dynamicInfoDtos.add(dynamicInfoDto);
        });

        return dynamicInfoDtos;
    }

    public DynamicInfoDtoPage iniDynamicInfoDtoPage(IPage<TblDynamicInfo> dynamicInfoIPage){
        List<TblDynamicInfo> dynamicInfos = dynamicInfoIPage.getRecords();
        DynamicInfoDtoPage dynamicInfoDtoPage = new DynamicInfoDtoPage();

        // 设置
        dynamicInfoDtoPage.setRecords(initDynamicInfoDto(dynamicInfos));
        dynamicInfoDtoPage.setCurrent(dynamicInfoIPage.getCurrent());
        dynamicInfoDtoPage.setPages(dynamicInfoIPage.getPages());
        dynamicInfoDtoPage.setTotal(dynamicInfoIPage.getTotal());

        return dynamicInfoDtoPage;
    }

}
