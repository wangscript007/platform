package cn.elvea.platform.core.system.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserSearchParam
 *
 * @author elvea
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchParam implements Serializable {

    /**
     * 搜索关键字
     */
    private String keyword;

    private String username;

    private Boolean usernameExactMatch;

    private String nickname;

    private Boolean nicknameExactMatch;

}
