package cn.elvea.platform.core.security.filter;

import cn.elvea.platform.core.security.authentication.EmailAuthenticationToken;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EmailAuthenticationFilter
 *
 * @author elvea
 */
public class EmailAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    // 属性
    // ===================================================================================================

    private String emailParameter = "email";

    private String passwordParameter = "password";

    // 构造函数
    // ===================================================================================================

    public EmailAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/email", "POST"));
    }

    // 方法
    // ===================================================================================================

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = obtainEmail(request);
        String captcha = obtainPassword(request);

        EmailAuthenticationToken authRequest = new EmailAuthenticationToken(email, captcha);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Nullable
    protected String obtainEmail(HttpServletRequest request) {
        return StringUtils.isEmpty(request.getParameter(emailParameter)) ?
                "" : request.getParameter(emailParameter).trim();
    }

    @Nullable
    protected String obtainPassword(HttpServletRequest request) {
        return StringUtils.isEmpty(request.getParameter(passwordParameter)) ?
                "" : request.getParameter(passwordParameter).trim();
    }

    protected void setDetails(HttpServletRequest request, EmailAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
