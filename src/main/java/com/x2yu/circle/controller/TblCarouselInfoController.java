package com.x2yu.circle.controller;


import com.x2yu.circle.entity.TblCarouselInfo;
import com.x2yu.circle.service.ITblCarouselInfoService;
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
    public List<TblCarouselInfo> getBookCarouselInfo(){

        return carouselInfoService.getBookCarouselInfo();
    }
}
