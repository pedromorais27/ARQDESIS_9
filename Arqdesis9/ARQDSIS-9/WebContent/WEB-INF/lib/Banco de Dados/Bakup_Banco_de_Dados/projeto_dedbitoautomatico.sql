-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: projeto
-- ------------------------------------------------------
-- Server version	5.6.27

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
-- Table structure for table `dedbitoautomatico`
--

DROP TABLE IF EXISTS `dedbitoautomatico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dedbitoautomatico` (
  `codigoDebito` int(11) NOT NULL AUTO_INCREMENT,
  `tipoDebito` varchar(45) DEFAULT NULL,
  `operadora` varchar(45) DEFAULT NULL,
  `codigoConsumidor` int(11) DEFAULT NULL,
  `dataDebitol` datetime DEFAULT NULL,
  `valorDebito` decimal(10,0) DEFAULT NULL,
  `conta` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoDebito`),
  KEY `conta_idx` (`conta`),
  CONSTRAINT `conta` FOREIGN KEY (`conta`) REFERENCES `conta` (`conta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dedbitoautomatico`
--

LOCK TABLES `dedbitoautomatico` WRITE;
/*!40000 ALTER TABLE `dedbitoautomatico` DISABLE KEYS */;
INSERT INTO `dedbitoautomatico` VALUES (1,'debito em conta corrente','Água',123,'2015-10-20 00:00:00',200,206107),(2,'debito em conta corrente','Água',123,'2015-10-22 00:00:00',200,206107),(3,'debito em conta corrente','Telefone',123,'2015-10-19 00:00:00',200,206107),(4,'debito em conta corrente','Água',123,'2015-10-30 00:00:00',200,206107);
/*!40000 ALTER TABLE `dedbitoautomatico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-22 10:03:07
