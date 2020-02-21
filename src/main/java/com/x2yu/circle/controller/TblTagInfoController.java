package com.x2yu.circle.controller;


import com.x2yu.circle.dto.TagsItemDto;
import com.x2yu.circle.entity.TblTagInfo;
import com.x2yu.circle.service.ITblTagInfoService;
import com.x2yu.circle.service.ITblTagItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-21
 */
@RestController
@RequestMapping("api/tag/")
public class TblTagInfoController {

    @Autowired
    ITblTagInfoService tagInfoService;

    @Autowired
    ITblTagItemService tagItemService;

    @GetMapping("book/list")
    public List<TagsItemDto> getTagList(){
        List<TagsItemDto> tagsItemDtos = new ArrayList<>();

        List<TblTagInfo> tblTagInfos = tagInfoService.list();

        for(TblTagInfo tag: tblTagInfos){
            TagsItemDto tagsItemDto = new TagsItemDto();
            tagsItemDto.setTblTagInfo(tag);

            //查询tag目录下标签项
            Map<String,Object> columnMap = new HashMap<>();
            columnMap.put("tid",tag.getId());

            // 填充标签项
            tagsItemDto.setTagItemList(tagItemService.listByMap(columnMap));

            tagsItemDtos.add(tagsItemDto);

        }
        return tagsItemDtos;
    }
}
