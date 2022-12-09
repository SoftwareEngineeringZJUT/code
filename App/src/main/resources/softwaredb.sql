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

 Date: 09/12/2022 18:09:07
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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '9VC', 'dwadsa', '钱博超', 2, '2022-11-14 16:51:25', '2022-12-09 16:29:18');
INSERT INTO `admin` VALUES (2, 'qwaG', 'wmwz', '石天翊', 3, '2022-08-31 03:28:39', '2022-04-05 19:44:30');
INSERT INTO `admin` VALUES (3, 'Ww', 'A98oa', '周烨华', 3, '2022-12-27 14:39:40', '2022-12-11 04:49:01');
INSERT INTO `admin` VALUES (4, 'Y1', 'CD4H9', '许鹤轩', 3, '2022-09-19 07:18:16', '2022-03-26 17:06:10');
INSERT INTO `admin` VALUES (5, 'a119r', 'Behw', '阎正豪', 1, '2022-11-19 15:07:49', '2022-07-02 15:22:26');
INSERT INTO `admin` VALUES (6, 'U4B', 'tz', '刘鹏飞', 2, '2022-11-15 00:16:04', '2022-02-07 18:01:24');
INSERT INTO `admin` VALUES (7, 'nw', 'GQD', '陈立果', 3, '2022-05-18 08:41:14', '2022-06-10 21:08:20');
INSERT INTO `admin` VALUES (8, 'Ly3eF', 'twmLj', '唐文', 2, '2022-10-27 14:48:54', '2022-11-22 04:12:04');
INSERT INTO `admin` VALUES (9, '5iph', 'kez8', '武展鹏', 2, '2022-09-16 20:51:58', '2022-12-13 23:31:05');
INSERT INTO `admin` VALUES (10, 'xsAU3', 'djk2D', '阎子默', 1, '2022-01-13 05:25:30', '2022-08-10 04:50:24');
INSERT INTO `admin` VALUES (11, 'sda', 'dwasd', 'qqqwda', 3, '2022-12-09 17:42:41', '2022-12-09 17:42:47');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('121355838518641', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
INSERT INTO `bank` VALUES ('17111', 0.01, '2022-12-09 17:50:34', '2022-12-09 17:50:50');
INSERT INTO `bank` VALUES ('176986322451600', 0.00, '2022-12-09 17:49:59', '2022-12-09 17:49:59');
INSERT INTO `bank` VALUES ('176986322451631', 100.00, '2022-12-09 17:31:54', '2022-12-09 17:31:54');
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '黑名单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blacklist
-- ----------------------------
INSERT INTO `blacklist` VALUES (21, '2022-12-09 16:42:24', '2022-12-09 17:52:21');
INSERT INTO `blacklist` VALUES (22, '2022-12-09 16:42:24', '2022-12-09 17:52:28');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `product_id` bigint NOT NULL COMMENT '产品id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `amount` decimal(10, 0) NOT NULL COMMENT '金额',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '支付状态（0：未支付，1：已支付，2：已取消）',
  `pay_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`user_id`) USING BTREE,
  INDEX `product`(`product_id`) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (221018001, 2, 25, 640, 0, NULL, '2022-11-30 17:57:38', '2022-11-30 17:57:38');
INSERT INTO `order` VALUES (221018002, 1, 25, 47701, 0, NULL, '2022-11-30 17:57:41', '2022-11-30 17:57:41');
INSERT INTO `order` VALUES (221018003, 3, 25, 6, 0, NULL, '2022-11-30 17:57:56', '2022-11-30 17:57:56');
INSERT INTO `order` VALUES (221018004, 3, 25, 569724, 0, NULL, '2022-11-30 17:57:57', '2022-11-30 17:57:57');
INSERT INTO `order` VALUES (221018005, 3, 25, 439337, 0, NULL, '2022-11-30 17:57:57', '2022-11-30 17:57:57');
INSERT INTO `order` VALUES (221018006, 3, 25, 34166783, 0, NULL, '2022-11-30 17:57:58', '2022-11-30 17:57:58');
INSERT INTO `order` VALUES (221018007, 3, 25, 10197346, 0, NULL, '2022-11-30 17:57:44', '2022-11-30 17:57:44');
INSERT INTO `order` VALUES (221018008, 2, 25, 5, 0, NULL, '2022-11-30 17:57:59', '2022-11-30 17:57:59');
INSERT INTO `order` VALUES (221018009, 1, 25, 865, 0, NULL, '2022-11-30 17:57:45', '2022-11-30 17:57:45');
INSERT INTO `order` VALUES (221018010, 1, 25, 67528, 0, NULL, '2022-11-30 17:57:46', '2022-11-30 17:57:46');
INSERT INTO `order` VALUES (221018011, 1, 25, 5604, 0, NULL, '2022-11-30 17:57:46', '2022-11-30 17:57:46');
INSERT INTO `order` VALUES (221018012, 2, 25, 576510, 0, NULL, '2022-11-30 17:57:47', '2022-11-30 17:57:47');
INSERT INTO `order` VALUES (221018013, 3, 25, 3586660478, 0, NULL, '2022-11-30 17:58:01', '2022-11-30 17:58:01');
INSERT INTO `order` VALUES (221018014, 3, 25, 771655862, 0, NULL, '2022-11-30 17:57:48', '2022-11-30 17:57:48');
INSERT INTO `order` VALUES (221018015, 1, 25, 1400060, 0, NULL, '2022-11-30 17:57:49', '2022-11-30 17:57:49');
INSERT INTO `order` VALUES (221018016, 2, 25, 8008692, 0, NULL, '2022-11-30 17:58:02', '2022-11-30 17:58:02');
INSERT INTO `order` VALUES (221018017, 3, 25, 62408318, 0, NULL, '2022-11-30 17:57:50', '2022-11-30 17:57:50');
INSERT INTO `order` VALUES (221018018, 2, 25, 794218134, 0, NULL, '2022-11-30 17:57:51', '2022-11-30 17:57:51');
INSERT INTO `order` VALUES (221018019, 3, 25, 6, 0, NULL, '2022-11-30 17:58:04', '2022-11-30 17:58:04');
INSERT INTO `order` VALUES (221018020, 3, 25, 576, 0, NULL, '2022-11-30 17:57:55', '2022-11-30 17:57:55');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '请输入商品名称', 2, '2022-09-27 02:54:41', 69154.4, 65488039, 29594075, 75381, 3760, 53975, 964888071, 'pI', 1, '关于商品的描述。。。', 'DMB', '2022-12-01 16:13:38', '2022-12-01 16:13:38');
INSERT INTO `product` VALUES (2, '请输入商品名称', 2, '2022-12-08 01:31:01', 55647.1, 4312, 442050627, 13039, 11246, 39265, 48504, 'Ba', 1, '关于商品的描述。。。', '6fD', '2022-12-01 16:11:51', '2022-12-01 16:11:51');
INSERT INTO `product` VALUES (3, '请输入商品名称', 2, '2022-08-02 21:40:41', 24093.2, 82489051, 528785632, 39124, 1352, 60121, 994531655, 'C81F1', 0, '关于商品的描述。。。', 'gI', '2022-12-01 16:44:58', '2022-12-01 16:44:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `real_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `id_card` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `address` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `bank_card` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '银行卡号',
  `phone` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `user_status` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '用户状态',
  `balance` bigint NOT NULL DEFAULT 0 COMMENT '余额',
  `label` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户标签',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `acc`(`account`) USING BTREE COMMENT '唯一',
  INDEX `bank_card`(`bank_card`) USING BTREE,
  CONSTRAINT `bank_card` FOREIGN KEY (`bank_card`) REFERENCES `bank` (`bank_card`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (21, 'ababa', 'password', '王嘉懿', '11111', '河南', '949253319326529', '15833045629', '0', 205986079, 'nFvZ', '2022-12-03 14:51:15', '2022-12-03 14:51:15');
INSERT INTO `user` VALUES (22, '夏明辉', 'password', '陶远航', '11111', '安徽', '924332441159241', '15744061205', '0', 63117416, 'HAuO', '2022-11-30 17:20:06', '2022-11-30 17:20:06');
INSERT INTO `user` VALUES (23, '叶志强', 'password', '尹鸿涛', '11111', '福建', '523357367145629', '13952577250', '0', 1, 'CCA3', '2022-11-30 17:20:07', '2022-11-30 17:20:07');
INSERT INTO `user` VALUES (24, '夏天翊', 'password', '钱天磊', '11111', '重庆', '545741819458527', '13752132663', '0', 912623, 'e6sQ', '2022-11-30 17:20:07', '2022-11-30 17:20:07');
INSERT INTO `user` VALUES (25, '熊琪', 'password', '黎子默', '11111', '江苏', '585576364182136', '13047413377', '0', 76065, 'kk', '2022-11-30 17:20:08', '2022-11-30 17:20:08');
INSERT INTO `user` VALUES (26, '孙笑愚', 'password', '梁昊强', '11111', '浙江', '121355838518641', '17534664368', '0', 60978, 'iY', '2022-11-30 17:20:08', '2022-11-30 17:20:08');
INSERT INTO `user` VALUES (27, '傅伟诚', 'password', '程语堂', '11111', '四川', '483828899526396', '17792780155', '0', 9248, 'MU', '2022-11-30 17:20:09', '2022-11-30 17:20:09');
INSERT INTO `user` VALUES (28, '高嘉懿', 'password', '任弘文', '11111', '上海', '339859773732371', '15706028442', '0', 867141, '9TP', '2022-11-30 17:20:09', '2022-11-30 17:20:09');
INSERT INTO `user` VALUES (30, '严哲瀚', 'password', '叶擎宇', '11111', '北京', '544941575294526', '13826487172', '0', 67176927, 'Pj', '2022-11-30 17:20:20', '2022-11-30 17:20:20');
INSERT INTO `user` VALUES (31, '郝凯瑞', 'password', '马立果', '11111', '吉林', '262854179319773', '17821963792', '0', 77952980, '2gLUy', '2022-11-30 17:20:21', '2022-11-30 17:20:21');
INSERT INTO `user` VALUES (32, '曹鑫磊', 'password', '程思源', '11111', '广东', '614258291697214', '17693644756', '0', 269, 'z7S', '2022-11-30 17:20:21', '2022-11-30 17:20:21');
INSERT INTO `user` VALUES (33, '孟鸿涛', 'password', '冯鹏', '11111', '吉林', '215166347866352', '14563202790', '1', 207, 'W6mYn', '2022-12-03 14:51:50', '2022-12-03 14:51:50');
INSERT INTO `user` VALUES (34, '彭金鑫', 'password', '雷鹏煊', '11111', '广东', '974545732877946', '17072767762', '0', 7012409688, 'lsh', '2022-11-30 17:20:22', '2022-11-30 17:20:22');
INSERT INTO `user` VALUES (35, '姜瑞霖', 'password', '何立诚', '11111', '海南', '456487169694617', '17147828004', '0', 56677001, 'tW4', '2022-11-30 17:20:23', '2022-11-30 17:20:23');
INSERT INTO `user` VALUES (36, '唐晓博', 'password', '韦立果', '11111', '广西壮族自治区', '176986322451631', '14726075467', '0', 2, '5ty', '2022-11-30 17:20:23', '2022-11-30 17:20:23');
INSERT INTO `user` VALUES (37, '万乐驹', 'password', '贺煜祺', '11111', '河南', '829154877331274', '15378875633', '0', 46222095, 'y7', '2022-11-30 17:20:24', '2022-11-30 17:20:24');
INSERT INTO `user` VALUES (38, '曹瑞霖', 'password', '黎楷瑞', '11111', '香港', '443914639538559', '17118439342', '0', 23668701, 'u4', '2022-11-30 17:20:25', '2022-11-30 17:20:25');
INSERT INTO `user` VALUES (39, '侯鹤轩', 'password', '杜文博', '11111', '台湾', '251243258899898', '15309996754', '0', 1294, 'rudk', '2022-11-30 17:20:25', '2022-11-30 17:20:25');
INSERT INTO `user` VALUES (40, '彭越泽', 'password', '贾致远', '11111', '海南', '431876728662644', '15380462027', '0', 336370835, 'e1Px', '2022-11-30 17:20:26', '2022-11-30 17:20:26');
INSERT INTO `user` VALUES (41, '崔果', 'password', '王嘉懿', '11111', '河北', '949253319326529', '15833045629', '0', 205986079, 'nFvZ', '2022-11-30 17:20:06', '2022-11-30 17:20:06');

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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '白名单' ROW_FORMAT = Dynamic;

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
