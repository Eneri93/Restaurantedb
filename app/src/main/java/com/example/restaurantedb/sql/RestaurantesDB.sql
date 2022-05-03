-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema RestaurantesDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema RestaurantesDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RestaurantesDB` DEFAULT CHARACTER SET utf8 ;
USE `RestaurantesDB` ;

-- -----------------------------------------------------
-- Table `RestaurantesDB`.`Franquicia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestaurantesDB`.`Franquicia` (
  `idFranquicia` INT NOT NULL,
  `nombreFranquicia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFranquicia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestaurantesDB`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestaurantesDB`.`Restaurante` (
  `idRestaurante` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `facturacion_anual` VARCHAR(45) NOT NULL,
  `logo` MEDIUMBLOB NULL,
  `Franquicia_idFranquicia` INT NOT NULL,
  PRIMARY KEY (`idRestaurante`),
  INDEX `fk_Restaurante_Franquicia_idx` (`Franquicia_idFranquicia` ASC) VISIBLE,
  CONSTRAINT `fk_Restaurante_Franquicia`
    FOREIGN KEY (`Franquicia_idFranquicia`)
    REFERENCES `RestaurantesDB`.`Franquicia` (`idFranquicia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RestaurantesDB`.`logos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RestaurantesDB`.`logos` (
  `idlogos` INT NOT NULL,
  `logo` MEDIUMBLOB NOT NULL,
  `idRestaurante` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idlogos`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
