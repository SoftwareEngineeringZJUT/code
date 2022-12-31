/*
 Navicat Premium Data Transfer

 Source Server         : student
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : softwaredb

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 29/12/2022 22:15:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `real_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `rank` int NOT NULL DEFAULT 0 COMMENT '权限等级',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `ad`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1004 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '9VC', 'dwadsa', '钱博超', 6, '2022-11-14 16:51:25', '2022-12-10 00:55:36');
INSERT INTO `admin` VALUES (2, 'qwaG', 'wmwz', '石天翊', 3, '2022-08-31 03:28:39', '2022-04-05 19:44:30');
INSERT INTO `admin` VALUES (3, 'Ww', 'A98oa', '周烨华', 3, '2022-12-27 14:39:40', '2022-12-11 04:49:01');
INSERT INTO `admin` VALUES (4, 'Y1', 'CD4H9', '许鹤轩', 3, '2022-09-19 07:18:16', '2022-03-26 17:06:10');
INSERT INTO `admin` VALUES (5, 'a119r', 'Behw', '阎正豪', 1, '2022-11-19 15:07:49', '2022-07-02 15:22:26');
INSERT INTO `admin` VALUES (6, 'U4B', 'tz', '刘鹏飞', 2, '2022-11-15 00:16:04', '2022-02-07 18:01:24');
INSERT INTO `admin` VALUES (7, 'nw', 'GQD', '陈立果', 3, '2022-05-18 08:41:14', '2022-06-10 21:08:20');
INSERT INTO `admin` VALUES (10, 'OP', 'djk2D', '阎子默', 2, '2022-01-13 05:25:30', '2022-12-10 13:44:00');
INSERT INTO `admin` VALUES (1001, 'admin01', 'ad0001', '姜辉', 10, '2022-12-29 16:56:41', '2022-12-29 16:56:41');
INSERT INTO `admin` VALUES (1002, 'admin02', 'ad0002', '徐坤', 4, '2022-12-29 16:56:41', '2022-12-29 16:56:41');
INSERT INTO `admin` VALUES (1003, 'admin03', 'ad0003', '王梅', 3, '2022-12-29 16:56:41', '2022-12-29 16:56:41');

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank`  (
  `bank_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行卡号',
  `bank_balance` decimal(64, 2) NOT NULL DEFAULT 0.00 COMMENT '银行卡余额',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`bank_card`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('121355838518641', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('17111', 0.01, '2022-12-09 17:50:34', '2022-12-09 17:50:50');
INSERT INTO `bank` VALUES ('176986322451600', 0.00, '2022-12-09 17:49:59', '2022-12-09 17:49:59');
INSERT INTO `bank` VALUES ('176986322451631', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('2020031512010001', 20000000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512020002', 10000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512030003', 50000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512040004', 30000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512050005', 1000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512060006', 100.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512070007', 3000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512080008', 50000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512090009', 120000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512100010', 500000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512110011', 200000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512120012', 100000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512130013', 700000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512140014', 60000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512150015', 20000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512160016', 40000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512170017', 50000000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512180018', 5000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512190019', 40000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('2020031512200020', 10000.00, '2022-12-29 16:21:24', '2022-12-29 16:21:24');
INSERT INTO `bank` VALUES ('215166347866352', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('251243258899898', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('262854179319773', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('339859773732371', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('431876728662644', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('443914639538559', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('456487169694617', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('483828899526396', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('523357367145629', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('544941575294526', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('545741819458527', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('585576364182136', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('614258291697214', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('829154877331274', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('924332441159241', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('949253319326529', 100.00, '2022-12-09 17:27:10', '2022-12-09 17:27:10');
INSERT INTO `bank` VALUES ('974545732877946', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist`  (
  `uid` bigint NOT NULL COMMENT '用户名',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`) USING BTREE,
  CONSTRAINT `uid1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '黑名单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `product_id` bigint NOT NULL COMMENT '产品id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `amount` decimal(10, 0) NOT NULL COMMENT '金额',
  `state` tinyint(3) UNSIGNED ZEROFILL NOT NULL DEFAULT 000 COMMENT '支付状态（0：买进，1：卖出）',
  `pay_time` datetime NOT NULL COMMENT '支付时间',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`user_id`) USING BTREE,
  INDEX `product`(`product_id`) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 221018023 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '请输入商品名称' COMMENT '商品名称',
  `publisher` bigint NOT NULL COMMENT '发布者',
  `expire` datetime NOT NULL COMMENT '商品期限',
  `annual_rate` float NOT NULL COMMENT '年转化率',
  `start_deposit` decimal(10, 0) NOT NULL COMMENT '起存金额',
  `increment` decimal(10, 0) NOT NULL COMMENT '递增金额',
  `personal_limit` decimal(10, 0) NOT NULL DEFAULT 0 COMMENT '每人限额',
  `daily_limit` decimal(10, 0) NOT NULL DEFAULT 0 COMMENT '每日限额',
  `stock` decimal(10, 0) NOT NULL DEFAULT 0 COMMENT '产品库存',
  `saled` decimal(10, 0) UNSIGNED ZEROFILL NOT NULL COMMENT '已售出',
  `risk` int NOT NULL DEFAULT 0 COMMENT '风险等级',
  `settlement_type` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '存款' COMMENT '结息方式',
  `onsale` int NOT NULL COMMENT '是否上线',
  `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '关于商品的描述。。。' COMMENT '商品说明',
  `service_process` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '原子服务流程',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `pub`(`publisher`) USING BTREE,
  CONSTRAINT `pub` FOREIGN KEY (`publisher`) REFERENCES `admin` (`admin_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '产品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '请输入商品名称', 2, '2022-09-27 02:54:41', 69154.4, 65488039, 29594075, 75381, 3760, 53975, 0000000000, 964888071, 'pI', 1, '关于商品的描述。。。', 'DMB', '2022-12-01 16:13:38', '2022-12-01 16:13:38');
INSERT INTO `product` VALUES (2, '请输入商品名称', 2, '2022-12-08 01:31:01', 55647.1, 4312, 442050627, 13039, 11246, 39265, 0000000000, 48504, 'Ba', 1, '关于商品的描述。。。', '6fD', '2022-12-01 16:11:51', '2022-12-01 16:11:51');
INSERT INTO `product` VALUES (3, '请输入商品名称', 2, '2022-08-02 21:40:41', 24093.2, 82489051, 528785632, 39124, 1352, 60121, 0000000000, 994531655, 'C81F1', 0, '关于商品的描述。。。', 'gI', '2022-12-01 16:44:58', '2022-12-01 16:44:58');
INSERT INTO `product` VALUES (2001, '产品A', 1002, '2022-11-14 16:51:25', 1.82, 50, 50, 200000, 20000, 3000, 0000000010, 4, '到期结息', 1, '说明A', '1;2;4;6;8;9;7;3;5;10;11', '2022-12-29 17:05:47', '2022-12-29 17:05:47');
INSERT INTO `product` VALUES (2002, '产品B', 1002, '2022-11-14 16:51:25', 1.83, 50, 50, 100000, 10000, 1000, 0000000400, 2, '到期结息', 1, '说明B', '1;2;3;4;5;6;7;8;9;10;11', '2022-12-29 17:05:47', '2022-12-29 17:05:47');
INSERT INTO `product` VALUES (2003, '产品C', 1002, '2022-11-14 16:51:25', 1.62, 50, 50, 100000, 10000, 2000, 0000001000, 2, '到期结息', 1, '说明C', '1;3;1;5;4;6;7;8;9;11;10', '2022-12-29 17:05:47', '2022-12-29 17:05:47');
INSERT INTO `product` VALUES (2004, '产品D', 1003, '2022-11-14 16:51:25', 1.66, 50, 50, 300000, 10000, 5000, 0000002000, 5, '到期结息', 1, '说明D', '2;3;4;5;1;6;8;7;9;10;11', '2022-12-29 17:05:47', '2022-12-29 17:05:47');
INSERT INTO `product` VALUES (2005, '产品E', 1003, '2022-11-14 16:51:25', 1.67, 50, 50, 500000, 10000, 1000, 0000000200, 3, '到期结息', 1, '说明E 6', '7;8;9;1;2;3;4;5;10;11', '2022-12-29 17:05:47', '2022-12-29 17:05:47');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `contant` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `optionA` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `optionB` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `optionC` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `optionD` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ifsend` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `howmanyA` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `howmanyB` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `howmanyC` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `howmanyD` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('option', '02', '影响你学习的因素是什么', 'A.教学形式', 'B.周围同学', 'C.电子产品', 'D.其他因素', 'yes', '9', '8', '5', '3');
INSERT INTO `question` VALUES ('option', '03', '你对本课程的知识掌握情况如何？', 'A.非常差', 'B.一般般', 'C.还行', 'D.很好', 'yes', '7', '11', '3', '3');
INSERT INTO `question` VALUES ('option', '04', '你对哪种教学方式比较感兴趣？', 'A.ppt', 'B.粉笔板述', 'C.图片展示', 'D.视频展示', 'yes', '5', '7', '8', '4');
INSERT INTO `question` VALUES ('option', '05', '你对这门课成绩满意程度如何？', 'A.不满意', 'B.一般般', 'C.还可以', 'D.很满意', 'yes', '1', '1', '1', '1');
INSERT INTO `question` VALUES ('option', '06', '你觉得这门课程老师教学效果如何？', 'A.不好', 'B.一般', 'C.还可以', 'D.非常好', 'yes', '2', '1', '1', '0');
INSERT INTO `question` VALUES ('option', '08', '你感觉这门课程锻炼你什么能力？', 'A.独立思考能力', 'B.合作能力', 'C.创作能力', 'D.思维能力', 'yes', '1', '3', '0', '0');
INSERT INTO `question` VALUES ('fill', '09', '你有什么好的学习方法可以分享吗？', '', '0', '0', '0', 'yes', '0', '0', '0', '0');
INSERT INTO `question` VALUES ('fill', '10', '你对教学老师有什么建议吗？', '', '0', '0', '0', 'yes', '0', '0', '0', '0');
INSERT INTO `question` VALUES ('fill', '11', '你觉得这门课以后发展如何？', '无', '0', '0', '0', 'yes', '0', '0', '0', '0');
INSERT INTO `question` VALUES ('option', '77', '123', 'A.2', 'B.2', 'C.2', 'D.2', 'yes', '0', '0', '0', '0');
INSERT INTO `question` VALUES ('fill', '01', '1312', '0', '0', '0', '0', 'yes', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `snumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `spassword` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('李四', 'lisi', '123');
INSERT INTO `student` VALUES ('王五', 'wangwu', '123');
INSERT INTO `student` VALUES ('张三', 'zhangsan', '123');
INSERT INTO `student` VALUES ('王五', 'wangwu', '123');
INSERT INTO `student` VALUES ('', 'bu', '123');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tnumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tpassword` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('管理1', 'guanli1', '123');
INSERT INTO `teacher` VALUES ('管理2', 'guanli2', '123');
INSERT INTO `teacher` VALUES ('管理3', 'guanli3', '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `real_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `id_card` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身份证号',
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `bank_card` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行卡号',
  `phone` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `user_status` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '用户状态',
  `balance` decimal(20, 0) UNSIGNED ZEROFILL NOT NULL DEFAULT 00000000000000000000 COMMENT '余额',
  `label` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户标签',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `acc`(`account`) USING BTREE COMMENT '唯一',
  INDEX `bank_card`(`bank_card`) USING BTREE,
  CONSTRAINT `bank_card` FOREIGN KEY (`bank_card`) REFERENCES `bank` (`bank_card`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3021 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3001, '1860943831', 'qwer123', '王丽', '410182200106442111', '浙江省杭州市', '2020031512010001', '19157776666', '0', 00000000000020000000, '六级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3002, '1137264205', 'plmk22', '王志明', '410183199802121234', '河南省周口市', '2020031512030003', '19157682677', '0', 00000000000000050000, '二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3003, '531657052', 'zxcc223', '刘高', '410182154812056443', '浙江省嘉兴市', '2020031512040004', '19157682678', '0', 00000000000000030000, ' 二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3004, '1193341879', 'zvcg125', '王海', '410182169902054543', '广东省潮汕市', '2020031512050005', '19157682679', '0', 00000000000000001000, ' 一级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3005, '1159393885', 'ghjk454', '王丽丽', '410122200304154212', '广西省玉林市', '2020031512060006', '19157682680', '0', 00000000000000000100, ' 一级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3006, '871464491', 'ljks111', '刘能', '410222194509084512', '山东省威海市', '2020031512070007', '19157682681 ', '0', 00000000000000003000, ' 一级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3007, '858762595', 'bnmd123', '王志宇', '410183145612121245', '山东省聊城市', '2020031512080008', '19157682682 ', '0', 00000000000000050000, ' 二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3008, '860883450', 'nnnd115', '展亚鹏', '410212201012044622', '山东省临沂市', '2020031512090009', '19157682683 ', '0', 00000000000000120000, ' 三级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3009, '859034105', 'jnik2341', '王佳音', '310182200208124611', '安徽省蚌埠市', '2020031512100010', '18167682644 ', '0', 00000000000000500000, ' 四级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3010, '858484046', 'ijnb2938', '李力', '120182200122120544', '浙江省金华市', '2020031512110011', '15427772645 ', '0', 00000000000000200000, ' 四级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3011, '1123842381', 'oijh111', '王海明', '32514215463255417', '浙江省衢州市 ', '2020031512120012', '15426663612 ', '0', 00000000000000100000, ' 二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3012, '1172200457', 'nbgh3334', '刘志', '410182200404044444', '广东省佛山市 ', '2020031512130013', '19157682222 ', '0', 00000000000000700000, ' 五级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3013, '214620167', 'ghvb2223', '王洲', '120183200102121548', '广西省南昌市 ', '2020031512140014', '19157682451 ', '0', 00000000000000060000, ' 五级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3014, '747317034', 'penge345', '王平', '146456123504051346', '湖北省武汉市 ', '2020031512150015', '19157684999 ', '0', 00000000000000020000, ' 二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3015, '859785647', 'liuneng223', '孙立东', '440123200101014562', '湖北省黄冈市 ', '2020031512160016', '19157682222 ', '0', 00000000000000040000, ' 二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3016, '1182325243', 'pengzh42', '彭朝晖', '483254618402014532', '河北省石家庄市 ', '2020031512170017', '19157662614 ', '0', 00000000000050000000, ' 六级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3017, '1173680817', 'penglu42', '王晓丽', '410199456101021549', '河北省衡水市 ', '2020031512180018', '19157411234 ', '0', 00000000000000005000, ' 一级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3018, '859824029', 'mnuy2423', '张杰', '410165200208541645', '辽宁省葫芦岛市 ', '2020031512190019', '15467821548 ', '0', 00000000000000040000, ' 二级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3019, '1194890021', 'bnmb78', '朱振', '120101200104051245', '河北省唐山市 ', '2020031512200020', '12345214876 ', '0', 00000000000000010000, ' 一级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');
INSERT INTO `user` VALUES (3020, '1193374994', 'tyui123', '李力', '410183200510642112', '河南省郑州市 ', '2020031512020002', '19157887777 ', '0', 00000000000000010000, ' 一级用户', '2022-12-29 17:24:19', '2022-12-29 17:24:19');

-- ----------------------------
-- Table structure for wasd
-- ----------------------------
DROP TABLE IF EXISTS `wasd`;
CREATE TABLE `wasd`  (
  `sno` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sum` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wasd
-- ----------------------------
INSERT INTO `wasd` VALUES ('01', 22);
INSERT INTO `wasd` VALUES ('02', 0);

-- ----------------------------
-- Table structure for wasdw
-- ----------------------------
DROP TABLE IF EXISTS `wasdw`;
CREATE TABLE `wasdw`  (
  `sno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wasdw
-- ----------------------------
INSERT INTO `wasdw` VALUES ('01', 10);
INSERT INTO `wasdw` VALUES ('03', 20);
INSERT INTO `wasdw` VALUES ('01', 20);

-- ----------------------------
-- Table structure for wasdwasd
-- ----------------------------
DROP TABLE IF EXISTS `wasdwasd`;
CREATE TABLE `wasdwasd`  (
  `sno` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wasdwasd
-- ----------------------------

-- ----------------------------
-- Table structure for whitelist
-- ----------------------------
DROP TABLE IF EXISTS `whitelist`;
CREATE TABLE `whitelist`  (
  `uid` bigint NOT NULL COMMENT '用户名',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`) USING BTREE,
  CONSTRAINT `uid2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '白名单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of whitelist
-- ----------------------------

-- ----------------------------
-- Triggers structure for table admin
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_admin`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_admin` BEFORE INSERT ON `admin` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table admin
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_admin`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_admin` BEFORE UPDATE ON `admin` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table bank
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_bank`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_bank` BEFORE INSERT ON `bank` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table bank
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_bank`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_bank` BEFORE UPDATE ON `bank` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table blacklist
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_blacklist`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_blacklist` BEFORE INSERT ON `blacklist` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table blacklist
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_blacklist`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_blacklist` BEFORE UPDATE ON `blacklist` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_order`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_order` BEFORE INSERT ON `order` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_order`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_order` BEFORE UPDATE ON `order` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table product
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_product`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_product` BEFORE INSERT ON `product` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table product
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_product`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_product` BEFORE UPDATE ON `product` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_user`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_user` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_user`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_user` BEFORE UPDATE ON `user` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table wasdw
-- ----------------------------
DROP TRIGGER IF EXISTS `aftertrigger`;
delimiter ;;
CREATE TRIGGER `aftertrigger` AFTER INSERT ON `wasdw` FOR EACH ROW begin
update wasd set sum=sum+1 where sno='01';
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table wasdw
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger22`;
delimiter ;;
CREATE TRIGGER `trigger22` AFTER INSERT ON `wasdw` FOR EACH ROW begin
update wasd set sum=sum+new.score where sno=new.sno;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table wasdwasd
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger1`;
delimiter ;;
CREATE TRIGGER `trigger1` AFTER INSERT ON `wasdwasd` FOR EACH ROW begin
update wasd
set sum=sum+score where sno=NEW.sno;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table whitelist
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_INSERT_whitelist`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_INSERT_whitelist` BEFORE INSERT ON `whitelist` FOR EACH ROW BEGIN
	SET new.gmt_create = CURRENT_TIMESTAMP ,
			new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table whitelist
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_ON_UPDATE_whitelist`;
delimiter ;;
CREATE TRIGGER `TRIGGER_ON_UPDATE_whitelist` BEFORE UPDATE ON `whitelist` FOR EACH ROW BEGIN
	SET new.gmt_update = CURRENT_TIMESTAMP;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
