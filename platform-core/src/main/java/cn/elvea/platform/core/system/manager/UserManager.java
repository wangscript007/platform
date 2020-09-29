package cn.elvea.platform.core.system.manager;

import cn.elvea.platform.commons.service.Manager;
import cn.elvea.platform.core.system.domain.UserEntity;

/**
 * UserManager
 *
 * @author elvea
 */
public interface UserManager extends Manager<UserEntity, Long> {

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return {@link UserEntity}
     */
    UserEntity findByUsername(String username);

    /**
     * 根据邮箱查询
     *
     * @param email 用户名
     * @return {@link UserEntity}
     */
    UserEntity findByEmail(String email);

    /**
     * 根据手机号码查询
     *
     * @param mobileCountryCode 手机国家区号
     * @param mobile            手机号码
     * @return {@link UserEntity}
     */
    UserEntity findByMobile(String mobileCountryCode, String mobile);

    /**
     * 清空缓存
     */
    void clearCache();

}
