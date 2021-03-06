package cn.elvea.platform.security.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * IntrospectController
 *
 * @author elvea
 */
@RestController
@Tag(name = "Security", description = "认证授权控制器")
public class IntrospectController {

    private final TokenStore tokenStore;

    public IntrospectController(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    /**
     * INTROSPECT
     *
     * @param token 凭证
     * @return Map
     */
    @Operation(summary = "INTROSPECT")
    @ApiResponse(description = "INTROSPECT")
    @PostMapping("/introspect")
    public Map<String, Object> introspect(@RequestParam("token") String token) {
        OAuth2AccessToken accessToken = this.tokenStore.readAccessToken(token);
        Map<String, Object> attributes = new HashMap<>();
        if (accessToken == null || accessToken.isExpired()) {
            attributes.put("active", false);
            return attributes;
        }

        OAuth2Authentication authentication = this.tokenStore.readAuthentication(token);

        attributes.put("active", true);
        attributes.put("exp", accessToken.getExpiration().getTime());
        attributes.put("scope", String.join(" ", accessToken.getScope()));
        attributes.put("sub", authentication.getName());

        return attributes;
    }

}
