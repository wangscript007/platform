package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * UserEntity
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_user")
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
     * 来源
     */
    private String source;
    /**
     * 启用状态
     */
    private Boolean active;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 修改人
     */
    private Long updatedBy;
    /**
     * 修改时间
     */
    private LocalDateTime updatedAt;
    /**
     * 来源标识
     */
    private String sourceId;
    /**
     * 来源编号
     */
    private String sourceCode;
    /**
     * 来源附加信息
     */
    private String sourceExtra;
}
