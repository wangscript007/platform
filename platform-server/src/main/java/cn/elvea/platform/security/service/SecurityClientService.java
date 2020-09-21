package cn.elvea.platform.security.service;

import cn.elvea.platform.core.system.dto.ClientDto;
import cn.elvea.platform.core.system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * SecurityClientDetailsService
 *
 * @author elvea
 * @see ClientDetailsService
 */
@Service
public class SecurityClientService implements ClientDetailsService {

    @Autowired
    ClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDto dto = this.clientService.findByClientId(clientId);
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(dto.getClientId());
        details.setClientSecret(dto.getClientSecret());
        details.setAuthorizedGrantTypes(StringUtils.commaDelimitedListToSet(dto.getClientAuthenticationMethods()));
        details.setScope(StringUtils.commaDelimitedListToSet(dto.getScopes()));
        details.setRegisteredRedirectUri(StringUtils.commaDelimitedListToSet(dto.getRedirectUris()));
        return details;
    }

}
