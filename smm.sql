/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : smm

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-09-13 13:49:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clas
-- ----------------------------
DROP TABLE IF EXISTS `clas`;
CREATE TABLE `clas` (
  `cid` varchar(255) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `shid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `FK_shid` (`shid`) USING BTREE,
  CONSTRAINT `FK_shid` FOREIGN KEY (`shid`) REFERENCES `school` (`shid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clas
-- ----------------------------

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `shid` varchar(255) NOT NULL,
  `shname` varchar(255) DEFAULT NULL,
  `shaddress` varchar(255) DEFAULT NULL,
  UNIQUE KEY `shid` (`shid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `cid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuid`),
  UNIQUE KEY `FK8FFE823B21396B18` (`cid`) USING BTREE,
  CONSTRAINT `FK8FFE823B21396B18` FOREIGN KEY (`cid`) REFERENCES `clas` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_word` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'chen', '123');
