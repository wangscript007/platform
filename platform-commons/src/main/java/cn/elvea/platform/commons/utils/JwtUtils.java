package cn.elvea.platform.commons.utils;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

/**
 * JwtUtils
 *
 * @author elvea
 */
public abstract class JwtUtils {

    public static void generateRsaKey1() throws Exception {
        // 实例化密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥生成器
        keyPairGenerator.initialize(2048);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 输出
        System.out.println(publicKey.toString());
        System.out.println(privateKey.toString());
    }

    public static void generateRsaKey2() throws Exception {
        RSAKey jwk = new RSAKeyGenerator(2048)
                .keyUse(KeyUse.SIGNATURE)
                .keyID(UUID.randomUUID().toString())
                .generate();
        System.out.println(jwk);
        System.out.println(jwk.toPublicJWK());
    }

    public static void generateRsaKey3() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair keyPair = gen.generateKeyPair();

        JWK jwk = new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey((RSAPrivateKey) keyPair.getPrivate())
                .keyUse(KeyUse.SIGNATURE)
                .keyID(UUID.randomUUID().toString())
                .build();
        System.out.println(jwk.toRSAKey());
        System.out.println(jwk.toJSONString());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("generateRsaKey1......");
        JwtUtils.generateRsaKey1();
        System.out.println("generateRsaKey2......");
        JwtUtils.generateRsaKey2();
        System.out.println("generateRsaKey3......");
        JwtUtils.generateRsaKey3();
    }

}
