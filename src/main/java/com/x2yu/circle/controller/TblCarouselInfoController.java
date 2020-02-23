package com.x2yu.circle.controller;


import com.x2yu.circle.entity.TblCarouselInfo;
import com.x2yu.circle.service.ITblCarouselInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 走马灯展示信息表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-17
 */
@RestController
public class TblCarouselInfoController {

    @Autowired
    ITblCarouselInfoService carouselInfoService;

    @GetMapping("api/carousel/book")
    @ApiOperation("首页书籍跑马灯展示")
//    @ApiImplicitParam(name="bid",value = "书籍id",required = true,dataType = "Integer")
    public List<TblCarouselInfo> getBookCarouselInfo(){

        return carouselInfoService.getBookCarouselInfo();
    }
}
