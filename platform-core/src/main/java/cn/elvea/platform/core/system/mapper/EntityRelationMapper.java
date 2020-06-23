package cn.elvea.platform.core.system.mapper;

import cn.elvea.platform.core.system.domain.EntityRelationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * EntityRelationMapper
 *
 * @author elvea
 */
@Mapper
public interface EntityRelationMapper {

    List<EntityRelationEntity> searchByPageable(Pageable pageable);

    Page<EntityRelationEntity> searchByPage(Pageable pageable);

}
