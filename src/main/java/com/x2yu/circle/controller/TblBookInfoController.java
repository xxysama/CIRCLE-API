package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.dto.BookPageDto;
import com.x2yu.circle.dto.DetailsBookDto;
import com.x2yu.circle.dto.SimpleBookDto;
import com.x2yu.circle.entity.TblAuthorInfo;
import com.x2yu.circle.entity.TblBookInfo;
import com.x2yu.circle.entity.TblBookTag;
import com.x2yu.circle.service.ITblAuthorInfoService;
import com.x2yu.circle.service.ITblBookInfoService;
import com.x2yu.circle.service.ITblBookTagService;
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
    @Autowired
    ITblBookTagService bookTagService;

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

        List<TblBookInfo> bookInfos = bookInfoService.getHomeBooks();

        List<SimpleBookDto> bookDtos = initSimpleBookDto(bookInfos);

        return bookDtos;
    }

    @GetMapping("rand5/{bid}")
    @ApiOperation("根据书籍id随机获取同作者的5本书籍")
    @ApiImplicitParam(name="bid",value = "书籍id",required = true,dataType = "Integer")
    public  List<SimpleBookDto> getRandFiveBooks(@PathVariable("bid") Integer bid){

        Integer authorId = bookInfoService.getById(bid).getAuthorId();

        List<TblBookInfo> bookInfos = bookInfoService.getRandFiveByAuthorId(bid,authorId);

        List<SimpleBookDto> bookDtos = initSimpleBookDto(bookInfos);

        return bookDtos;
    }

    @GetMapping("search/{des}")
    @ApiOperation("根据输入内容模糊搜索")
    @ApiImplicitParam(name = "des",value = "描述",required = true,dataType = "String")
    public List<SimpleBookDto>  getBookListBySearch(@PathVariable("des")String des){

        // 根据作者名称搜索的话 先获取作者信息集合

        List<TblAuthorInfo> authorInfos = authorInfoService.getAuthorBySearch(des);
        // 初始化为0
        Integer authorId = 0;
        if(authorInfos.size() != 0){
            //默认获取集合第一个id
            authorId = authorInfos.get(0).getId();
        }

        List<SimpleBookDto> bookDtos = initSimpleBookDto(bookInfoService.getBookListBySearch(des,authorId));

        return bookDtos;
    }

    @GetMapping("page/{page}")
    @ApiOperation("分页测试")
    @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "Integer")
    public BookPageDto getBooksDtoByPage(@PathVariable("page")Integer current){

        // 分页查询每页的数据量
        Integer pageSize = 12;

        Page<TblBookInfo> pages = new Page<>(current,pageSize);

        // 获取查询分页数据
        IPage<TblBookInfo> bookInfoIPage = bookInfoService.page(pages);

        // 填充分页数据
        List<SimpleBookDto> bookDtos = initSimpleBookDto(bookInfoIPage.getRecords());

        // 填充分页数据
        BookPageDto bookPageDto = initPageData(bookInfoIPage,bookDtos);

        return bookPageDto;
    }

    @GetMapping("tag/{tid}/{page}")
    @ApiOperation("根据标签分页查询书籍信息")
    @ApiImplicitParam(name = "tid",value = "标签",required = true,dataType = "Integer")
    public  BookPageDto getBookDtoByTag(@PathVariable("tid")Integer tid,@PathVariable("page") Integer page){
        // 根据标签id 查询书籍id集合
        Integer pageSize = 12; // 每页12个数据
        Integer current = page;// 默认第一页

        Page<TblBookTag> pages = new Page<>(current,pageSize);
        QueryWrapper<TblBookTag> wrapper = new QueryWrapper();
        wrapper.eq("tid",tid);

        // 分页查询
        IPage<TblBookTag> bookTagPage = bookTagService.page(pages,wrapper);

        // 获取书籍id集合
        List<TblBookTag> bookTags = bookTagPage.getRecords();

        List<Integer> bidList = new ArrayList<>();
        for(TblBookTag bookTag: bookTags){
            bidList.add(bookTag.getBid());
        }

        // 填充分页数据
        List<SimpleBookDto> bookDtos  = initSimpleBookDto(bookInfoService.listByIds(bidList));

        // 填充分页数据
        BookPageDto bookPageDto = initPageData(bookTagPage,bookDtos);

        return  bookPageDto;
    }



    // 填充BookDto数据
    private List<SimpleBookDto> initSimpleBookDto(List<TblBookInfo> bookInfos){
        List<SimpleBookDto> bookDtos = new ArrayList<>(12);

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

    // 填充分页数据
    private BookPageDto initPageData(IPage iPage,List<SimpleBookDto> bookDtos){
        // 填充分页数据
        BookPageDto bookPageDto = new BookPageDto();
        bookPageDto.setRecords(bookDtos);
        bookPageDto.setTotal(iPage.getTotal());
        bookPageDto.setCurrent(iPage.getCurrent());
        bookPageDto.setPages(iPage.getPages());

        return  bookPageDto;
    }


}
