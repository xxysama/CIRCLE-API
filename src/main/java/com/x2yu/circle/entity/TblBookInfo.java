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
 * 书籍信息表 
 * </p>
 *
 * @author x2yu
 * @since 2020-02-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TblBookInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 书籍id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书籍名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 出版时间
     */
    private String publishTime;

    /**
     * 国际标准书号
     */
    private String isbn;

    /**
     * 封面
     */
    private String imgSrc;

    /**
     * 书籍简介
     */
    private String bookIntroduction;

    /**
     * 作者简介
     */
    private String authorIntroduction;

    /**
     * 评论表id字段
     */
    private Integer commmentsId;

    /**
     * 评分记录表id
     */
    private String scoreId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 乐观锁
     */
    private Integer revision;


}
