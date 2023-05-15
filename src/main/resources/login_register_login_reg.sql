-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: login_register
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `login_reg`
--

DROP TABLE IF EXISTS `login_reg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_reg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(45) NOT NULL,
  `confirm_password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_reg`
--

LOCK TABLES `login_reg` WRITE;
/*!40000 ALTER TABLE `login_reg` DISABLE KEYS */;
INSERT INTO `login_reg` VALUES (1,'Hitesh Kumar','abc@gmail.com','1234','1234'),(2,'Someone','something@gmail.com','1234','1234'),(3,'Name','xyz@gmail.com','1234','1234'),(4,'hi','dhsdf','81dc9bdb52d04dc20036dbd8313ed055','81dc9bdb52d04dc20036dbd8313ed055'),(5,'ddd','ffg','6eea9b7ef19179a06954edd0f6c05ceb','6eea9b7ef19179a06954edd0f6c05ceb'),(6,'a','a','c4ca4238a0b923820dcc509a6f75849b','c4ca4238a0b923820dcc509a6f75849b'),(7,'a','q','22ea1c649c82946aa6e479e1ffd321e4a318b1b0','22ea1c649c82946aa6e479e1ffd321e4a318b1b0'),(8,'e','e','58e6b3a414a1e090dfc6029add0f3555ccba127f','58e6b3a414a1e090dfc6029add0f3555ccba127f'),(9,'hitesh thakur','hitesh@gmail.com','296f221bf02be6e64e3e7bb2b961acdd8ae86ccf','296f221bf02be6e64e3e7bb2b961acdd8ae86ccf');
/*!40000 ALTER TABLE `login_reg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-15 17:57:10
