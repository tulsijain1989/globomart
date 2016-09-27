/*
Navicat MySQL Data Transfer

Source Server         : mysqlHRMS
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : globomart

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-09-22 14:42:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `price`
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `PRODUCT_ID` int(11) NOT NULL,
  `PRICE` double DEFAULT NULL,
  `QUANTITY` double DEFAULT NULL,
  `UNIT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'APPLE', 'APPLE IS GOOD FOR HEALTH', 'FRUIT');
INSERT INTO `product` VALUES ('2', 'MANGO', 'BAD fFOR HEALTH', 'FRUIT');
INSERT INTO `product` VALUES ('4', 'arun', 'Good for health', 'PLANT');
