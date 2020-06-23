package cn.elvea.platform.commons.persistence.mybatis.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * PageHelper
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageHelper<T> implements Serializable {

    Pageable pageable;

    Page<T> page;

}
