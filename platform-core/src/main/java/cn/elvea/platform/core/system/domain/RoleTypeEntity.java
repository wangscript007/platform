package cn.elvea.platform.core.system.domain;

import cn.elvea.platform.commons.jpa.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RoleTypeEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_role_type")
public class RoleTypeEntity extends BaseEntity {
}
