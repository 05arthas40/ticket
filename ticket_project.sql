/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : ticket_project

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2019-04-25 19:35:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityid` int(10) NOT NULL AUTO_INCREMENT,
  `proviceid` int(10) DEFAULT NULL,
  `privicename` varchar(20) DEFAULT NULL,
  `cityname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`cityid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='����';

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '广东', '广州');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(32) DEFAULT NULL,
  `cpassword` varchar(32) DEFAULT NULL,
  `caddress` varchar(32) DEFAULT NULL,
  `cdetails` text,
  `cphone` varchar(16) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL COMMENT '�̼�ͷ��',
  `isLock` bit(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0��δ��ˣ�1������ˣ�2��δͨ�����',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='�̼�';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', 'aaa', '123456', '广州市', '皮包公司1', '020', null, null, '1');
INSERT INTO `company` VALUES ('2', 'bbb', '123456', '深圳市', '皮包公司2', '020', null, null, '1');
INSERT INTO `company` VALUES ('3', 'ccc', '123456', '佛山市', '皮包公司3', '020', null, null, '1');

-- ----------------------------
-- Table structure for company_show
-- ----------------------------
DROP TABLE IF EXISTS `company_show`;
CREATE TABLE `company_show` (
  `csid` int(10) NOT NULL AUTO_INCREMENT,
  `cid` int(10) DEFAULT NULL,
  `pfmid` int(10) DEFAULT NULL,
  PRIMARY KEY (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='��˾�ݳ��м��';

-- ----------------------------
-- Records of company_show
-- ----------------------------
INSERT INTO `company_show` VALUES ('1', '1', '1');
INSERT INTO `company_show` VALUES ('2', '2', '2');
INSERT INTO `company_show` VALUES ('3', '2', '3');
INSERT INTO `company_show` VALUES ('4', '3', '4');
INSERT INTO `company_show` VALUES ('5', '3', '5');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `odid` int(10) NOT NULL AUTO_INCREMENT,
  `svid` int(10) DEFAULT NULL,
  `orderid` int(10) DEFAULT NULL,
  `count` int(5) DEFAULT NULL,
  PRIMARY KEY (`odid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='��������';

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for performances
-- ----------------------------
DROP TABLE IF EXISTS `performances`;
CREATE TABLE `performances` (
  `pfmid` int(10) NOT NULL AUTO_INCREMENT,
  `showtitle` varchar(32) DEFAULT NULL COMMENT '�ݳ�����',
  `pname` varchar(32) DEFAULT NULL COMMENT '�ݳ���',
  `pdecription` text COMMENT '�ݳ����ܣ�����+ͼƬ��',
  `ppicture` varchar(255) DEFAULT NULL COMMENT '���⺣��',
  `ptype` varchar(16) DEFAULT NULL COMMENT '�ݳ����ͣ��ݳ��ᡢ���ֻᡢ�����ȣ�',
  `reason` varchar(255) DEFAULT NULL COMMENT '�����ܾ�����',
  `status` int(1) DEFAULT NULL COMMENT '0��δ��ˣ�1������ˣ�2��δͨ����ˣ�3��ɾ����4���ݳ����',
  PRIMARY KEY (`pfmid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='�ݳ���Ϣ';

-- ----------------------------
-- Records of performances
-- ----------------------------
INSERT INTO `performances` VALUES ('1', 'cxk出来打篮球', 'cxk', '律师函', null, '演唱会', null, '1');
INSERT INTO `performances` VALUES ('2', '大碗宽面', 'wyf', 'c站', null, '演唱会', null, '1');
INSERT INTO `performances` VALUES ('3', '两开花', '666', 'c站', null, '演唱会', null, '1');
INSERT INTO `performances` VALUES ('4', '赌怪', '55open', 'c站', null, '演唱会', null, '1');
INSERT INTO `performances` VALUES ('5', '打酱油的灭霸', '妇联4', 'c站', null, '演唱会', null, '1');

-- ----------------------------
-- Table structure for shortcut
-- ----------------------------
DROP TABLE IF EXISTS `shortcut`;
CREATE TABLE `shortcut` (
  `scid` int(10) NOT NULL AUTO_INCREMENT,
  `svid` int(10) DEFAULT NULL,
  `orderid` int(10) DEFAULT NULL,
  `ticketcount` int(10) DEFAULT NULL,
  `singleprice` int(10) DEFAULT NULL,
  `price` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`scid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='���׿���';

-- ----------------------------
-- Records of shortcut
-- ----------------------------
INSERT INTO `shortcut` VALUES ('1', '1', '1', '1', '100', '100');

-- ----------------------------
-- Table structure for showdetails
-- ----------------------------
DROP TABLE IF EXISTS `showdetails`;
CREATE TABLE `showdetails` (
  `showid` int(10) NOT NULL AUTO_INCREMENT,
  `pfmid` int(10) DEFAULT NULL,
  `showdate` date DEFAULT NULL,
  `begin` varchar(10) DEFAULT NULL,
  `end` varchar(10) DEFAULT NULL,
  `vname` varchar(20) DEFAULT NULL COMMENT '��������',
  `saddress` varchar(64) DEFAULT NULL COMMENT '���ݵ�ַ',
  `reason` varchar(255) DEFAULT NULL COMMENT '�����ܾ�����',
  `status` int(1) DEFAULT NULL COMMENT '0��δ��ˣ�1������ˣ�2��δͨ����ˣ�3��ɾ����4��Բ�����',
  PRIMARY KEY (`showid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='�ݳ�����';

-- ----------------------------
-- Records of showdetails
-- ----------------------------
INSERT INTO `showdetails` VALUES ('1', '1', '2019-04-25', '111', '123', '天河体育中心', '天河体育中心', null, '1');
INSERT INTO `showdetails` VALUES ('2', '1', '2019-04-30', '123', '23', '123', '123', '', '1');
INSERT INTO `showdetails` VALUES ('3', '2', '2019-03-04', '23', '41', '2131', '123', '', '1');
INSERT INTO `showdetails` VALUES ('4', '3', '2019-04-24', '123', '13', '12星期五', '去', '', '1');
INSERT INTO `showdetails` VALUES ('5', '3', '2019-04-28', '124', '123', '徐庆', '12想', '', '1');
INSERT INTO `showdetails` VALUES ('6', '5', '2019-04-25', '124', '2141', '星期五', '124', '', '1');
INSERT INTO `showdetails` VALUES ('7', '4', '2019-04-24', '124', '234', '下午去', '现在就', '', '1');
INSERT INTO `showdetails` VALUES ('8', '5', '2019-04-24', '241', '124', '234手段', '134 我', '', '1');
INSERT INTO `showdetails` VALUES ('9', '4', '2019-06-10', '14', '14', '方法', '14 1', '', '1');
INSERT INTO `showdetails` VALUES ('10', '5', '2019-04-23', '124', '141', '阿发', '分为', '', '1');
INSERT INTO `showdetails` VALUES ('11', '3', '2019-05-05', '123', '1243', '214sad', '123手段', '', '1');
INSERT INTO `showdetails` VALUES ('12', '2', '2019-04-30', '24', '214', '否', '人11', '', '1');
INSERT INTO `showdetails` VALUES ('13', '2', '2019-03-10', '123', '123', '阿斯顿', '请问', '', '1');

-- ----------------------------
-- Table structure for show_city
-- ----------------------------
DROP TABLE IF EXISTS `show_city`;
CREATE TABLE `show_city` (
  `scid` int(10) NOT NULL AUTO_INCREMENT,
  `cityid` int(10) DEFAULT NULL,
  `showid` int(10) DEFAULT NULL,
  PRIMARY KEY (`scid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='�ݳ�-�����м��';

-- ----------------------------
-- Records of show_city
-- ----------------------------
INSERT INTO `show_city` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for show_venue
-- ----------------------------
DROP TABLE IF EXISTS `show_venue`;
CREATE TABLE `show_venue` (
  `svid` int(10) NOT NULL AUTO_INCREMENT,
  `showid` int(10) DEFAULT NULL,
  `seatType` int(5) DEFAULT NULL,
  `seatCount` int(5) DEFAULT NULL,
  `showprice` int(10) DEFAULT NULL,
  PRIMARY KEY (`svid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='�ݳ�-�����м��';

-- ----------------------------
-- Records of show_venue
-- ----------------------------
INSERT INTO `show_venue` VALUES ('1', '1', '1', '100', '100');

-- ----------------------------
-- Table structure for ticketorder
-- ----------------------------
DROP TABLE IF EXISTS `ticketorder`;
CREATE TABLE `ticketorder` (
  `orderid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `cid` int(10) DEFAULT NULL,
  `ordertime` varchar(32) DEFAULT NULL COMMENT '下单时间：超时订单取消',
  `expfee` varchar(16) DEFAULT NULL COMMENT '运费',
  `discount` double(3,2) DEFAULT NULL,
  `totalprice` int(10) DEFAULT NULL,
  `uaname` varchar(32) DEFAULT NULL,
  `uaphone` varchar(16) DEFAULT NULL,
  `uaddress` varchar(64) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0：待支付，1：支付成功，2：支付失败，3：超时取消，4：客户取消（订单关闭）',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of ticketorder
-- ----------------------------
INSERT INTO `ticketorder` VALUES ('1', '1', '1', '2019年4月25日10:48:44', '10', '0.50', '100', 'zs', '123', '东莞市', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL,
  `nickname` varchar(16) DEFAULT NULL COMMENT '身份证姓名',
  `phone` varchar(16) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `icon` varbinary(255) DEFAULT NULL COMMENT '用户头像',
  `name` varchar(16) DEFAULT NULL COMMENT '身份证',
  `gender` bit(1) DEFAULT b'0' COMMENT '0：女，1：男',
  `idc` char(18) DEFAULT NULL COMMENT '身份证号',
  `isLock` bit(1) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs', '2dd65e975ba9a8b988486979d651a50f', null, '123', 'zs@qq.com', null, 'zs', '\0', null, '\0', '');
INSERT INTO `user` VALUES ('2', 'ls', '2dd65e975ba9a8b988486979d651a50f', null, '111', 'ls@qq.com', '', 'ls', '\0', '', '\0', '');
INSERT INTO `user` VALUES ('3', 'ww', '2dd65e975ba9a8b988486979d651a50f', null, '222', 'ww@qq.com', '', 'ww', '\0', '', '\0', '');
INSERT INTO `user` VALUES ('4', 'll', '2dd65e975ba9a8b988486979d651a50f', null, '333', 'll@qq.com', '', 'll', '\0', '', '\0', '');
INSERT INTO `user` VALUES ('5', 't7', '2dd65e975ba9a8b988486979d651a50f', null, '444', 't7@qq.com', '', 't7', '\0', '', '\0', '');
INSERT INTO `user` VALUES ('6', 'w8', '2dd65e975ba9a8b988486979d651a50f', null, '555', 'w8@qq.com', '', 'w8', '\0', '', '\0', '');
INSERT INTO `user` VALUES ('7', 'aa', '2dd65e975ba9a8b988486979d651a50f', null, '666', 'aa@qq.com', '', 'aa', '\0', '', '\0', '');

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `uaid` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) DEFAULT NULL,
  `uaname` varchar(32) DEFAULT NULL COMMENT '收件人姓名',
  `uaphone` varchar(16) DEFAULT NULL,
  `uaddress` varchar(64) DEFAULT NULL,
  `isDefault` bit(1) DEFAULT NULL COMMENT '是否为默认地址',
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`uaid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='收件人信息';

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES ('1', '1', 'zs', '123', '东莞市', null, '');
