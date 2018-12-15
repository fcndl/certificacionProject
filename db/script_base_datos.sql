-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: admin_campos
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campo`
--

DROP TABLE IF EXISTS `campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `campo` (
  `id_campo` int(11) NOT NULL,
  `nombre_campo` varchar(45) NOT NULL,
  `id_estado_campo` int(11) NOT NULL,
  PRIMARY KEY (`id_campo`),
  KEY `fk_campo__estado_campo_idx` (`id_estado_campo`),
  CONSTRAINT `fk_campo__estado_campo` FOREIGN KEY (`id_estado_campo`) REFERENCES `estadocampo` (`id_estado_campo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campo`
--

LOCK TABLES `campo` WRITE;
/*!40000 ALTER TABLE `campo` DISABLE KEYS */;
/*!40000 ALTER TABLE `campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cultivo`
--

DROP TABLE IF EXISTS `cultivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cultivo` (
  `id_cultivo` int(11) NOT NULL,
  `nombre_cultivo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cultivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cultivo`
--

LOCK TABLES `cultivo` WRITE;
/*!40000 ALTER TABLE `cultivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cultivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocampo`
--

DROP TABLE IF EXISTS `estadocampo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estadocampo` (
  `id_estado_campo` int(11) NOT NULL,
  `estado_campo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado_campo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocampo`
--

LOCK TABLES `estadocampo` WRITE;
/*!40000 ALTER TABLE `estadocampo` DISABLE KEYS */;
INSERT INTO `estadocampo` VALUES (1,'creado'),(2,'parcialmente trabajado'),(3,'completamente trabajado'),(4,'en desuso');
/*!40000 ALTER TABLE `estadocampo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lote` (
  `numero_lote` int(11) NOT NULL,
  `superficie` int(11) NOT NULL,
  `id_tipo_suelo` int(11) NOT NULL,
  `id_campo` int(11) NOT NULL,
  PRIMARY KEY (`numero_lote`),
  KEY `fk_lote__tiposuelo_idx` (`id_tipo_suelo`),
  KEY `fk_lote__campo_idx` (`id_campo`),
  CONSTRAINT `fk_lote__campo` FOREIGN KEY (`id_campo`) REFERENCES `campo` (`id_campo`),
  CONSTRAINT `fk_lote__tiposuelo` FOREIGN KEY (`id_tipo_suelo`) REFERENCES `tiposuelo` (`id_tipo_suelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `momentolaboreo`
--

DROP TABLE IF EXISTS `momentolaboreo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `momentolaboreo` (
  `id_momento_laboreo` int(11) NOT NULL,
  `id_cultivo` int(11) NOT NULL,
  `id_tipo_laboreo` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  `momento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_momento_laboreo`),
  KEY `fk_laboreos_cultivos__tipo_laboreo_idx` (`id_tipo_laboreo`),
  KEY `fk_laboreos_cultivos__cultivo_idx` (`id_cultivo`),
  CONSTRAINT `fk_laboreos_cultivos__cultivo` FOREIGN KEY (`id_cultivo`) REFERENCES `cultivo` (`id_cultivo`),
  CONSTRAINT `fk_laboreos_cultivos__tipo_laboreo` FOREIGN KEY (`id_tipo_laboreo`) REFERENCES `tipolaboreo` (`id_tipo_laboreo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `momentolaboreo`
--

LOCK TABLES `momentolaboreo` WRITE;
/*!40000 ALTER TABLE `momentolaboreo` DISABLE KEYS */;
/*!40000 ALTER TABLE `momentolaboreo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectocultivo`
--

DROP TABLE IF EXISTS `proyectocultivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proyectocultivo` (
  `id_proyecto_cultivo` int(11) NOT NULL,
  `id_cultivo` int(11) NOT NULL,
  `numero_lote` int(11) NOT NULL,
  `vigente` int(11) NOT NULL,
  `fecha_ini` datetime DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `cancelado` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_proyecto_cultivo`),
  KEY `fk_proyecto_cultivo__cultivo_idx` (`id_cultivo`),
  KEY `fk_proyecto_cultivo__lote_idx` (`numero_lote`),
  CONSTRAINT `fk_proyecto_cultivo__cultivo` FOREIGN KEY (`id_cultivo`) REFERENCES `cultivo` (`id_cultivo`),
  CONSTRAINT `fk_proyecto_cultivo__lote` FOREIGN KEY (`numero_lote`) REFERENCES `lote` (`numero_lote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectocultivo`
--

LOCK TABLES `proyectocultivo` WRITE;
/*!40000 ALTER TABLE `proyectocultivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyectocultivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrolaboreos`
--

DROP TABLE IF EXISTS `registrolaboreos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registrolaboreos` (
  `id_registro_laboreo` int(11) NOT NULL,
  `id_proyecto_cultivo` int(11) NOT NULL,
  `id_momento_laboreo` int(11) NOT NULL,
  PRIMARY KEY (`id_registro_laboreo`),
  KEY `fk_registro_laboreos__proyecto_cultivo_idx` (`id_proyecto_cultivo`),
  KEY `fk_registro_laboreos__momento_laboreo_idx` (`id_momento_laboreo`),
  CONSTRAINT `fk_registro_laboreos__momento_laboreo` FOREIGN KEY (`id_momento_laboreo`) REFERENCES `momentolaboreo` (`id_momento_laboreo`),
  CONSTRAINT `fk_registro_laboreos__proyecto_cultivo` FOREIGN KEY (`id_proyecto_cultivo`) REFERENCES `proyectocultivo` (`id_proyecto_cultivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrolaboreos`
--

LOCK TABLES `registrolaboreos` WRITE;
/*!40000 ALTER TABLE `registrolaboreos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrolaboreos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipolaboreo`
--

DROP TABLE IF EXISTS `tipolaboreo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipolaboreo` (
  `id_tipo_laboreo` int(11) NOT NULL,
  `nombre_tipo_laboreo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_laboreo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipolaboreo`
--

LOCK TABLES `tipolaboreo` WRITE;
/*!40000 ALTER TABLE `tipolaboreo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipolaboreo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposuelo`
--

DROP TABLE IF EXISTS `tiposuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tiposuelo` (
  `id_tipo_suelo` int(11) NOT NULL,
  `tipo_suelo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_suelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposuelo`
--

LOCK TABLES `tiposuelo` WRITE;
/*!40000 ALTER TABLE `tiposuelo` DISABLE KEYS */;
INSERT INTO `tiposuelo` VALUES (1,'Tipo 1'),(2,'Tipo 2'),(3,'Tipo 3'),(4,'Tipo 4'),(5,'Tipo 5');
/*!40000 ALTER TABLE `tiposuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-13  7:30:27
