package com.x2yu.circle.controller;


import com.x2yu.circle.entity.TblBookInfo;
import com.x2yu.circle.service.ITblBookInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 书籍信息表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-14
 */
@RestController
@RequestMapping("api/book/")
public class TblBookInfoController {

    @Autowired
    ITblBookInfoService bookInfoService;


    @GetMapping("{id}")
    @ApiOperation("根据id获取书籍信息")
    @ApiImplicitParam(name="id",value = "书籍id",required = true,dataType = "Integer")
    public TblBookInfo getBookById(@PathVariable("id") Integer id){
        return bookInfoService.getById(id);
    }

    @GetMapping("list/latest")
    @ApiOperation("获取首页最新展示书籍信息")
    public List<TblBookInfo> getHomeBooks(){
        return bookInfoService.getHomeBooks();
    }

    @GetMapping("rand5/{bid}")
    @ApiOperation("根据书籍id随机获取同作者的5本书籍")
    @ApiImplicitParam(name="bid",value = "书籍id",required = true,dataType = "Integer")
    public  List<TblBookInfo> getRandFiveBooks(@PathVariable("bid") Integer bid){

        String author = bookInfoService.getById(bid).getAuthor();

        return bookInfoService.getRandFiveByAuthor(author);
    }

    @GetMapping("search/{des}")
    @ApiOperation("根据输入内容模糊搜索")
    @ApiImplicitParam(name = "des",value = "描述",required = true,dataType = "String")
    public List<TblBookInfo> getBookListBySearch(@PathVariable("des")String des){
        return bookInfoService.getBookListBySearch(des);
    }
}
