CREATE TABLE `product` (
	`product_id` INT NOT NULL,
	`name` VARCHAR(50) NOT NULL DEFAULT '',
	`description` VARCHAR(50) NOT NULL DEFAULT '',
	`prize` FLOAT NOT NULL DEFAULT 0,
	`quantity` INT NOT NULL DEFAULT 0
	PRIMARY KEY (`product_id`)
);