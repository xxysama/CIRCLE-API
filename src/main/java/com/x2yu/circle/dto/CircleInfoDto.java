package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/4/16 19:06
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CircleInfoDto {

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 分类id
     */
    private String categoryName;

    /**
     * 分类类别
     */
    private String categoryType;

    /*
    * 所属分类下展示圈子信息
    * **/
    private List<CircleSimpleInfoDto> circleSimpleInfoDtos;

}
