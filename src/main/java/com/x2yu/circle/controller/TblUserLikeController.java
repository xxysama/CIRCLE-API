package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblUserLike;
import com.x2yu.circle.service.ITblUserLikeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户点赞关系表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/api/like/")
public class TblUserLikeController {

    @Autowired
    ITblUserLikeService likeService;

    @PutMapping("/bookComment")
    @ApiOperation("更新点赞人数")
    public void updateBookLikeNum(@RequestBody TblUserLike userLike){


        // 如果已经点赞过了
        if(likeService.existUserBookLike(userLike.getLikeId(),userLike.getUid())){


            // 先查询本体
            TblUserLike tblUserLike = likeService.getOneByDes(userLike);

            tblUserLike.setIsvalid(!tblUserLike.getIsvalid());

            // 更新
            likeService.updateById(tblUserLike);
        }else {
            // 第一次点赞
            userLike.setLikeType("book");
            userLike.setIsvalid(true);

            likeService.save(userLike);
        }

    }

//    @GetMapping("getBook")
//    @Autowired("获取某一书籍的")
}
