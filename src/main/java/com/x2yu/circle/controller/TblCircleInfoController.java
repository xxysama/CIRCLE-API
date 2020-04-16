package com.x2yu.circle.controller;


import com.x2yu.circle.dto.CircleInfoDto;
import com.x2yu.circle.dto.CircleSimpleInfoDto;
import com.x2yu.circle.entity.TblCarouselInfo;
import com.x2yu.circle.entity.TblCategoryInfo;
import com.x2yu.circle.entity.TblCircleInfo;
import com.x2yu.circle.service.ITblCategoryInfoService;
import com.x2yu.circle.service.ITblCircleInfoService;
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
 * 圈子信息表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
@RestController
@RequestMapping("/api/circle/")
public class TblCircleInfoController {

    @Autowired
    ITblCircleInfoService circleInfoService;
    @Autowired
    ITblCategoryInfoService categoryInfoService;

    @GetMapping("init")
    @ApiOperation("根据圈子分类id查询信息")
    public List<CircleInfoDto> getCircleInfoPageByCid(){

        List<CircleInfoDto> circleInfoDtos = new ArrayList<>();

        // 圈子分类id集合获取
        List<TblCategoryInfo> categoryInfos = categoryInfoService.list();

//        // java8使用流获取某一列数据
//        List<Integer> ids = categoryInfos.stream().map(TblCategoryInfo::getId).collect(Collectors.toList());

        categoryInfos.forEach(categoryInfo -> {
            CircleInfoDto infoDto = new CircleInfoDto();

            infoDto.setCategoryId(categoryInfo.getId());
            infoDto.setCategoryName(categoryInfo.getCategoryName());
            infoDto.setCategoryType(categoryInfo.getCategoryType());

            // 查询每个分类下的展示圈子
            List<CircleSimpleInfoDto> simpleInfoDtos = intiCircleSimpleInfo(circleInfoService.getTopCircleInfo(categoryInfo.getId()));
            infoDto.setCircleSimpleInfoDtos(simpleInfoDtos);

            circleInfoDtos.add(infoDto);
        });


        return circleInfoDtos;
    }

    @GetMapping("topic")
    @ApiOperation("获取最热门小组信息")
    public List<CircleSimpleInfoDto> getTopicCircleInfo(){

        return  intiCircleSimpleInfo(circleInfoService.getTopicCircleInfo());
    }

    // 填充CircleInfoDto数据


    // 填充CircleSimpleInfoDto数据
    private List<CircleSimpleInfoDto> intiCircleSimpleInfo(List<TblCircleInfo> circleInfos){
        List<CircleSimpleInfoDto> simpleInfoDtos = new ArrayList<>();

        for(TblCircleInfo circleInfo : circleInfos){
            CircleSimpleInfoDto infoDto = new CircleSimpleInfoDto();
            infoDto.setId(circleInfo.getId());
            infoDto.setCircleName(circleInfo.getCircleName());
            infoDto.setCategoryId(circleInfo.getCategoryId());
            infoDto.setCircleImg(circleInfo.getCircleImg());
            infoDto.setCircleMotto(circleInfo.getCircleMotto());
            infoDto.setMemberNumber(circleInfo.getMemberNumber());
            infoDto.setHot(circleInfo.getHot());

            simpleInfoDtos.add(infoDto);
        }

        return simpleInfoDtos;
    }
}
