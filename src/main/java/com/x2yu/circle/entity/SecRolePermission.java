package com.x2yu.circle.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限关系表 
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SecRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限表ID
     */
    private Integer permissionId;

    /**
     * 角色表ID
     */
    private Integer roleId;

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
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
