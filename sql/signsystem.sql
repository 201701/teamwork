/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : signsystem

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2020-07-02 09:18:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for leaverecordlist
-- ----------------------------
DROP TABLE IF EXISTS `leaverecordlist`;
CREATE TABLE `leaverecordlist` (
  `id` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `beginTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL,
  `reasonForLeave` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `signDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leaverecordlist
-- ----------------------------
INSERT INTO `leaverecordlist` VALUES (null, '1234', 'user1', '07:50:00', '08:00:00', '累了', '1', '2020-06-14');
INSERT INTO `leaverecordlist` VALUES (null, '9999', 'user3', '13:20:00', '13:30:00', '生病', '1', '2020-06-16');
INSERT INTO `leaverecordlist` VALUES (null, '1111', 'user4', '13:20:00', '13:30:00', '生病', '2', '2020-06-16');
INSERT INTO `leaverecordlist` VALUES (null, '5678', 'user2', '07:50:00', '08:00:00', '累', '1', '2020-06-14');
INSERT INTO `leaverecordlist` VALUES (null, '1234', 'user1', '15:30:00', '16:00:00', '啊啊', '1', '2020-06-29');
INSERT INTO `leaverecordlist` VALUES (null, '1234', 'user1', '15:40:00', '15:50:00', '啊啊', '3', '2020-06-29');

-- ----------------------------
-- Table structure for signlist
-- ----------------------------
DROP TABLE IF EXISTS `signlist`;
CREATE TABLE `signlist` (
  `id` int(11) DEFAULT NULL,
  `signDate` date DEFAULT NULL,
  `beginTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signlist
-- ----------------------------
INSERT INTO `signlist` VALUES (null, '2020-06-14', '07:50:00', '08:00:00');
INSERT INTO `signlist` VALUES (null, '2020-06-28', '09:20:00', '09:29:00');
INSERT INTO `signlist` VALUES (null, '2020-06-28', '09:50:08', '10:00:27');
INSERT INTO `signlist` VALUES (null, '2020-06-29', '15:40:00', '15:50:00');
INSERT INTO `signlist` VALUES (null, '2020-06-29', '15:30:00', '16:00:00');
INSERT INTO `signlist` VALUES (null, '2020-06-29', '15:18:00', '15:30:00');

-- ----------------------------
-- Table structure for signrecordlist
-- ----------------------------
DROP TABLE IF EXISTS `signrecordlist`;
CREATE TABLE `signrecordlist` (
  `id` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `signDate` date DEFAULT NULL,
  `beginTime` time DEFAULT NULL,
  `endTime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signrecordlist
-- ----------------------------
INSERT INTO `signrecordlist` VALUES ('1', '1234', 'user1', '2020-06-14', '07:50:00', '08:00:00');
INSERT INTO `signrecordlist` VALUES ('2', '5678', 'user2', '2020-06-14', '07:50:00', '08:00:00');
INSERT INTO `signrecordlist` VALUES ('3', '9999', 'user3', '2020-06-16', '13:20:00', '13:30:00');
INSERT INTO `signrecordlist` VALUES ('4', '1111', 'user4', '2020-06-16', '13:20:00', '13:30:00');
INSERT INTO `signrecordlist` VALUES (null, '1234', 'user1', '2020-06-27', '22:38:00', '23:00:00');
INSERT INTO `signrecordlist` VALUES (null, '1234', 'user1', '2020-06-28', '09:50:08', '10:00:27');
INSERT INTO `signrecordlist` VALUES (null, '1234', 'user1', '2020-06-28', '11:00:00', '11:40:00');
INSERT INTO `signrecordlist` VALUES (null, '1234', 'user1', '2020-06-29', '15:18:00', '15:30:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `signCount` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1234', 'user1', '3');
INSERT INTO `user` VALUES ('2', '5678', 'user2', '5');
INSERT INTO `user` VALUES ('3', '9999', 'user4', '7');
INSERT INTO `user` VALUES (null, '200000', 'user20', null);
INSERT INTO `user` VALUES (null, '1111', 'user3', '0');
