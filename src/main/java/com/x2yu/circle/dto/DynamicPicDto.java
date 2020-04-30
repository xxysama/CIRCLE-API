package com.x2yu.circle.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.x2yu.circle.entity.TblDynamicPic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/4/26 0:01
 * @Describe：前端动态图片关系传输对象
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DynamicPicDto implements Serializable {

    private  List<TblDynamicPic> dynamicPics;

}
