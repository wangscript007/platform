package cn.elvea.platform.security.service;

import cn.elvea.platform.core.system.dto.UserDto;
import cn.elvea.platform.core.system.service.UserService;
import cn.elvea.platform.security.SecurityUser;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SecurityUserDetailsServices
 *
 * @author elvea
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public SecurityUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(username);
        }

        List<SimpleGrantedAuthority> authorities = Lists.newArrayList();
        authorities.add(new SimpleGrantedAuthority("USER"));

        return new SecurityUser(user.getUsername(), user.getPassword(), authorities);
    }

}
