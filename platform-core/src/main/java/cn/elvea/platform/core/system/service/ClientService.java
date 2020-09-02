package cn.elvea.platform.core.system.service;

import cn.elvea.platform.core.system.dto.ClientDto;

/**
 * ClientService
 *
 * @author elvea
 */
public interface ClientService {

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return {@link ClientDto}
     */
    ClientDto findById(Long id);

    /**
     * 根据客户端标识查询
     *
     * @param clientId 客户端标识
     * @return {@link ClientDto}
     */
    ClientDto findByClientId(String clientId);

}
