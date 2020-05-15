package cn.elvea.platform.security.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static cn.elvea.platform.commons.constants.SecurityConstants.AUTH_USER_PATH;

/**
 * AuthController
 *
 * @author elvea
 */
@RestController
@Tag(name = "auth", description = "认证和授权控制器")
public class AuthController {

    /**
     * 用户
     */
    @Operation(summary = "获取用户信息")
    @ApiResponse(description = "用户信息")
    @GetMapping(AUTH_USER_PATH)
    public Object getUserInfo(@AuthenticationPrincipal Jwt jwt) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("username", jwt.getClaimAsString("username"));
        return Collections.unmodifiableMap(map);
    }

}
