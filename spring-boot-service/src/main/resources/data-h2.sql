INSERT INTO t_user (id, name,password, roles, url) VALUES (1, 'admin','password','admin','https://longfeizheng.io');

INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (1, 'el-icon-lx-home','dashboard','系统首页', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (2, 'el-icon-lx-cascades','table','基础表格', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (3, 'el-icon-lx-copy','tabs','tab选项卡', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (4, 'el-icon-lx-calendar','3','表单相关', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (5, null,'form','基本表单', 1, 4);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (6, null,'3-2','三级菜单', 1, 4);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (7, null,'editor','富文本编辑器', 2, 6);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (8, null,'markdown','markdown编辑器', 2, 6);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (9, null,'upload','文件上传', 1, 4);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (10, 'el-icon-lx-emoji','icon','自定义图标', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (11, 'el-icon-pie-chart','charts','schart图表', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (12, 'el-icon-rank','6','拖拽组件', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (13, null,'drag','拖拽列表', 1, 12);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (14, null,'dialog','拖拽弹框', 1, 12);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (15, 'el-icon-lx-global','i18n','国际化功能', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (16, 'el-icon-lx-warn','7','错误处理', 0, 0);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (17, null,'permission','拖拽弹框', 1, 16);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (18, null,'404','404页面', 1, 16);
INSERT INTO t_menu_item (id, icon, index, title, level, parent_id) VALUES (19, 'el-icon-lx-warn','menu','菜单管理', 0, 0);

