/*
Navicat MySQL Data Transfer

Source Server         : fante
Source Server Version : 50557
Source Host           : 39.105.28.106:3306
Source Database       : panghuan

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2019-08-18 00:58:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `intro` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `hits` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '1',
  `created` varchar(255) DEFAULT NULL,
  `updated` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('2', 'java基础环境配置java基础环境配置java基础环境配置java基础环境配置java基础环境配置java基础环境配置java基础环境配置java基础环境配置', '#JAVA基础环境变量\n- JDK配置\n## jdk配置如下', '手把手教你配置java环境变量手把手教你配置java环境变量手把手教你配置java环境变量手把手教你配置java环境变量', '1', '4', '1', '2019-08-17 15:42:06', '2019-08-17 15:42:06');
INSERT INTO `article` VALUES ('3', 'Spring入门', '## Spring 入门', 'Spring入门级教程', '2', '0', '1', '2019-08-15 22:23:32', null);
INSERT INTO `article` VALUES ('5', '驱蚊器翁驱蚊器翁驱蚊器翁驱蚊器翁驱蚊器翁', '请问请问', '其味无穷额其味无穷额其味无穷额其味无穷额其味无穷额其味无穷额其味无穷额其味无穷额', '1', '4', '0', '2019-08-17 15:47:35', '2019-08-17 15:47:35');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'java', 'Java经典案例');
INSERT INTO `category` VALUES ('2', 'HTML', 'HTML');
INSERT INTO `category` VALUES ('3', 'CSS', 'DIV+CSS3布局');
INSERT INTO `category` VALUES ('5', 'JS', 'ES6');
INSERT INTO `category` VALUES ('9', 'JQuery', '');
INSERT INTO `category` VALUES ('10', 'BootStrap', '');

-- ----------------------------
-- Table structure for category_article
-- ----------------------------
DROP TABLE IF EXISTS `category_article`;
CREATE TABLE `category_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of category_article
-- ----------------------------
INSERT INTO `category_article` VALUES ('3', '3', '1');
INSERT INTO `category_article` VALUES ('20', '2', '1');
INSERT INTO `category_article` VALUES ('21', '2', '9');
INSERT INTO `category_article` VALUES ('22', '5', '1');
INSERT INTO `category_article` VALUES ('23', '5', '2');
INSERT INTO `category_article` VALUES ('24', '5', '3');
INSERT INTO `category_article` VALUES ('25', '4', '1');
INSERT INTO `category_article` VALUES ('26', '4', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `aid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `created` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', 'owen', '写的好！！！', '2', '2', '2019-08-17 22:08:55');
INSERT INTO `comment` VALUES ('3', '张三', '写的好啊兄弟，不错不错', '2', '2', '2019-08-17 22:10:52');
INSERT INTO `comment` VALUES ('4', '李四', '太棒了，学到了', '2', '3', '2019-08-17 22:11:02');
INSERT INTO `comment` VALUES ('5', 'kakarot', '超级赛亚人变身', '2', '2', '2019-08-17 22:11:12');
INSERT INTO `comment` VALUES ('6', 'hello', 'world', '2', '2', '2019-08-17 22:11:21');
INSERT INTO `comment` VALUES ('7', '呵呵哒', '好人一生平安', '2', '2', '2019-08-17 22:11:43');
INSERT INTO `comment` VALUES ('8', '喵喵喵', '喵喵喵喵喵', '2', '2', '2019-08-17 22:11:53');
INSERT INTO `comment` VALUES ('10', '我勒个去', '呵呵呵哒', '2', '1', '2019-08-17 22:38:20');
INSERT INTO `comment` VALUES ('11', '测试一下', '我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦我来测试一下长度多少你会崩溃哦', '2', '2', '2019-08-18 00:07:04');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'kakarot', '15252089523');
