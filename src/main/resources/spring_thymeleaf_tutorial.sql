-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 27, 2012 at 06:50 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `spring_thymeleaf_tutorial`
--

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3580769128426C` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`, `user_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 5),
(6, 1, 6),
(7, 2, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 2, 13);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstName`, `lastName`, `password`, `username`) VALUES
(1, 'John', 'Smith', '21232f297a57a5a743894a0e4a801fc3', 'john'),
(2, 'Jane', 'Adams', 'ee11cbb19052e40b07aac0ca060c23ee', 'jane'),
(3, 'Michael', 'Watson', 'xdhhjkd', 'mike'),
(4, 'Alice', 'Smith', 'zvksdfm', 'alice'),
(5, 'Nancy', 'Kerr', 'xmnogpd', 'nancy'),
(6, 'Jeff', 'Sprouse', 'mvbnko', 'jeff'),
(7, 'Betty', 'Star', 'mnhtiep', 'betty'),
(8, 'John', 'Tracy', 'trrtyur', 'johnny'),
(9, 'Selena', 'Garcia', 'iriopow', 'selena'),
(10, 'Jennifer', 'Vogtle', 'zxvbcvb', 'jenny'),
(11, 'Steve', 'Martin', 'z34ghgd', 'steve'),
(12, 'Gail', 'Hansen', 'xjmcmik', 'gail'),
(13, 'Edward', 'Zeigler', 'mncmksk', 'edward');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `FK3580769128426C` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
