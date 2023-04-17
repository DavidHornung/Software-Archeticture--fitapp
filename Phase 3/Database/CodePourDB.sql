-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: gads_db
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievement` (
  `idAchievement` int NOT NULL,
  `Achievement_Pokemon` varchar(45) NOT NULL,
  PRIMARY KEY (`idAchievement`),
  UNIQUE KEY `Achievement_Pokemon_UNIQUE` (`Achievement_Pokemon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `idRecipe` int NOT NULL AUTO_INCREMENT,
  `Recipe_titel` varchar(45) DEFAULT NULL,
  `Recipe_image` varchar(45) DEFAULT NULL,
  `Recipe_goal` varchar(45) DEFAULT NULL,
  `Recipe_ingredient` varchar(45) DEFAULT NULL,
  `Recipe_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRecipe`),
  UNIQUE KEY `Recipe_image_UNIQUE` (`Recipe_image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainingprogram`
--

DROP TABLE IF EXISTS `trainingprogram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainingprogram` (
  `IDTRAININGPROGRAM` int NOT NULL AUTO_INCREMENT,
  `GOAL` char(5) DEFAULT NULL,
  `HOURS` int DEFAULT NULL,
  `CARDIO` int DEFAULT NULL,
  `LEGS` varchar(3) DEFAULT NULL,
  `ARMS` int DEFAULT NULL,
  `ABS` int DEFAULT NULL,
  `TRAININGPROGRAMTITEL` longtext,
  `TRAININGPROGRAMGOAL` longtext,
  `TRAININGPROGRAMEXERCICESIMAGE` longtext,
  `TRAININGPROGRAMGIF1` longtext,
  `TRAININGPROGRAMGIF2` longtext,
  `TRAININGPROGRAMGIF3` longtext,
  `TRAININGPROGRAMGIF4` longtext,
  `TRAININGPROGRAMGIF5` longtext,
  PRIMARY KEY (`IDTRAININGPROGRAM`),
  UNIQUE KEY `idTrainingProgram_UNIQUE` (`IDTRAININGPROGRAM`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainingprogram`
--

LOCK TABLES `trainingprogram` WRITE;
/*!40000 ALTER TABLE `trainingprogram` DISABLE KEYS */;
INSERT INTO `trainingprogram` VALUES (1,'gain',10,0,'Yes',0,0,'https://fontmeme.com/permalink/221124/9ad5a9ffcbb91f2567caf96108b0810e.png','https://fontmeme.com/permalink/221125/2508019f6a46027af4c9d176d385664d.png','https://fontmeme.com/permalink/221125/f75f0fb0d51027f47d4b3e13b66e3919.png','https://i.kym-cdn.com/photos/images/newsfeed/001/135/060/dcd.gif','https://hips.hearstapps.com/hmg-prod/images/workouts/2017/10/legpress-1509458589.gif','https://i.pinimg.com/originals/6d/78/57/6d78572bfdda6c7378a394fa7db314e4.gif','https://thepadelmagazine.com/wp-content/uploads/2022/01/giphy-2022-01-21T223358.246.gif','https://i.kym-cdn.com/photos/images/original/002/190/432/5c6.gif');
/*!40000 ALTER TABLE `trainingprogram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `IDUSER` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) DEFAULT NULL,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `PASSWORD` int DEFAULT NULL,
  `AGE` int DEFAULT NULL,
  `GENDER` varchar(45) DEFAULT NULL,
  `HEIGHT` double DEFAULT NULL,
  `WEIGHT` double DEFAULT NULL,
  `USERPICTURES` longtext,
  `GOAL` varchar(45) DEFAULT NULL,
  `TARGETWEIGHT` double DEFAULT NULL,
  `NBHOURSPERSESSION` int DEFAULT NULL,
  `BMI` double DEFAULT NULL,
  `STRDATE` varchar(45) DEFAULT NULL,
  `INPUTCARDIO` varchar(3) DEFAULT NULL,
  `INPUTARMS` varchar(3) DEFAULT NULL,
  `INPUTABS` varchar(3) DEFAULT NULL,
  `INPUTLEGS` varchar(3) DEFAULT NULL,
  `ACHIEVEMENTPOKEMON` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDUSER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Adrian','Adrian','Muino','adrian@muino.com',1234,27,'M',2,83,'https://www.hominides.com/wp-content/uploads/2021/09/gorille-tete-face-600x660.jpg',NULL,100,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'David','David','Hornung','David.hornung@gmail.com',1234,27,'M',1.7,80,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Pepito','Pepito','Bla','hhhh@gmail.com',123,25,'F',1.7,80,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_achievement`
--

DROP TABLE IF EXISTS `user_has_achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_has_achievement` (
  `idUser` int NOT NULL,
  `Achievement_idAchievement` int NOT NULL,
  PRIMARY KEY (`idUser`,`Achievement_idAchievement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_achievement`
--

LOCK TABLES `user_has_achievement` WRITE;
/*!40000 ALTER TABLE `user_has_achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_recipe`
--

DROP TABLE IF EXISTS `user_has_recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_has_recipe` (
  `idUser` int NOT NULL,
  `Recipe_idRecipe` int NOT NULL,
  PRIMARY KEY (`idUser`,`Recipe_idRecipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_recipe`
--

LOCK TABLES `user_has_recipe` WRITE;
/*!40000 ALTER TABLE `user_has_recipe` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userhastraining`
--

DROP TABLE IF EXISTS `userhastraining`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userhastraining` (
  `IDUSER` int NOT NULL,
  `IDTRAININGPROGRAM` int NOT NULL,
  PRIMARY KEY (`IDUSER`,`IDTRAININGPROGRAM`),
  KEY `user_has_training_ibfk_2_idx` (`IDTRAININGPROGRAM`) /*!80000 INVISIBLE */,
  CONSTRAINT `userhastraining_ibfk_1` FOREIGN KEY (`IDUSER`) REFERENCES `user` (`IDUSER`),
  CONSTRAINT `userhastraining_ibfk_2` FOREIGN KEY (`IDTRAININGPROGRAM`) REFERENCES `trainingprogram` (`IDTRAININGPROGRAM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userhastraining`
--

LOCK TABLES `userhastraining` WRITE;
/*!40000 ALTER TABLE `userhastraining` DISABLE KEYS */;
/*!40000 ALTER TABLE `userhastraining` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05 18:14:36
