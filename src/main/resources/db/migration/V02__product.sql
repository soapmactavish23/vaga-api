CREATE TABLE `product` (
	`id` INT(10) NOT NULL,
	`client_id` INT(10) NOT NULL,
	`code` INT(10) NOT NULL,
	`name` VARCHAR(100) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`value` DOUBLE(10,2) NOT NULL,
	`quantity` INT(10) NOT NULL,
	`date` DATE NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `random_number` (`code`) USING BTREE,
	INDEX `client_id` (`client_id`) USING BTREE,
	CONSTRAINT `FK_product_client` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
ENGINE=InnoDB
;
