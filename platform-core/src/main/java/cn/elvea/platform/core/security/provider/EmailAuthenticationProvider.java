package cn.elvea.platform.core.security.provider;

import cn.elvea.platform.core.security.authentication.EmailAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * EmailAuthenticationProvider
 *
 * @author elvea
 */
public class EmailAuthenticationProvider implements AuthenticationProvider {

    UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        EmailAuthenticationToken authenticationToken = (EmailAuthenticationToken) authentication;
        UserDetails userDetails = userDetailsService.loadUserByUsername("");
        EmailAuthenticationToken authenticationResult = new EmailAuthenticationToken(userDetails, userDetails.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return EmailAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
