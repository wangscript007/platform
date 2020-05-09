DROP DATABASE IF EXISTS `platform`;

CREATE DATABASE IF NOT EXISTS `platform`
    DEFAULT CHARACTER SET `utf8mb4`
    DEFAULT COLLATE `utf8mb4_general_ci`;

USE `platform`;

create table `oauth_client_details`
(
    `client_id`               VARCHAR(256) PRIMARY KEY,
    `resource_ids`            VARCHAR(256),
    `client_secret`           VARCHAR(256),
    `scope`                   VARCHAR(256),
    `authorized_grant_types`  VARCHAR(256),
    `web_server_redirect_uri` VARCHAR(256),
    `authorities`             VARCHAR(256),
    `access_token_validity`   INTEGER,
    `refresh_token_validity`  INTEGER,
    `additional_information`  VARCHAR(4096),
    `autoapprove`             VARCHAR(256)
);

insert into oauth_client_details
values ('webapp', 'webapp', '$2a$10$vLBvzWIja24Ex.E2FLQbaOib0GXJ3VW5LhjmCtbdtUbamxKG8Jiq2',
        'webapp, profile', 'client_credentials,password,refresh_token',
        '', null, null, null, null, true);

create table `oauth_client_token`
(
    `token_id`          VARCHAR(256),
    `token`             LONGTEXT,
    `authentication_id` VARCHAR(256) PRIMARY KEY,
    `user_name`         VARCHAR(256),
    `client_id`         VARCHAR(256)
);

create table `oauth_access_token`
(
    `token_id`          VARCHAR(256),
    `token`             LONGTEXT,
    `authentication_id` VARCHAR(256) PRIMARY KEY,
    `user_name`         VARCHAR(256),
    `client_id`         VARCHAR(256),
    `authentication`    LONGTEXT,
    `refresh_token`     VARCHAR(256)
);

create table `oauth_refresh_token`
(
    `token_id`       VARCHAR(256),
    `token`          LONGTEXT,
    `authentication` LONGTEXT
);

create table `oauth_code`
(
    `code`           VARCHAR(256),
    `authentication` LONGTEXT
);

create table `oauth_approvals`
(
    `userId`         VARCHAR(256),
    `clientId`       VARCHAR(256),
    `scope`          VARCHAR(256),
    `status`         VARCHAR(10),
    `expiresAt`      TIMESTAMP,
    `lastModifiedAt` TIMESTAMP
);

/* ========================================================================================================= */
/* 基础表 */
/* ========================================================================================================= */

/* 角色类型表 */
CREATE TABLE `sys_role_type`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(100) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `description` VARCHAR(250) COMMENT '备注',
    `active`      TINYINT COMMENT '启用状态',
    CONSTRAINT `pk_sys_role_type` PRIMARY KEY (`id`)
);

/* 角色表 */
CREATE TABLE `sys_role`
(
    `id`           BIGINT UNSIGNED COMMENT 'ID',
    `role_type_id` BIGINT UNSIGNED COMMENT '角色类型ID',
    `code`         VARCHAR(100) COMMENT '编号',
    `title`        VARCHAR(150) COMMENT '标题',
    `label`        VARCHAR(150) COMMENT '文本',
    `description`  VARCHAR(255) COMMENT '简介',
    `active`       TINYINT COMMENT '启用状态',
    `created_at`   DATETIME COMMENT '创建时间',
    `created_by`   BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`   DATETIME COMMENT '修改时间',
    `updated_by`   BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`   DATETIME COMMENT '删除时间',
    `deleted_by`   BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_role` PRIMARY KEY (`id`)
);

/* 权限表 */
CREATE TABLE `sys_permission`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `parent_id`   BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(100) COMMENT '编号',
    `title`       VARCHAR(150) COMMENT '标题',
    `description` VARCHAR(255) COMMENT '简介',
    `active`      TINYINT COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`  DATETIME COMMENT '修改时间',
    `updated_by`  BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除时间',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_permission` PRIMARY KEY (`id`)
);

/* 部门表 */
CREATE TABLE `sys_department`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(150) COMMENT '编号',
    `title`       VARCHAR(150) COMMENT '标题',
    `description` VARCHAR(255) COMMENT '简介',
    `root_ind`    TINYINT(1) COMMENT '是否顶层部门' DEFAULT 0,
    `active`      TINYINT COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT COMMENT '创建人',
    `updated_at`  DATETIME COMMENT '修改时间',
    `updated_by`  BIGINT COMMENT '修改时间',
    `deleted_at`  DATETIME COMMENT '删除时间',
    `deleted_by`  BIGINT COMMENT '删除人',
    CONSTRAINT `pk_sys_department_id` PRIMARY KEY (`id`)
);

/* 岗位表 */
CREATE TABLE `sys_position`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(150) COMMENT '编号',
    `title`       VARCHAR(150) COMMENT '标题',
    `description` VARCHAR(255) COMMENT '简介',
    `root_ind`    TINYINT(1) COMMENT '是否顶层岗位' DEFAULT 0,
    `active`      TINYINT COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`  DATETIME COMMENT '修改时间',
    `updated_by`  BIGINT UNSIGNED COMMENT '修改时间',
    `deleted_at`  DATETIME COMMENT '删除时间',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_position_id` PRIMARY KEY (`id`)
);

/* 用户表 */
CREATE TABLE `sys_user`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `username`    VARCHAR(150) COMMENT '用户名',
    `email`       VARCHAR(150) COMMENT '电子邮箱',
    `mobile`      VARCHAR(150) COMMENT '手机号码',
    `password`    VARCHAR(255) COMMENT '密码',
    `nickname`    VARCHAR(255) COMMENT '昵称',
    `description` VARCHAR(255) COMMENT '备注',
    `status`      TINYINT(1) COMMENT '状态',
    `active`      TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`  DATETIME COMMENT '修改时间',
    `updated_by`  BIGINT UNSIGNED COMMENT '修改时间',
    `deleted_at`  DATETIME COMMENT '删除时间',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_user_id` PRIMARY KEY (`id`)
);

/* 角色-权限关联表 */
CREATE TABLE `sys_role_permission_relation`
(
    `role_id`       BIGINT UNSIGNED COMMENT '角色ID',
    `permission_id` BIGINT UNSIGNED COMMENT '权限ID',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_role_permission_relation` PRIMARY KEY (`role_id`, `permission_id`)
);

/* 用户-角色关联表 */
CREATE TABLE `sys_user_role_relation`
(
    `role_id`    BIGINT UNSIGNED COMMENT '角色ID',
    `user_id`    BIGINT UNSIGNED COMMENT '用户ID',
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_user_role_relation` PRIMARY KEY (`role_id`, `user_id`)
);

/* 实体关联 */
CREATE TABLE `sys_entity_relation`
(
    `id`         BIGINT UNSIGNED COMMENT 'ID',
    `type`       VARCHAR(50) COMMENT '关联类型',
    `parent_id`  BIGINT UNSIGNED COMMENT '父ID',
    `child_id`   BIGINT UNSIGNED COMMENT '子ID',
    `level`      INT UNSIGNED COMMENT '层级序号',
    `parent_ind` TINYINT(1) UNSIGNED COMMENT '是否直接上级',
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_entity_relation` PRIMARY KEY (`id`)
);

/* ========================================================================================================= */
/* 通用分类 */
/* ========================================================================================================= */

/* 分类类型 */
CREATE TABLE `sys_catalog_type`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(100) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `description` VARCHAR(250) COMMENT '备注',
    CONSTRAINT `pk_sys_catalog_type` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_catalog_type`
    COMMENT '分类类型表';

/* 分类 */
CREATE TABLE `sys_catalog`
(
    `id`              BIGINT UNSIGNED COMMENT 'ID',
    `catalog_type_id` BIGINT UNSIGNED COMMENT '分类类型ID',
    `code`            VARCHAR(150) COMMENT '编号',
    `title`           VARCHAR(255) COMMENT '标题',
    `description`     VARCHAR(255) COMMENT '简介',
    `root_ind`        TINYINT(1) UNSIGNED COMMENT '是否根分类' DEFAULT 0,
    `active`          TINYINT(1) UNSIGNED COMMENT '启用状态'  DEFAULT 1,
    `created_at`      DATETIME COMMENT '创建时间',
    `created_by`      BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`      DATETIME COMMENT '更新时间',
    `updated_by`      BIGINT UNSIGNED COMMENT '更新人',
    CONSTRAINT `pk_sys_catalog_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_catalog`
    COMMENT '分类表';

CREATE INDEX `ix_sys_cat_ct_id` ON `sys_catalog` (`catalog_type_id`);

/* 分类层级关联 */
CREATE TABLE `sys_catalog_relation`
(
    `id`            BIGINT UNSIGNED COMMENT 'ID',
    `relation_type` VARCHAR(50) COMMENT '关联类型',
    `parent_id`     BIGINT UNSIGNED COMMENT '父节点ID',
    `child_id`      BIGINT UNSIGNED COMMENT '子节点ID',
    `parent_ind`    TINYINT(1) UNSIGNED COMMENT '是否直接父节点',
    `idx`           BIGINT UNSIGNED COMMENT '层级序号',
    `path`          TEXT COMMENT '关联的完整路径',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_catalog_relation` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_catalog_relation`
    COMMENT '分类层级关联表';

CREATE INDEX `ix_sys_cat_r_type` ON `sys_catalog_relation` (`relation_type`);
CREATE INDEX `ix_sys_cat_r_parent_id` ON `sys_catalog_relation` (`parent_id`);
CREATE INDEX `ix_sys_cat_r_child_id` ON `sys_catalog_relation` (`child_id`);

/* ========================================================================================================= */
/* 通用字典 */
/* ========================================================================================================= */

CREATE TABLE `sys_dictionary_type`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(100) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `description` VARCHAR(250) COMMENT '备注',
    CONSTRAINT `pk_sys_dictionary_type` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_dictionary_type`
    COMMENT '字典类型表';

/* 字典明细 */
CREATE TABLE `sys_dictionary_item`
(
    `id`                 BIGINT COMMENT 'ID' NOT NULL,
    `dictionary_type_id` BIGINT COMMENT '字典类型ID',
    `idx`                INT COMMENT '序号',
    `source`             VARCHAR(50) COMMENT '来源',
    `created_at`         DATETIME COMMENT '创建时间',
    `created_by`         BIGINT COMMENT '创建人',
    `updated_at`         DATETIME COMMENT '更新时间',
    `updated_by`         BIGINT COMMENT '更新人',
    CONSTRAINT `pk_sys_dictionary_item` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_dictionary_item`
    COMMENT '字典明细表';

CREATE INDEX `ix_sys_dictionary_item` ON `sys_dictionary_item` (`dictionary_type_id`);

/* 字典关联 */
CREATE TABLE `sys_dictionary_relation`
(
    `id`                 BIGINT UNSIGNED COMMENT 'ID',
    `dictionary_type_id` BIGINT UNSIGNED COMMENT '字典类型ID',
    `dictionary_item_id` BIGINT UNSIGNED COMMENT '字典明细ID',
    `target_type`        VARCHAR(50) COMMENT '目标类型',
    `target_entity_id`   BIGINT UNSIGNED COMMENT '目标实体',
    `created_at`         DATETIME COMMENT '创建时间',
    `created_by`         BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_dictionary_relation` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_dictionary_relation`
    COMMENT '字典关联表';

CREATE INDEX `ix_sys_dictionary_relation` ON `sys_dictionary_relation`
    (`dictionary_type_id`, `dictionary_item_id`, `target_type`, `target_entity_id`);

/* ========================================================================================================= */
/* 通用标签 */
/* ========================================================================================================= */

/* 标签类型 */
CREATE TABLE `sys_tag_type`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(100) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `description` VARCHAR(250) COMMENT '备注',
    CONSTRAINT `pk_sys_tag_type` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_tag_type`
    COMMENT '字典类型表';

CREATE TABLE `sys_tag`
(
    `id`          BIGINT UNSIGNED COMMENT '标签ID',
    `tag_type_id` BIGINT UNSIGNED COMMENT '标签类型ID',
    `title`       VARCHAR(150) COMMENT '标题',
    `description` VARCHAR(255) COMMENT '简介',
    `active`      TINYINT(1) COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`  DATETIME COMMENT '更新时间',
    `updated_by`  BIGINT UNSIGNED COMMENT '更新人',
    `deleted_at`  DATETIME COMMENT '删除时间',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_tag` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_tag`
    COMMENT '标签表';

CREATE INDEX `ix_sys_tag_type_id` ON `sys_tag` (`tag_type_id`);

/* 标签关联表 */
CREATE TABLE `sys_tag_relation`
(
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `tag_type_id`      BIGINT UNSIGNED COMMENT '标签类型ID',
    `tag_id`           BIGINT UNSIGNED COMMENT '标签ID',
    `target_type`      VARCHAR(50) COMMENT '目标类型',
    `target_entity_id` BIGINT UNSIGNED COMMENT '目标实体ID',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_tag_relation` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_tag_relation`
    COMMENT '标签关联表';

CREATE INDEX `ix_sys_tag_relation` ON `sys_tag_relation` (`tag_type_id`, `tag_id`, `target_type`, `target_entity_id`);

/* 基础数据 */
insert into sys_role_type (id, code, label, description, active)
values (1, 'SYSTEM_ADMINISTRTOR', 'label_role_system_administrtor', 'System Administrator', 1),
       (2, 'ADMINISTRTOR', 'label_role_administrtor', 'Administrator', 1),
       (3, 'USER', 'label_role_user', 'General User', 1),
       (4, 'ANONYMOUS_USER', 'label_role_anonymous_user', 'Anonymous User', 1);

insert into sys_role (id, code, title, label, description, active, created_at)
values (1, 'SADMIN', 'System Administrator', 'label_role_system_administrtor', 'System Administrator', 1, now()),
       (2, 'ADMINISTRTOR', 'Administrator', 'label_role_administrtor', 'Administrator', 1, now()),
       (3, 'USER', 'General User', 'label_role_user', 'General User', 1, now()),
       (4, 'ANONYMOUS_USER', 'Anonymous User', 'label_role_anonymous_user', 'Anonymous User', 1, now());

insert into sys_user (id, username, nickname, active, created_at, password)
values (1, 'admin', 'Administrator', 1, now(), '$2a$10$MLkjYEPJkO6KNrfUUBld6eWVr1G09nugg5UpIQVUtsQ.3Z9U2lOSK');
