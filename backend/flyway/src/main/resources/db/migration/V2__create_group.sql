CREATE TABLE `group` (
	`group_id` INT(11) NOT NULL,
	`description` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`group_id`) USING BTREE
)