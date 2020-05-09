package cn.elvea.platform.core.tag.dto;

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
public class TagRelationDto implements Serializable {
    /**
     * 标签类型ID
     */
    private Long typeId;
    /**
     * 标签明细
     */
    private List<TagDto> items = Collections.emptyList();
    /**
     * 标签明细ID
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
