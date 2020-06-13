package cn.elvea.platform.commons.persistence.jdbc.callback;

import cn.elvea.platform.commons.Context;
import cn.elvea.platform.commons.domain.IdEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

/**
 * IdEntityCallback
 *
 * @author elvea
 */
public class IdEntityCallback implements BeforeSaveCallback<IdEntity> {

    @Autowired
    private Context context;

    /**
     * @see BeforeSaveCallback#onBeforeSave(Object, MutableAggregateChange)
     */
    @NotNull
    @Override
    public IdEntity onBeforeSave(IdEntity entity, @NotNull MutableAggregateChange<IdEntity> aggregateChange) {
        if (entity.getId() == null) {
            entity.setId(this.context.generateNextId());
        }
        return entity;
    }

}
