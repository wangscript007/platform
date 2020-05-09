package cn.elvea.platform.security.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static cn.elvea.platform.commons.constants.SecurityConstants.AUTH_LOGIN_PATH;
import static cn.elvea.platform.commons.constants.SecurityConstants.AUTH_USER_PATH;

/**
 * AuthController
 *
 * @author elvea
 */
@Controller
public class AuthController {

    /**
     * 登录页面
     */
    @GetMapping(AUTH_LOGIN_PATH)
    public String login() {
        return "login";
    }

    /**
     * 用户
     */
    @ResponseBody
    @GetMapping(AUTH_USER_PATH)
    public Object getUserInfo(@AuthenticationPrincipal Jwt principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("username", principal.getClaimAsString("username"));
        return Collections.unmodifiableMap(map);
    }

}
