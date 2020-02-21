package com.x2yu.circle.controller;


import com.x2yu.circle.entity.TblBookInfo;
import com.x2yu.circle.service.ITblBookInfoService;
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
    public TblBookInfo getBookById(@PathVariable("id") Integer id){
        return bookInfoService.getById(id);
    }

    @GetMapping("list/latest")
    public List<TblBookInfo> getHomeBooks(){
        return bookInfoService.getHomeBooks();
    }

    @GetMapping("rand5/{bid}")
    public  List<TblBookInfo> getRandFiveBooks(@PathVariable("bid") Integer bid){

        String author = bookInfoService.getById(bid).getAuthor();

        return bookInfoService.getRandFiveByAuthor(author);
    }
}
