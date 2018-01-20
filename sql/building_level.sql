ALTER TABLE `building`
	ADD COLUMN `bld_level` INT(20) NOT NULL DEFAULT '1' AFTER `bld_slot`;
