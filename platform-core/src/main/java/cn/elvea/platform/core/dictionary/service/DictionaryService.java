package cn.elvea.platform.core.dictionary.service;

import cn.elvea.platform.core.dictionary.dto.DictionaryRelationDto;

/**
 * TagService
 *
 * @author elvea
 */
public interface DictionaryService {

    /**
     * 保存实体标签管理
     *
     * @param dto {@link DictionaryRelationDto}
     */
    void saveRelation(DictionaryRelationDto dto);

}
