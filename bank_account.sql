-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bank_account
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountbalance` int(11) DEFAULT NULL,
  `deposit_count` int(11) DEFAULT NULL,
  `total_deposit` int(11) DEFAULT NULL,
  `total_withdraw` int(11) DEFAULT NULL,
  `withdraw_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,20822,4,24300,3478,3),(2,31100,4,31400,300,2);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_limits`
--

DROP TABLE IF EXISTS `transaction_limits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_limits` (
  `transaction_limit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `max_depo_freq` int(11) DEFAULT NULL,
  `max_depo_per_day` int(11) DEFAULT NULL,
  `max_depo_per_transaction` int(11) DEFAULT NULL,
  `max_withdraw_freq` int(11) DEFAULT NULL,
  `max_withdraw_per_day` int(11) DEFAULT NULL,
  `max_withdraw_per_transaction` int(11) DEFAULT NULL,
  PRIMARY KEY (`transaction_limit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_limits`
--

LOCK TABLES `transaction_limits` WRITE;
/*!40000 ALTER TABLE `transaction_limits` DISABLE KEYS */;
INSERT INTO `transaction_limits` VALUES (1,4,150000,40000,3,50000,20000);
/*!40000 ALTER TABLE `transaction_limits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL,
  `transaction_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `transaction_amount` double DEFAULT NULL,
  `transaction_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (17,1,'2017-08-19 15:25:08',300,'deposit'),(18,1,'2017-08-19 15:59:28',0,'balance'),(19,1,'2017-08-19 18:33:44',0,'balance'),(20,1,'2017-08-19 18:37:25',0,'balance'),(21,1,'2017-08-19 18:47:50',0,'balance'),(22,2,'2017-08-20 09:15:03',0,'balance'),(23,2,'2017-08-20 09:17:00',0,'balance'),(24,2,'2017-08-20 09:17:05',0,'balance'),(25,2,'2017-08-20 09:17:07',0,'balance'),(26,1,'2017-08-20 09:17:15',0,'balance'),(27,1,'2017-08-21 10:23:21',0,'balance'),(28,1,'2017-08-21 10:23:29',0,'balance'),(29,1,'2017-08-21 10:24:55',0,'balance'),(30,2,'2017-08-21 10:25:12',0,'balance'),(31,1,'2017-08-21 10:34:57',0,'balance'),(32,2,'2017-08-21 11:59:30',200,'deposit'),(33,2,'2017-08-21 11:59:37',200,'deposit'),(34,2,'2017-08-21 12:00:28',200,'withdraw'),(35,1,'2017-08-21 12:05:30',1000,'withdraw'),(36,1,'2017-08-21 12:06:21',1000,'deposit'),(37,1,'2017-08-21 12:06:54',1878,'withdraw'),(38,2,'2017-08-21 12:34:52',100,'withdraw'),(39,2,'2017-08-21 12:35:16',1000,'deposit'),(40,1,'2017-08-22 09:31:36',0,'balance'),(41,1,'2017-08-22 09:38:42',0,'balance'),(42,2,'2017-08-22 09:42:43',0,'balance'),(43,2,'2017-08-22 09:42:57',30000,'deposit'),(44,1,'2017-08-22 10:55:03',5000,'deposit'),(45,1,'2017-08-22 10:55:19',10000,'deposit'),(46,2,'2017-08-22 10:55:42',0,'balance'),(47,1,'2017-08-22 10:55:50',0,'balance');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-22 14:10:07
