package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClientEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClientEntity extends BaseEntity {
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoapprove;
}
