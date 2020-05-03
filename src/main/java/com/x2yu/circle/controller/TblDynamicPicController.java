package com.x2yu.circle.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.x2yu.circle.entity.TblDynamicPic;
import com.x2yu.circle.service.ITblDynamicPicService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 动态图片关系表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
@RestController
@RequestMapping("api/dynamic/pic/")
public class TblDynamicPicController {

    @Autowired
    ITblDynamicPicService dynamicPicService;

    @PostMapping("submit")
    @ApiOperation("动态中图片提交接口")
    public Result submitDynamicPic(@RequestBody String tblDynamicPics){

        JSONObject jsonObject = JSONObject.parseObject(tblDynamicPics);
        JSONArray jsonArray = (JSONArray)jsonObject.get("dynamicPics");
        List<TblDynamicPic> dynamicPics = (List<TblDynamicPic>) JSONArray.parseArray(jsonArray.toString(),TblDynamicPic.class);

        try {
                dynamicPicService.saveBatch(dynamicPics);
                return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError("图片信息储存失败!");
        }
    }
}
