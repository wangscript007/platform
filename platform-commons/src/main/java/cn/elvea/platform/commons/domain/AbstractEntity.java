package cn.elvea.platform.commons.domain;

import java.util.Objects;

/**
 * AbstractEntity
 *
 * @author elvea
 */
public abstract class AbstractEntity implements IdEntity {

    /**
     * 复写equals方法，实现用ID主键做对象比较
     *
     * @param obj 目标对比对象
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdEntity)) {
            return false;
        }
        IdEntity entity = (IdEntity) obj;
        return getId() != null && Objects.equals(getId(), entity.getId());
    }

}
