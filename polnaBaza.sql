CREATE DATABASE  IF NOT EXISTS `wel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wel`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: wel
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `block`
--

DROP TABLE IF EXISTS `block`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `block` (
  `idBlock` int(11) NOT NULL AUTO_INCREMENT,
  `hash` varchar(255) DEFAULT NULL,
  `idDogodek` int(11) NOT NULL,
  `idOseba` int(11) NOT NULL,
  `prejsnjiHash` varchar(255) DEFAULT NULL,
  `stTock` int(11) NOT NULL,
  `timeStamp` bigint(20) NOT NULL,
  PRIMARY KEY (`idBlock`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block`
--

LOCK TABLES `block` WRITE;
/*!40000 ALTER TABLE `block` DISABLE KEYS */;
INSERT INTO `block` VALUES (1,'d54e729f6772d73c45b42b653df28d9157fc822716c527218a45c73b606aa8f1',4,1,' ',4,1528719675603),(2,'3334e87091ebc6f606d43d0dccc6778fff7c3e7a040ffbab0373d0aedb0541e7',5,1,'d54e729f6772d73c45b42b653df28d9157fc822716c527218a45c73b606aa8f1',10,1528726976885),(3,'fbb220f9b3deb8ce5340acf9d265ba9a14af0f54833b28fd1f1d8dbf644231d8',8,1,'3334e87091ebc6f606d43d0dccc6778fff7c3e7a040ffbab0373d0aedb0541e7',1,1528727010839),(4,'c7e62fae4469a41462282db2abf6670e6ad6741fd017e13cf17a46992ef9c254',9,2,'fbb220f9b3deb8ce5340acf9d265ba9a14af0f54833b28fd1f1d8dbf644231d8',5,1528963820489),(5,'9d23915c0b8b33500079cc562997c6f5dcbd4448b63d0d459e846935795edd6f',9,12,'c7e62fae4469a41462282db2abf6670e6ad6741fd017e13cf17a46992ef9c254',5,1528963821423),(6,'266c46e85c0c23c4a07a816be7719d6911ef6b9df9be9a5912a5e6a7d2bbfcdd',9,10,'9d23915c0b8b33500079cc562997c6f5dcbd4448b63d0d459e846935795edd6f',5,1528963822322),(7,'e0b0fbbc212b817faf80116c305f08c5b8e5dcd9b1db6027d010ff439464b4ad',9,4,'266c46e85c0c23c4a07a816be7719d6911ef6b9df9be9a5912a5e6a7d2bbfcdd',5,1528963823365),(8,'3a3dc95d845d73c529966e552f9fa1d55f60619235c38df8e5294880e15b7c7d',9,11,'e0b0fbbc212b817faf80116c305f08c5b8e5dcd9b1db6027d010ff439464b4ad',5,1528963824310),(9,'0885f5d945609eba59888debff3ebea10aca3d1f271b8f07ad05eb16cc9455fe',9,13,'3a3dc95d845d73c529966e552f9fa1d55f60619235c38df8e5294880e15b7c7d',5,1528963829778),(10,'9a768f046adf7f432081d1c8f3dcc1edd6fb21cf9fd5daf8cd21a849077a585a',9,5,'0885f5d945609eba59888debff3ebea10aca3d1f271b8f07ad05eb16cc9455fe',5,1528963832049),(11,'4893gh8w9e8hgw9e5hg89eh5hge9h5g9e5hghe5g85ehg',0,1,'sfe43',30,1515917878000),(12,'3535',0,1,'rgw5',15,1519373878000),(13,'3556',0,1,'45g4g4',27,1521793078000),(14,'35635tw5g',0,1,'4545',10,1524471478000),(15,'43r344f',0,1,'6he6h',35,1527063478000),(16,'885a0d7e0e64f76349dac54d01bb944133ab18bf939e743724a3ed0a387980e6',9,1,'9a768f046adf7f432081d1c8f3dcc1edd6fb21cf9fd5daf8cd21a849077a585a',5,1528964592992),(17,'e30fec704f95a69b1439b8340a7ff2bd8908469c740507038c763f667aa3ea70',12,5,'885a0d7e0e64f76349dac54d01bb944133ab18bf939e743724a3ed0a387980e6',1,1528965165473);
/*!40000 ALTER TABLE `block` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dogodek`
--

DROP TABLE IF EXISTS `dogodek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dogodek` (
  `idDogodek` int(11) NOT NULL AUTO_INCREMENT,
  `datumKonca` datetime DEFAULT NULL,
  `datumPrijave` datetime DEFAULT NULL,
  `datumZacetka` datetime DEFAULT NULL,
  `idLastnik` int(11) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `opisDogodka` varchar(10000) DEFAULT NULL,
  `tocke` int(11) NOT NULL,
  PRIMARY KEY (`idDogodek`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogodek`
--

LOCK TABLES `dogodek` WRITE;
/*!40000 ALTER TABLE `dogodek` DISABLE KEYS */;
INSERT INTO `dogodek` VALUES (8,'2018-06-15 16:43:00','2018-06-11 21:43:00','2018-06-15 14:43:00',1,'Piknik','<p><img src=\"https://fm.cnbc.com/applications/cnbc.com/resources/img/editorial/2017/05/12/104466932-PE_Color.240x240.jpg?v=1494613853\" alt=\"the donald\" width=\"400\" height=\"400\" /></p>',1),(9,'2018-06-23 14:27:00','2018-06-14 21:27:00','2018-06-23 09:27:00',1,'Plezanje','<p>V soboto bomo plezali, prinesite stvari za pleznaje in veliko dobre volje.</p>\r\n<p><img src=\"https://pmdvod.nationalgeographic.com/NG_Video/717/575/ibex-6_640x360_761611843920.jpg\" alt=\"goat\" width=\"640\" height=\"360\" /></p>',5),(10,'2018-07-01 11:33:00','2018-06-30 21:33:00','2018-07-01 09:33:00',1,'Nogomet','<p>Igrali bomo nogomet.</p>\r\n<p>Dobimo se na nogometnem igriscu.</p>\r\n<p><img src=\"http://i0.kym-cdn.com/photos/images/original/001/283/414/e62.jpg\" alt=\"dsf\" width=\"743\" height=\"549\" /></p>',4),(11,'2018-06-20 11:39:00','2018-06-18 21:39:00','2018-06-20 09:39:00',1,'Rokomet','<p>Rokometna tekma...</p>\r\n<p>Odvijala se bo v Ljudskem vrtu.</p>\r\n<p><img src=\"https://media.gettyimages.com/photos/anna-kovacs-of-hungary-in-action-during-the-ihf-womens-handball-world-picture-id886216172\" alt=\"\" width=\"1024\" height=\"682\" /></p>',6),(12,'2018-06-23 11:41:00','2018-06-22 21:41:00','2018-06-23 09:41:00',1,'Tekmovanje v risanju tabel','<p>Risali bomo tabele. Najlepsa tabel zmaga.</p>\r\n<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\r\n<tbody>\r\n<tr>\r\n<td style=\"width: 33.3333%;\">&nbsp;</td>\r\n<td style=\"width: 33.3333%;\">&nbsp;</td>\r\n<td style=\"width: 33.3333%;\">&nbsp;</td>\r\n</tr>\r\n<tr>\r\n<td style=\"width: 33.3333%;\">&nbsp;</td>\r\n<td style=\"width: 33.3333%;\">&nbsp;</td>\r\n<td style=\"width: 33.3333%;\">&nbsp;</td>\r\n</tr>\r\n</tbody>\r\n</table>',1);
/*!40000 ALTER TABLE `dogodek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dogodek_oseba`
--

DROP TABLE IF EXISTS `dogodek_oseba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dogodek_oseba` (
  `idDogodek` int(11) NOT NULL,
  `idOseba` int(11) NOT NULL,
  KEY `FKyw3nk5rm3m8nvybuu9d0j1jx` (`idOseba`),
  KEY `FKl7r2jxrfr8np25cmb59sgbdg` (`idDogodek`),
  CONSTRAINT `FKl7r2jxrfr8np25cmb59sgbdg` FOREIGN KEY (`idDogodek`) REFERENCES `dogodek` (`idDogodek`),
  CONSTRAINT `FKyw3nk5rm3m8nvybuu9d0j1jx` FOREIGN KEY (`idOseba`) REFERENCES `oseba` (`idOseba`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogodek_oseba`
--

LOCK TABLES `dogodek_oseba` WRITE;
/*!40000 ALTER TABLE `dogodek_oseba` DISABLE KEYS */;
INSERT INTO `dogodek_oseba` VALUES (8,1),(10,1),(12,1),(9,2),(9,6),(9,12),(9,10),(9,3),(11,1),(11,3),(11,4),(11,5),(11,6),(11,9),(12,10),(12,11),(12,4),(12,5),(9,1),(9,4),(9,5),(9,9),(9,11),(9,13);
/*!40000 ALTER TABLE `dogodek_oseba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nasvet`
--

DROP TABLE IF EXISTS `nasvet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nasvet` (
  `idNasvet` int(11) NOT NULL AUTO_INCREMENT,
  `naslov` varchar(255) DEFAULT NULL,
  `nasvet` varchar(10000) DEFAULT NULL,
  `timeStamp` bigint(20) NOT NULL,
  `fk_avtor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idNasvet`),
  KEY `FK2fva42csuyppw1skkssk3dya5` (`fk_avtor`),
  CONSTRAINT `FK2fva42csuyppw1skkssk3dya5` FOREIGN KEY (`fk_avtor`) REFERENCES `oseba` (`idOseba`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nasvet`
--

LOCK TABLES `nasvet` WRITE;
/*!40000 ALTER TABLE `nasvet` DISABLE KEYS */;
INSERT INTO `nasvet` VALUES (1,'Pravilno sedenje','<p><img src=\"http://www.ergonomics.com.au/wp-content/uploads/2014/06/2014-05-22_14-40-48.jpg\" alt=\"stol\" width=\"1000\" height=\"434\" /></p>\r\n<p>We see too many workplace injuries that could be avoided. And prevention is better than cure. Here is a four-step checklist that you can carry out at your workstation, to make sure you&rsquo;re comfortable, safe and productive at the office.&nbsp;<strong>STEP 1: Your Chair</strong></p>\r\n<ul>\r\n<li><span class=\"title03\">Push your hips as far back as they can go in the chair.</span></li>\r\n<li><span class=\"title03\">Adjust the seat height&nbsp;</span>so your feet are flat on the floor and your knees equal to, or slightly lower than, your hips.</li>\r\n<li><span class=\"title03\">Adjust the back of the chair to a 100&deg;-110&deg; reclined angle.</span>&nbsp;Make sure your upper and lower back are supported. Use inflatable cushions or small pillows if necessary. If you have an active back mechanism on your chair, use it to make frequent position changes.</li>\r\n<li><span class=\"title03\">Adjust the armrests (if fitted) so that your shoulders are relaxed.</span>&nbsp;If your armrests are in the way, remove them.</li>\r\n</ul>\r\n<p><strong>STEP 2: Your Keyboard</strong>&nbsp;An articulating keyboard tray can provide optimal positioning of input devices. However, it should accommodate the mouse, enable leg clearance, and have an adjustable height and tilt mechanism. The tray should not push you too far away from other work materials, such as your telephone.</p>\r\n<ul>\r\n<li><span class=\"title03\">Pull up close to your keyboard.</span></li>\r\n<li><span class=\"title03\">Position the keyboard directly in front of your body.</span></li>\r\n<li><span class=\"title03\">Determine what section of the keyboard you use most frequently</span>, and readjust the keyboard so that section is centred with your body.</li>\r\n<li><span class=\"title03\">Adjust the keyboard height</span>&nbsp;so that your shoulders are relaxed, your elbows are in a slightly open position (100&deg; to 110&deg;), and your wrists and hands are straight.</li>\r\n<li><span class=\"title03\">The tilt of your keyboard is dependent upon your sitting position.</span>&nbsp;Use the keyboard tray mechanism, or keyboard feet, to adjust the tilt. If you sit in a forward or upright position, try tilting your keyboard away from you at a negative angle. If you are reclined, a slight positive tilt will help maintain a straight wrist position.</li>\r\n<li><span class=\"title03\">Wristrests can help to maintain neutral postures and pad hard surfaces.</span>&nbsp;However, the wristrest should only be used to rest the palms of the hands between keystrokes. Resting on the wristrest while typing is not recommended. Avoid using excessively wide wristrests, or wristrests that are higher than the space bar of your keyboard.</li>\r\n<li><span class=\"title03\">Place the pointer as close as possible to the keyboard.</span>&nbsp;Placing it on a slightly inclined surface, or using it on a mousebridge placed over the 10-keypad, can help to bring it closer.</li>\r\n</ul>\r\n<p>If you do not have a fully adjustable keyboard tray, you may need to adjust your workstation height, the height of your chair, or use a seat cushion to get into a comfortable position. Remember to use a footrest if your feet dangle.&nbsp;<strong>STEP 3: Screen, Document, and Telephone</strong>&nbsp;Incorrect positioning of the screen and source documents can result in awkward postures. Adjust the screen and source documents so that your neck is in a neutral, relaxed position.</p>\r\n<ul>\r\n<li><span class=\"title03\">Centre the screen directly in front of you</span>, above your keyboard.</li>\r\n<li><span class=\"title03\">Position the top of the screen approximately 2-3&rdquo; above seated eye level.</span>&nbsp;(If you wear bifocals, lower the screen to a comfortable reading level.)</li>\r\n<li><span class=\"title03\">Sit at least an arm&rsquo;s length away from the screen</span>and then adjust the distance for your vision.</li>\r\n<li><span class=\"title03\">Reduce glare by careful positioning of the screen.</span><span class=\"title03\">Position source documents directly in front of you, between the screen and the keyboard, using an in-line copy stand.</span>&nbsp;If there is insufficient space, place source documents on a document holder positioned adjacent to the screen.\r\n<ul>\r\n<li>Place screen at right angles to windows</li>\r\n</ul>\r\n<ul>\r\n<li>Adjust curtains or blinds as needed</li>\r\n<li>Adjust the vertical screen angle and screen controls to minimize glare from overhead lights</li>\r\n<li>Other techniques to reduce glare include use of optical glass glare filters, light filters, or secondary task lights</li>\r\n</ul>\r\n</li>\r\n<li><span class=\"title03\">Place your telephone within easy reach.</span>&nbsp;Telephone stands or arms can help.</li>\r\n<li><span class=\"title03\">Use headsets and speaker phone</span>&nbsp;to eliminate cradling the handset.</li>\r\n</ul>\r\n<p><strong>STEP 4: Pauses and Breaks</strong>&nbsp;Once you have correctly set up your computer workstation use good work habits. No matter how perfect the environment, prolonged, static postures will inhibit blood circulation and take a toll on your body.</p>\r\n<ul>\r\n<li><span class=\"title03\">Take short 1-2 minute stretch breaks every 20-30 minutes.</span>&nbsp;After each hour of work, take a break or change tasks for at least 5-10 minutes. Always try to get away from your computer during lunch breaks.</li>\r\n<li><span class=\"title03\">Avoid eye fatigue by resting and refocusing your eyes periodically.</span>&nbsp;Look away from the monitor and focus on something in the distance.</li>\r\n<li><span class=\"title03\">Rest your eyes by covering them</span>&nbsp;with your palms for 10-15 seconds.</li>\r\n<li><span class=\"title03\">Use correct posture</span>&nbsp;when working. Keep moving as much as possible.*Information supplied by UCLA Ergonomics</li>\r\n</ul>\r\n<p>*Information supplied by UCLA Ergonomics</p>',1528720570716,1),(2,'Pica','<p><strong>Pizza</strong>&nbsp;is a traditional&nbsp;<a title=\"Italian cuisine\" href=\"https://en.wikipedia.org/wiki/Italian_cuisine\">Italian</a>&nbsp;<a title=\"Dish (food)\" href=\"https://en.wikipedia.org/wiki/Dish_(food)\">dish</a>&nbsp;consisting of a yeasted&nbsp;<a title=\"Flatbread\" href=\"https://en.wikipedia.org/wiki/Flatbread\">flatbread</a>&nbsp;typically topped with&nbsp;<a title=\"Tomato sauce\" href=\"https://en.wikipedia.org/wiki/Tomato_sauce\">tomato sauce</a>&nbsp;and&nbsp;<a title=\"Cheese\" href=\"https://en.wikipedia.org/wiki/Cheese\">cheese</a>&nbsp;and baked in an oven. It can also be topped with additional vegetables, meats, and&nbsp;<a class=\"mw-redirect\" title=\"Condiments\" href=\"https://en.wikipedia.org/wiki/Condiments\">condiments</a>, and can be made without cheese.</p>\r\n<p>The term&nbsp;<em>pizza</em>&nbsp;was first recorded in the 10th century, in a Latin manuscript from the&nbsp;<a title=\"Southern Italy\" href=\"https://en.wikipedia.org/wiki/Southern_Italy\">Southern Italian</a>&nbsp;town of&nbsp;<a title=\"Gaeta\" href=\"https://en.wikipedia.org/wiki/Gaeta\">Gaeta</a>&nbsp;in&nbsp;<a title=\"Lazio\" href=\"https://en.wikipedia.org/wiki/Lazio\">Lazio</a>, on the border with&nbsp;<a title=\"Campania\" href=\"https://en.wikipedia.org/wiki/Campania\">Campania</a>.<sup id=\"cite_ref-MartinMaiden_1-0\" class=\"reference\"><a href=\"https://en.wikipedia.org/wiki/Pizza#cite_note-MartinMaiden-1\">[1]</a></sup>&nbsp;Modern pizza was invented in&nbsp;<a title=\"Naples\" href=\"https://en.wikipedia.org/wiki/Naples\">Naples</a>, and the dish and its variants have since become popular and common in many areas of the world.<sup id=\"cite_ref-Miller_2-0\" class=\"reference\"><a href=\"https://en.wikipedia.org/wiki/Pizza#cite_note-Miller-2\">[2]</a></sup>&nbsp;In 2009, upon&nbsp;<a title=\"Italy\" href=\"https://en.wikipedia.org/wiki/Italy\">Italy</a>\'s request,&nbsp;<a title=\"Neapolitan pizza\" href=\"https://en.wikipedia.org/wiki/Neapolitan_pizza\">Neapolitan pizza</a>&nbsp;was registered with the&nbsp;<a title=\"European Union\" href=\"https://en.wikipedia.org/wiki/European_Union\">European Union</a>&nbsp;as a&nbsp;<a class=\"mw-redirect\" title=\"Traditional Speciality Guaranteed\" href=\"https://en.wikipedia.org/wiki/Traditional_Speciality_Guaranteed\">Traditional Speciality Guaranteed</a>&nbsp;dish.<sup id=\"cite_ref-3\" class=\"reference\"><a href=\"https://en.wikipedia.org/wiki/Pizza#cite_note-3\">[3]</a></sup><sup id=\"cite_ref-4\" class=\"reference\"><a href=\"https://en.wikipedia.org/wiki/Pizza#cite_note-4\">[4]</a></sup>&nbsp;The&nbsp;<em>Associazione Verace Pizza Napoletana</em>&nbsp;(True Neapolitan Pizza Association), a non-profit organization founded in 1984 with headquarters in Naples, aims to \"promote and protect... the true Neapolitan pizza\".<sup id=\"cite_ref-AVPN_5-0\" class=\"reference\"><a href=\"https://en.wikipedia.org/wiki/Pizza#cite_note-AVPN-5\">[5]</a></sup></p>\r\n<p>Pizza is one of the most popular foods in the world and a common&nbsp;<a title=\"Fast food\" href=\"https://en.wikipedia.org/wiki/Fast_food\">fast food</a>&nbsp;item in Europe and North America. Many independent or chain restaurants, cafes, and fast food outlets offer pizza. Restaurants or chains specializing in pizza are&nbsp;<a class=\"mw-redirect\" title=\"Pizzeria\" href=\"https://en.wikipedia.org/wiki/Pizzeria\">pizzerias</a>.&nbsp;<a title=\"Pizza delivery\" href=\"https://en.wikipedia.org/wiki/Pizza_delivery\">Pizza delivery</a>&nbsp;is common in some parts of the world.</p>\r\n<p>Pizza is sold fresh or frozen, either whole or in portions.<sup id=\"cite_ref-Baofu_2013_6-0\" class=\"reference\"><a href=\"https://en.wikipedia.org/wiki/Pizza#cite_note-Baofu_2013-6\">[6]</a></sup>&nbsp;Various types of ovens are used to cook them and many varieties exist. Several similar dishes are prepared from ingredients commonly used in pizza preparation, such as&nbsp;<a title=\"Calzone\" href=\"https://en.wikipedia.org/wiki/Calzone\">calzone</a>&nbsp;and&nbsp;<a title=\"Stromboli (food)\" href=\"https://en.wikipedia.org/wiki/Stromboli_(food)\">stromboli</a>. In the United States, pizza is usually&nbsp;<a title=\"Finger food\" href=\"https://en.wikipedia.org/wiki/Finger_food\">eaten out of hand</a>&nbsp;after dividing into slices from a large pizza or small&nbsp;<a title=\"Pizzetta\" href=\"https://en.wikipedia.org/wiki/Pizzetta\">pizzetta</a>&nbsp;as a whole. In Italy, pizza is eaten with a fork and knife in restaurants, but is also sold to take away and eaten out of hand.&nbsp;<a title=\"Frozen food\" href=\"https://en.wikipedia.org/wiki/Frozen_food\">Frozen</a>&nbsp;pizza became popular in the late 20th century.</p>',1528960204998,1),(3,'Your Dress Code Provides a Guide for Employees','<p><img src=\"https://tyroneeagleeyenews.com/wp-content/uploads/2018/04/dresscode2-900x658.jpg\" alt=\"d\" width=\"900\" height=\"658\" /></p>\r\n<p>A dress code is a set of standards that companies develop to help provide their employees with guidance about what is appropriate to wear to work.&nbsp;<a href=\"https://www.thebalancecareers.com/work-dress-codes-and-image-collection-1919406\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"1\">Dress codes range from formal to business casual</a>&nbsp;to casual.</p>\r\n<p>The&nbsp;<a href=\"https://www.thebalancecareers.com/a-formal-professional-dress-code-1919381\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"2\">formality of the workplace dress code</a>&nbsp;is normally determined by the number and type of interactions employees have with customers or clients in the workplace. In workplaces that are frequented by clients who expect their counselors to exhibit ​<a href=\"https://www.thebalancecareers.com/what-is-integrity-really-1917676\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"3\">professionalism and integrity</a>, the&nbsp;<a href=\"https://www.thebalancecareers.com/formal-dress-code-attire-4051115\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"4\">dress is often formal</a>.</p>\r\n<div id=\"billboard1-sticky_1-0\" class=\"comp billboard1-sticky billboard-sticky is-lockable\" data-height=\"1050\">&nbsp;</div>\r\n<p class=\"html-slice\">This includes law offices, financial consulting firms, banks, and some large businesses.</p>\r\n<p>However, even these organizations are relaxing their dress codes. For example, banking giant J.P. Morgan Chase &amp; Co. now allows its employees to&nbsp;<a href=\"https://www.thebalancecareers.com/business-casual-dress-code-4051117\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"5\">wear business casual attire</a>&nbsp;most of the time. In a visit to a law firm, it was noted that employees were dressed in business casual but most had jackets hanging on their office doors.</p>\r\n<p>Tech firms and start-ups generally favor casual dress, essentially what employees would wear to watch a sporting event or grocery shop on the weekend. But, with 60 percent of Millenial employees and employees in general, favoring more casual dressing, employers who want to remain competitive in recruiting, are offering casual dress as a perk.</p>\r\n<p>In workplaces where some employees interact with customers or clients and others do not, an organization may choose to have two dress codes.</p>\r\n<div id=\"native-placeholder_1-0\" class=\"comp native-placeholder mntl-block\">&nbsp;</div>\r\n<p class=\"html-slice\">A&nbsp;<a href=\"https://www.thebalancecareers.com/a-relaxed-casual-dress-code-1919378\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"6\">more casual dress code</a>&nbsp;is normally adopted for employees with no customer or client contact. This is the dress code that the majority of employees want. Competitive employers allow this dressing for work.</p>\r\n<p>Depending on the organization, the dress code may be written in great detail, or in the case of a casual dress code,&nbsp;<a href=\"https://www.thebalancecareers.com/simple-sample-dress-codes-for-business-attire-1917931\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"7\">very little detail is necessary</a>.</p>\r\n<div id=\"billboard2-sticky_1-0\" class=\"comp billboard2-sticky billboard-sticky is-lockable\" data-height=\"600\" data-parent=\"\">&nbsp;</div>\r\n<p class=\"html-slice\">Over the years, employees have seen a shift towards a more casual dress standard, even in industries that were previously very formal. Startups, in particular, tend towards a more casual dress code.</p>\r\n<h3>Why Dress Codes Are Important</h3>\r\n<p>In some professions, dress codes are so strict that you call them uniforms. You want everyone to know who the police officer is, for instance. If your company sends out plumbers or cable television installers, your employees are showing up in strangers\' homes to do work.&nbsp;</p>\r\n<p>A uniform identifies them as the person hired and not some random guy off the street who wants to look at your toilet. (Okay, not likely to happen, but still.)</p>\r\n<p>In other jobs, dress codes are important because you are representing the company.</p>\r\n<p>Employees that work at clothing stores are often required to wear clothes the store sells. Target requires khaki pants and red shirts so that their employees are easy to spot.</p>\r\n<p>Fast food restaurants require a strict uniform so that it doesn\'t look like customers have wandered behind the counter.</p>\r\n<p>For office jobs, the person who sits at the front desk might have a stricter dress code than the Chief Information Officer (CIO).</p>\r\n<p>Why? Because everyone who walks in off the street sees the receptionist, but you\'ll only see the CIO if you have an appointment.</p>\r\n<div id=\"billboard3-sticky_1-0\" class=\"comp billboard3-sticky billboard-sticky is-lockable\" data-height=\"600\" data-parent=\"\">&nbsp;</div>\r\n<p>Many client based industries, like law firms and corporate accounting, have formal dress codes. No one wants to meet with a lawyer wearing a tank top and Daisy Duke shorts. A suit is the chosen outfit, for both male and female employees.</p>\r\n<p>What you wear to work tells people a lot about you. Have you ever heard the advice, &ldquo;don\'t dress for the job you have; dress for the job you want&rdquo;? It\'s good advice because&nbsp;<a href=\"https://www.thebalancecareers.com/communication-and-professional-image-in-networking-1916641\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"8\">how people perceive you influences what they think</a>&nbsp;of your work performance.</p>\r\n<h3>What about Casual Dress?</h3>\r\n<p>If you can trust television to be accurate, you can see the evolution of dress codes. Now? It\'s a much more casual world, and some famous heads of big companies dress very casually&mdash;Mark Zuckerberg, CEO of Facebook, for instance, who seems to live in a hoodie.</p>\r\n<p>Even companies that used to require strict, formal dress have largely softened.</p>\r\n<p class=\"html-slice\">You\'re more likely to encounter someone in cotton pants and a casual shirt when you visit a Fortune 100 company than someone in a suit. This is generally&nbsp;<a href=\"https://www.thebalancecareers.com/business-casual-dress-code-1919379\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"9\">known as business casual</a>&nbsp;and can vary greatly from organization to organization.</p>\r\n<p>Some companies allow jeans in a business casual office, others require pressed pants. Some business casual offices allow flip-flops while some require closed toe shoes. (Of course, some closed toe shoe requirements are for safety reasons instead of just dress codes.)</p>\r\n<p>Even if your company has no dress code, you still need an internal one. Sloppy is never appropriate&mdash;even if your job is feeding pigs. Don\'t push limits. If your dress code allows sleeveless shirts, don\'t push it to spaghetti straps.</p>\r\n<p>A good guide is&nbsp;<a href=\"https://www.thebalancecareers.com/leaders-set-expectations-examples-1918620\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"10\">to look at a senior person</a>&nbsp;of your gender and use that person as a guide. If the VP wouldn\'t wear a mini skirt, you probably shouldn\'t either.</p>\r\n<h3>Legal Requirements for a Dress Code</h3>\r\n<p>Companies can generally decide how they want their employees to look, with some very important exceptions. First, the&nbsp;<a href=\"https://www.thebalancecareers.com/prevent-employment-discrimination-and-lawsuits-1917923\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"11\">dress code can\'t discriminate</a>. Men and women need to have similar standards.</p>\r\n<p>Second, it has to&nbsp;<a href=\"https://www.thebalancecareers.com/what-is-religious-discrimination-and-accommodation-1917920\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"12\">allow for religious accommodations</a>&nbsp;if they are reasonable. Employers need to accommodate an employee whose religion requires him to keep his head covered or to wear a religious necklace&nbsp;unless there are extreme circumstances.</p>\r\n<p>If you\'re writing your company\'s dress code, it\'s ideal to&nbsp;<a href=\"https://www.thebalancecareers.com/employment-law-advice-best-websites-2071543\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"13\">double check with your employment attorney before</a>&nbsp;implementing it as policy.</p>\r\n<h3>Additional Resource About Dress Codes</h3>\r\n<ul>\r\n<li><a href=\"https://www.thebalancecareers.com/manufacturing-setting-dress-code-1919380\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"14\">Business Casual Dress Code for Work: Manufacturing</a></li>\r\n</ul>\r\n<p><strong>Disclaimer:</strong>&nbsp;Please note that the information provided, while authoritative, is not guaranteed for accuracy and legality. The site is read by a world-wide audience and&nbsp;<a href=\"https://www.thebalancecareers.com/changing-employment-laws-1917681\" data-component=\"link\" data-source=\"inlineLink\" data-type=\"internalLink\" data-ordinal=\"16\">employment laws</a>&nbsp;and regulations vary from state to state and country to country. Please seek legal assistance, or assistance from State, Federal, or International governmental resources, to make certain your legal interpretation and decisions are correct for your location. This information is for guidance, ideas, and assistance.</p>',1528965035766,1);
/*!40000 ALTER TABLE `nasvet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obvestilo`
--

DROP TABLE IF EXISTS `obvestilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obvestilo` (
  `idObvestila` int(11) NOT NULL AUTO_INCREMENT,
  `idDogodka` int(11) NOT NULL,
  `idOsebe` int(11) NOT NULL,
  `timeStamp` bigint(20) NOT NULL,
  PRIMARY KEY (`idObvestila`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obvestilo`
--

LOCK TABLES `obvestilo` WRITE;
/*!40000 ALTER TABLE `obvestilo` DISABLE KEYS */;
INSERT INTO `obvestilo` VALUES (1,4,1,1528274246350),(2,4,1,1528274248366),(3,4,1,1528275397551),(4,4,1,1528275398009),(5,4,1,1528275399861),(6,4,1,1528275676758),(7,4,1,1528275676843),(8,4,1,1528275676877),(9,4,1,1528275676912),(10,4,1,1528275676953),(11,4,1,1528275677037),(12,4,1,1528275698012),(13,4,1,1528275698233),(14,4,1,1528275698290),(15,4,1,1528275698331),(16,4,1,1528275698375),(17,4,1,1528275699882),(18,4,1,1528275723917),(19,4,1,1528275731718),(20,4,1,1528275731862),(21,4,1,1528275737120),(22,4,1,1528275775224),(23,4,1,1528275777107),(24,4,1,1528275859535),(25,4,1,1528275861714),(26,4,1,1528275945848),(27,4,1,1528275948093),(28,4,1,1528275958135),(29,4,1,1528276032185),(30,4,1,1528276034499),(31,4,1,1528276044490),(32,4,1,1528276056208),(33,4,1,1528276118577),(34,4,1,1528276120912),(35,4,1,1528276130867),(36,4,1,1528276142525),(37,4,1,1528276267431),(38,4,1,1528276351414),(39,4,1,1528276437789),(40,4,1,1528276524198),(41,4,1,1528276600036),(42,4,1,1528276610027),(43,4,1,1528276620151),(44,4,1,1528276630086),(45,4,1,1528276640038),(46,4,1,1528276670390),(47,4,1,1528276680029),(48,4,1,1528276690073),(49,4,1,1528276700036),(50,4,1,1528276710034),(51,4,1,1528276720028),(52,4,1,1528276730036),(53,4,1,1528276740027),(54,4,1,1528276780045),(55,4,1,1528276800030),(56,4,1,1528276840037),(57,4,1,1528276860032),(58,4,1,1528276900021),(59,4,1,1528276920034),(60,4,1,1528276960039);
/*!40000 ALTER TABLE `obvestilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oseba`
--

DROP TABLE IF EXISTS `oseba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oseba` (
  `idOseba` int(11) NOT NULL AUTO_INCREMENT,
  `EMSO` varchar(255) DEFAULT NULL,
  `datumRojstva` datetime DEFAULT NULL,
  `datumZaposlitve` datetime DEFAULT NULL,
  `davcnaStevilka` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `geslo` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `oddelek` varchar(255) DEFAULT NULL,
  `priimek` varchar(255) DEFAULT NULL,
  `spol` varchar(255) DEFAULT NULL,
  `telefonskaStevilka` varchar(255) DEFAULT NULL,
  `tocke` int(11) NOT NULL,
  `uporabniskoIme` varchar(255) DEFAULT NULL,
  `vloga` varchar(255) DEFAULT NULL,
  `drzava` varchar(255) DEFAULT NULL,
  `hisnaStevilka` varchar(255) DEFAULT NULL,
  `posta` varchar(255) DEFAULT NULL,
  `postnaStevilka` int(11) NOT NULL,
  `ulica` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idOseba`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oseba`
--

LOCK TABLES `oseba` WRITE;
/*!40000 ALTER TABLE `oseba` DISABLE KEYS */;
INSERT INTO `oseba` VALUES (1,'34585734','1997-08-01 01:00:00','2018-05-30 02:00:00','SI758492934','actualgregor@gmail.com','f','Gregor','Vodstvo','Gorjanc','M','65756756',55,'f','admin','Slovenija','123','Maribor',2000,'Lepa ulica'),(2,'34563456','1996-02-02 01:00:00','2018-05-30 02:00:00','SI453453434','manica.a6@gmail.com','f','Manica','Vodstvo','Abramenko','Z','567756555',13,'manica','zaposleni','Slovenija','5','Maribor',2000,'Brsternica'),(3,'45645634','1996-02-02 01:00:00','2018-05-30 02:00:00','SI546538686','m.@g.c','f','Matic','Finance','Novak','M','0904304646',4,'matic','organizator','Slovenija','34','Kranj',4000,'Grda ulica'),(4,'34573547','1996-02-02 01:00:00','2018-05-30 02:00:00','SI546538686','m.@g.c','f','Jakob','Informatiki','Ilc','M','0904304646',5,'jakob','kadrovska','Slovenija','65','Kranj',4566,'Zelena ulica'),(5,'45745747','1996-02-02 01:00:00','2018-05-30 02:00:00','SI546538686','m.@g.c','f','Tadeja','Razvojni oddelek','Mesner','Z','0904304646',6,'ilc','kadrovska','Slovenija','76','Cerkvenjak',7654,'Rumena ulica'),(6,'34745753','1991-06-05 02:00:00','2018-06-05 02:00:00','SI546538686','m.@g.c','f','Izidor','Organizatorji dogodkov','Horvat','M','1235357655',0,'izidor','zaposleni','Slovenija','75','Celje',3456,'Oranžna ulica'),(9,'45734575','1111-06-05 02:00:00','2018-06-05 02:00:00','SI546538686','m.@g.cf','f','Ana','Kadrovska služba','Portir','Z','6756735673',0,'lololo','zaposleni','Slovenija','34','Kranj',5467,'Siva ulica'),(10,'43573457','1968-06-06 02:00:00','2018-06-06 02:00:00','SI546538686','m.@g.cf','f','Eva','Informatiki','Brumec','M','8666666666',5,'upo 4','zaposleni','Slovenija','77','Maribor',2563,'Modra ulica'),(11,'34574354','1970-06-07 02:00:00','2018-06-07 02:00:00','SI546538686','a.a@a.com','f','Ceciilija','Organizatorji dogodkov','Cerar','Z','4546456463',5,'kekec','zaposleni','Slovenija','34f','Ljubljana',1000,'Rjava ulica'),(12,'3464564564','1978-06-14 02:00:00','2018-06-14 02:00:00','43434667','a.a@a.com','f','Špela','Finance','Ščavnica','Z','34363622',5,'spela','zaposleni','Slovenija','88','Celje',3456,'Prešernova ulica'),(13,'3464564564','1987-06-14 02:00:00','2018-06-14 02:00:00','43434667','a.a@a.com','f','Maja','Finance','Čebela','Z','34363622',5,'maja','zaposleni','Slovenija','18','Ljubljana',1233,'Gerbera');
/*!40000 ALTER TABLE `oseba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tekmovanje`
--

DROP TABLE IF EXISTS `tekmovanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tekmovanje` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leto` int(11) NOT NULL,
  `mesec` int(11) NOT NULL,
  `nagrada` varchar(255) DEFAULT NULL,
  `fk_lastnik` int(11) DEFAULT NULL,
  `potrebneTocke` int(11) NOT NULL,
  `tip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3bytvhdyiqyrnnecqmw6ilqeo` (`fk_lastnik`),
  CONSTRAINT `FK3bytvhdyiqyrnnecqmw6ilqeo` FOREIGN KEY (`fk_lastnik`) REFERENCES `oseba` (`idOseba`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tekmovanje`
--

LOCK TABLES `tekmovanje` WRITE;
/*!40000 ALTER TABLE `tekmovanje` DISABLE KEYS */;
INSERT INTO `tekmovanje` VALUES (2,2018,6,'Likalnik',1,1,'limit'),(3,2018,6,'Paket keksov',1,3,'limit'),(4,2018,6,'Severina CD',1,50,'limit'),(5,2018,6,'Kuhalnik',1,15,'limit'),(6,2018,6,'Plinski kuhalnik',1,0,'top'),(7,2018,6,'Toaster',1,26,'limit');
/*!40000 ALTER TABLE `tekmovanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tekmovanje_oseba`
--

DROP TABLE IF EXISTS `tekmovanje_oseba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tekmovanje_oseba` (
  `id` int(11) NOT NULL,
  `idOseba` int(11) NOT NULL,
  PRIMARY KEY (`id`,`idOseba`),
  KEY `FKs3yuykvbhay11tm8t6pbax93l` (`idOseba`),
  CONSTRAINT `FKb8rvtig4u5yax4gayvh810she` FOREIGN KEY (`id`) REFERENCES `tekmovanje` (`id`),
  CONSTRAINT `FKs3yuykvbhay11tm8t6pbax93l` FOREIGN KEY (`idOseba`) REFERENCES `oseba` (`idOseba`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tekmovanje_oseba`
--

LOCK TABLES `tekmovanje_oseba` WRITE;
/*!40000 ALTER TABLE `tekmovanje_oseba` DISABLE KEYS */;
INSERT INTO `tekmovanje_oseba` VALUES (3,1),(5,1),(6,1),(3,2),(3,4),(3,5),(3,10),(3,11),(3,12),(3,13);
/*!40000 ALTER TABLE `tekmovanje_oseba` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-14 10:36:19
