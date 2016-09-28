CREATE UNIQUE INDEX uq_exam_pratice_ids ON `qk_practice`.`exam_pratice`(exma_id,practice_id); 
CREATE UNIQUE INDEX uq_exam_instance_ids ON `qk_practice`.`exam_instance`(exam_id,user_id); 
CREATE UNIQUE INDEX uq_practice_instance_ids ON `qk_practice`.`practice_instance`(exam_instance_id,practice_id,user_id);

--CREATE UNIQUE INDEX uq_pratice_ids ON `qk_practice`.`practice`(practice_id,subject_id);
--CREATE UNIQUE INDEX uq_exam_ids ON `qk_practice`.`exam`(exam_id,subject_id);
