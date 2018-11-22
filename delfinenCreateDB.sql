CREATE DATABASE  IF NOT EXISTS `delfinen`;
USE `delfinen`;
-- Host: localhost    Database: delfinen
-- ------------------------------------------------------
-- Server version	8.0.13

--
-- Table structure for table `disciplines`
--

DROP TABLE IF EXISTS `disciplines`;
CREATE TABLE `disciplines` (
  `idcategories` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategories`)
);

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `idmembers` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `active` varchar(45) DEFAULT NULL,
  `elite` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmembers`)
);

--
-- Table structure for table `members_disciplines`
--

DROP TABLE IF EXISTS `members_disciplines`;
CREATE TABLE `members_disciplines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberID` int(11) DEFAULT NULL,
  `discipline1` varchar(45) DEFAULT NULL,
  `discipline2` varchar(45) DEFAULT NULL,
  `discipline3` varchar(45) DEFAULT NULL,
  `discipline4` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `idpayments` int(11) NOT NULL AUTO_INCREMENT,
  `idmembers` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpayments`)
);

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
CREATE TABLE `results` (
  `idresults` int(11) NOT NULL AUTO_INCREMENT,
  `idmembers` int(11) DEFAULT NULL,
  `iddisciplines` int(11) DEFAULT NULL,
  `time` double DEFAULT NULL,
  `comp` varchar(45) DEFAULT NULL,
  `place` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idresults`)
);
