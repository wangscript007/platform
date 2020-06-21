package cn.elvea.platform.commons.persistence.mybatis;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;

/**
 * MyBatisNamespaceStrategy
 *
 * @author elvea
 * @see NamespaceStrategy
 */
public class MyBatisNamespaceStrategy implements NamespaceStrategy {

    @Override
    public @NotNull String getNamespace(@NotNull Class<?> domainType) {
        return domainType.getName() + "Repository";
    }

}
