package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblTagItem;
import com.x2yu.circle.service.ITblTagItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签项表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-21
 */
@RestController
@RequestMapping("api/tagItem/")
public class TblTagItemController {

    @Autowired
    ITblTagItemService tagItemService;

    @GetMapping("list/{tid}")
    public List<TblTagItem> getTagItemList(@PathVariable("tid")Integer tid){

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("tid",tid);

        return tagItemService.listByMap(columnMap);
    }
}
