-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: addressbook
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
-- Table structure for table `addresslist`
--

DROP TABLE IF EXISTS `addresslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresslist` (
  `ADDRESSLIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(30) DEFAULT NULL,
  `ADDRESS` varchar(30) DEFAULT NULL,
  `CITY` varchar(20) DEFAULT NULL,
  `STATE` varchar(20) DEFAULT NULL,
  `ZIP` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ADDRESSLIST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresslist`
--

LOCK TABLES `addresslist` WRITE;
/*!40000 ALTER TABLE `addresslist` DISABLE KEYS */;
INSERT INTO `addresslist` VALUES (1,'Home','123 Paper Street','Anytown','NY','12345'),(2,'Home','123 Paper Street','Anytown','NY','12345'),(3,'Home','123 Paper Street','Anytown','NY','12345'),(4,'Home','123 Paper Street','Anytown','NY','12345'),(5,'Home','123 Paper Street','Anytown','NY','12345'),(6,'Work','256 Paper Street','Anytown','NY','12345'),(7,'Work','256 Paper Street','Anytown','NY','12345'),(8,'Work','256 Paper Street','Anytown','NY','12345');
/*!40000 ALTER TABLE `addresslist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_addresses`
--

DROP TABLE IF EXISTS `contact_addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_addresses` (
  `CONTACTS_ID` int(11) NOT NULL,
  `ADDRESSLIST_ID` int(11) NOT NULL,
  KEY `CONTACTS_ID_idx` (`CONTACTS_ID`),
  KEY `ADDRESSLIST_ID_idx` (`ADDRESSLIST_ID`),
  CONSTRAINT `ADDRESSLIST_ID` FOREIGN KEY (`ADDRESSLIST_ID`) REFERENCES `addresslist` (`ADDRESSLIST_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `CONTACTS_ID` FOREIGN KEY (`CONTACTS_ID`) REFERENCES `contacts` (`CONTACTS_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_addresses`
--

LOCK TABLES `contact_addresses` WRITE;
/*!40000 ALTER TABLE `contact_addresses` DISABLE KEYS */;
INSERT INTO `contact_addresses` VALUES (3,6),(3,8);
/*!40000 ALTER TABLE `contact_addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_phones`
--

DROP TABLE IF EXISTS `contact_phones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_phones` (
  `PHONELIST_ID` int(11) NOT NULL,
  `CONTACTS_ID` int(11) NOT NULL,
  KEY `CONTACTS_ID_idx` (`CONTACTS_ID`),
  KEY `PHONELIST_ID_idx` (`PHONELIST_ID`),
  CONSTRAINT `CONTACTS_ID_PHONE` FOREIGN KEY (`CONTACTS_ID`) REFERENCES `contacts` (`CONTACTS_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `PHONELIST_ID` FOREIGN KEY (`PHONELIST_ID`) REFERENCES `phonelist` (`PHONELIST_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_phones`
--

LOCK TABLES `contact_phones` WRITE;
/*!40000 ALTER TABLE `contact_phones` DISABLE KEYS */;
INSERT INTO `contact_phones` VALUES (1,3),(2,4);
/*!40000 ALTER TABLE `contact_phones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `CONTACTS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(30) NOT NULL,
  `LASTNAME` varchar(30) NOT NULL,
  `DOB` date DEFAULT NULL,
  PRIMARY KEY (`CONTACTS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'Kyle','Campbell','1981-05-21'),(2,'Anna','Butler','1995-07-11'),(3,'Linda','Martinez','2001-05-03'),(4,'Peter','Stewart','1967-01-21'),(5,'Jasper','Smith','2019-10-04');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonelist`
--

DROP TABLE IF EXISTS `phonelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonelist` (
  `PHONELIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(30) DEFAULT NULL,
  `NUMBER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PHONELIST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonelist`
--

LOCK TABLES `phonelist` WRITE;
/*!40000 ALTER TABLE `phonelist` DISABLE KEYS */;
INSERT INTO `phonelist` VALUES (1,'Home','123-456-7890'),(2,'Work','234-567-8901');
/*!40000 ALTER TABLE `phonelist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-07 16:09:10
