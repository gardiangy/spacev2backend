ALTER TABLE `construction`
	ADD COLUMN `bld_id` BIGINT(20) NULL AFTER `pl_id`,
	ADD CONSTRAINT `FK_construction_building` FOREIGN KEY (`bld_id`) REFERENCES `building` (`bld_id`);
