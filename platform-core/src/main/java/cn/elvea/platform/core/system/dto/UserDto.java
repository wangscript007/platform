package cn.elvea.platform.core.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * User
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto {
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
    private List<RoleDto> roles = Collections.emptyList();
}
