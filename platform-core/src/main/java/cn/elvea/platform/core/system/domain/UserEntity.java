package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * UserEntity
 *
 * @author elvea
 */
@Data
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
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户状态
     */
    private String status;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 修改时间
     */
    private String updatedAt;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 用户角色
     */
    @Transient
    private List<RoleEntity> roles = Lists.newArrayList();
}
