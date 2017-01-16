DROP TABLE IF EXISTS `aws`.`awsbatch`;
CREATE TABLE  `aws`.`awsbatch` (
  `awsbatchID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `batchName` varchar(45) NOT NULL DEFAULT '',
  `Status` varchar(45) NOT NULL DEFAULT '',
  `Servername` varchar(45) NOT NULL DEFAULT '',
  `XmlName` varchar(45) NOT NULL DEFAULT '',
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NoOfDocsFromZip` int(10) DEFAULT NULL,
  PRIMARY KEY (`awsbatchID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `aws`.`awsdocument`;
CREATE TABLE  `aws`.`awsdocument` (
  `awsdocumentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `deliveryType` varchar(45) DEFAULT NULL,
  `docId` varchar(45) DEFAULT NULL,
  `docName` varchar(45) DEFAULT NULL,
  `Status` varchar(45) NOT NULL DEFAULT '',
  `XmlName` varchar(45) NOT NULL DEFAULT '',
  `mmid` varchar(45) NOT NULL DEFAULT '',
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DateUpdated` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`awsdocumentID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `aws`.`logfailure`;
CREATE TABLE  `aws`.`logfailure` (
  `LogFailureId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Process` varchar(45) NOT NULL DEFAULT '',
  `Message` varchar(45) NOT NULL DEFAULT '',
  `AdditionalText` varchar(45) NOT NULL DEFAULT '',
  `servername` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`LogFailureId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;