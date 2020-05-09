package cn.elvea.platform.commons.domain;

import java.io.Serializable;

/**
 * IdEntity
 *
 * @author elvea
 */
public interface IdEntity extends Serializable {

    /**
     * @return Long
     */
    Long getId();

    /**
     * @param id Long
     */
    void setId(Long id);

}
