package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblUserFollow;
import com.x2yu.circle.service.ITblUserFollowService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户关注表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-05-02
 */
@RestController
@RequestMapping("api/userfollow/")
public class TblUserFollowController {

    @Autowired
    ITblUserFollowService userFollowService;

    @PutMapping("apply")
    @ApiOperation("用户关注")
    public Result updateUserFollow(@RequestBody TblUserFollow userFollow){

        QueryWrapper<TblUserFollow> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userFollow.getUserId())
                .eq("follow_id",userFollow.getFollowId());

        try {
            // 已经有关注关系 更新相反
            if(userFollowService.count(wrapper) > 0){
                userFollow = userFollowService.getOne(wrapper);
                userFollow.setIsvalid(!userFollow.getIsvalid());

                userFollowService.update(userFollow,wrapper);
                return ResultUtil.success();
            }else{

                userFollow.setIsvalid(true);
                userFollowService.save(userFollow);
                return ResultUtil.success();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError();
        }

    }
}
