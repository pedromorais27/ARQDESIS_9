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
-- Table structure for table `movimento`
--

DROP TABLE IF EXISTS `movimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimento` (
  `codigoMovimento` int(11) NOT NULL AUTO_INCREMENT,
  `numConta` int(11) DEFAULT NULL,
  `dataOperacao` datetime DEFAULT NULL,
  `valorOperacao` decimal(10,0) DEFAULT NULL,
  `agenciaDestino` int(11) DEFAULT NULL,
  `contaDestino` int(11) DEFAULT NULL,
  `codCli` int(11) DEFAULT NULL,
  `codDebito` int(11) DEFAULT NULL,
  `tipoMovimento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigoMovimento`),
  KEY `conta_idx` (`numConta`),
  KEY `codCli_idx` (`codCli`),
  KEY `codDebito_idx` (`codDebito`),
  CONSTRAINT `codCli` FOREIGN KEY (`codCli`) REFERENCES `cliente` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codDebito` FOREIGN KEY (`codDebito`) REFERENCES `dedbitoautomatico` (`codigoDebito`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `numConta` FOREIGN KEY (`numConta`) REFERENCES `conta` (`conta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimento`
--

LOCK TABLES `movimento` WRITE;
/*!40000 ALTER TABLE `movimento` DISABLE KEYS */;
INSERT INTO `movimento` VALUES (1,206107,'2015-10-20 00:00:00',200,0,0,NULL,NULL,'Debito Automatico'),(2,206107,'2015-10-22 00:00:00',200,0,0,NULL,NULL,'Debito Automatico'),(3,206107,'2015-10-19 00:00:00',200,0,0,NULL,NULL,'Debito Automatico'),(4,206107,'2015-10-20 00:00:00',200,169,655070,NULL,NULL,'Transferencia'),(5,206107,'2015-10-30 00:00:00',200,0,0,NULL,NULL,'Debito Automatico'),(6,206107,'2015-10-21 00:00:00',10,0,0,NULL,NULL,'Debito em Conta corrente'),(7,655070,'2015-10-21 00:00:00',20,0,0,NULL,NULL,'Debito em Conta corrente');
/*!40000 ALTER TABLE `movimento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-22 10:03:02
