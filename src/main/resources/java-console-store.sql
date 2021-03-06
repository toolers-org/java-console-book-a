
/*
MySQL - 5.7.22
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`java_console_store` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `java_console_store`;

/*`admin`表结构 */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(16),
  `password` varchar(16),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*`book`表结构 */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32),
  `author` varchar(32),
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*
MySQL - 5.7.22
*/

CREATE DATABASE java-console-store` 

USE `java-console-store`;

/*`admin`表结构 */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(16) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*`book`表结构 */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `author` varchar(32) CHARACTER SET latin1 DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

