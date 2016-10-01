CREATE UNIQUE INDEX uq_exam_pratice_ids ON `qk_practice`.`exam_pratice`(exma_id,practice_id); 

--CREATE UNIQUE INDEX uq_pratice_ids ON `qk_practice`.`practice`(practice_id,subject_id);
--CREATE UNIQUE INDEX uq_exam_ids ON `qk_practice`.`exam`(exam_id,subject_id);

--ALTER TABLE `qk_practice`.`exam` CHANGE COLUMN `titile` `title` VARCHAR(100) NOT NULL ;