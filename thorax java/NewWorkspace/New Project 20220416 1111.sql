-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema thorax
--

CREATE DATABASE IF NOT EXISTS thorax;
USE thorax;

--
-- Definition of table `dataset`
--

DROP TABLE IF EXISTS `dataset`;
CREATE TABLE `dataset` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Area` int(10) unsigned NOT NULL,
  `Stage` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dataset`
--

/*!40000 ALTER TABLE `dataset` DISABLE KEYS */;
INSERT INTO `dataset` (`id`,`Area`,`Stage`) VALUES 
 (1,0,'Healthy'),
 (2,1,'Initial'),
 (3,2,'Initial'),
 (4,3,'Initial'),
 (5,4,'Initial'),
 (6,5,'Initial'),
 (7,6,'Initial'),
 (8,7,'Initial'),
 (9,8,'Initial'),
 (10,9,'Initial'),
 (11,10,'Initial'),
 (12,11,'Initial'),
 (13,12,'Initial'),
 (14,13,'Initial'),
 (15,14,'Initial'),
 (16,15,'Initial'),
 (17,16,'Initial'),
 (18,17,'Initial'),
 (19,18,'Initial'),
 (20,19,'Initial'),
 (21,20,'Initial'),
 (22,21,'Initial'),
 (23,22,'Initial'),
 (24,23,'Initial'),
 (25,24,'Initial'),
 (26,25,'Initial'),
 (27,26,'Initial'),
 (28,27,'Initial'),
 (29,28,'Initial'),
 (30,29,'Initial'),
 (31,30,'Initial'),
 (32,31,'Initial'),
 (33,32,'Initial'),
 (34,33,'Initial'),
 (35,34,'Initial'),
 (36,35,'Initial'),
 (37,36,'Initial'),
 (38,37,'Critical');
/*!40000 ALTER TABLE `dataset` ENABLE KEYS */;


--
-- Definition of table `tbl_results`
--

DROP TABLE IF EXISTS `tbl_results`;
CREATE TABLE `tbl_results` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `area` varchar(45) NOT NULL,
  `stage` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_results`
--

/*!40000 ALTER TABLE `tbl_results` DISABLE KEYS */;
INSERT INTO `tbl_results` (`id`,`area`,`stage`,`name`) VALUES 
 (1,'51.441402','Covid Is In Critical Stage','nitin');
/*!40000 ALTER TABLE `tbl_results` ENABLE KEYS */;


--
-- Definition of table `tbladmin`
--

DROP TABLE IF EXISTS `tbladmin`;
CREATE TABLE `tbladmin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbladmin`
--

/*!40000 ALTER TABLE `tbladmin` DISABLE KEYS */;
INSERT INTO `tbladmin` (`id`,`email`,`pass`) VALUES 
 (1,'admin@gmail.com','admin');
/*!40000 ALTER TABLE `tbladmin` ENABLE KEYS */;


--
-- Definition of table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_address` varchar(45) NOT NULL,
  `user_age` varchar(45) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_mob` varchar(45) NOT NULL,
  `user_pass` varchar(45) NOT NULL,
  `doc_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbluser`
--

/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` (`id`,`user_name`,`user_address`,`user_age`,`user_email`,`user_mob`,`user_pass`,`doc_name`) VALUES 
 (1,'Shekhar','Pune','25','shekhar.thube@gmail.com','9632124596','123','Dr.Joshi'),
 (2,'Akshay','Pune','24','akshay454554@gmail.com','8956451278','123','Dr. Joshi'),
 (3,'ss','ss','32','ss@gmail.com','9890123456','ss','ss'),
 (4,'jahnavi','pune','22','jahnavisharma104@gmail.com','7587281689','jahnavi@123','Dr Srivastava'),
 (5,'nikitabarve','Ahmednagar','21','nikitabarve2205@gmail.com','7798564433','Nikita@123','Nikita');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
