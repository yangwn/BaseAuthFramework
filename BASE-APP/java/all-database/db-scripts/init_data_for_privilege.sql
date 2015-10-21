#BEGIN*************************权限表数据***************************BEGIN
#1. p_module
#2. p_resource
#3. p_user
#4. p_role
#5. p_role_module
#6. p_role_resource
#7. p_user_role
#8. p_department
#END***************************权限表数据***************************END

INSERT INTO `p_module`(id,name,flag,url,sort_no,create_person,create_date,update_person,update_date) 
VALUES
(1,'配置中心','p','http://127.0.0.1:10002/privilege-server',10,'system',NOW(),'system',NOW())
;

INSERT INTO `p_resource` (`id`, `name`, `url`, `remark`, `parent_id`, `permission`, `structure`, `type`, `sort_no`, `module_flag`, `create_person`, `create_date`, `update_person`, `update_date`)
VALUES
(1, '部门管理', '/controller/department/list.do', '', 0, 'perms[department:list],authc', 's-1', 1, 1, 'p', 'system', '2015-07-27 19:52:08', 'root', '2015-07-29 23:08:43'),
(2, '权限管理', '/controller/resource/list.do', '', 0, 'perms[resource:list],authc', 's-2', 1, 2, 'p', 'system', '2015-07-27 19:52:08', 'system', '2015-07-27 19:52:08'),
(3, '角色管理', '/controller/role/list.do', '', 0, 'perms[role:list],authc', 's-3', 1, 3, 'p', 'system', '2015-07-27 19:52:08', 'system', '2015-07-27 19:52:08'),
(4, '帐户管理', '/controller/user/list.do', '', 0, 'perms[user:list],authc', 's-4', 1, 4, 'p', 'system', '2015-07-27 19:52:08', 'system', '2015-07-27 19:52:08'),
(5, '子部门管理', '/controller/department/list.do', '', 1, 'perms[department:list],authc', 's-1-1', 1, 1, 'p', 'root', '2015-07-29 23:08:03', 'root', '2015-07-29 23:08:03'),
(6, '部门删除', '/controller/department/delete', '', 5, 'perms[department:delete],authc', 's-1-1-1', 2, 0, 'p', 'root', '2015-07-29 23:09:01', 'root', '2015-07-29 23:09:01');

--密码为root,对应的MD5为 63a9f0ea7bb98050796b649e85481845
INSERT INTO `p_user` 
VALUES 
(1, 'root', '63a9f0ea7bb98050796b649e85481845', '管理员', 1, 1, 0, 1, 0, 'system', '2013-10-21 01:04:49', 'system', '2013-10-21 01:04:49'),
(2, 'cl', '63a9f0ea7bb98050796b649e85481845', '电子商务', 1, 0, 1, 2, 0, 'root', '2013-10-23 01:09:30', 'root', '2013-10-23 01:09:30'),
(3, 'test', '63a9f0ea7bb98050796b649e85481845', '测试', 1, 0, 2, 3, 1, 'root', '2013-10-21 01:06:08', 'root', '2013-10-21 01:06:08');

INSERT INTO `p_role` VALUES (1, '物流总监', '物流总监', 'root', '2013-10-23 01:08:24', 'root', '2013-10-23 01:08:43');
INSERT INTO `p_role` VALUES (2, '客服总监', '客服总监', 'root', '2013-10-23 01:08:32', 'root', '2013-10-23 01:08:38');
INSERT INTO `p_role` VALUES (3, '运营总监', '运营总监', 'root', '2013-10-21 01:05:31', 'root', '2013-10-21 01:05:34');

INSERT INTO `p_role_module` VALUES (1, 1);
INSERT INTO `p_role_module` VALUES (2, 1);

INSERT INTO `p_role_resource` VALUES (1, 1);
INSERT INTO `p_role_resource` VALUES (1, 1);
INSERT INTO `p_role_resource` VALUES (1, 1);
INSERT INTO `p_role_resource` VALUES (2, 2);
INSERT INTO `p_role_resource` VALUES (2, 2);
INSERT INTO `p_role_resource` VALUES (2, 2);

INSERT INTO `p_department` VALUES (1, '电子商务', '', 0, 's-1', '1', 'system', '2013-10-21 01:04:50', 'root', '2013-10-23 01:03:39');
INSERT INTO `p_department` VALUES (2, '商品中心', '', 1, 's-1-1', '2', 'root', '2013-10-23 00:55:56', 'root', '2013-10-23 01:05:13');
INSERT INTO `p_department` VALUES (3, '技术中心', '', 1, 's-1-2', '3', 'root', '2013-10-23 00:56:10', 'root', '2013-10-23 01:06:18');
INSERT INTO `p_department` VALUES (4, '管理中心', '', 1, 's-1-3', '1', 'root', '2013-10-23 00:56:22', 'root', '2013-10-23 01:04:10');
INSERT INTO `p_department` VALUES (5, '总裁办', '', 4, 's-1-3-1', '1', 'root', '2013-10-23 00:56:41', 'root', '2013-10-23 01:04:23');
INSERT INTO `p_department` VALUES (6, '财务部', '', 4, 's-1-3-2', '2', 'root', '2013-10-23 01:03:56', 'root', '2013-10-23 01:04:32');
INSERT INTO `p_department` VALUES (7, '人力资源部', '', 4, 's-1-3-3', '3', 'root', '2013-10-23 01:04:51', 'root', '2013-10-23 01:04:51');
INSERT INTO `p_department` VALUES (8, '开发组', '', 3, 's-1-2-1', '1', 'root', '2013-10-23 01:06:02', 'root', '2013-10-23 01:06:57');
INSERT INTO `p_department` VALUES (9, '测试组', '', 3, 's-1-2-2', '2', 'root', '2013-10-23 01:06:34', 'root', '2013-10-23 01:07:04');
INSERT INTO `p_department` VALUES (10, '运维组', '', 3, 's-1-2-3', '3', 'root', '2013-10-23 01:07:12', 'root', '2013-10-23 01:07:12');
INSERT INTO `p_department` VALUES (11, '视觉形象部', '', 2, 's-1-1-3', '3', 'root', '2013-10-23 01:05:47', 'root', '2013-10-23 01:05:47');
INSERT INTO `p_department` VALUES (12, '女装部', '', 11, 's-1-1-1', '1', 'root', '2013-10-23 01:05:23', 'root', '2013-10-23 01:05:23');
INSERT INTO `p_department` VALUES (13, '男装部', '', 11, 's-1-1-2', '2', 'root', '2013-10-23 01:05:32', 'root', '2013-10-23 01:05:32');

INSERT INTO `p_user_role` VALUES (2, 1);