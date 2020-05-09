package cn.elvea.platform.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * SecurityUser
 *
 * @author elvea
 */
public class SecurityUser extends User {

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
