package cn.elvea.platform.core.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

@Slf4j
public class KeyStoreKeyFactory {

    private Resource resource;

    private char[] password;

    private KeyStore store;

    private Object lock = new Object();

    public KeyStoreKeyFactory(Resource resource, char[] password) {
        this.resource = resource;
        this.password = password;
    }

    public KeyPair getKeyPair(String alias) {
        return getKeyPair(alias, password);
    }

    public KeyPair getKeyPair(String alias, char[] password) {
        InputStream inputStream = null;
        try {
            synchronized (lock) {
                if (store == null) {
                    synchronized (lock) {
                        store = KeyStore.getInstance("jks");
                        inputStream = resource.getInputStream();
                        store.load(inputStream, this.password);
                    }
                }
            }
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) store.getKey(alias, password);
            RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
            return new KeyPair(publicKey, key);
        } catch (Exception e) {
            throw new IllegalStateException("Cannot load keys from store: " + resource, e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}