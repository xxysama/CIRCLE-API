package com.x2yu.circle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户点赞关系表 
 * </p>
 *
 * @author x2yu
 * @since 2020-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TblUserLike implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 点赞用户id
     */
    private Integer uid;

    /**
     * 点赞主题id
     */
    private Integer likeId;

    /**
     * 点赞主题类型
     */
    private String likeType;

    /**
     * 是否有效
     */
    private Boolean isvalid;

    /**
     * 乐观锁
     */
    private Integer revision;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
