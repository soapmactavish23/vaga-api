CREATE TABLE `client` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(150) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB;

INSERT INTO `client` (`id`, `name`) VALUES (1, 'Josefa Alice Melissa Oliveira');
INSERT INTO `client` (`id`, `name`) VALUES (2, 'Luiza Letícia');
INSERT INTO `client` (`id`, `name`) VALUES (3, 'Davi Isaac Guilherme Oliveira');
INSERT INTO `client` (`id`, `name`) VALUES (4, 'Mariana Beatriz Marcela Nunes');
INSERT INTO `client` (`id`, `name`) VALUES (5, 'Simone Marcela Laís');
INSERT INTO `client` (`id`, `name`) VALUES (6, 'Carlos Eduardo Thiago Jorge Nunes');
INSERT INTO `client` (`id`, `name`) VALUES (7, 'Sara Stefany Hadassa Drumond');
INSERT INTO `client` (`id`, `name`) VALUES (8, 'Sabrina Fernanda Mariane');
INSERT INTO `client` (`id`, `name`) VALUES (9, 'Manoel Henry Drumond');
INSERT INTO `client` (`id`, `name`) VALUES (10, 'Nelson Carlos Caldeira');

