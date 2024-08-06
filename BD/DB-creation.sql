-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Av3-BD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Av3-BD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Av3-BD` DEFAULT CHARACTER SET utf8 ;
USE `Av3-BD` ;

-- -----------------------------------------------------
-- Table `Av3-BD`.`tb_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Av3-BD`.`tb_client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Av3-BD`.`tb_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Av3-BD`.`tb_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `capacity` INT NOT NULL,
  `location` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Av3-BD`.`tb_reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Av3-BD`.`tb_reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `hour` INT NOT NULL,
  `minute` INT NOT NULL,
  `id_client` INT NOT NULL,
  `id_table` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reservation_Client_idx` (`id_client` ASC) VISIBLE,
  INDEX `fk_Reservation_Table1_idx` (`id_table` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_Client`
    FOREIGN KEY (`id_client`)
    REFERENCES `Av3-BD`.`tb_client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Table1`
    FOREIGN KEY (`id_table`)
    REFERENCES `Av3-BD`.`tb_table` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

ALTER TABLE `av3-bd`.`tb_reservation` 
ADD COLUMN `num_people` INT NOT NULL AFTER `id_table`;

ALTER TABLE `av3-bd`.`tb_reservation` 
CHANGE COLUMN `date` `reservation_date` DATE NOT NULL ;
ALTER TABLE `av3-bd`.`tb_reservation` 
CHANGE COLUMN `date` `reservation_date` DATE NOT NULL ;


INSERT INTO tb_table (number, capacity, location) VALUES (1, 2, 21);
INSERT INTO tb_table (number, capacity, location) VALUES (2, 2, 22);
INSERT INTO tb_table (number, capacity, location) VALUES (3, 2, 23);

INSERT INTO tb_table (number, capacity, location) VALUES (4, 8, 81);
INSERT INTO tb_table (number, capacity, location) VALUES (5, 8, 82);
INSERT INTO tb_table (number, capacity, location) VALUES (6, 8, 83);

INSERT INTO tb_table (number, capacity, location) VALUES (7, 4, 41);
INSERT INTO tb_table (number, capacity, location) VALUES (8, 4, 42);
INSERT INTO tb_table (number, capacity, location) VALUES (9, 8, 84);
