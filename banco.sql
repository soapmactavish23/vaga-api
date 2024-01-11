-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.30 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para vaga
CREATE DATABASE IF NOT EXISTS `vaga` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vaga`;

-- Copiando estrutura para tabela vaga.client
CREATE TABLE IF NOT EXISTS `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela vaga.client: ~10 rows (aproximadamente)
DELETE FROM `client`;
INSERT INTO `client` (`id`, `name`) VALUES
	(1, 'Josefa Alice Melissa Oliveira'),
	(2, 'Luiza Letícia'),
	(3, 'Davi Isaac Guilherme Oliveira'),
	(4, 'Mariana Beatriz Marcela Nunes'),
	(5, 'Simone Marcela Laís'),
	(6, 'Carlos Eduardo Thiago Jorge Nunes'),
	(7, 'Sara Stefany Hadassa Drumond'),
	(8, 'Sabrina Fernanda Mariane'),
	(9, 'Manoel Henry Drumond'),
	(10, 'Nelson Carlos Caldeira');

-- Copiando estrutura para tabela vaga.flyway_schema_history
CREATE TABLE IF NOT EXISTS `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela vaga.flyway_schema_history: ~2 rows (aproximadamente)
DELETE FROM `flyway_schema_history`;
INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
	(1, '01', 'client', 'SQL', 'V01__client.sql', 1401805740, 'root', '2024-01-11 21:41:12', 19, 1),
	(2, '02', 'product', 'SQL', 'V02__product.sql', 1046066779, 'root', '2024-01-11 21:41:12', 24, 1);

-- Copiando estrutura para tabela vaga.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `code` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `value` double(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `random_number` (`code`) USING BTREE,
  KEY `client_id` (`client_id`) USING BTREE,
  CONSTRAINT `FK_product_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela vaga.product: ~10 rows (aproximadamente)
DELETE FROM `product`;
INSERT INTO `product` (`id`, `client_id`, `code`, `name`, `value`, `quantity`, `date`) VALUES
	(62, 1, 0, 'string', 90.00, 11, '2023-12-10'),
	(63, 2, 1, 'string', 95.00, 6, '2023-12-10'),
	(64, 3, 2, 'string', 0.00, 0, '2023-12-10'),
	(65, 4, 3, 'string', 0.00, 0, '2023-12-10'),
	(66, 5, 4, 'string', 0.00, 0, '2023-12-10'),
	(67, 6, 5, 'string', 0.00, 0, '2023-12-10'),
	(68, 7, 6, 'string', 0.00, 0, '2023-12-10'),
	(69, 8, 7, 'string', 0.00, 0, '2023-12-10'),
	(70, 9, 8, 'string', 0.00, 10, '2023-12-10'),
	(71, 10, 9, 'string', 0.00, 1, '2024-01-11');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
