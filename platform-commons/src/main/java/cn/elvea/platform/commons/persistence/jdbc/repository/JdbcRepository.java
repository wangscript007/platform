package cn.elvea.platform.commons.persistence.jdbc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * JdbcRepository
 *
 * @param <T> 实体
 * @param <K> 主键
 */
public interface JdbcRepository<T, K> extends PagingAndSortingRepository<T, K> {
}
