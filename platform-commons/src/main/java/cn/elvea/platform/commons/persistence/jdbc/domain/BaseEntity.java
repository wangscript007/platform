package cn.elvea.platform.commons.persistence.jdbc.domain;

import cn.elvea.platform.commons.domain.AbstractEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.data.annotation.Id;

/**
 * BaseEntity
 *
 * @author elvea
 */
public abstract class BaseEntity extends AbstractEntity {

    /**
     * ID
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
