CREATE TABLE `invoice` (
	`invoice_id` INT NOT NULL,
	`amount` FLOAT NOT NULL DEFAULT 0,
	`status` VARCHAR(50) NOT NULL DEFAULT '',
	`client_id` INT NOT NULL,
	PRIMARY KEY (`invoice_id`),
	CONSTRAINT `fl_client_invoice` FOREIGN KEY (`client_id`) REFERENCES `clients`(`client_id`)
);
