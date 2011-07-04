/*
SQLyog Enterprise - MySQL GUI v5.20
Host - 5.1.30-community : Database - mycms
*********************************************************************
Server version : 5.1.30-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `mycms`;

USE `mycms`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `cusnote` */

DROP TABLE IF EXISTS `cusnote`;

CREATE TABLE `cusnote` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `note_cusid` int(11) DEFAULT '0',
  `note_userid` int(11) DEFAULT '0',
  `note_time` datetime DEFAULT '2009-04-00 00:00:00',
  `note_addr` varchar(100) DEFAULT '不详',
  `note_summary` varchar(200) DEFAULT '不详',
  `note_info` varchar(200) DEFAULT '不详',
  `note_remark` varchar(1000) DEFAULT '不详',
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `cusnote` */

insert  into `cusnote`(`note_id`,`note_cusid`,`note_userid`,`note_time`,`note_addr`,`note_summary`,`note_info`,`note_remark`) values (1,NULL,NULL,'2009-03-04 00:00:00','家乐福','放火','ASDFA','ADSFA'),(2,NULL,NULL,'2009-05-05 14:05:05','sdf','asfa','asdf','asdffd'),(3,1,NULL,'2009-04-12 11:31:59','友谊商店','物品首饰','已交易','三件套,纯金首饰');

/*Table structure for table `cusorder` */

DROP TABLE IF EXISTS `cusorder`;

CREATE TABLE `cusorder` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_cusid` int(11) DEFAULT '0',
  `order_date` datetime DEFAULT '2009-04-00 00:00:00',
  `order_addr` varchar(200) DEFAULT '不详',
  `order_state` int(11) DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cusorder` */

insert  into `cusorder`(`order_id`,`order_cusid`,`order_date`,`order_addr`,`order_state`) values (1,1,'2009-02-09 00:00:00','德政二马路45号',0),(2,2,'2009-03-02 00:00:00','中山六路中六电脑城2楼B02',1),(3,1,'2008-05-08 00:00:00','东风东路12号',0),(4,1,'2008-06-07 00:00:00','员村2横路5号',1),(5,3,'2009-04-00 00:00:00','梅花村1号',0),(6,4,'2007-08-10 00:00:00','西门口东街1号',0);

/*Table structure for table `cusorderitems` */

DROP TABLE IF EXISTS `cusorderitems`;

CREATE TABLE `cusorderitems` (
  `item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_count` int(10) unsigned DEFAULT '0',
  `item_prodid` int(10) unsigned DEFAULT '0',
  `item_orderid` int(10) unsigned DEFAULT '0',
  `item_price` double DEFAULT '0',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `cusorderitems` */

insert  into `cusorderitems`(`item_id`,`item_count`,`item_prodid`,`item_orderid`,`item_price`) values (1,4,1,1,7000),(2,5,1,1,50),(3,10,2,3,80),(4,71,3,4,18),(5,11,3,5,52),(6,12,6,5,82),(7,1000,7,6,2.5),(8,1000,8,6,1),(9,2,5,7,500);

/*Table structure for table `cusstaff` */

DROP TABLE IF EXISTS `cusstaff`;

CREATE TABLE `cusstaff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(50) DEFAULT '无名',
  `staff_cusid` int(11) DEFAULT '0',
  `staff_sex` varchar(2) DEFAULT '男',
  `staff_job` varchar(100) DEFAULT '厕所工',
  `staff_phone` varchar(100) DEFAULT '10086',
  `staff_tel` varchar(100) DEFAULT '10000',
  `staff_remark` varchar(200) DEFAULT '不详',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `cusstaff` */

insert  into `cusstaff`(`staff_id`,`staff_name`,`staff_cusid`,`staff_sex`,`staff_job`,`staff_phone`,`staff_tel`,`staff_remark`) values (1,'董浩斌',1,'男','经理','346343','2424423','jlkjl'),(2,'黄振耀',2,'男','广州负责人','79797987','4535345','4543'),(3,'高展辉',2,'男','中山移动','324543543','34234','傻西'),(6,'邓小洞',1,'男','广州黄埔区组长','08098023','98080983','大佬'),(7,'何建',3,'男','广州东山区组长','32423423','68967',NULL),(8,'蔡亮楷',4,'男','广州荔湾区组长','453634634','234645768',NULL),(9,'肖筱',5,'女','广州黄埔区组长','435345','2147483647',NULL),(10,'方宜',6,'女','广州天河区工作员','09808098','47587809',NULL),(11,'李香琴',7,'女','上下九区段负责人','09808098','86531478',NULL),(12,'卡东西',8,'男','广州从化区组长','09808098','56312488',NULL),(13,'蔡亮楷',9,'男','佛山地区组长','453634634','2147483647',NULL),(14,'何建',10,NULL,NULL,'32423423',NULL,NULL),(15,'关志佳',11,NULL,NULL,'34535634',NULL,NULL),(16,'徐小辉',12,NULL,NULL,'4098023',NULL,NULL);

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_userid` int(11) DEFAULT '0',
  `cus_name` varchar(200) DEFAULT '0',
  `cus_area` int(10) unsigned DEFAULT '0',
  `cus_level` int(10) unsigned DEFAULT '0',
  `cus_contentment` int(11) DEFAULT '0',
  `cus_credit` int(11) DEFAULT '0',
  `cus_address` varchar(200) DEFAULT '不详',
  `cus_postalcode` int(11) DEFAULT '510000',
  `cus_tel` varchar(100) DEFAULT '10086',
  `cus_fax` varchar(100) DEFAULT '10000',
  `cus_site` varchar(100) DEFAULT '不详',
  `cus_enrol` varchar(100) DEFAULT '不详',
  `cus_corporation` varchar(50) DEFAULT '不详',
  `cus_bankroll` int(11) DEFAULT '0',
  `cus_turnover` int(11) DEFAULT '0',
  `cus_bank` varchar(100) DEFAULT '不详',
  `cus_bankAccouts` varchar(100) DEFAULT '0',
  `cus_terraTax` varchar(100) DEFAULT '不详',
  `cus_countryTax` varchar(100) DEFAULT '不详',
  `cus_status` int(11) DEFAULT '0',
  `cus_losedate` datetime DEFAULT '2000-01-01 00:00:00',
  `cus_manid` int(10) unsigned DEFAULT '0',
  `cus_loseinfo` varchar(300) DEFAULT '不详',
  `cus_losedelay` varchar(300) DEFAULT '不详',
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `customers` */

insert  into `customers`(`cus_id`,`cus_userid`,`cus_name`,`cus_area`,`cus_level`,`cus_contentment`,`cus_credit`,`cus_address`,`cus_postalcode`,`cus_tel`,`cus_fax`,`cus_site`,`cus_enrol`,`cus_corporation`,`cus_bankroll`,`cus_turnover`,`cus_bank`,`cus_bankAccouts`,`cus_terraTax`,`cus_countryTax`,`cus_status`,`cus_losedate`,`cus_manid`,`cus_loseinfo`,`cus_losedelay`) values (1,3,'宜通世纪',1,2,1,4,'荔湾区',3344,'323532534','3425454','AFLK.COM','45345','广力',334,324,'324','23324','3242','23423',2,'2009-05-15 12:43:50',1,'不详','XXXX'),(2,2,'中国移动',1,1,1,3,'天河区',23123,'85321452','3345657','acet.com','78345','并卡尔',5000,50,'5200','1236685','123573','12344',3,'2009-05-23 21:05:40',2,'叼佢','不详'),(3,1,'广州穗微',0,1,3,5,'东山区',50012,'13106574576','7543389','nbac.com','80124','博卡',1000000,2000,'5623','235779','672345','5812',2,'2009-05-23 21:04:53',7,'不详','登门拜访，尽量拖延时间'),(4,2,'电信盈科',0,1,2,4,'芳村区',40013,'13702356849','4456779','nets.com.cn','12378','西丽',2000,1000,'987','12347','42365769','8793454',2,'2009-05-23 21:06:11',8,'不详','发送赠品'),(8,NULL,'用友',4,5,1,5,'黄埔区',32100,'15835658691','1134874','bauedas.hk','36467','西马克',65000,5300,'4876','65324','3435','803462',2,'2009-05-23 21:11:12',12,NULL,'讲粗口'),(9,2,'电信盈科',0,5,2,4,'越秀区',8231,'13609753689','3456790','oiuyli.cn','24576','千万朵',480000,62000,'0934','23456','567','8734523',1,'2009-05-04 00:00:00',13,'不详','不详'),(10,NULL,'广州穗微',0,6,1,1,'',0,'','','','','',0,0,'','','','',1,NULL,14,NULL,NULL),(11,12,'润迅通信',0,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,15,NULL,NULL),(12,14,'上海交大',0,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,16,NULL,NULL);

/*Table structure for table `produces` */

DROP TABLE IF EXISTS `produces`;

CREATE TABLE `produces` (
  `prod_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(150) DEFAULT '不详',
  `prod_price` double DEFAULT '0',
  `prod_type` varchar(100) DEFAULT '不详',
  `prod_level` varchar(100) DEFAULT '不详',
  `prod_info` varchar(200) DEFAULT '不详',
  `prod_unit` varchar(45) DEFAULT '不详',
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `produces` */

insert  into `produces`(`prod_id`,`prod_name`,`prod_price`,`prod_type`,`prod_level`,`prod_info`,`prod_unit`) values (1,'2202机架',20000,'RBS2000','3234 234e','大机架','个'),(2,'CDU C+',10000,'RBS 2202','4521/4f43','合路器','个'),(3,'1101机架',30000,'RBS 2001','4321/1234','小机架','件'),(4,'PDU MC',60000,'Bcs 300','678/987','Kasd','套'),(5,'CNM F1',8080,'Ks 4000','789/412','Bao','包'),(6,'KDX EW',9012,'BVKLH','5012/1236','VNC','箱'),(7,'LK JS',125754,'VSJKLO','98745/120938','EOIR_DL','KM'),(8,'CXA 01',876541,'CDO','123/098','CID','PC'),(9,'TRU 1800',3990,'96/39','3023/234','1800载波','个'),(10,'DTRU 1800',6400,'78/38','9/39/32','2206载波','个'),(11,'Nokia N73',1400,'32/09','08230/23233','手机','个'),(12,'索爱 x1',2000,'34/3432','l342/231','手机','个'),(13,'多普达 O2',3432,'323/23','34324/ae3','商务手机','个'),(14,'Acer ASPIRE 4520G',5000,'8080/32','32432/SDF','手提电脑','个'),(15,'Canon A650',2000,'342/322','不详','数码相机','个'),(16,'KingMax 超棒 8G',100,'23213/32','34/231','迷你U盘','个'),(17,'Acer AF160',600,'5343/45','435/affe3','17寸纯平','个'),(18,'TP-Link 无线路由',130,'TL-WR541G+','08/dafe','无线路由器','个'),(19,'魅族 miniplayer',500,'8080/dfade33','dadf/3232','视频Mp3','个'),(20,'七彩虹 5700LE',400,'3234/354','342/34df','显卡','个'),(21,'Bonny 网球排',342,'568/435','3566/765','网球拍','个'),(22,'三鹿天然奶粉',20,'435/435','45/234','会吃死人的','箱');

/*Table structure for table `sellchance` */

DROP TABLE IF EXISTS `sellchance`;

CREATE TABLE `sellchance` (
  `cha_id` int(11) NOT NULL AUTO_INCREMENT,
  `cha_userid` int(11) DEFAULT '0',
  `cha_source` varchar(200) DEFAULT '不详',
  `cha_clientName` varchar(100) DEFAULT '不详',
  `cha_successRate` int(11) DEFAULT '0',
  `cha_summary` varchar(500) DEFAULT '不详',
  `cha_context` varchar(10) DEFAULT '不详',
  `cha_contextPhone` varchar(20) DEFAULT '10086',
  `cha_desc` varchar(500) DEFAULT '不详',
  `cha_creatorid` int(10) unsigned DEFAULT '0',
  `cha_createtime` datetime DEFAULT '2009-04-01 00:00:00',
  `cha_dispatchid` int(10) unsigned DEFAULT '0',
  `cha_distime` datetime DEFAULT '2009-04-01 00:00:00',
  `cha_code` varchar(45) DEFAULT '不详',
  `cha_staut` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`cha_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `sellchance` */

insert  into `sellchance`(`cha_id`,`cha_userid`,`cha_source`,`cha_clientName`,`cha_successRate`,`cha_summary`,`cha_context`,`cha_contextPhone`,`cha_desc`,`cha_creatorid`,`cha_createtime`,`cha_dispatchid`,`cha_distime`,`cha_code`,`cha_staut`) values (7,1,'上网搜索','润迅通信',60,'靠BB机起家','关志佳','34535634','又一条水鱼',1,'2009-05-03 19:44:13',12,'2009-05-18 21:59:14',NULL,4),(8,1,'熟人介绍','广州穗微',90,'广州代维第三','何建','32423423','把握机会',3,'2009-05-05 08:56:11',2,'2009-05-15 12:40:33',NULL,4),(9,1,'走访','电信盈科',30,'香港上市公司','蔡亮楷','453634634','好好把握',1,'2009-05-11 13:28:06',2,'2009-05-11 13:30:50',NULL,4),(10,1,'网上搜索','上海交大',100,'网络学院','徐小辉','4098023','高风险要有高回报',7,'2009-05-23 20:29:16',14,'2009-05-23 20:45:35',NULL,4);

/*Table structure for table `sellplan` */

DROP TABLE IF EXISTS `sellplan`;

CREATE TABLE `sellplan` (
  `plan_id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_chanceid` int(11) DEFAULT '0',
  `plan_pubdate` datetime DEFAULT '2009-04-01 00:00:00',
  `plan_content` varchar(200) DEFAULT '不详',
  `plan_stauts` int(10) unsigned DEFAULT '1',
  `plan_result` varchar(200) DEFAULT '不详',
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `sellplan` */

insert  into `sellplan`(`plan_id`,`plan_chanceid`,`plan_pubdate`,`plan_content`,`plan_stauts`,`plan_result`) values (2,1,'2009-04-06 00:00:00','推介产品',2,'差唔多完成'),(3,1,'2009-04-08 00:00:00','砍佢全家',1,NULL),(4,1,'2009-04-08 00:00:00','踢门',1,NULL),(5,2,'2009-03-04 13:23:34','电话骚扰',1,'积极向上'),(10,7,'2009-05-04 17:27:17','上门劈友',1,'高峰时的'),(11,9,'2009-05-11 13:31:30','电话咨询',1,'反应良好');

/*Table structure for table `services` */

DROP TABLE IF EXISTS `services`;

CREATE TABLE `services` (
  `ser_id` int(11) NOT NULL AUTO_INCREMENT,
  `ser_userid` int(11) DEFAULT '0',
  `ser_type` int(11) DEFAULT '0',
  `ser_context` varchar(100) DEFAULT '不详',
  `ser_cusid` int(11) DEFAULT '0',
  `ser_status` int(11) DEFAULT '1',
  `ser_requset` varchar(1000) DEFAULT '不详',
  `ser_pubtime` datetime DEFAULT '2009-04-01 00:00:00',
  `ser_createrid` int(11) DEFAULT '0',
  `ser_assginerid` int(11) DEFAULT '0',
  `ser_asstime` datetime DEFAULT '2009-04-01 00:00:00',
  `ser_handle` varchar(1000) DEFAULT '不详',
  `ser_handletime` datetime DEFAULT '2009-04-01 00:00:00',
  `ser_handlerid` int(10) unsigned DEFAULT '0',
  `ser_result` varchar(50) DEFAULT '不详',
  `ser_level` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`ser_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `services` */

insert  into `services`(`ser_id`,`ser_userid`,`ser_type`,`ser_context`,`ser_cusid`,`ser_status`,`ser_requset`,`ser_pubtime`,`ser_createrid`,`ser_assginerid`,`ser_asstime`,`ser_handle`,`ser_handletime`,`ser_handlerid`,`ser_result`,`ser_level`) values (1,1,1,'fff',1,2,'3','2009-04-29 10:34:53',1,1,NULL,'叼那姓','2009-04-30 12:55:48',1,NULL,NULL),(3,3,5,'3G芯片采购',2,3,'想买一批3G芯片','2009-04-29 10:34:53',2,4,NULL,'打七区','2009-05-18 10:13:44',11,'打得好',4),(4,1,1,'手机门户',2,5,'手机业务,手机网络技术','2009-04-12 11:51:51',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,1,2,'广州代维第三公司',3,5,'上个月采购的一批打印机存在质量问题','2009-05-14 01:26:10',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,3,5,'关于OA采购',4,1,'希望向贵公司购入一批IBM 5302 OA机','2009-05-14 01:29:21',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,1,2,'啊啊',1,2,'adsfa','2009-05-14 01:35:48',1,2,'2009-05-14 16:36:34',NULL,NULL,NULL,NULL,NULL),(8,1,2,'质量问题',1,2,'货物有严重缺陷','2009-05-14 04:35:36',1,3,'2009-05-15 12:46:26',NULL,NULL,NULL,NULL,NULL),(10,1,5,'打断手一万，断脚两万',3,2,'保证意外','2009-05-18 10:05:06',1,11,'2009-05-18 22:06:10',NULL,NULL,NULL,NULL,NULL),(11,1,2,'OA机质量有问题',9,1,'OA机质量有问题','2009-07-27 11:27:21',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `storage` */

DROP TABLE IF EXISTS `storage`;

CREATE TABLE `storage` (
  `sto_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sto_name` varchar(100) DEFAULT '不详' COMMENT '仓库名',
  `sto_desc` varchar(300) DEFAULT '不详' COMMENT '仓库描述',
  PRIMARY KEY (`sto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='仓库表';

/*Data for the table `storage` */

insert  into `storage`(`sto_id`,`sto_name`,`sto_desc`) values (1,'皇后码头','不详'),(2,'天字码头2期','不详'),(3,'芳村器件仓库','不详'),(4,'库斯塔码头','不详'),(5,'美斯特仓库','不详'),(6,'柯尼卡道8号仓','不详'),(7,'阿道夫区5号街7仓','不详');

/*Table structure for table `storage_shelf` */

DROP TABLE IF EXISTS `storage_shelf`;

CREATE TABLE `storage_shelf` (
  `she_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `she_name` varchar(45) DEFAULT NULL COMMENT '货架名',
  `she_storageid` int(10) unsigned zerofill DEFAULT NULL COMMENT '仓库号',
  `she_desc` varchar(45) DEFAULT NULL COMMENT '货架描述',
  PRIMARY KEY (`she_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='货架表';

/*Data for the table `storage_shelf` */

insert  into `storage_shelf`(`she_id`,`she_name`,`she_storageid`,`she_desc`) values (1,'T09架',0000000001,NULL),(2,'34324架',0000000001,NULL),(3,'423层32架',0000000001,NULL),(4,'7080层3-0架',0000000002,NULL),(5,'453架',0000000002,NULL),(6,'2层',0000000003,NULL),(7,'1层',0000000003,NULL),(8,'3层1架',0000000003,NULL),(9,'首层',0000000004,NULL),(10,'2层',0000000004,NULL),(11,'码头仓',0000000005,NULL),(12,'4层3架',0000000006,NULL),(13,'东郊仓',0000000006,NULL),(14,'西郊仓',0000000007,NULL);

/*Table structure for table `storage_shelfitems` */

DROP TABLE IF EXISTS `storage_shelfitems`;

CREATE TABLE `storage_shelfitems` (
  `sitem_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sitem_shelfid` int(10) unsigned DEFAULT '0' COMMENT '货架号',
  `sitem_prodid` int(10) unsigned DEFAULT '0' COMMENT '物品号',
  `sitem_count` int(10) unsigned DEFAULT '0' COMMENT '物品数量',
  PRIMARY KEY (`sitem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='货架清单表';

/*Data for the table `storage_shelfitems` */

insert  into `storage_shelfitems`(`sitem_id`,`sitem_shelfid`,`sitem_prodid`,`sitem_count`) values (1,1,1,30),(2,1,1,5),(3,2,2,6),(4,2,1,9),(5,3,5,10),(6,4,6,51);

/*Table structure for table `sys_dataoptions` */

DROP TABLE IF EXISTS `sys_dataoptions`;

CREATE TABLE `sys_dataoptions` (
  `opt_id` int(11) NOT NULL AUTO_INCREMENT,
  `opt_dataid` int(11) DEFAULT NULL,
  `opt_name` varchar(50) DEFAULT NULL,
  `opt_value` int(11) DEFAULT NULL,
  `opt_isEdit` int(11) DEFAULT NULL,
  PRIMARY KEY (`opt_id`),
  KEY `FK_dataid` (`opt_dataid`),
  CONSTRAINT `FK_dataid` FOREIGN KEY (`opt_dataid`) REFERENCES `sys_datas` (`data_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dataoptions` */

insert  into `sys_dataoptions`(`opt_id`,`opt_dataid`,`opt_name`,`opt_value`,`opt_isEdit`) values (2,1,'合作伙伴',2,1),(3,1,'大客户',3,1),(4,1,'重点开发客户',4,1),(5,1,'普通客户',5,1),(6,2,'咨询',1,1),(7,2,'投诉',2,1),(8,2,'建议',3,1),(9,3,'华北',1,1),(10,3,'华南',2,1),(11,3,'华东',3,1),(12,3,'华西',4,1),(13,4,'☆',1,1),(14,4,'☆☆',2,1),(15,4,'☆☆☆',3,1),(16,4,'☆☆☆☆',4,1),(17,4,'☆☆☆☆☆',5,1),(19,8,'管理员',1,0),(20,3,'华中',5,1),(21,8,'高管',2,0),(22,8,'客户经理',3,1),(23,8,'业务主管',4,1),(24,8,'客服人员',5,1),(25,9,'新创建',1,0),(26,9,'已分配',2,0),(27,9,'已处理',3,0),(28,9,'已反馈',4,0),(29,9,'已归档',5,0),(30,2,'买卖',5,1),(31,11,'新创建',1,0),(32,11,'已分配',2,0),(33,11,'开发成功',3,0),(34,11,'已归档',4,0),(35,3,'未知',0,0),(36,5,'☆',1,0),(37,5,'☆☆',2,0),(38,5,'☆☆☆',3,0),(39,5,'☆☆☆☆',4,0),(40,5,'☆☆☆☆☆',5,0),(42,12,'跟进中',1,0),(43,12,'暂缓流失',2,1),(44,12,'确认流失',3,0),(45,1,'黑名单',6,1),(47,1,'重要战略伙伴',1,0);

/*Table structure for table `sys_datas` */

DROP TABLE IF EXISTS `sys_datas`;

CREATE TABLE `sys_datas` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT,
  `data_title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `sys_datas` */

insert  into `sys_datas`(`data_id`,`data_title`) values (1,'客户等级'),(2,'服务类型'),(3,'地区'),(4,'客户满意度'),(5,'客户信用度'),(8,'用户角色'),(9,'服务状态'),(11,'营销机会状态'),(12,'客户状态'),(13,'asd');

/*Table structure for table `sys_function` */

DROP TABLE IF EXISTS `sys_function`;

CREATE TABLE `sys_function` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(50) DEFAULT NULL,
  `f_mid` int(11) DEFAULT NULL,
  `f_url` varchar(120) DEFAULT NULL,
  `f_grant` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `sys_function` */

insert  into `sys_function`(`f_id`,`f_name`,`f_mid`,`f_url`,`f_grant`) values (1,'营销机会管理',1,'sell_showChance.jsp','A1'),(2,'客户开发计划',1,'sell_showEmpolder.jsp','A2'),(3,'客户信息管理',2,'cus_showCustomer.jsp','B1'),(4,'客户流失管理',2,'cus_showBleed.jsp','B2'),(5,'服务创建',3,'ser_doCreate.jsp','C1'),(6,'服务分配',3,'ser_showAssign.jsp','C2'),(7,'服务处理',3,'ser_showHandle.jsp','C3'),(8,'服务反馈',3,'ser_showFeedBack.jsp','C4'),(9,'服务归档',3,'ser_showFile.jsp','C5'),(10,'客户贡献分析',4,'sta_showComposing.jsp','D1'),(11,'客户构成分析',4,'sta_showContribute.jsp','D2'),(12,'客户流失分析',4,'sta_showLose.jsp','D3'),(13,'客户服务分析',4,'sta_showServer.jsp','D4'),(14,'数据字典管理',5,'data_showDictonary.jsp','E1'),(15,'查询产品信息',5,'prod_showInfo.jsp','E2'),(16,'查询仓库信息',5,'prod_showStore.jsp','E3'),(17,'管理角色权限',6,'grant_roleManage.jsp','F1'),(18,'管理用户权限',6,'grant_userManage.jsp','F2'),(19,'管理用户资料',6,'user_doManage.jsp','F2');

/*Table structure for table `sys_message` */

DROP TABLE IF EXISTS `sys_message`;

CREATE TABLE `sys_message` (
  `mes_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mes_context` varchar(300) DEFAULT NULL,
  `mes_fromid` int(10) unsigned DEFAULT NULL,
  `mes_toid` int(10) unsigned DEFAULT NULL,
  `mes_time` datetime DEFAULT NULL,
  `mes_isPublic` int(10) unsigned DEFAULT NULL,
  `mes_title` varchar(45) NOT NULL,
  PRIMARY KEY (`mes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `sys_message` */

insert  into `sys_message`(`mes_id`,`mes_context`,`mes_fromid`,`mes_toid`,`mes_time`,`mes_isPublic`,`mes_title`) values (1,'欢迎使用客服关系管理系统',1,2,'2009-03-04 00:00:00',1,'重要通知'),(2,'如需帮助请致电：13632254864',1,3,'2009-05-03 00:00:00',1,'温馨提示'),(3,'做得唔错',1,3,'2009-05-14 13:23:43',1,'关于统计管理效果'),(4,'界面设计比较简陋，希望能改善一下',5,1,'2009-05-15 08:42:14',1,'系统界面问题'),(5,'初期测试已通过，建议开发给客户使用.',2,1,'2009-05-15 12:02:12',1,'系统测试报告'),(6,'还有很多操作BUG要解决～',6,1,'2009-05-21 20:21:30',1,'用户体验报告'),(7,'同上',9,1,'2009-05-21 21:51:18',1,'龟兄'),(8,'多谢大家支持',1,13,'2009-05-21 22:03:22',1,'多谢'),(9,'~~~',12,1,'2009-05-21 22:05:18',1,''),(10,'大家可唔可以讲得详细D啊？',1,1,'2009-05-21 22:25:59',1,'关于大家的意见'),(11,'晖哥，我支持你！',14,1,'2009-05-23 21:32:41',1,''),(12,'请你好好放低',15,1,'2009-05-23 22:18:57',1,'123'),(13,'水敏话，你个网站整得好好',11,1,'2009-05-26 00:18:09',1,''),(14,'叼',11,1,'2009-05-26 00:20:22',1,'');

/*Table structure for table `sys_model` */

DROP TABLE IF EXISTS `sys_model`;

CREATE TABLE `sys_model` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(50) NOT NULL,
  `m_desc` varchar(100) NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sys_model` */

insert  into `sys_model`(`m_id`,`m_name`,`m_desc`) values (1,'sellManage','营销管理'),(2,'customerManage','客户管理'),(3,'serviceManage','服务管理'),(4,'statisticsManage','统计管理'),(5,'baseData','基础数据'),(6,'systemManage','配置管理');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) DEFAULT NULL,
  `u_pass` varchar(20) DEFAULT NULL,
  `u_realname` varchar(10) DEFAULT NULL,
  `u_roleid` int(11) DEFAULT NULL,
  `u_grant` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`u_id`,`u_name`,`u_pass`,`u_realname`,`u_roleid`,`u_grant`) values (1,'ken','167','林海晖',1,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E1/E2/E3/F1/F2'),(2,'fei','fei','朱鹏飞',2,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E2/E3/'),(3,'cheng','cheng','欧信成',3,NULL),(5,'jie','jie','高佬',2,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E1/E2/E3/F1/F2/F2/'),(6,'ray','ray','小文文',2,NULL),(7,'wenwenjie','wenwenjie','傻仔杰',3,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E2/E3/'),(8,'lucky','lucky','孔嘉',2,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E2/E3/'),(9,'gackt','gackt','西门中方',2,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E2/E3/'),(11,'penny','penny','昆仑',4,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E1/E2/E3/'),(13,'anson','anson','臭街',1,NULL),(14,'eastone','eastone','中山宜通',3,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E2/E3/'),(15,'t09','t09','S2下午班',5,'A1/A2/B1/B2/C1/C2/C3/C4/C5/D1/D2/D3/D4/E1/E2/E3/');

/*Table structure for table `view_sys_dataoptions` */

DROP TABLE IF EXISTS `view_sys_dataoptions`;

DROP VIEW IF EXISTS `view_sys_dataoptions`;

CREATE TABLE `view_sys_dataoptions` (
  `opt_id` int(11) NOT NULL DEFAULT '0',
  `data_title` varchar(100) DEFAULT NULL,
  `opt_name` varchar(50) DEFAULT NULL,
  `opt_value` int(11) DEFAULT NULL,
  `isEdit` varchar(4) DEFAULT NULL,
  `opt_isEdit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*View structure for view view_sys_dataoptions */

DROP VIEW IF EXISTS `view_sys_dataoptions`;

DROP TABLE IF EXISTS `view_sys_dataoptions`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_sys_dataoptions` AS select `sys_dataoptions`.`opt_id` AS `opt_id`,`sys_datas`.`data_title` AS `data_title`,`sys_dataoptions`.`opt_name` AS `opt_name`,`sys_dataoptions`.`opt_value` AS `opt_value`,(case when (`sys_dataoptions`.`opt_isEdit` = 0) then '不可编辑' else '可编辑' end) AS `isEdit`,`sys_dataoptions`.`opt_isEdit` AS `opt_isEdit` from (`sys_dataoptions` join `sys_datas`) where (`sys_datas`.`data_id` = `sys_dataoptions`.`opt_dataid`);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
