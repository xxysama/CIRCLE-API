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
 * 评论表 
 * </p>
 *
 * @author x2yu
 * @since 2020-02-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TblCommentsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主题id
     */
    private Integer topicId;

    /**
     * 主题类型
     */
    private String topicType;

    /**
     * 点赞人数
     */
    private Integer likeNum;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论用户id
     */
    private Integer fromUid;

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
