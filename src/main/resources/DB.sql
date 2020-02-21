/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.5.29 : Database - zcx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zcx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zcx`;

/*Table structure for table `a_table` */

DROP TABLE IF EXISTS `a_table`;

CREATE TABLE `a_table` (
                           `a_id` int(11) DEFAULT NULL,
                           `a_name` varchar(10) DEFAULT NULL,
                           `a_part` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `a_table` */

/*Table structure for table `b_table` */

DROP TABLE IF EXISTS `b_table`;

CREATE TABLE `b_table` (
                           `b_id` int(11) DEFAULT NULL,
                           `b_name` varchar(10) DEFAULT NULL,
                           `b_part` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `b_table` */

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
                          `CId` varchar(10) DEFAULT NULL,
                          `Cname` varchar(10) DEFAULT NULL,
                          `TId` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`CId`,`Cname`,`TId`) values ('01','语文','02'),('02','数学','01'),('03','英语','03');

/*Table structure for table `demo` */

DROP TABLE IF EXISTS `demo`;

CREATE TABLE `demo` (
                        `name` varchar(100) DEFAULT NULL,
                        `nickname` varchar(133) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `demo` */

insert  into `demo`(`name`,`nickname`) values ('詹栋','zcd'),('朱彩霞','zcx');

/*Table structure for table `girl` */

DROP TABLE IF EXISTS `girl`;

CREATE TABLE `girl` (
                        `id` bigint(108) NOT NULL AUTO_INCREMENT,
                        `name` varchar(10) DEFAULT NULL,
                        `time` datetime DEFAULT NULL,
                        `result` varchar(100) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `girl` */

insert  into `girl`(`id`,`name`,`time`,`result`) values (1,'lq','2012-01-01 13:51:24','nothing'),(2,'zl','2014-04-01 13:52:38','miss'),(3,'zcx','2018-06-20 13:56:35','pig');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
                          `id` bigint(100) NOT NULL AUTO_INCREMENT,
                          `name` varchar(10) DEFAULT NULL,
                          `age` int(16) DEFAULT NULL,
                          `favorite` varchar(100) DEFAULT NULL,
                          `detail` varchar(100) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`id`,`name`,`age`,`favorite`,`detail`) values (1,'zcd',20,'cb','cool'),(2,'zcx',20,'pig','pig'),(3,'lzz',21,'give head','fool'),(4,'sf',26,'collect soul','影魔'),(5,'1',1,NULL,NULL),(6,'1',1,NULL,NULL),(7,'1',1,NULL,NULL),(8,'1',1,NULL,NULL),(9,'1',1,NULL,NULL),(10,'1',1,NULL,NULL),(11,'01',1,NULL,NULL),(12,'01',1,NULL,NULL),(13,'01',1,NULL,NULL),(14,'01',1,NULL,NULL),(15,'01',1,NULL,NULL);

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
                      `SId` varchar(10) DEFAULT NULL,
                      `CId` varchar(10) DEFAULT NULL,
                      `score` decimal(18,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc` */

insert  into `sc`(`SId`,`CId`,`score`) values ('01','01','80.0'),('01','02','90.0'),('01','03','99.0'),('02','01','70.0'),('02','02','60.0'),('02','03','80.0'),('03','01','80.0'),('03','02','80.0'),('03','03','80.0'),('04','01','50.0'),('04','02','30.0'),('04','03','20.0'),('05','01','76.0'),('05','02','87.0'),('06','01','31.0'),('06','03','34.0'),('07','02','89.0'),('07','03','98.0');

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
                        `id` int(10) NOT NULL AUTO_INCREMENT,
                        `name` varchar(20) NOT NULL,
                        `logo` varchar(100) DEFAULT NULL,
                        `description` varchar(80) NOT NULL,
                        `price` varchar(20) NOT NULL,
                        `type` varchar(20) NOT NULL,
                        `recommend` varchar(10) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `shop` */

insert  into `shop`(`id`,`name`,`logo`,`description`,`price`,`type`,`recommend`) values (1,'末世',NULL,'普攻额外伤害','2460','attack','N'),(2,'泣血之刃',NULL,'物理吸血','1740','attack','N'),(3,'无尽战刃',NULL,'高额暴击伤害','2140','attack','Y'),(4,'宗师之力',NULL,'强化普攻','2100','attack','Y'),(5,'闪电匕首',NULL,'普攻附带闪电','1840','attack','N'),(6,'影刃',NULL,'暴击增加攻速','2070','attack','Y'),(7,'暗影战斧',NULL,'打脆皮用','2090','attack','Y'),(8,'破军',NULL,'高额攻击','2950','attack','N'),(9,'逐日之弓',NULL,'攻击距离变远','2100','attack','N'),(10,'破晓',NULL,'射手神装','3400','attack','N'),(11,'纯净苍穹',NULL,'暂时增加免伤','2230','attack','N');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                           `SId` varchar(10) DEFAULT NULL,
                           `Sname` varchar(10) DEFAULT NULL,
                           `Sage` datetime DEFAULT NULL,
                           `Ssex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`SId`,`Sname`,`Sage`,`Ssex`) values ('01','赵雷','1990-01-01 00:00:00','男'),('02','钱电','1990-12-21 00:00:00','男'),('03','孙风','1990-12-20 00:00:00','男'),('04','李云','1990-12-06 00:00:00','男'),('05','周梅','1991-12-01 00:00:00','女'),('06','吴兰','1992-01-01 00:00:00','女'),('07','郑竹','1989-01-01 00:00:00','女'),('09','张三','2017-12-20 00:00:00','女'),('10','李四','2017-12-25 00:00:00','女'),('11','李四','2012-06-06 00:00:00','女'),('12','赵六','2013-06-13 00:00:00','女'),('13','孙七','2014-06-01 00:00:00','女');

/*Table structure for table `t_dept` */

DROP TABLE IF EXISTS `t_dept`;

CREATE TABLE `t_dept` (
                          `deptno` int(11) DEFAULT NULL,
                          `dname` varchar(20) DEFAULT NULL,
                          `loc` varchar(40) DEFAULT NULL,
                          KEY `index_deptno` (`deptno`),
                          KEY `index_dname` (`dname`),
                          KEY `index_loc` (`loc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dept` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
                           `TId` varchar(10) DEFAULT NULL,
                           `Tname` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`TId`,`Tname`) values ('01','张三'),('02','李四'),('03','王五');

/*Table structure for table `tournament` */

DROP TABLE IF EXISTS `tournament`;

CREATE TABLE `tournament` (
                              `id` bigint(10) NOT NULL AUTO_INCREMENT,
                              `player` varchar(30) DEFAULT NULL,
                              `ethnicity` varchar(10) DEFAULT NULL,
                              `population` bigint(100) DEFAULT NULL,
                              `gold` bigint(10) DEFAULT NULL,
                              `wood` bigint(10) DEFAULT NULL,
                              `hero` varchar(10) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `index_player` (`player`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tournament` */

insert  into `tournament`(`id`,`player`,`ethnicity`,`population`,`gold`,`wood`,`hero`) values (1,'ted','ud',50,300,200,'dk+lich'),(2,'fly','orc',50,300,100,'bm+tc'),(3,'sky','hum',50,300,100,'am+mk'),(4,'moon','ne',80,2000,300,'dh+panda');

/*Table structure for table `visitor` */

DROP TABLE IF EXISTS `visitor`;

CREATE TABLE `visitor` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `username` varchar(30) DEFAULT NULL,
                           `password` int(20) DEFAULT NULL,
                           `type` varchar(20) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `visitor` */

insert  into `visitor`(`id`,`username`,`password`,`type`) values (1,'test',123456,'F'),(2,'xiaofeng',123,'T'),(3,'小风',456,'T'),(4,'a',200,'F');

/*Table structure for table `war3` */

DROP TABLE IF EXISTS `war3`;

CREATE TABLE `war3` (
                        `id` varchar(20) DEFAULT NULL,
                        `ethnicity` varchar(10) DEFAULT NULL,
                        `map` varchar(40) DEFAULT NULL,
                        `grade` bigint(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `war3` */

insert  into `war3`(`id`,`ethnicity`,`map`,`grade`) values (NULL,'a',NULL,500),(NULL,NULL,NULL,200);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
