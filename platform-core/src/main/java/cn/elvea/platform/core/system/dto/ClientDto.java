package cn.elvea.platform.core.system.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 客户端
 *
 * @author elvea
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClientDto implements Serializable {
    private String code;
}
