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

