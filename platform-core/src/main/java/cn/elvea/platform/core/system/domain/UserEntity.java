package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.persistence.jdbc.domain.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table("sys_user")
public class UserEntity extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 全名
     */
    private String fullname;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 备注
     */
    private String description;
    /**
     * 有效期开始时间
     */
    private LocalDateTime startDate;
    /**
     * 有效期结束时间
     */
    private LocalDateTime endDate;
    /**
     * 入职日期
     */
    private LocalDate entryDate;
    /**
     * 离职日期
     */
    private LocalDate resignationDate;
    /**
     * 注册时间
     */
    private LocalDateTime registerAt;
    /**
     * 审批时间
     */
    private LocalDateTime approvalAt;
    /**
     * 审批人
     */
    private Long approvalBy;
    /**
     * 用户状态
     */
    private String status;
    /**
     * 启用状态
     */
    private Boolean active;
    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createdAt;
    /**
     * 创建人
     */
    @CreatedBy
    private Long createdBy;
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
    /**
     * 最后修改人
     */
    @LastModifiedBy
    private Long lastModifiedBy;
    /**
     * 删除时间
     */
    private LocalDateTime deletedAt;
    /**
     * 删除人
     */
    private String deletedBy;
    /**
     * 来源
     */
    private String source;
    /**
     * 来源标识
     */
    private String sourceKey;
    /**
     * 来源信息
     */
    private String sourceExtra;
}
