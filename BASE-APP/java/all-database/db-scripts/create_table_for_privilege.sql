#BEGIN*************************权限表单列表***************************BEGIN
#1. p_module
#2. p_resource
#3. p_user
#4. p_role
#5. p_role_module
#6. p_role_resource
#7. p_user_role
#8. p_department 是否与p_area 重复
#9. p_area
#END***************************权限表单列表***************************END

#系统模块表
DROP TABLE IF EXISTS `p_module`;
CREATE TABLE `p_module` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键' ,
`name`  varchar(50) NOT NULL DEFAULT '' COMMENT '系统模块名称' ,
`flag`  varchar(20) NOT NULL DEFAULT '' COMMENT '系统模块标记' ,
`url`  varchar(300) NOT NULL DEFAULT '' COMMENT '系统访问URL' ,
`sort_no`  int(11) NOT NULL DEFAULT 0 COMMENT '排序号' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人' ,
`update_date`  datetime NOT NULL COMMENT '最后更新时间' ,
PRIMARY KEY (`id`)
)
COMMENT='系统模块表'
;

#权限资源表
DROP TABLE IF EXISTS `p_resource`;

CREATE TABLE `p_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单资源名称',
  `url` varchar(300) NOT NULL DEFAULT '' COMMENT '菜单资源URL',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '菜单资源简要描述',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级id',
  `permission` varchar(64) DEFAULT NULL COMMENT '权限控制表达式',
  `structure` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单的层级结构',
  `type` int(1) DEFAULT NULL COMMENT '1.导航类型;2.安全类型',
  `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `module_flag` varchar(20) NOT NULL DEFAULT '' COMMENT '所属系统模块的标记',
  `create_person` varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人',
  `create_date` datetime NOT NULL COMMENT '记录生成时间',
  `update_person` varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人',
  `update_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_structure` (`structure`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='权限资源表';
#用户表
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'UUID主键' ,
`username`  varchar(30) NOT NULL DEFAULT '' COMMENT '登录用户名' ,
`password`  varchar(50) NOT NULL DEFAULT '' COMMENT '登录密码' ,
`fullname`  varchar(30) NOT NULL DEFAULT '' COMMENT '姓名' ,
`gender`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '性别：1男0女' ,
`is_admin`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否管理员：1是0否' ,
`department_id`  int(11) NOT NULL DEFAULT 0 COMMENT '外键，所属部门Id' ,
`is_lock`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否锁定：1是0否' ,
`is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除：1是0否' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人' ,
`update_date`  datetime NOT NULL COMMENT '最后更新时间' ,
PRIMARY KEY (`id`),
INDEX `idx_username` (`username`) USING BTREE 
)
COMMENT='用户表'
;

#角色表
DROP TABLE IF EXISTS `p_role`;
CREATE TABLE `p_role` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'UUID主键' ,
`name`  varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称' ,
`remark`  varchar(500) NOT NULL DEFAULT '' COMMENT '角色描述' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人' ,
`update_date`  datetime NOT NULL COMMENT '最后更新时间' ,
PRIMARY KEY (`id`)
)
COMMENT='角色表'
;

#角色系统模块关系表
DROP TABLE IF EXISTS `p_role_module`;
CREATE TABLE `p_role_module` (
`role_id`  int(11) NOT NULL COMMENT '角色ID' ,
`module_id`  int(11) NOT NULL COMMENT '模块ID' ,
INDEX `idx_role_id` (`role_id`) USING BTREE ,
INDEX `idx_module_id` (`module_id`) USING BTREE 
)
COMMENT='角色系统模块关系表'
;

#角色权限资源关系表
DROP TABLE IF EXISTS `p_role_resource`;
CREATE TABLE `p_role_resource` (
`role_id`  int(11) NOT NULL COMMENT '角色ID' ,
`resource_id`  int(11) NOT NULL COMMENT '资源ID' ,
INDEX `idx_role_id` (`role_id`) USING BTREE ,
INDEX `idx_resource_id` (`resource_id`) USING BTREE 
)
COMMENT='角色权限资源关系表'
;

#用户角色关系表
DROP TABLE IF EXISTS `p_user_role`;
CREATE TABLE `p_user_role` (
`user_id`  int(11) NOT NULL COMMENT '用户ID' ,
`role_id`  int(11) NOT NULL COMMENT '角色ID' ,
INDEX `idx_user_id` (`user_id`) USING BTREE ,
INDEX `idx_role_id` (`role_id`) USING BTREE 
)
COMMENT='用户角色关系表'
;

#部门表
DROP TABLE IF EXISTS `p_department`;
CREATE TABLE `p_department` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'UUID主键' ,
`name`  varchar(30) NOT NULL DEFAULT '' COMMENT '部门名称' ,
`remark`  varchar(500) NOT NULL DEFAULT '' COMMENT '部门描述' ,
`parent_id`  int(11) NOT NULL DEFAULT 0 COMMENT '父级id' ,
`structure`  varchar(20) NOT NULL DEFAULT '' COMMENT '部门的层级结构' ,
`sort_no`  int(11) NOT NULL DEFAULT 0  COMMENT '排序号' ,
`create_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人' ,
`create_date`  datetime NOT NULL COMMENT '记录生成时间' ,
`update_person`  varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人' ,
`update_date`  datetime NOT NULL COMMENT '最后更新时间' ,
PRIMARY KEY (`id`)
)
COMMENT='部门表'
;