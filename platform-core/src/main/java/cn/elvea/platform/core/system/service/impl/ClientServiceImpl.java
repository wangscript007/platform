package cn.elvea.platform.core.system.service.impl;

import cn.elvea.platform.commons.utils.ConvertUtils;
import cn.elvea.platform.core.system.domain.ClientEntity;
import cn.elvea.platform.core.system.dto.ClientDto;
import cn.elvea.platform.core.system.manager.ClientManager;
import cn.elvea.platform.core.system.service.ClientService;
import org.springframework.stereotype.Service;

/**
 * ClientService
 *
 * @author elvea
 * @see ClientService
 */
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientManager clientManager;

    public ClientServiceImpl(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    /**
     * @see ClientService#findById(Long)
     */
    @Override
    public ClientDto findById(Long id) {
        ClientEntity entity = clientManager.findById(id);
        return ConvertUtils.convert(entity, ClientDto.class);
    }

    /**
     * @see ClientService#findByClientId(String)
     */
    @Override
    public ClientDto findByClientId(String clientId) {
        ClientEntity entity = clientManager.findByClientId(clientId);
        return ConvertUtils.convert(entity, ClientDto.class);
    }

}
