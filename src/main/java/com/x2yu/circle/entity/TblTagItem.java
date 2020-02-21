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
 * 标签项表
 * </p>
 *
 * @author x2yu
 * @since 2020-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TblTagItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签项id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签项名字
     */
    private String tagItemName;

    /**
     * 主标签id
     */
    private Integer tid;

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
