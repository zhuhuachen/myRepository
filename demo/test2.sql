/*
Navicat MySQL Data Transfer

Source Server         : 本机 
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-02-17 11:30:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card_payment
-- ----------------------------
DROP TABLE IF EXISTS `card_payment`;
CREATE TABLE `card_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_tendered` float NOT NULL,
  `card_account_number` varchar(255) DEFAULT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `sale_id` int(11) DEFAULT NULL,
  `fee` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72nhra11w862n2l4d67mu05s9` (`sale_id`),
  CONSTRAINT `FK72nhra11w862n2l4d67mu05s9` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of card_payment
-- ----------------------------

-- ----------------------------
-- Table structure for cashier
-- ----------------------------
DROP TABLE IF EXISTS `cashier`;
CREATE TABLE `cashier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1suh4hf2ao9msntvdxonmre1c` (`store_id`),
  CONSTRAINT `FK1suh4hf2ao9msntvdxonmre1c` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cashier
-- ----------------------------
INSERT INTO `cashier` VALUES ('1', '张三', '1');

-- ----------------------------
-- Table structure for cash_desk
-- ----------------------------
DROP TABLE IF EXISTS `cash_desk`;
CREATE TABLE `cash_desk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_opened` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt1xlu14j83123kb8lv4jxbg0m` (`store_id`),
  CONSTRAINT `FKt1xlu14j83123kb8lv4jxbg0m` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cash_desk
-- ----------------------------
INSERT INTO `cash_desk` VALUES ('1', '', '1号收银台', '1');

-- ----------------------------
-- Table structure for cash_payment
-- ----------------------------
DROP TABLE IF EXISTS `cash_payment`;
CREATE TABLE `cash_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_tendered` float NOT NULL,
  `balance` float NOT NULL,
  `sale_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKem93ye8oo2ytxjfc9now9mp4e` (`sale_id`),
  CONSTRAINT `FKem93ye8oo2ytxjfc9now9mp4e` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cash_payment
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_price` float NOT NULL,
  `price` float NOT NULL,
  `stock_number` int(11) NOT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKivjcskeis2krwrnmct7htnkbc` (`catalog_id`),
  CONSTRAINT `FKivjcskeis2krwrnmct7htnkbc` FOREIGN KEY (`catalog_id`) REFERENCES `product_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '1', 'apple', '1', '2', '100', '2020-01-14 10:15:21.000000', '1');
INSERT INTO `item` VALUES ('2', '2', 'orange', '2', '3', '50', '2020-01-14 10:15:40.000000', '1');

-- ----------------------------
-- Table structure for product_catalog
-- ----------------------------
DROP TABLE IF EXISTS `product_catalog`;
CREATE TABLE `product_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2jvigaigptf1d2idc8p62dos7` (`store_id`),
  CONSTRAINT `FK2jvigaigptf1d2idc8p62dos7` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product_catalog
-- ----------------------------
INSERT INTO `product_catalog` VALUES ('1', '水果', '1');

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `is_complete` bit(1) NOT NULL,
  `is_readyto_pay` bit(1) NOT NULL,
  `time` datetime(6) DEFAULT NULL,
  `cash_desk_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKocwc9gokhxjpetsabel8uoxfb` (`cash_desk_id`),
  CONSTRAINT `FKocwc9gokhxjpetsabel8uoxfb` FOREIGN KEY (`cash_desk_id`) REFERENCES `cash_desk` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sale
-- ----------------------------

-- ----------------------------
-- Table structure for sales_line_item
-- ----------------------------
DROP TABLE IF EXISTS `sales_line_item`;
CREATE TABLE `sales_line_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `subamount` float NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `sale_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKafe1x7kdhat74mcxq3p7npomc` (`item_id`),
  KEY `FKn14176lmn5xh2viug8ynl76y` (`sale_id`),
  CONSTRAINT `FKafe1x7kdhat74mcxq3p7npomc` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `FKn14176lmn5xh2viug8ynl76y` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sales_line_item
-- ----------------------------

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `is_opened` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '山东济宁', '', '小卖部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `birth` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
