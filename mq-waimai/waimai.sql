-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: waimai
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mq_msg_log`
--

DROP TABLE IF EXISTS `mq_msg_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mq_msg_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` enum('consumed_fail','consumed_success','send_success','pre_send','send_fail') NOT NULL,
  `cause` varchar(45) DEFAULT NULL,
  `exchange` varchar(45) NOT NULL,
  `routing_key` varchar(45) NOT NULL,
  `msg` varchar(200) NOT NULL,
  `try_count` tinyint(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mq_msg_log`
--

LOCK TABLES `mq_msg_log` WRITE;
/*!40000 ALTER TABLE `mq_msg_log` DISABLE KEYS */;
INSERT INTO `mq_msg_log` VALUES (1,'send_success',NULL,'order-exchange','order-queue','{\"goodId\":1,\"id\":0,\"msgId\":0,\"orderTime\":1585886460000,\"salerId\":1,\"totalPrice\":11,\"userId\":1}',0),(2,'send_success',NULL,'order-exchange','order-queue','{\"goodId\":1,\"id\":0,\"msgId\":0,\"orderTime\":1585886460000,\"salerId\":1,\"totalPrice\":11,\"userId\":1}',0);
/*!40000 ALTER TABLE `mq_msg_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saler_goods`
--

DROP TABLE IF EXISTS `saler_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saler_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saler_id` int(11) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saler_goods`
--

LOCK TABLES `saler_goods` WRITE;
/*!40000 ALTER TABLE `saler_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `saler_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waimai_order`
--

DROP TABLE IF EXISTS `waimai_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waimai_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `saler_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `order_time` timestamp(3) NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `msg_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waimai_order`
--

LOCK TABLES `waimai_order` WRITE;
/*!40000 ALTER TABLE `waimai_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `waimai_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waimai_saler`
--

DROP TABLE IF EXISTS `waimai_saler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waimai_saler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saler_name` varchar(45) NOT NULL,
  `poseition` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waimai_saler`
--

LOCK TABLES `waimai_saler` WRITE;
/*!40000 ALTER TABLE `waimai_saler` DISABLE KEYS */;
/*!40000 ALTER TABLE `waimai_saler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waimai_user`
--

DROP TABLE IF EXISTS `waimai_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waimai_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `poseition` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waimai_user`
--

LOCK TABLES `waimai_user` WRITE;
/*!40000 ALTER TABLE `waimai_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `waimai_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-03 18:09:35
