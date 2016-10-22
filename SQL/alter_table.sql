CREATE UNIQUE INDEX uq_exam_pratice_ids ON `qk_practice`.`exam_practice`(exam_id,practice_id); 

CREATE UNIQUE INDEX uq_exam_instance_ids ON `qk_practice`.`exam_instance`(exam_id,user_id,trial_times);

CREATE UNIQUE INDEX uq_practice_tag_ids ON `qk_practice`.`practice_tag`(practice_id,tag_id);

CREATE UNIQUE INDEX uq_exam_tag_ids ON `qk_practice`.`exam_tag`(exam_id,tag_id);

-- CREATE UNIQUE INDEX uq_practice_instance_ids ON `qk_practice`.`exam_pratice`(exma_id,practice_id);

-- CREATE UNIQUE INDEX uq_pratice_ids ON `qk_practice`.`practice`(practice_id,subject_id);
-- CREATE UNIQUE INDEX uq_exam_ids ON `qk_practice`.`exam`(exam_id,subject_id);

-- ALTER TABLE `qk_practice`.`exam` CHANGE COLUMN `titile` `title` VARCHAR(100) NOT NULL ;