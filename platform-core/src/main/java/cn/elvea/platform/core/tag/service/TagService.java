package cn.elvea.platform.core.tag.service;

import cn.elvea.platform.core.tag.dto.TagRelationDto;

/**
 * TagService
 *
 * @author elvea
 */
public interface TagService {

    /**
     * 保存实体标签管理
     *
     * @param dto {@link TagRelationDto}
     */
    void saveRelation(TagRelationDto dto);

}
