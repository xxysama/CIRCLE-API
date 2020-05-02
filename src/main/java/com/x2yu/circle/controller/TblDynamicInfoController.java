package com.x2yu.circle.controller;


import com.x2yu.circle.entity.TblDynamicInfo;
import com.x2yu.circle.mapper.TblDynamicInfoMapper;
import com.x2yu.circle.service.ITblDynamicInfoService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 动态信息表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
@RestController
@RequestMapping("api/circle/dynamic/")
public class TblDynamicInfoController {

    @Autowired
    ITblDynamicInfoService dynamicInfoService;
    @Autowired
    TblDynamicInfoMapper dynamicInfoMapper;

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

    @GetMapping("list/")
    @ApiOperation("滚动加载好友动态，每次加载5条")
    public void listDynamicScroll(){

    }

}
