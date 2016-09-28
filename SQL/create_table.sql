-- MySQL Script generated by MySQL Workbench
-- 09/28/16 23:54:47
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema qk_practice
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `qk_practice` ;

-- -----------------------------------------------------
-- Schema qk_practice
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qk_practice` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `qk_practice` ;

-- -----------------------------------------------------
-- Table `qk_practice`.`subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`subject` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`subject` (
  `subject_id` VARCHAR(45) NULL,
  `name` VARCHAR(50) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`subject_id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `name_UNIQUE` ON `qk_practice`.`subject` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`anwser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`anwser` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`anwser` (
  `anwser_id` VARCHAR(45) NOT NULL,
  `anwser` VARCHAR(500) NOT NULL,
  `attachment` VARCHAR(500) NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`anwser_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`status` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`status` (
  `status_id` VARCHAR(45) NULL,
  `code` VARCHAR(30) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `code_UNIQUE` ON `qk_practice`.`status` (`code` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `name_UNIQUE` ON `qk_practice`.`status` (`name` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`practice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`practice` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`practice` (
  `practice_id` VARCHAR(45) NOT NULL,
  `subject_id` VARCHAR(45) NULL,
  `anwser_id` VARCHAR(45) NOT NULL,
  `code` VARCHAR(30) NULL,
  `titile` VARCHAR(100) NOT NULL,
  `description` LONGTEXT NULL,
  `attachment` VARCHAR(500) NULL,
  `is_public` VARCHAR(1) NOT NULL DEFAULT 'N',
  `status_id` VARCHAR(45) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` NVARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`practice_id`),
  CONSTRAINT `fk_practice_subject_id`
    FOREIGN KEY (`subject_id`)
    REFERENCES `qk_practice`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_practice_anwser_id`
    FOREIGN KEY (`anwser_id`)
    REFERENCES `qk_practice`.`anwser` (`anwser_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_practice_status_id`
    FOREIGN KEY (`status_id`)
    REFERENCES `qk_practice`.`status` (`status_id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `titile_index` ON `qk_practice`.`practice` (`titile` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_subject_id_idx` ON `qk_practice`.`practice` (`subject_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_anwser_id_idx` ON `qk_practice`.`practice` (`anwser_id` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `code_UNIQUE` ON `qk_practice`.`practice` (`code` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_status_id_idx` ON `qk_practice`.`practice` (`status_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`tag` (
  `tag_id` VARCHAR(45) NOT NULL,
  `tag` VARCHAR(50) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`tag_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`exam` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`exam` (
  `exma_id` VARCHAR(45) NULL,
  `subject_id` VARCHAR(45) NULL,
  `code` VARCHAR(30) NULL,
  `titile` VARCHAR(100) NOT NULL,
  `decription` VARCHAR(100) NULL,
  `is_public` VARCHAR(1) NULL DEFAULT 'N',
  `duration` INT NOT NULL,
  `status_id` VARCHAR(45) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`exma_id`),
  CONSTRAINT `fk_exam_subject_id`
    FOREIGN KEY (`subject_id`)
    REFERENCES `qk_practice`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_status_id`
    FOREIGN KEY (`status_id`)
    REFERENCES `qk_practice`.`status` (`status_id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `code_UNIQUE` ON `qk_practice`.`exam` (`code` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_subject_id_idx` ON `qk_practice`.`exam` (`subject_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_status_id_idx` ON `qk_practice`.`exam` (`status_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`exam_pratice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`exam_pratice` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`exam_pratice` (
  `exam_pratice_id` VARCHAR(45) NOT NULL,
  `exma_id` VARCHAR(45) NOT NULL,
  `practice_id` VARCHAR(45) NOT NULL,
  `score` INT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`exam_pratice_id`),
  CONSTRAINT `fk_exam_practice_exam_id`
    FOREIGN KEY (`exma_id`)
    REFERENCES `qk_practice`.`exam` (`exma_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_practice_practice_id`
    FOREIGN KEY (`practice_id`)
    REFERENCES `qk_practice`.`practice` (`practice_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_exam_id_idx` ON `qk_practice`.`exam_pratice` (`exma_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_practice_id_idx` ON `qk_practice`.`exam_pratice` (`practice_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`exam_instance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`exam_instance` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`exam_instance` (
  `exam_instance_id` VARCHAR(45) NULL,
  `exam_id` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `start_time` BIGINT NULL DEFAULT 0,
  `end_time` BIGINT NULL,
  `score` INT NULL DEFAULT 0,
  `status_id` VARCHAR(45) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`exam_instance_id`),
  CONSTRAINT `fk_exam_instance_exam_id`
    FOREIGN KEY (`exam_id`)
    REFERENCES `qk_practice`.`exam` (`exma_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_instance_status`
    FOREIGN KEY (`status_id`)
    REFERENCES `qk_practice`.`status` (`status_id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_status_idx` ON `qk_practice`.`exam_instance` (`status_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`practice_instance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`practice_instance` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`practice_instance` (
  `practice_instance_id` VARCHAR(45) NULL,
  `exam_instance_id` VARCHAR(45) NULL,
  `practice_id` VARCHAR(45) NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `anwser` VARCHAR(500) NULL,
  `score` INT NULL DEFAULT 0,
  `attachment` VARCHAR(100) NULL,
  `status_id` VARCHAR(45) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`practice_instance_id`),
  CONSTRAINT `fk_practice_instance_practice_id`
    FOREIGN KEY (`practice_id`)
    REFERENCES `qk_practice`.`practice` (`practice_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_practice_instance_exam_instance_id`
    FOREIGN KEY (`exam_instance_id`)
    REFERENCES `qk_practice`.`exam_instance` (`exam_instance_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_practice_instance_status_id`
    FOREIGN KEY (`status_id`)
    REFERENCES `qk_practice`.`status` (`status_id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `code_UNIQUE` ON `qk_practice`.`practice_instance` (`practice_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_status_id_idx` ON `qk_practice`.`practice_instance` (`status_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_exam_instance_id_idx` ON `qk_practice`.`practice_instance` (`exam_instance_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`exam_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`exam_tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`exam_tag` (
  `exam_tag_id` VARCHAR(45) NOT NULL,
  `tag_id` VARCHAR(45) NOT NULL,
  `exam_id` VARCHAR(45) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`exam_tag_id`),
  CONSTRAINT `fk_exam_tag_tag_id`
    FOREIGN KEY (`tag_id`)
    REFERENCES `qk_practice`.`tag` (`tag_id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_tag_exam_id`
    FOREIGN KEY (`exam_id`)
    REFERENCES `qk_practice`.`exam` (`exma_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_tag_id_idx` ON `qk_practice`.`exam_tag` (`tag_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_exam_id_idx` ON `qk_practice`.`exam_tag` (`exam_id` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `qk_practice`.`practice_tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qk_practice`.`practice_tag` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `qk_practice`.`practice_tag` (
  `practice_tag_id` VARCHAR(45) NOT NULL,
  `practice_id` VARCHAR(45) NOT NULL,
  `tag_id` VARCHAR(45) NOT NULL,
  `is_delete` VARCHAR(1) NULL DEFAULT 'N',
  `created_time` BIGINT(20) NOT NULL,
  `last_modified_by` VARCHAR(45) NOT NULL,
  `last_modified_time` BIGINT(20) NOT NULL,
  PRIMARY KEY (`practice_tag_id`),
  CONSTRAINT `fk_practice_tag_tag_id`
    FOREIGN KEY (`tag_id`)
    REFERENCES `qk_practice`.`tag` (`tag_id`)
    ON DELETE RESTRICT
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_practice_tag_practice_id`
    FOREIGN KEY (`practice_id`)
    REFERENCES `qk_practice`.`practice` (`practice_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_tag_id_idx` ON `qk_practice`.`practice_tag` (`tag_id` ASC);

SHOW WARNINGS;
CREATE INDEX `fk_practice_id_idx` ON `qk_practice`.`practice_tag` (`practice_id` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
