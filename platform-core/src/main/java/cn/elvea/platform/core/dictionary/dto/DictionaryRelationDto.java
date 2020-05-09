package cn.elvea.platform.core.dictionary.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * TagRelationDto
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class DictionaryRelationDto implements Serializable {
    /**
     * 字典类型ID
     */
    private Long typeId;
    /**
     * 字典明细
     */
    private List<DictionaryItemDto> items = Collections.emptyList();
    /**
     * 字典明细ID
     */
    private List<Long> itemIds = Collections.emptyList();
    /**
     * 目标类型
     */
    private String targetType;
    /**
     * 目标实体ID
     */
    private Long targetEntityId;
}
