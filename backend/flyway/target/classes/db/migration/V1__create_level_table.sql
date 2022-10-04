CREATE TABLE `level` (
	`level_id` INT(11) NOT NULL,
	`description` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`level_id`) USING BTREE
)
COMMENT='Permitir almacenar los niveles que hay en un colegio'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

-- CTRL + ALT + L ->tabular el código