package com.x2yu.circle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 圈子信息表 
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_circle_info")
public class TblCircleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 圈子公告板
     */
    private String circleBoard;

    /**
     * 成员人数
     */
    private Integer memberNumber;

    /**
     * 所属分类id
     */
    private Integer categoryId;

    /**
     * 乐观锁
     */
    private Integer revision;

    /**
     * 圈子热度
     */
    private Integer hot;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
