package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: x2yu
 * @Date: 2020/4/16 15:40
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CircleSimpleInfoDto {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 圈子名称
     */
    private String circleName;

    /**
     * 圈子封面图片
     */
    private String circleImg;

    /**
     * 圈子座右铭
     */
    private String circleMotto;

    /**
     * 成员人数
     */
    private Integer memberNumber;

    /**
     * 所属分类id
     */
    private Integer categoryId;

    /**
     * 热度
     */
    private Integer hot;
}
