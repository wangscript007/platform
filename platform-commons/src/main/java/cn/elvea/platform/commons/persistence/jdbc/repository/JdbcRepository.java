package cn.elvea.platform.commons.persistence.jdbc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * JdbcRepository
 *
 * @param <T>
 * @param <ID>
 */
public interface JdbcRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
}
