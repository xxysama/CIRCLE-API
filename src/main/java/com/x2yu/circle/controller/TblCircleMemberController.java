package com.x2yu.circle.controller;


import com.x2yu.circle.entity.TblCircleMember;
import com.x2yu.circle.service.ITblCircleInfoService;
import com.x2yu.circle.service.ITblCircleMemberService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 圈子成员表  前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
@RestController
@RequestMapping("api/circle/member/")
public class TblCircleMemberController {

    @Autowired
    ITblCircleMemberService circleMemberService;
    @Autowired
    ITblCircleInfoService circleInfoService;


    @PostMapping("apply")
    @ApiOperation("加入圈子")
    public Result applyCircle(@RequestBody TblCircleMember circleMember){

        try {
            // 判断是否加入过小组
            if(circleMemberService.alreadyApplyCircle(circleMember.getCircleId(),circleMember.getMemberId())){
                return ResultUtil.submitError("已经加入小组！");
            }
            circleMemberService.save(circleMember);

            // 暂定在这调用一次更新小组人数
            circleInfoService.flashCircleMember(circleMember.getCircleId());

            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError("申请失败！");
        }
    }
}
