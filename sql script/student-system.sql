CREATE DATABASE  IF NOT EXISTS `student_system`;

USE `student_system`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `student`
--

INSERT INTO `student` VALUES 
	(1,'Mohamed','Ali','mohamed@gmail.com'),
	(2,'Akram','Yousef','akram@gmail.com'),
	(3,'Ehab','yasser','ehab@gmail.com');
    
--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



--
-- Data for table `teacher`
--

INSERT INTO `teacher` VALUES 
	(1,'john','anton','john@gmail.com'),
	(2,'sarah','ahmed','sarah@gmail.com'),
	(3,'fady','khalil','avani@gmail.com');
    
--
--

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;

CREATE TABLE `quiz` (
  `id` int NOT NULL AUTO_INCREMENT,
  `topic` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `quiz` VALUES 
	(1,'math','first quiz in math'),
	(2,'english','first quiz in english'),
	(3,'arabic','third quiz in arabic');



--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `course`
--

INSERT INTO `course` VALUES 
	(1,'calculas','the content of calculas_1'),
	(2,'english','the content of english for grade 6'),
	(3,'arabic','the content of arabic for grade 7');
     

