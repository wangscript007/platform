package cn.elvea.platform.security.service;

import cn.elvea.platform.core.system.dto.ClientDto;
import cn.elvea.platform.core.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

/**
 * SecurityClientDetailsService
 *
 * @author elvea
 * @see RegisteredClientRepository
 */
@Service
public class SecurityClientService implements RegisteredClientRepository {

    @Autowired
    ClientService clientService;

    /**
     * @see RegisteredClientRepository#findById(String)
     */
    @Override
    public RegisteredClient findById(String id) {
        ClientDto dto = clientService.findById(Long.valueOf(id));
        return RegisteredClient.withId(dto.getClientId())
                .clientSecret(dto.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .authorizationGrantType(AuthorizationGrantType.PASSWORD)
                .redirectUri(dto.getRedirectUris())
                .scope(dto.getScopes()).build();
    }

    /**
     * @see RegisteredClientRepository#findByClientId(String)
     */
    @Override
    public RegisteredClient findByClientId(String clientId) {
        ClientDto dto = clientService.findByClientId(clientId);
        return RegisteredClient.withId(dto.getClientId())
                .clientSecret(dto.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .authorizationGrantType(AuthorizationGrantType.PASSWORD)
                .redirectUri(dto.getRedirectUris())
                .scope(dto.getScopes()).build();
    }

}
