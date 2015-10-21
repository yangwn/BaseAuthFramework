# ************************************************************
# Sequel Pro SQL dump
# Version 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.27)
# Database: admin
# Generation Time: 2015-10-21 08:18:31 +0000
# ************************************************************

# Dump of table p_department
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_department`;

CREATE TABLE `p_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'UUID主键',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '部门名称',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '部门描述',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级id',
  `structure` varchar(20) NOT NULL DEFAULT '' COMMENT '部门的层级结构',
  `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `create_person` varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人',
  `create_date` datetime NOT NULL COMMENT '记录生成时间',
  `update_person` varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人',
  `update_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

LOCK TABLES `p_department` WRITE;
/*!40000 ALTER TABLE `p_department` DISABLE KEYS */;

INSERT INTO `p_department` (`id`, `name`, `remark`, `parent_id`, `structure`, `sort_no`, `create_person`, `create_date`, `update_person`, `update_date`)
VALUES
	(1,'电子商务','',0,'s-1',1,'system','2013-10-21 01:04:50','root','2013-10-23 01:03:39'),
	(2,'商品中心','',1,'s-1-1',2,'root','2013-10-23 00:55:56','root','2013-10-23 01:05:13'),
	(3,'技术中心','',1,'s-1-2',3,'root','2013-10-23 00:56:10','root','2013-10-23 01:06:18'),
	(4,'管理中心','',1,'s-1-3',1,'root','2013-10-23 00:56:22','root','2013-10-23 01:04:10'),
	(5,'总裁办','',4,'s-1-3-1',1,'root','2013-10-23 00:56:41','root','2013-10-23 01:04:23'),
	(6,'财务部','',4,'s-1-3-2',2,'root','2013-10-23 01:03:56','root','2013-10-23 01:04:32'),
	(7,'人力资源部','',4,'s-1-3-3',3,'root','2013-10-23 01:04:51','root','2013-10-23 01:04:51'),
	(8,'开发组','',3,'s-1-2-1',1,'root','2013-10-23 01:06:02','root','2013-10-23 01:06:57'),
	(9,'测试组','',3,'s-1-2-2',2,'root','2013-10-23 01:06:34','root','2013-10-23 01:07:04'),
	(10,'运维组','',3,'s-1-2-3',3,'root','2013-10-23 01:07:12','root','2013-10-23 01:07:12'),
	(11,'视觉部','',2,'s-1-1-3',3,'root','2013-10-23 01:05:47','root','2013-10-23 01:05:47'),
	(12,'服装部','',11,'s-1-1-1',1,'root','2013-10-23 01:05:23','root','2013-10-23 01:05:23'),
	(13,'装潢部','',11,'s-1-1-2',2,'root','2013-10-23 01:05:32','root','2013-10-23 01:05:32');

/*!40000 ALTER TABLE `p_department` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_module`;

CREATE TABLE `p_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '系统模块名称',
  `flag` varchar(20) NOT NULL DEFAULT '' COMMENT '系统模块标记',
  `url` varchar(300) NOT NULL DEFAULT '' COMMENT '系统访问URL',
  `sort_no` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `create_person` varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人',
  `create_date` datetime NOT NULL COMMENT '记录生成时间',
  `update_person` varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人',
  `update_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模块表';

LOCK TABLES `p_module` WRITE;
/*!40000 ALTER TABLE `p_module` DISABLE KEYS */;

INSERT INTO `p_module` (`id`, `name`, `flag`, `url`, `sort_no`, `create_person`, `create_date`, `update_person`, `update_date`)
VALUES
	(1,'配置中心','p','http://127.0.0.1:10002/privilege-server',10,'system','2015-10-12 10:13:45','system','2015-10-12 10:13:45');

/*!40000 ALTER TABLE `p_module` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_resource
# ------------------------------------------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限资源表';

LOCK TABLES `p_resource` WRITE;
/*!40000 ALTER TABLE `p_resource` DISABLE KEYS */;

INSERT INTO `p_resource` (`id`, `name`, `url`, `remark`, `parent_id`, `permission`, `structure`, `type`, `sort_no`, `module_flag`, `create_person`, `create_date`, `update_person`, `update_date`)
VALUES
	(1,'部门管理','/controller/department/list.do','',0,'perms[department:list],authc','s-1',1,1,'p','system','2015-07-27 19:52:08','root','2015-07-29 23:08:43'),
	(2,'权限管理','/controller/resource/list.do','',0,'perms[resource:list],authc','s-2',1,2,'p','system','2015-07-27 19:52:08','system','2015-07-27 19:52:08'),
	(3,'角色管理','/controller/role/list.do','',0,'perms[role:list],authc','s-3',1,3,'p','system','2015-07-27 19:52:08','system','2015-07-27 19:52:08'),
	(4,'帐户管理','/controller/user/list.do','',0,'perms[user:list],authc','s-4',1,4,'p','system','2015-07-27 19:52:08','system','2015-07-27 19:52:08'),
	(5,'子部门管理','/controller/department/list.do','',1,'perms[department:list],authc','s-1-1',1,1,'p','root','2015-07-29 23:08:03','root','2015-07-29 23:08:03'),
	(6,'部门删除','/controller/department/delete','',5,'perms[department:delete],authc','s-1-1-1',2,0,'p','root','2015-07-29 23:09:01','root','2015-07-29 23:09:01');

/*!40000 ALTER TABLE `p_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_role`;

CREATE TABLE `p_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'UUID主键',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '角色描述',
  `create_person` varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人',
  `create_date` datetime NOT NULL COMMENT '记录生成时间',
  `update_person` varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人',
  `update_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

LOCK TABLES `p_role` WRITE;
/*!40000 ALTER TABLE `p_role` DISABLE KEYS */;

INSERT INTO `p_role` (`id`, `name`, `remark`, `create_person`, `create_date`, `update_person`, `update_date`)
VALUES
	(1,'CPO','物流总监','root','2013-10-23 01:08:24','root','2013-10-23 01:08:43'),
	(2,'CCO','客服总监','root','2013-10-23 01:08:32','root','2013-10-23 01:08:38'),
	(3,'COO','运营总监','root','2013-10-21 01:05:31','root','2013-10-21 01:05:34'),
	(4,'采购主管','采购主管','root','2015-10-20 15:02:30','root','2015-10-20 15:02:30');

/*!40000 ALTER TABLE `p_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_role_module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_role_module`;

CREATE TABLE `p_role_module` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `module_id` int(11) NOT NULL COMMENT '模块ID',
  KEY `idx_role_id` (`role_id`) USING BTREE,
  KEY `idx_module_id` (`module_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色系统模块关系表';

LOCK TABLES `p_role_module` WRITE;
/*!40000 ALTER TABLE `p_role_module` DISABLE KEYS */;

INSERT INTO `p_role_module` (`role_id`, `module_id`)
VALUES
	(1,1),
	(2,1),
	(4,1);

/*!40000 ALTER TABLE `p_role_module` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_role_resource
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_role_resource`;

CREATE TABLE `p_role_resource` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '资源ID',
  KEY `idx_role_id` (`role_id`) USING BTREE,
  KEY `idx_resource_id` (`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限资源关系表';

LOCK TABLES `p_role_resource` WRITE;
/*!40000 ALTER TABLE `p_role_resource` DISABLE KEYS */;

INSERT INTO `p_role_resource` (`role_id`, `resource_id`)
VALUES
	(1,1),
	(2,2),
	(4,1),
	(4,5),
	(4,6);

/*!40000 ALTER TABLE `p_role_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_user`;

CREATE TABLE `p_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'UUID主键',
  `username` varchar(30) NOT NULL DEFAULT '' COMMENT '登录用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '登录密码',
  `fullname` varchar(30) NOT NULL DEFAULT '' COMMENT '姓名',
  `gender` tinyint(1) NOT NULL DEFAULT '1' COMMENT '性别：1男0女',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '外键，所属部门Id',
  `is_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否管理员：1是0否',
  `is_lock` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否锁定：1是0否',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除：1是0否',
  `create_person` varchar(30) NOT NULL DEFAULT '' COMMENT '记录生成人',
  `create_date` datetime NOT NULL COMMENT '记录生成时间',
  `update_person` varchar(30) NOT NULL DEFAULT '' COMMENT '最后更新人',
  `update_date` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

LOCK TABLES `p_user` WRITE;
/*!40000 ALTER TABLE `p_user` DISABLE KEYS */;

INSERT INTO `p_user` (`id`, `username`, `password`, `fullname`, `gender`, `department_id`, `is_admin`, `is_lock`, `is_delete`, `create_person`, `create_date`, `update_person`, `update_date`)
VALUES
	(1,'root','63a9f0ea7bb98050796b649e85481845','管理员',1,0,1,0,0,'system','2013-10-21 01:04:49','system','2013-10-21 01:04:49'),
	(2,'cl','63a9f0ea7bb98050796b649e85481845','电子商务',1,1,0,0,0,'root','2013-10-23 01:09:30','root','2013-10-23 01:09:30'),
	(3,'test','63a9f0ea7bb98050796b649e85481845','测试',1,2,0,0,1,'root','2013-10-21 01:06:08','root','2013-10-21 01:06:08'),
	(4,' go','63a9f0ea7bb98050796b649e85481845','采购',1,2,0,0,0,'root','2015-10-20 15:02:10','root','2015-10-20 15:02:10');

/*!40000 ALTER TABLE `p_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table p_user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `p_user_role`;

CREATE TABLE `p_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

LOCK TABLES `p_user_role` WRITE;
/*!40000 ALTER TABLE `p_user_role` DISABLE KEYS */;

INSERT INTO `p_user_role` (`user_id`, `role_id`)
VALUES
	(2,1),
	(1,1);

/*!40000 ALTER TABLE `p_user_role` ENABLE KEYS */;
UNLOCK TABLES;