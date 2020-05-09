package cn.elvea.platform.commons.jpa.domain;

import cn.elvea.platform.commons.domain.AbstractEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * BaseEntity
 *
 * @author elvea
 */
@MappedSuperclass
public abstract class BaseEntity extends AbstractEntity {

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "IdGenerator")
    @GenericGenerator(name = "IdGenerator", strategy = "cn.elvea.platform.commons.jpa.id.SnowflakeIdGenerator")
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
