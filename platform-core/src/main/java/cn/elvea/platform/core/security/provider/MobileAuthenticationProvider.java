package cn.elvea.platform.core.security.provider;

import cn.elvea.platform.core.security.authentication.MobileAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * MobileAuthenticationProvider
 *
 * @author elvea
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {

    UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken authenticationToken = (MobileAuthenticationToken) authentication;
        UserDetails userDetails = userDetailsService.loadUserByUsername("");
        MobileAuthenticationToken authenticationResult = new MobileAuthenticationToken(userDetails, userDetails.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
