-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bookmall
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bookmall` ;

-- -----------------------------------------------------
-- Schema bookmall
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookmall` DEFAULT CHARACTER SET utf8 ;
USE `bookmall` ;

-- -----------------------------------------------------
-- Table `bookmall`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmall`.`category` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookmall`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmall`.`book` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `category_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_book_category1`
    FOREIGN KEY (`category_no`)
    REFERENCES `bookmall`.`category` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookmall`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmall`.`member` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookmall`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmall`.`cart` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `count` INT NOT NULL,
  `book_no` INT NOT NULL,
  `member_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_cart_book1`
    FOREIGN KEY (`book_no`)
    REFERENCES `bookmall`.`book` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_member1`
    FOREIGN KEY (`member_no`)
    REFERENCES `bookmall`.`member` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookmall`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmall`.`orders` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `order_name` VARCHAR(45) NOT NULL,
  `order_email` VARCHAR(45) NOT NULL,
  `total_price` INT NOT NULL,
  `addr` VARCHAR(200) NOT NULL,
  `member_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_orders_member1`
    FOREIGN KEY (`member_no`)
    REFERENCES `bookmall`.`member` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bookmall`.`orders_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmall`.`orders_book` (
  `orders_no` INT NOT NULL,
  `book_no` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `count` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`orders_no`, `book_no`),
  CONSTRAINT `fk_book_has_order_order1`
    FOREIGN KEY (`orders_no`)
    REFERENCES `bookmall`.`orders` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_book_book1`
    FOREIGN KEY (`book_no`)
    REFERENCES `bookmall`.`book` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
