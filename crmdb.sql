/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : crmdb

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 15/06/2023 16:43:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business_record
-- ----------------------------
DROP TABLE IF EXISTS `business_record`;
CREATE TABLE `business_record`  (
  `rec_id` int NOT NULL AUTO_INCREMENT COMMENT '客户交往记录编号',
  `rec_date` date NOT NULL COMMENT '客户交往日期',
  `rec_loc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户交往地点',
  `rec_summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户交往概要',
  `rec_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户交往详细信息',
  `cus_id` int NOT NULL COMMENT '客户编号',
  `salesman_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '销售员',
  PRIMARY KEY (`rec_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of business_record
-- ----------------------------
INSERT INTO `business_record` VALUES (1, '2023-06-15', '中国', '12', '123', 2, '张小川');
INSERT INTO `business_record` VALUES (2, '2023-06-15', '中国', '12', '4444', 2, '张小川');
INSERT INTO `business_record` VALUES (4, '2023-06-09', '123', '123123', '213213', 2, '123213');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `con_id` int NOT NULL AUTO_INCREMENT COMMENT '联系人编号',
  `con_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人姓名',
  `con_gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人性别：男、女',
  `con_job` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人职位',
  `con_tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人办公电话',
  `con_phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人手机号码',
  `con_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人备注',
  `cus_id` int NOT NULL COMMENT '客户编号',
  PRIMARY KEY (`con_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, '张小川', '男', '项目经理', '66668888', '13013974639876', '喜欢喝白酒，66666666666666666666', 1);
INSERT INTO `contact` VALUES (4, '123', '男', '123123', '123123', '123213', '21312323', 1);
INSERT INTO `contact` VALUES (7, '123', '男', '123123', '123123', '123213', '21312323', 2);
INSERT INTO `contact` VALUES (8, '12313', '男', '213213', '123213', '123213', '213213', 2);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `cus_id` int NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `cus_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户名称',
  `cus_region` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户地区： 东北、西北、华北、华中、西南、华东',
  `cus_industry` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户行业：金融、房地产、商业服务、运输物流、生产、政府、文化传媒、其他',
  `cus_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户等级：大客户、普通客户、VIP客户',
  `cus_rate` int NOT NULL COMMENT '客户评分：1，2，3，4，5',
  `cus_credit` int NOT NULL COMMENT '信用等级：1，2，3，4，5',
  `cus_addr` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户地址',
  `cus_postcode` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户邮编',
  `cus_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户电话',
  `cus_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户网址',
  `cus_fax` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户传真',
  `cus_salesman` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户的销售员',
  `cus_state` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户状态：正常、流失',
  PRIMARY KEY (`cus_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '流失');
INSERT INTO `customer` VALUES (2, '重庆理工大学', '西南', '教育', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (3, '重庆交通大学', '西南', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (4, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '流失');
INSERT INTO `customer` VALUES (5, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (6, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (7, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (8, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (9, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (10, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (11, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (12, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (13, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (14, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (15, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (16, '招商银行', '华东', '金融', 'VIP客户', 5, 5, '上海市浦东区陆家嘴', '800000', '021-88889555', 'www.cmcb.com', '021-88889555', '123', '正常');
INSERT INTO `customer` VALUES (17, '123', '东北', '教育', '普通客户', 3, 2, '123', '123', '123', '13', '213', '123', '正常');
INSERT INTO `customer` VALUES (18, '重庆大学', '东北', '征服', '普通客户', 4, 4, '123123', '123213', '123213', '123123', '213213123', '123123', '正常');

-- ----------------------------
-- Table structure for customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `customer_loss`;
CREATE TABLE `customer_loss`  (
  `cl_id` int NOT NULL AUTO_INCREMENT COMMENT '流失预警ID，主键，自动递增',
  `cus_id` int NOT NULL COMMENT '客户ID',
  `su_id` int NOT NULL COMMENT '客户经理ID',
  `cl_order_time` timestamp NOT NULL COMMENT '上次下单时间',
  `cl_pause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '暂缓流失措施',
  `cl_loss_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '确认流失原因',
  `cl_loss_time` timestamp NULL DEFAULT NULL COMMENT '确认流失时间',
  `cl_status` int NULL DEFAULT NULL COMMENT '状态。1-预警、2-暂缓、3-流失、4-挽回',
  PRIMARY KEY (`cl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer_loss
-- ----------------------------
INSERT INTO `customer_loss` VALUES (1, 1, 1, '2019-11-17 15:22:40', '', '', NULL, 2);
INSERT INTO `customer_loss` VALUES (2, 2, 1, '2019-03-18 15:21:50', '', '', NULL, 1);

-- ----------------------------
-- Table structure for dev_plan
-- ----------------------------
DROP TABLE IF EXISTS `dev_plan`;
CREATE TABLE `dev_plan`  (
  `dev_id` int NOT NULL AUTO_INCREMENT COMMENT '开发计划编号',
  `sal_id` int NOT NULL COMMENT '销售机会编号',
  `dev_date` date NOT NULL COMMENT '计划日期',
  `dev_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '计划内容',
  `dev_dateexec` date NULL DEFAULT NULL COMMENT '执行日期',
  `dev_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行结果',
  `dev_executor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执行人',
  PRIMARY KEY (`dev_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dev_plan
-- ----------------------------
INSERT INTO `dev_plan` VALUES (1, 1, '2022-04-30', '无', '2022-05-21', '无', NULL);
INSERT INTO `dev_plan` VALUES (4, 3, '2023-06-13', '123', '2023-06-13', '乐----2023-06-13', 'zxc');
INSERT INTO `dev_plan` VALUES (5, 3, '2023-06-13', '大师傅', '2023-07-18', NULL, NULL);
INSERT INTO `dev_plan` VALUES (6, 3, '2023-06-22', '阿斯顿发发生发撒法手动阀发射点法发是', '2023-06-13', '客户同意进一步商谈----2023-06-13     用户成功下单----2023-06-13    开发成功----2023-06-13\n', NULL);
INSERT INTO `dev_plan` VALUES (7, 5, '2023-06-17', '金樽清酒斗十千', NULL, NULL, NULL);
INSERT INTO `dev_plan` VALUES (8, 5, '2023-06-30', '玉盘珍馐直万钱', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `odr_id` int NOT NULL AUTO_INCREMENT COMMENT '订单编号，主键，自动递增',
  `odr_time` timestamp NOT NULL COMMENT '订单日期',
  `odr_amount` decimal(7, 2) NOT NULL COMMENT '订单金额',
  `odr_shipto` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '送货地址',
  `odr_status` int NOT NULL COMMENT '订单状态。1-未付款、2-已付款、3-已发货、4-已收货、5-已退货',
  `cus_id` int NULL DEFAULT NULL COMMENT '客户编号',
  PRIMARY KEY (`odr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2019-03-18 15:21:50', 5000.00, '毕节市七星关区', 1, 2);
INSERT INTO `orders` VALUES (2, '2019-11-17 15:22:40', 8000.00, '毕节市高铁站', 2, 1);
INSERT INTO `orders` VALUES (3, '2021-12-28 15:23:13', 10000.00, '贵阳市', 3, 3);

-- ----------------------------
-- Table structure for sale_chance
-- ----------------------------
DROP TABLE IF EXISTS `sale_chance`;
CREATE TABLE `sale_chance`  (
  `sal_id` int NOT NULL AUTO_INCREMENT COMMENT '销售机会编号',
  `cus_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户名称',
  `sal_chance_source` int NOT NULL COMMENT '机会来源：1.促销、2.广告、3.搜索引擎、4.线上咨询、5.电话查询、6.邮件咨询、7.客户介绍',
  `sal_contact` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系人',
  `sal_contact_tel` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '联系电话',
  `sal_success_rate` int NOT NULL COMMENT '成功几率%',
  `sal_abs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '概要',
  `sal_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '机会描述',
  `sal_creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
  `sal_creat_time` datetime NOT NULL COMMENT '创建时间',
  `sal_assto` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '指派给',
  `sal_ass_time` datetime NULL DEFAULT NULL COMMENT '指派时间',
  `sal_state` int NOT NULL COMMENT '状态：1.未分配、2.已分配、3.开发成功、4.开发失败',
  PRIMARY KEY (`sal_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sale_chance
-- ----------------------------
INSERT INTO `sale_chance` VALUES (1, 'CQUT', 2, '张小川', '11012011932', 98, '系统设计', '数字教学系统设计', 'root', '2023-06-09 17:44:33', 'asto', '2023-06-09 21:14:32', 2);
INSERT INTO `sale_chance` VALUES (2, 'CQUT', 2, '张小川', '11012011932', 98, '系统设计', '数字教学系统设计', 'root', '2023-06-09 17:44:33', 'root', '2023-06-09 21:17:30', 2);
INSERT INTO `sale_chance` VALUES (3, '招商银行', 5, 'jack', '12345678910', 50, '五', '吃饭', 'root', '2023-06-09 16:33:22', 'zxc', '2023-06-12 15:47:10', 3);
INSERT INTO `sale_chance` VALUES (4, 'Cqut', 2, '张栋', '110', 60, '没有', '没有', 'root', '2023-06-11 11:28:23', 'root', '2023-06-11 11:28:37', 2);
INSERT INTO `sale_chance` VALUES (5, 'sd', 1, 'd', '234', 234, 'dsf', 'sd', 'user1', '2023-06-12 11:40:13', 'zxc', '2023-06-13 10:41:19', 4);

-- ----------------------------
-- Table structure for services
-- ----------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services`  (
  `ser_id` int NOT NULL AUTO_INCREMENT COMMENT '服务编号',
  `ser_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务类型：咨询、投诉、建议',
  `ser_summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务概要',
  `ser_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务详细要求',
  `cus_id` int NOT NULL COMMENT '客户编号',
  `ser_creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务创建人：当前登录用户',
  `ser_create_time` datetime NOT NULL COMMENT '服务创建时间：当前系统时间',
  `ser_state` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务状态：新创建、已分配、已处理、已归档',
  `ser_alloc_time` datetime NULL DEFAULT NULL COMMENT '服务分配时间',
  `ser_handler` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理人',
  `ser_process_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务处理方法',
  `ser_process_time` datetime NULL DEFAULT NULL COMMENT '服务处理时间',
  `ser_cus_feedback` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户反馈',
  `ser_cus_rate` int NULL DEFAULT NULL COMMENT '客户满意度:1,2,3,4,5',
  `ser_feedback_time` datetime NULL DEFAULT NULL COMMENT '客户反馈时间',
  PRIMARY KEY (`ser_id`) USING BTREE,
  INDEX `cus_id`(`cus_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of services
-- ----------------------------
INSERT INTO `services` VALUES (4, '咨询', '9999', '123', 1, '123', '2023-06-12 16:16:41', '已归档', '2023-06-12 16:16:41', '123123', '123123', '2023-06-12 16:16:41', '12312312313', 3, '2023-06-12 16:16:41');
INSERT INTO `services` VALUES (5, '建议', '1231312312313', '6666', 123, '123', '2023-06-12 16:16:48', '已归档', '2023-06-12 16:16:48', '213', '1313', '2023-06-12 16:16:48', '12313', 3, '2023-06-12 16:16:48');
INSERT INTO `services` VALUES (6, '咨询', '123', '123', 1, '123', '2023-06-12 15:33:17', '已处理', '2023-06-12 15:33:17', '234324', '234324', '2023-06-12 15:33:17', '123213', 5, '2023-06-12 15:33:17');
INSERT INTO `services` VALUES (8, '投诉', '123456', '9999', 1, '123', '2023-06-12 15:33:24', '已分配', '2023-06-12 15:33:24', 'user1', '123123', '2023-06-12 15:33:24', '123123', 2, '2023-06-12 16:05:06');
INSERT INTO `services` VALUES (9, '咨询', '21323', '13123123', 123123123, '213123', '2023-06-12 16:16:17', '已归档', '2023-06-12 16:16:17', 'user1', '牛牛牛22', '2023-06-12 16:16:17', '123123', 4, '2023-06-12 16:16:17');
INSERT INTO `services` VALUES (10, '咨询', '123123', '213213', 123213, '123213', '2023-06-12 16:16:29', '已归档', '2023-06-12 16:16:29', 'user1', '12312323', '2023-06-12 16:16:29', '12313', 5, '2023-06-12 16:16:29');
INSERT INTO `services` VALUES (11, '咨询', '123', '1231', 12123, '12213', '2023-06-11 19:20:34', '已分配', '2023-06-12 11:21:54', 'user1', '', '2023-06-12 16:22:25', '', NULL, NULL);
INSERT INTO `services` VALUES (12, '咨询', '123123', '123213', 123123, '123123', '2023-06-11 19:37:14', '已分配', '2023-06-12 14:25:11', 'user1', '', NULL, '', NULL, NULL);
INSERT INTO `services` VALUES (13, '咨询', '123123', '213213', 123213, '123213', '2023-06-09 17:17:13', '已归档', '2023-06-11 19:46:51', 'user1', '牛牛牛', '2023-06-12 15:53:12', '垃圾玩意', 5, '2023-06-12 16:05:11');
INSERT INTO `services` VALUES (14, '咨询', '123123', '123213', 123123, '123123', '2023-06-11 19:37:14', '已分配', '2023-06-12 14:25:11', 'user1', '', NULL, '', NULL, NULL);
INSERT INTO `services` VALUES (15, '咨询', '1213', '123213', 2123, '213123', '2023-06-14 09:09:32', '新创建', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_dic
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `about` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dic
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `su_id` int NOT NULL AUTO_INCREMENT COMMENT '用户编号，主键，自动递增',
  `su_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `su_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `su_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户角色：系统管理员(ADMIN)、销售主管(SUPERVISOR)、销售员(SALES)、高管(EXECUTIVE)',
  PRIMARY KEY (`su_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '123456', 'ADMIN');
INSERT INTO `sys_user` VALUES (2, 'user1', '123456', 'SALES');
INSERT INTO `sys_user` VALUES (3, 'user2', '123456', 'SUPERVISOR');
INSERT INTO `sys_user` VALUES (4, 'user3', '123456', 'MANAGER');
INSERT INTO `sys_user` VALUES (5, 'zxc', '123456', 'SALES');
INSERT INTO `sys_user` VALUES (6, 'supervisor', '123456', 'SUPERVISOR');

SET FOREIGN_KEY_CHECKS = 1;
