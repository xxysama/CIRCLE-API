package com.x2yu.circle.controller;


import com.x2yu.circle.dto.DetailsBookDto;
import com.x2yu.circle.dto.SimpleBookDto;
import com.x2yu.circle.entity.TblAuthorInfo;
import com.x2yu.circle.entity.TblBookInfo;
import com.x2yu.circle.service.ITblAuthorInfoService;
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
    @Autowired
    ITblAuthorInfoService authorInfoService;

    @GetMapping("{id}")
    @ApiOperation("根据id获取书籍信息")
    @ApiImplicitParam(name="id",value = "书籍id",required = true,dataType = "Integer")
    public DetailsBookDto getBookById(@PathVariable("id") Integer id){

        DetailsBookDto bookDto = new DetailsBookDto();

        TblBookInfo bookInfo = bookInfoService.getById(id);

        // 初始化数据
        bookDto.setBookId(bookInfo.getId());
        bookDto.setBookName(bookInfo.getBookName());
        bookDto.setImgSrc(bookInfo.getImgSrc());
        bookDto.setBookIntroduction(bookInfo.getBookIntroduction());
        bookDto.setPublisher(bookInfo.getPublisher());
        bookDto.setPublishTime(bookInfo.getPublishTime());
        bookDto.setIsbn(bookInfo.getIsbn());

        // 根据作者id 查询作者信息
        TblAuthorInfo authorInfo = authorInfoService.getById(bookInfo.getAuthorId());
        bookDto.setAuthor(authorInfo.getAuthor());
        bookDto.setAuthorIntroduction(authorInfo.getAuthorIntroduction());


        return bookDto;
    }


    @GetMapping("list/latest")
    @ApiOperation("获取首页最新展示书籍信息")
    public List<SimpleBookDto> getSimpleBoos(){
        List<SimpleBookDto> bookDtos = new ArrayList<>(12);

        List<TblBookInfo> bookInfos = bookInfoService.getHomeBooks();

        for(TblBookInfo bookInfo:bookInfos){
            SimpleBookDto bookDto = new SimpleBookDto();
            bookDto.setBookId(bookInfo.getId());
            bookDto.setBookName(bookInfo.getBookName());
            bookDto.setImgSrc(bookInfo.getImgSrc());
            bookDto.setBookIntroduction(bookInfo.getBookIntroduction());
            bookDto.setPublisher(bookInfo.getPublisher());
            bookDto.setPublishTime(bookInfo.getPublishTime());

            // 根据作者id 查询作者信息
            TblAuthorInfo authorInfo = authorInfoService.getById(bookInfo.getAuthorId());
            bookDto.setAuthor(authorInfo.getAuthor());

            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

//    @GetMapping("rand5/{bid}")
//    @ApiOperation("根据书籍id随机获取同作者的5本书籍")
//    @ApiImplicitParam(name="bid",value = "书籍id",required = true,dataType = "Integer")
//    public  List<TblBookInfo> getRandFiveBooks(@PathVariable("bid") Integer bid){
//
//        String author = bookInfoService.getById(bid).getAuthor();
//
//        return bookInfoService.getRandFiveByAuthor(author);
//    }

    @GetMapping("search/{des}")
    @ApiOperation("根据输入内容模糊搜索")
    @ApiImplicitParam(name = "des",value = "描述",required = true,dataType = "String")
    public List<TblBookInfo> getBookListBySearch(@PathVariable("des")String des){
        return bookInfoService.getBookListBySearch(des);
    }
}
