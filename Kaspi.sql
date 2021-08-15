-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema TASK_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TASK_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TASK_DB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `TASK_DB` ;

-- -----------------------------------------------------
-- Table `TASK_DB`.`application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TASK_DB`.`application` (
  `application_number` BIGINT NOT NULL AUTO_INCREMENT,
  `iin` BIGINT NOT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `total_money` BIGINT NULL DEFAULT NULL,
  `term` INT NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`application_number`),
  UNIQUE INDEX `application_number_UNIQUE` (`application_number` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `TASK_DB`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TASK_DB`.`client` (
  `iin` BIGINT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `fathername` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `birthday` DATETIME NOT NULL,
  `sex` VARCHAR(45) NOT NULL,
  `document_number` BIGINT NOT NULL,
  `department_given` VARCHAR(45) NOT NULL,
  `given_date` DATETIME NOT NULL,
  `until_date` VARCHAR(45) NOT NULL,
  `salary` BIGINT NOT NULL,
  `expenditure` BIGINT NOT NULL,
  PRIMARY KEY (`iin`),
  UNIQUE INDEX `iin_UNIQUE` (`iin` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TASK_DB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TASK_DB`.`user` (
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`login`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `TASK_DB`.`user`(`login`,`password`) VALUES ('admin','Gcf70h4aWQ1T9NMxE03XM3nq3nCmFGihnO4xMzHMgP0=');
