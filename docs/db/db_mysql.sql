DROP DATABASE IF EXISTS `platform`;

CREATE DATABASE IF NOT EXISTS `platform`
    DEFAULT CHARACTER SET `utf8mb4`
    DEFAULT COLLATE `utf8mb4_general_ci`;

USE `platform`;

/* ========================================================================================================= */
/* 基础表 */
/* ========================================================================================================= */

/* 客户端 */
CREATE TABLE `sys_client`
(
    `id`                            BIGINT UNSIGNED COMMENT 'ID',
    `client_id`                     VARCHAR(150) COMMENT 'Client ID',
    `client_secret`                 VARCHAR(255) COMMENT 'Client Secret',
    `authorization_grant_types`     VARCHAR(255) COMMENT 'Authorization Grant Types',
    `client_authentication_methods` VARCHAR(255) COMMENT 'Client Authentication Methods',
    `scopes`                        VARCHAR(255) COMMENT 'Score',
    `redirect_uris`                 VARCHAR(255) COMMENT 'Redirect Uris',
    `description`                   VARCHAR(255) COMMENT '备注',
    `active`                        TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`                    DATETIME COMMENT '创建时间',
    `created_by`                    BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at`              DATETIME COMMENT '最后修改时间',
    `last_modified_by`              BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`                    DATETIME COMMENT '删除时间',
    `deleted_by`                    BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_client` PRIMARY KEY (`id`)
);

CREATE INDEX `ix_sys_client_1` ON `sys_client` (`client_id`);
CREATE INDEX `ix_sys_client_2` ON `sys_client` (`active`);

/* 角色类型表 */
CREATE TABLE `sys_role_type`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `code`        VARCHAR(100) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `description` VARCHAR(250) COMMENT '备注',
    `active`      TINYINT UNSIGNED COMMENT '启用状态',
    CONSTRAINT `pk_sys_role_type` PRIMARY KEY (`id`)
);

CREATE INDEX `ix_sys_role_type_1` ON `sys_role_type` (`active`);
CREATE INDEX `ix_sys_role_type_2` ON `sys_role_type` (`code`);

/* 角色表 */
CREATE TABLE `sys_role`
(
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `role_type_id`     BIGINT UNSIGNED COMMENT '角色类型ID',
    `code`             VARCHAR(100) COMMENT '编号',
    `title`            VARCHAR(150) COMMENT '标题',
    `label`            VARCHAR(150) COMMENT '文本',
    `description`      VARCHAR(255) COMMENT '简介',
    `active`           TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`       DATETIME COMMENT '删除时间',
    `deleted_by`       BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_role` PRIMARY KEY (`id`)
);

CREATE INDEX `ix_sys_role_1` ON `sys_role` (`active`);
CREATE INDEX `ix_sys_role_2` ON `sys_role` (`code`);
CREATE INDEX `ix_sys_role_3` ON `sys_role` (`role_type_id`);

/* 权限表 */
CREATE TABLE `sys_permission`
(
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `parent_id`        BIGINT UNSIGNED COMMENT '父权限ID' default 0,
    `code`             VARCHAR(100) COMMENT '编号',
    `title`            VARCHAR(150) COMMENT '标题',
    `description`      VARCHAR(255) COMMENT '简介',
    `active`           TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`       DATETIME COMMENT '删除时间',
    `deleted_by`       BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_permission` PRIMARY KEY (`id`)
);

/* 部门表 */
CREATE TABLE `sys_department`
(
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `code`             VARCHAR(150) COMMENT '编号',
    `title`            VARCHAR(150) COMMENT '标题',
    `description`      VARCHAR(255) COMMENT '简介',
    `root_ind`         TINYINT(1) COMMENT '是否顶层部门',
    `active`           TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`       DATETIME COMMENT '删除时间',
    `deleted_by`       BIGINT UNSIGNED COMMENT '删除人',
    `source`           VARCHAR(100) COMMENT '来源',
    `source_key`       VARCHAR(255) COMMENT '来源标识',
    `source_extra`     VARCHAR(255) COMMENT '来源信息',
    CONSTRAINT `pk_sys_department_id` PRIMARY KEY (`id`)
);

/* 岗位表 */
CREATE TABLE `sys_position`
(
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `code`             VARCHAR(150) COMMENT '编号',
    `title`            VARCHAR(150) COMMENT '标题',
    `description`      VARCHAR(255) COMMENT '简介',
    `root_ind`         TINYINT(1) COMMENT '是否顶层岗位',
    `active`           TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`       DATETIME COMMENT '删除时间',
    `deleted_by`       BIGINT UNSIGNED COMMENT '删除人',
    `source`           VARCHAR(100) COMMENT '来源',
    `source_key`       VARCHAR(255) COMMENT '来源标识',
    `source_extra`     VARCHAR(255) COMMENT '来源信息',
    CONSTRAINT `pk_sys_position_id` PRIMARY KEY (`id`)
);

/* 用户表 */
CREATE TABLE `sys_user`
(
    `id`                  BIGINT UNSIGNED COMMENT 'ID',
    `username`            VARCHAR(150) COMMENT '用户名',
    `email`               VARCHAR(150) COMMENT '电子邮箱',
    `mobile_country_code` VARCHAR(10) COMMENT '手机国家区号',
    `mobile`              VARCHAR(50) COMMENT '手机号码',
    `password`            VARCHAR(255) COMMENT '密码',
    `nickname`            VARCHAR(255) COMMENT '昵称',
    `fullname`            VARCHAR(255) COMMENT '全名',
    `english_name`        VARCHAR(255) COMMENT '英文名',
    `id_card`             VARCHAR(50) COMMENT '身份证',
    `sex`                 VARCHAR(10) COMMENT '性别',
    `birthday`            DATETIME COMMENT '生日',
    `description`         VARCHAR(255) COMMENT '备注',
    `start_date`          DATETIME COMMENT '有效开始日期',
    `end_date`            DATETIME COMMENT '有效结束日期',
    `entry_date`          DATETIME COMMENT '入职日期',
    `resignation_date`    DATETIME COMMENT '离职日期',
    `register_at`         DATETIME COMMENT '注册时间',
    `approval_at`         DATETIME COMMENT '审批日期',
    `approval_by`         BIGINT UNSIGNED COMMENT '审批人',
    `status`              TINYINT(1) UNSIGNED COMMENT '状态',
    `active`              TINYINT UNSIGNED COMMENT '启用状态',
    `created_at`          DATETIME COMMENT '创建时间',
    `created_by`          BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at`    DATETIME COMMENT '最后修改时间',
    `last_modified_by`    BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`          DATETIME COMMENT '删除时间',
    `deleted_by`          BIGINT UNSIGNED COMMENT '删除人',
    `source`              VARCHAR(50) COMMENT '来源',
    `source_key`          VARCHAR(255) COMMENT '来源标识',
    `source_extra`        VARCHAR(255) COMMENT '来源信息',
    CONSTRAINT `pk_sys_user` PRIMARY KEY (`id`)
);

CREATE INDEX `ix_sys_user_username` ON `sys_user` (`username`);
CREATE INDEX `ix_sys_user_email` ON `sys_user` (`email`);
CREATE INDEX `ix_sys_user_mobile` ON `sys_user` (`mobile_country_code`, `mobile`);
CREATE INDEX `ix_sys_user_active` ON `sys_user` (`active`);

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
    `id`             BIGINT UNSIGNED COMMENT 'ID',
    `relation_type`  VARCHAR(50) COMMENT '关联类型',
    `ancestor_id`    BIGINT UNSIGNED COMMENT '祖先ID',
    `entity_id`      BIGINT UNSIGNED COMMENT '实体ID',
    `relation_index` INT UNSIGNED COMMENT '层级序号',
    `parent_ind`     TINYINT(1) UNSIGNED COMMENT '是否直接上级',
    `full_path`      VARCHAR(2000) COMMENT '层级路径',
    `created_at`     DATETIME COMMENT '创建时间',
    `created_by`     BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_entity_relation` PRIMARY KEY (`id`)
);

/* 用户登录会话记录 */
CREATE TABLE `sys_user_session`
(
    `id`                   BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `user_id`              BIGINT UNSIGNED NOT NULL COMMENT 'User ID',
    `session_id`           VARCHAR(150) COMMENT 'Session ID',
    `host`                 VARCHAR(150) COMMENT '登录主机',
    `device`               VARCHAR(150) COMMENT '登录设备',
    `client_version`       VARCHAR(150) COMMENT '客户端版本',
    `platform`             VARCHAR(150) COMMENT '登录平台',
    `access_token`         TEXT(1000) COMMENT 'Access Token',
    `refresh_token`        TEXT(1000) COMMENT 'Refresh Token',
    `start_datetime`       DATETIME COMMENT '会话开始时间',
    `last_access_datetime` DATETIME COMMENT '最近访问时间',
    `end_datetime`         DATETIME COMMENT '会话结束时间',
    `total_time`           INT UNSIGNED COMMENT '在线时长',
    `start_year`           INT UNSIGNED COMMENT '年',
    `start_month`          INT UNSIGNED COMMENT '月',
    `start_day`            INT UNSIGNED COMMENT '日',
    `start_hour`           INT UNSIGNED COMMENT '时',
    `start_minute`         INT UNSIGNED COMMENT '分',
    CONSTRAINT `pk_sys_user_session_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_session`
    COMMENT '用户会话表';

/* 用户会话刷新历史记录表 */
CREATE TABLE `sys_user_session_token_history`
(
    `id`            BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `user_id`       BIGINT UNSIGNED NOT NULL COMMENT 'User ID',
    `session_id`    VARCHAR(150) COMMENT 'Session ID',
    `token`         TEXT(1000) COMMENT 'Token',
    `refresh_token` TEXT(1000) COMMENT 'Refresh Token',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_user_ses_token_his_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_session_token_history`
    COMMENT '用户会话刷新历史记录表';

/* ========================================================================================================= */
/* 国际化 */
/* ========================================================================================================= */

/* 语言类型 */
CREATE TABLE `sys_lang_type`
(
    `id`          BIGINT UNSIGNED COMMENT 'ID',
    `locale`      VARCHAR(100) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `description` VARCHAR(250) COMMENT '备注',
    `default_ind` TINYINT UNSIGNED COMMENT '默认语言',
    `active`      TINYINT UNSIGNED COMMENT '启用状态',
    CONSTRAINT `pk_sys_lang_type` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_lang_type`
    COMMENT '语言类型表';

/* 多语言文本表 */
CREATE TABLE `sys_lang_label`
(
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `lang_type_id`     BIGINT UNSIGNED COMMENT '语言类型ID',
    `target_type`      VARCHAR(100) COMMENT '目标类型',
    `target_entity_id` BIGINT UNSIGNED COMMENT '目标实体ID',
    `label`            VARCHAR(255) COMMENT '多语言文本',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    CONSTRAINT `pk_sys_lang_label` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_lang_label`
    COMMENT '多语言文本表';

CREATE INDEX `ix_sys_lang_label_lt_id` ON `sys_lang_label` (`lang_type_id`);
CREATE INDEX `ix_sys_lang_label_t` ON `sys_lang_label` (`target_type`, `target_entity_id`);

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
    `id`               BIGINT UNSIGNED COMMENT 'ID',
    `catalog_type_id`  BIGINT UNSIGNED COMMENT '分类类型ID',
    `code`             VARCHAR(150) COMMENT '编号',
    `title`            VARCHAR(255) COMMENT '标题',
    `description`      VARCHAR(255) COMMENT '简介',
    `root_ind`         TINYINT(1) UNSIGNED COMMENT '是否根分类' DEFAULT 0,
    `active`           TINYINT(1) UNSIGNED COMMENT '启用状态'  DEFAULT 1,
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`       DATETIME COMMENT '删除时间',
    `deleted_by`       BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_catalog_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_catalog`
    COMMENT '分类表';

CREATE INDEX `ix_sys_cat_ct_id` ON `sys_catalog` (`catalog_type_id`);

/* 分类层级关联 */
CREATE TABLE `sys_catalog_relation`
(
    `id`             BIGINT UNSIGNED COMMENT 'ID',
    `relation_type`  VARCHAR(50) COMMENT '关联类型',
    `ancestor_id`    BIGINT UNSIGNED COMMENT '祖先ID',
    `entity_id`      BIGINT UNSIGNED COMMENT '实体ID',
    `relation_index` INT UNSIGNED COMMENT '层级序号',
    `parent_ind`     TINYINT(1) UNSIGNED COMMENT '是否直接上级',
    `full_path`      VARCHAR(2000) COMMENT '层级路径',
    `created_at`     DATETIME COMMENT '创建时间',
    `created_by`     BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_catalog_relation` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_catalog_relation`
    COMMENT '分类层级关联表';

CREATE INDEX `ix_sys_cat_r_type` ON `sys_catalog_relation` (`relation_type`);
CREATE INDEX `ix_sys_cat_r_parent_id` ON `sys_catalog_relation` (`ancestor_id`);
CREATE INDEX `ix_sys_cat_r_child_id` ON `sys_catalog_relation` (`entity_id`);

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
    `created_by`         BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at`   DATETIME COMMENT '最后修改时间',
    `last_modified_by`   BIGINT UNSIGNED COMMENT '最后修改人',
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
    `id`               BIGINT UNSIGNED COMMENT '标签ID',
    `tag_type_id`      BIGINT UNSIGNED COMMENT '标签类型ID',
    `title`            VARCHAR(150) COMMENT '标题',
    `description`      VARCHAR(255) COMMENT '简介',
    `active`           TINYINT(1) COMMENT '启用状态',
    `created_at`       DATETIME COMMENT '创建时间',
    `created_by`       BIGINT UNSIGNED COMMENT '创建人',
    `last_modified_at` DATETIME COMMENT '最后修改时间',
    `last_modified_by` BIGINT UNSIGNED COMMENT '最后修改人',
    `deleted_at`       DATETIME COMMENT '删除时间',
    `deleted_by`       BIGINT UNSIGNED COMMENT '删除人',
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

/* ========================================================================================================= */
/* 基础数据 */
/* ========================================================================================================= */

insert into sys_client (id, client_id, client_secret, authorization_grant_types, client_authentication_methods,
                        redirect_uris, scopes, active, created_at)
values (1, 'webapp', '$2a$10$vLBvzWIja24Ex.E2FLQbaOib0GXJ3VW5LhjmCtbdtUbamxKG8Jiq2',
        'basic,post', 'authorization_code,client_credentials,password,refresh_token', '', 'webapp', 1, now());

/* 用户与角色 */
insert into sys_role_type (id, code, label, description, active)
values (1, 'SYSTEM_ADMINISTRTOR', 'label_role_system_administrtor', 'System Administrator', 1),
       (2, 'ADMINISTRTOR', 'label_role_administrtor', 'Administrator', 1),
       (3, 'USER', 'label_role_user', 'User', 1),
       (4, 'ANONYMOUS_USER', 'label_role_anonymous_user', 'Anonymous User', 1);

insert into sys_role (id, code, title, label, active, created_at)
values (1, 'SYSTEM_ADMINISTRTOR', 'System Administrator', 'label_role_system_administrtor', 1, now()),
       (2, 'ADMINISTRTOR', 'Administrator', 'label_role_administrtor', 1, now()),
       (3, 'USER', 'User', 'label_role_user', 1, now()),
       (4, 'ANONYMOUS_USER', 'Anonymous User', 'label_role_anonymous_user', 1, now());

insert into sys_user (id, username, email, mobile_country_code, mobile, nickname, active, created_at, password)
values (1, 'admin', 'platform@host.com', '86', '13800138000', 'Administrator', 1, now(),
        '$2a$10$MLkjYEPJkO6KNrfUUBld6eWVr1G09nugg5UpIQVUtsQ.3Z9U2lOSK');

/* 语言类型 */
insert into sys_lang_type (id, locale, label, description, default_ind, active)
values (1, 'zh_CN', 'label_lang_type_zh_cn', '简体中文', 1, 1),
       (2, 'zh_CN', 'label_lang_type_zh_tw', '繁体中文', 2, 1),
       (3, 'zh_CN', 'label_lang_type_en_us', '美式英语', 3, 1);

/* 部门 */
insert into sys_department (id, code, title, description, active)
values (1, 'ROOT', 'Root', 'Root', 1);

/* 岗位 */
insert into sys_position (id, code, title, description, active)
values (1, 'ROOT', 'Root', 'Root', 1);
