CREATE TABLE `client` (
	`client_id` INT NOT NULL,
	`firstName` VARCHAR(50) NOT NULL DEFAULT '',
	`lastName` VARCHAR(50) NOT NULL DEFAULT ''
	PRIMARY KEY (`client_id`)
);