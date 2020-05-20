package cn.elvea.platform.security.web;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * JwkSetController
 *
 * @author elvea
 */
@RestController
@Tag(name = "Security", description = "认证和授权控制器")
public class JwkSetController {

    private final KeyPair keyPair;

    public JwkSetController(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    @Operation(summary = "JWKS")
    @ApiResponse(description = "JWKS")
    @GetMapping("/.well-known/jwks.json")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) this.keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
