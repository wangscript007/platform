package cn.elvea.platform.commons.persistence.jdbc.callback;

import cn.elvea.platform.commons.Context;
import cn.elvea.platform.commons.domain.IdEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.relational.core.conversion.MutableAggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.util.Assert;

/**
 * IdEntityCallback
 *
 * @author elvea
 */
public class IdEntityCallback implements BeforeSaveCallback<IdEntity> {

    private final Context context;

    public IdEntityCallback(Context context) {

        Assert.notNull(context, "Context must not be null!");

        this.context = context;
    }

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
