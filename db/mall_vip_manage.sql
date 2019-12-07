/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : mall_vip_manage

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-07 20:26:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `note` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '超级管理员');
INSERT INTO `admin` VALUES ('3', '樱诺', 'admin', '系统开发者');
INSERT INTO `admin` VALUES ('32', '泡芙', '12345', '测试');

-- ----------------------------
-- Table structure for all_order
-- ----------------------------
DROP TABLE IF EXISTS `all_order`;
CREATE TABLE `all_order` (
  `order_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `actual_amount` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `pay_amount` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201912260018 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of all_order
-- ----------------------------
INSERT INTO `all_order` VALUES ('201912260006', '15985428639', '1000', '900.0', '2019-12-07 19:02:59');
INSERT INTO `all_order` VALUES ('201912260007', '0731852354', '10', '10.0', '2019-12-07 19:13:59');
INSERT INTO `all_order` VALUES ('201912260008', '15985428639', '1000', '900.0', '2019-12-07 19:25:11');
INSERT INTO `all_order` VALUES ('201912260009', '15985428639', '1000', '900.0', '2019-12-07 19:30:18');
INSERT INTO `all_order` VALUES ('201912260010', '15985428639', '1000', '900.0', '2019-12-07 19:32:56');
INSERT INTO `all_order` VALUES ('201912260011', '15985428639', '1000', '900.0', '2019-12-07 19:34:20');
INSERT INTO `all_order` VALUES ('201912260012', '15985428639', '1212', '1090.8', '2019-12-07 19:39:19');
INSERT INTO `all_order` VALUES ('201912260013', '15985428639', '1212', '1090.8', '2019-12-07 19:43:10');
INSERT INTO `all_order` VALUES ('201912260014', '15985428639', '100', '50.0', '2019-12-07 19:47:22');
INSERT INTO `all_order` VALUES ('201912260015', '15985428639', '10', '5.0', '2019-12-07 19:48:29');
INSERT INTO `all_order` VALUES ('201912260016', '15985428639', '10', '5.0', '2019-12-07 19:49:32');
INSERT INTO `all_order` VALUES ('201912260017', '15985428639', '1000', '950.0', '2019-12-07 20:06:22');

-- ----------------------------
-- Table structure for ann
-- ----------------------------
DROP TABLE IF EXISTS `ann`;
CREATE TABLE `ann` (
  `ann_id` int(11) NOT NULL AUTO_INCREMENT,
  `ann_name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `ann_content` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`ann_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of ann
-- ----------------------------
INSERT INTO `ann` VALUES ('1', '循环通知', '速进双十二继续剁手01&新会员全场立减10员，冲冲冲&年货节，屯年后，享折扣');
INSERT INTO `ann` VALUES ('2', '公告板', '樱诺商城积分说明01： 用户在商城、超市等线下合作场景付款成功后，可提供手机号码开通樱诺商城会员。会员可永久享受其会员等级所带来的优惠活动。开通会员后，用户积分会在每次付款成功，订单生成成功后更新。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `phone` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `gender` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `point` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  `rank` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'Skyzc', '15985428639', '123456', '男', '福建厦门', '1104', '6');
INSERT INTO `user` VALUES ('5', '小白', '01088903116', 'edf8', '男', '福建省厦门市', '45', '1');
INSERT INTO `user` VALUES ('7', '泡芙', '17703456789', '232323', '女', '福建省福州市', '52', '1');
INSERT INTO `user` VALUES ('8', '小咪', '123456789', '12345', '女', '福建厦门', '543', '6');
INSERT INTO `user` VALUES ('9', '小松', '987612332', '12345', '男', '内蒙古', '432', '6');
INSERT INTO `user` VALUES ('10', '张三', '2341234', '123123', '男', '福建省厦门市', '32', '6');
INSERT INTO `user` VALUES ('11', 'JenKinY', '19908799834', '12345', '男', 'Xiamen,Fujian,china', '234', '3');
INSERT INTO `user` VALUES ('12', 'guest', '01088903116', '12345', '男', '帆帆帆帆', '666', '6');
INSERT INTO `user` VALUES ('13', '小花', '13785437654', '12345', '女', '福建省厦门市', '268', '3');
INSERT INTO `user` VALUES ('14', '亮亮', '0731852354', '12345', '男', '中国内蒙古', '88', '2');

-- ----------------------------
-- Table structure for vip_rule
-- ----------------------------
DROP TABLE IF EXISTS `vip_rule`;
CREATE TABLE `vip_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `max_point` int(20) NOT NULL,
  `is_rank` int(20) NOT NULL,
  `rebate` decimal(11,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of vip_rule
-- ----------------------------
INSERT INTO `vip_rule` VALUES ('1', '99', '1', '10.00');
INSERT INTO `vip_rule` VALUES ('2', '199', '2', '9.50');
INSERT INTO `vip_rule` VALUES ('3', '299', '3', '8.00');
INSERT INTO `vip_rule` VALUES ('4', '399', '4', '7.00');
INSERT INTO `vip_rule` VALUES ('5', '499', '5', '6.00');
INSERT INTO `vip_rule` VALUES ('6', '599', '6', '5.00');
