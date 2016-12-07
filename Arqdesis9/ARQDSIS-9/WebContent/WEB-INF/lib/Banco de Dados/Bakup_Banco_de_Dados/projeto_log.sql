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
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `codigoItemLog` int(11) NOT NULL AUTO_INCREMENT,
  `codigoDoMovimento` int(11) DEFAULT NULL,
  `tipoOperacao` varchar(45) DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  `Conta` int(11) DEFAULT NULL,
  `agencia` int(11) DEFAULT NULL,
  `codigoDoCliente` int(11) DEFAULT NULL,
  `dataOperacao` datetime DEFAULT NULL,
  PRIMARY KEY (`codigoItemLog`),
  KEY `codigoMovimento_idx` (`codigoDoMovimento`),
  KEY `codCli_idx` (`codigoDoCliente`),
  KEY `codConta_idx` (`Conta`),
  CONSTRAINT `codigoDaConta` FOREIGN KEY (`Conta`) REFERENCES `conta` (`conta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoDoCliente` FOREIGN KEY (`codigoDoCliente`) REFERENCES `cliente` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `codigoDoMovimento` FOREIGN KEY (`codigoDoMovimento`) REFERENCES `movimento` (`codigoMovimento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,'Debito Automatico',200,206107,6234,1,'2015-10-20 00:00:00'),(2,2,'Debito Automatico',200,206107,6234,1,'2015-10-22 00:00:00'),(3,3,'Debito Automatico',200,206107,6234,1,'2015-10-19 00:00:00'),(4,4,'Transferencia',200,206107,169,1,'2015-10-20 00:00:00'),(5,5,'Debito Automatico',200,206107,0,1,'2015-10-30 00:00:00'),(6,6,'Debito em Conta corrente',10,206107,6234,1,'2015-10-21 00:00:00'),(7,7,'Debito em Conta corrente',20,655070,169,2,'2015-10-21 00:00:00');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-22 10:03:00
