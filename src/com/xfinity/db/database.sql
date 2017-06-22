-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.5-10.1.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for medilab
DROP DATABASE IF EXISTS `medilab`;
CREATE DATABASE IF NOT EXISTS `medilab` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `medilab`;


-- Dumping structure for table medilab.tbl_report_result
DROP TABLE IF EXISTS `tbl_report_result`;
CREATE TABLE IF NOT EXISTS `tbl_report_result` (
  `reportResultId` int(11) NOT NULL,
  `elementId` int(11) NOT NULL,
  `result` varchar(50) NOT NULL,
  PRIMARY KEY (`reportResultId`),
  KEY `FK_report_element` (`elementId`),
  CONSTRAINT `FK_report_element` FOREIGN KEY (`elementId`) REFERENCES `tbl_test_element` (`testElementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table medilab.tbl_test
DROP TABLE IF EXISTS `tbl_test`;
CREATE TABLE IF NOT EXISTS `tbl_test` (
  `testId` int(11) NOT NULL,
  `testName` varchar(100) NOT NULL,
  `footer` varchar(1000) NOT NULL,
  PRIMARY KEY (`testId`),
  UNIQUE KEY `testName` (`testName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table medilab.tbl_test_element
DROP TABLE IF EXISTS `tbl_test_element`;
CREATE TABLE IF NOT EXISTS `tbl_test_element` (
  `testElementId` int(11) NOT NULL,
  `testId` int(11) NOT NULL,
  `testElementName` varchar(100) NOT NULL,
  `unit` varchar(20) NOT NULL,
  `range` varchar(50) NOT NULL,
  `results` varchar(150) NOT NULL,
  PRIMARY KEY (`testElementId`),
  UNIQUE KEY `testElementName` (`testElementName`,`testId`),
  KEY `FK_test_element` (`testId`),
  CONSTRAINT `FK_test_element` FOREIGN KEY (`testId`) REFERENCES `tbl_test` (`testId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table medilab.tbl_test_report
DROP TABLE IF EXISTS `tbl_test_report`;
CREATE TABLE IF NOT EXISTS `tbl_test_report` (
  `reportId` int(11) NOT NULL,
  `patientName` varchar(50) NOT NULL,
  `testId` int(11) NOT NULL,
  `age` varchar(20) NOT NULL,
  `referredBy` varchar(50) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`reportId`),
  KEY `FK_test_report` (`testId`),
  CONSTRAINT `FK_test_report` FOREIGN KEY (`testId`) REFERENCES `tbl_test` (`testId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for view medilab.view_report_result
DROP VIEW IF EXISTS `view_report_result`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `view_report_result` (
	`testElementName` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`unit` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`range` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`result` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=InnoDB;

-- Dumping structure for view medilab.view_report_result
DROP VIEW IF EXISTS `view_report_result`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `view_report_result`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `view_report_result` AS SELECT tte.testElementName, tte.unit, tte.`range`, trr.result from tbl_report_result as trr inner join tbl_test_element as tte on trr.elementId=tte.testElementId ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

ALTER TABLE `medilab`.`tbl_test_element` 
ADD COLUMN `grouping` ENUM('true', 'false') NULL DEFAULT 'true' AFTER `results`,
ADD COLUMN `floatingPoints` INT(11) NULL DEFAULT 0 AFTER `grouping`;

DROP TABLE IF EXISTS `tbl_doctor`;
CREATE TABLE IF NOT EXISTS `tbl_doctor` (
  `docId` int(11) NOT NULL,
  `docName` varchar(100) NOT NULL,
  PRIMARY KEY (`docId`),
  UNIQUE KEY `docName` (`docName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `medilab`.`tbl_doctor` 
CHANGE COLUMN `docId` `docId` INT(11) NOT NULL AUTO_INCREMENT ;
