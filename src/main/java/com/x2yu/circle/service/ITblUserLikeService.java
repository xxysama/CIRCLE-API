package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblUserLike;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

/**
 * <p>
 * 用户点赞关系表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-03-03
 */
public interface ITblUserLikeService extends IService<TblUserLike> {


    public boolean existUserBookLike(Integer commentId, Integer userId);

    public TblUserLike getOneByDes(TblUserLike userLike);

    /*
     *获取某一评论点赞数量
      *  */
    public  Integer getBookCommentsLikeNum(Integer commentId);
}
