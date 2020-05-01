-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 23, 2014 at 01:25 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vctuser`
--
CREATE DATABASE IF NOT EXISTS `vctuser` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vctuser`;

-- --------------------------------------------------------

--
-- Table structure for table `activetask_tbl`
--

CREATE TABLE IF NOT EXISTS `activetask_tbl` (
  `session` varchar(50) NOT NULL,
  `glbtime` bigint(30) NOT NULL,
  `task` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `agenda_tbl`
--

CREATE TABLE IF NOT EXISTS `agenda_tbl` (
  `session_name` varchar(100) NOT NULL,
  `topic` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agenda_tbl`
--

INSERT INTO `agenda_tbl` (`session_name`, `topic`, `user_id`) VALUES
('Java', 'AWT', 'sagar'),
('Java', 'Swing', 'sagar');

-- --------------------------------------------------------

--
-- Table structure for table `agenda_topic`
--

CREATE TABLE IF NOT EXISTS `agenda_topic` (
  `topic` varchar(100) NOT NULL,
  `subtopic` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agenda_topic`
--

INSERT INTO `agenda_topic` (`topic`, `subtopic`) VALUES
('AWT', 'Basic'),
('Swing', 'Look & Feel'),
('Swing', 'Difference');

-- --------------------------------------------------------

--
-- Table structure for table `chatcon_tbl`
--

CREATE TABLE IF NOT EXISTS `chatcon_tbl` (
  `session` varchar(50) NOT NULL,
  `sender` varchar(100) NOT NULL,
  `receiver` varchar(100) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `download_tbl`
--

CREATE TABLE IF NOT EXISTS `download_tbl` (
  `session` varchar(50) NOT NULL,
  `subtopic` varchar(100) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `filex` blob NOT NULL,
  `creator` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `handsup_tbl`
--

CREATE TABLE IF NOT EXISTS `handsup_tbl` (
  `session` varchar(50) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `hostip` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `loggedin_tbl`
--

CREATE TABLE IF NOT EXISTS `loggedin_tbl` (
  `user_id` varchar(100) NOT NULL,
  `iplogin` varchar(150) NOT NULL,
  `Attend_Time` varchar(150) NOT NULL,
  `sessname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mcqpoll_tbl`
--

CREATE TABLE IF NOT EXISTS `mcqpoll_tbl` (
  `session` varchar(50) NOT NULL,
  `pollno` varchar(100) NOT NULL,
  `polltype` varchar(100) NOT NULL,
  `ques` varchar(600) NOT NULL,
  `optA` varchar(100) NOT NULL,
  `optB` varchar(100) NOT NULL,
  `optC` varchar(100) DEFAULT NULL,
  `optD` varchar(100) DEFAULT NULL,
  `correct` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mcqpoll_tbl`
--

INSERT INTO `mcqpoll_tbl` (`session`, `pollno`, `polltype`, `ques`, `optA`, `optB`, `optC`, `optD`, `correct`) VALUES
('Java', '1', 'mcq', 'What is swing?', 'abcd', 'efgh', 'ikjl', 'lmno', 'OptC'),
('Java', '2', 'yno', 'continue?', 'True', 'False', NULL, NULL, 'OptA');

-- --------------------------------------------------------

--
-- Table structure for table `partc_info`
--

CREATE TABLE IF NOT EXISTS `partc_info` (
  `user_id` varchar(100) NOT NULL DEFAULT '',
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `pic` blob,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `partc_info`
--

INSERT INTO `partc_info` (`user_id`, `first_name`, `last_name`, `age`, `phone`, `pic`) VALUES
('dinesh', 'Dinesh', 'Rajpal', '17', '8080550850', 0xffd8ffe000104a46494600010200000100010000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc00011080055002503012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f0a860559364e5a3e7182315a169a64da83148559d17bed38afaeaefc31e18d4829bbd32d59b3d76006b52c348d2ac2158acacada14ec15003fcaab4b8934cf98fc3fe16ba98a9b7d1e6738c190822bd9bc15e17b98024b756e91f9792327e63c77200af45dab8dbc63d38c536491635381daabda6866e377a91848edf8214337276ae05158f7974c651cd14ae438a382d27e20d86af7df665601c0cf26bb6b6be2a402f5f30ebba75e7827c6ed04d95d8eac180e194d7b8e8baec7a8e9915c2b0c10322ada562b547a324eb20dc187e751ddcea91924d72f6fa9f96a4161c525f6b01a13cf6ac7918d4d11deea4166c64515c2eabac62ec8cd157633d4ccfda0ad10ea7a7df270597673dfae3f9571fe10f12cd670081d8ec0d80335d97c6c9bedf3451c7f32dbe324763cd78b452b45202188c7342b9b3f79687bb9f102bc5b95f04fbd54b9d7c14237feb5e569aeca800cf6a64dadbba102a9cd19fb36747a9ebaab738dd9fc68ae16599e572cc4e68a8e634513df75cd21a5f0f38bbf9afe6c3b63d0f4ffc76bc1eea16b7b874652086c60d7d23e228e492356e42a281c7b71d6bc37c5f64d1dd79e3a1e30074ab90a1a1cc126909a0d256468145145007d5de20f2cdb04cae475e78af16f13c492249ce79ec6a197c45e20f13dd490c07cb65cbb63b0e3fc457233dede1761348720ed619eb5ac888a2948a0310062a3a7336e393ce69b5916145145007a7f8402dae9dacceaa0cac59379ea07f915e79764991dbd5b268a2ae42299a28a2a06145145007ffd9),
('monish', 'Monish', 'Mirza', '17', '9005785412', 0xffd8ffe000104a46494600010200000100010000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc00011080056005403012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f9feaedb8558833bba73d54e2a9a8cf7c5589b04c48872b81f9d006ed86bf7ba70536f71e7463aa4879fc0d77de1df882b2b247286427820d7006c2c60d26669c6fb952bb638e161952b9cf99bb031cf50738ace4b5b9b0d51addd5d191b0c1ba83ef4da6849a67d3965aaacd08901c8355b54f1643a6425e45763d02a8c93599e0ab77bbd1a1924200d9c927d2bcf3c75aa41a86b22d2c2f526811b6b981b209ce303b1e78f4a433b5ff84bef3534916e2f7ec16edc225bb0f30fae5bb55dd365b55d3afe4b6bbbdb890c2e375c5c1901e3b0e9fa579b58593eab75a3e9d05c3591bbddbdbec6584602b3025cb0df9dbce3000edeb892788f57f0eea57167f69590c6ae8593a12548523e84838f6a6d3424d3d51cbdca949e4523189187eb5055cbbc882d949e021c0fc7354e90c28a28a00055a96166b8754e830c00ec08cd5602ba0d34c51ea2a645ddfb95383df1400ba75bdf4de5bb4c238e1c1f32655dabcf192c3a67d7bd6b5f6913dbdf45713dc1b879937994b641cf718e2b1b58d55eecad928090ef0c40ee4640fe66b42defc7951da03c42760fa601fe79a2e07a8edb9ff853fa9b5b332ba5b39257aed1d7f4cd79d787b4c5d724b4b10cc8ede6c08c3f87e5f317f5423f1af69f045ac57de0d36730cc7731344c3d43647f5af11f0fdcdde89a8218c66eacae049e57773137ccbf880c2802ecda5788347ba904334c8eca53cd0a3383d7071919ef8eb5c76b366f69a898a42c642a198b9e4935f56bdb5aea16b15dc5b65b79a31246c47de561907f239af9e7e26c489e3b68a14036c29903d793fca9b7712496c72fa9c06265e846d0411d3bff00856756c6acbfe8f0b1249088391d3a9ac7a430a28a280157a8ad1f3cc77d13127fd585acf5fbc29f33ee9723b002802e42a27d48e4f19ebe80549a6319b53e5b0a58b1354033246c7382d4412491c9fbafbc78a00f4283e246afa3eb115b69d73b2c2cd55521f2d0895801bb7920939391c11818c60f34be3754d2bc7b75736a71657eb16ad6d9feeca0337ea58579da3133e589c93cfd6b6b55f10ddea97fa61b911aff0067d9c5631141d634ced273df0d401ef5f0fb575bbf0b369e6453258b94501b930b7cd19fa0c941fee578978bee7fb57c77aa4b1b02aafb14fa6d014ff235b1e18f167f635cde5c1dbb23d3a58d07a9254a03f4231f89ae1165769649198991892ec7bfad006aebb1a430448010c1537023bedcff00222b06afdd3bb59c4cfcef390c4e4f1c62a85001451450014514500492302aa29aa7041a6d28e28027778b16fb07cca9893ebb9bfa6292e40f383039c806a0a5249ef401297210ed279c03f4a489b6e7a64f14c0d8523d69b40166f27f39d147dd8d428c7b77aad45140051451400514514005145140051451400514514005145140051451400514514005145140051451400514514005145140051451401fffd9);

-- --------------------------------------------------------

--
-- Table structure for table `pdfs_tbl`
--

CREATE TABLE IF NOT EXISTS `pdfs_tbl` (
  `session` varchar(50) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `pdfname` varchar(100) DEFAULT NULL,
  `pdf` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pres_info`
--

CREATE TABLE IF NOT EXISTS `pres_info` (
  `user_id` varchar(100) NOT NULL DEFAULT '',
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `profession` varchar(100) DEFAULT NULL,
  `specialist` varchar(100) DEFAULT NULL,
  `pic` blob,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pres_info`
--

INSERT INTO `pres_info` (`user_id`, `first_name`, `last_name`, `age`, `phone`, `branch`, `profession`, `specialist`, `pic`) VALUES
('sagar', 'Sagar', 'Palao', '18', '8108595242', 'CM', 'abcd', 'xyz', 0xffd8ffe000104a46494600010200000100010000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc00011080078004b03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f00cd68e9b2ed900c81ce79acda7862ac08ed5517603a1b0d4923bd9891f7b819ad0975d4b46de4ee27b0ae3b71ea0e39a19cb1e4e6adcc4d27b9d15d78aee2e49400aa918e2a2fb65cdea986de366089bc841d87526b0d549390715d0f867537d1f5db79238bcd127eee48cf1bd4f0456529b2e942329599b5a27c3fbdd7b4b87516ba8e149e509b31c85ce0b7358bade8377a26b3259aceb391cabc43ef0fa76af49d63c72896e915a242b228f2e0b489b3b4fab60f6adaf01f82a167935fd7a60d3dc0fbd201ebdbbf6ef514d4a4f537c53a34e368bd4f3ed0fc2fa9dec68d340ea0fa8c1aea0f87046761ea3d6bd52f23b0b2465b6439f5c66b89ba9835cc84f735d5cb64792aaddea7ce58adef0ee88fabde0882654f7ac2af52f869679962201cb9233f856713b4e335bf0cdf6957453c87311190c06456110738afa94e8b0dcc288e9b86df981ef58b27c0fd1f5a0f345712d94a4e46c1914da4c8e6ee7cfd140d18123a9da7a1ab567677371724c5379271f7b711c57b7597ecf4ff6a02f35a636cadc044f988aec2dbe0c786e1d9e649772ece83cc001faf1531493d4a7dd1e3be14d1e0b4ba43ba2791c8266c9639fa135eefa0e881ac2269886909dc4b296dc33d0e7a55fb0f04e89a6b29b6b55509d33c9ada9e75b78b0b8e9c568e6ad6462e1cceece6fc4af1c319450a063181c5797dc5c0fb43e077aec7c4d785de4c93d3d6bce27bac4ee33de95cc5c53678b8eb5ed1f0fd360b761c60578c0ea3eb5ed7e07388a12476acee7723d66318b757c74152a6b505b8da66556f426abdd4bf66d1de5738d82bc4bc7371aac4aba8c7e6c709e8474eb55157319dee7d056bac3b61838753d0835ad0de79a879e45789fc35f1436a9a5986e24fdec585c1ea715e8d6fa8189861b83eb44e1d814ba33abf3494ac9d46e020e4d20d4d0a925874ae6b5bd4f62b1ddd2b349dec393d34399f13dfaabbfcc39e2bc86f7c458bc9403c66ba3f18eba511c6724f4c5796bb9772c7a9ad742231b8d5ea3eb5ecfe0bc88a1e7a8af1851f32fb9af6cf07478f287602a3a1b9ea53442eec56227e5908e0d4fe2af0edadff80ef6c9e052041b978e430e7fa53eca3262b7e3a1ef5a7af4c9169572ec7810b023f0a94ddc4d59dd9f257853599742d706e62abbf6b0cfbd7b55978823bb8bcc5719e3bd7cff00aa662d66e5b1ff002d9987e75b9a3f88a4810ee6c63a56d17dcce71bec7b636bd8246ee9ef5cf6b7adef8cfcdd7deb886f136e19f300ac6d53c40ee8515b34368851652f115fb5cde3286c815894e772ee59ba9a666b36cdd2b2248c66441ef5ee1e120abb39c715e1a0e0823a8af52f096b9132203200e383cd34867bcdbb85b289bba806b9ef12eb4d7b20d2ad5f325cf071d80e4e7f0ae47c47e3e8f4cd1b6c32a9988daa33c8355be19cb77a8d8eabad5f3ef79f11c471ca953938fceaa31b194eecf36f1c69274dd65d40c024f3eb5cc0729d0d7aa78e6d12f60795e33e6216208ea6bca5810c41e0e694b42a3b0be6b7a9fce9858b75a4a2a0b0a28a28017353dbdccb6cdbe290a37b1aaf522824aaeec027f2a6068db5bdeeb9a9476d1879ae253855519c7ad7d35a0f871344f0cd9589c6e54dce47f136064d709e0393c3be1ab24977235e9199666232323a0addd57e27693142e239101e8aa1b3c56913393317c5500569005ee462bc6b56b530deb91c026bb4d73c7e2fa460b0e1727048eb5c56a57cb78c1c2e09a9915133cf5a4a5ef4952505145148000abd6d6524ea190f3daa9038adad1a628b261371c71ed551dc0b91e897cd6ecf3bb0c26e033fce89f47d9a7e9cca096b9900dc7b74ad2875494e9ce9e539936ed04f7a82dee65bab7b65914a1b57508bebc815b72e805cf1c58da69f6ba75a5ba2ef8e305d80ea70335c2487e7239eb5d8f8bae0de5fc63ba0c1ae3e61b65606b190911d14515230a28a2800ad1d36f4db48413c1a28aa8ee074305f2b43f37241c8da29f6d6f3b5cacf229542db871f951456fd04335588099a56cee6cb735c9dc1dd331f7a28aca4864345145660145145007fffd9);

-- --------------------------------------------------------

--
-- Table structure for table `screenshots_tbl`
--

CREATE TABLE IF NOT EXISTS `screenshots_tbl` (
  `session` varchar(50) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `scrshot` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `session_tbl`
--

CREATE TABLE IF NOT EXISTS `session_tbl` (
  `activated` tinyint(1) NOT NULL,
  `activation_time` varchar(100) NOT NULL,
  `session_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `session_tbl`
--

INSERT INTO `session_tbl` (`activated`, `activation_time`, `session_name`) VALUES
(0, '2014/02/18 21:36:44', 'Java'),
(0, '2014/02/20 20:11:50', 'Java'),
(0, '2014/02/22 20:24:26', 'Java');

-- --------------------------------------------------------

--
-- Table structure for table `slides_tbl`
--

CREATE TABLE IF NOT EXISTS `slides_tbl` (
  `session` varchar(50) NOT NULL,
  `subtopic` varchar(100) NOT NULL,
  `slidename` varchar(100) NOT NULL,
  `slide` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studpolls`
--

CREATE TABLE IF NOT EXISTS `studpolls` (
  `session` varchar(50) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `pollno` varchar(100) NOT NULL,
  `answer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studpolls`
--

INSERT INTO `studpolls` (`session`, `user_id`, `pollno`, `answer`) VALUES
('Java', 'monish', '2', 'optA'),
('Java', 'dinesh', '1', 'optB'),
('Java', 'dinesh', '2', 'optB'),
('Java', 'dinesh', '3', 'optC');

-- --------------------------------------------------------

--
-- Table structure for table `vct_partc`
--

CREATE TABLE IF NOT EXISTS `vct_partc` (
  `user_id` varchar(100) NOT NULL,
  `passwd` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vct_partc`
--

INSERT INTO `vct_partc` (`user_id`, `passwd`) VALUES
('admin', 'admin'),
('dinesh', 'dinesh'),
('monish', 'monish');

-- --------------------------------------------------------

--
-- Table structure for table `vct_pres`
--

CREATE TABLE IF NOT EXISTS `vct_pres` (
  `user_id` varchar(100) NOT NULL,
  `paswd` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vct_pres`
--

INSERT INTO `vct_pres` (`user_id`, `paswd`) VALUES
('admin', 'admin'),
('sagar', 'sagar');

-- --------------------------------------------------------

--
-- Table structure for table `weblinkstbl`
--

CREATE TABLE IF NOT EXISTS `weblinkstbl` (
  `session` varchar(50) NOT NULL,
  `weblink` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weblinkstbl`
--

INSERT INTO `weblinkstbl` (`session`, `weblink`) VALUES
('Java', 'www.google.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
