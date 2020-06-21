package cn.elvea.platform.core.security.filter;

import cn.elvea.platform.core.security.authentication.MobileAuthenticationToken;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MobileAuthenticationFilter
 *
 * @author elvea
 */
public class MobileAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    // 属性
    // ===================================================================================================

    private String mobileParameter = "mobile";

    private String captchaParameter = "captcha";

    // 构造函数
    // ===================================================================================================

    public MobileAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/mobile", "POST"));
    }

    // 方法
    // ===================================================================================================

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String mobile = obtainMobile(request);
        String captcha = obtainCaptcha(request);

        MobileAuthenticationToken authRequest = new MobileAuthenticationToken(mobile, captcha);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Nullable
    protected String obtainMobile(HttpServletRequest request) {
        return StringUtils.isEmpty(request.getParameter(mobileParameter)) ?
                "" : request.getParameter(mobileParameter).trim();
    }

    @Nullable
    protected String obtainCaptcha(HttpServletRequest request) {
        return StringUtils.isEmpty(request.getParameter(captchaParameter)) ?
                "" : request.getParameter(captchaParameter).trim();
    }

    protected void setDetails(HttpServletRequest request, MobileAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
