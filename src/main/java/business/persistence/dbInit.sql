-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fog_carport
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fog_carport` ;

-- -----------------------------------------------------
-- Schema fog_carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog_carport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fog_carport` ;

-- -----------------------------------------------------
-- Table `fog_carport`.`Carport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`Carport` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`Carport` (
                                                       `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                       `roofAngle` INT UNSIGNED NOT NULL,
                                                       `width` INT UNSIGNED NOT NULL,
                                                       `length` INT UNSIGNED NOT NULL,
                                                       `shedWidth` INT UNSIGNED NOT NULL,
                                                       `shedLength` INT UNSIGNED NOT NULL,
                                                       `name` VARCHAR(45) NULL,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                       UNIQUE INDEX `model_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`MaterialCategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`MaterialCategory` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`MaterialCategory` (
                                                                `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                                `name` VARCHAR(45) NOT NULL,
                                                                PRIMARY KEY (`id`),
                                                                UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                                UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`Material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`Material` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`Material` (
                                                        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                        `name` VARCHAR(45) NOT NULL,
                                                        `cost` DECIMAL(12,2) NOT NULL,
                                                        `width` INT UNSIGNED NULL,
                                                        `length` INT UNSIGNED NULL,
                                                        `materialCategoryId` INT UNSIGNED NULL,
                                                        PRIMARY KEY (`id`),
                                                        UNIQUE INDEX `Id_UNIQUE` (`id` ASC) VISIBLE,
                                                        INDEX `fk_Material_MaterialCategory1_idx` (`materialCategoryId` ASC) VISIBLE,
                                                        CONSTRAINT `fk_Material_MaterialCategory1`
                                                            FOREIGN KEY (`materialCategoryId`)
                                                                REFERENCES `fog_carport`.`MaterialCategory` (`id`)
                                                                ON DELETE NO ACTION
                                                                ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`PostalCode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`PostalCode` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`PostalCode` (
                                                          `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                          `postalCode` INT(4) UNSIGNED NOT NULL,
                                                          `name` VARCHAR(45) NOT NULL,
                                                          PRIMARY KEY (`id`),
                                                          UNIQUE INDEX `townId_UNIQUE` (`id` ASC) VISIBLE,
                                                          UNIQUE INDEX `postalCode_UNIQUE` (`postalCode` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`Town`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`Town` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`Town` (
                                                    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                    `name` INT UNSIGNED NOT NULL,
                                                    `postalCodeId` INT UNSIGNED NOT NULL,
                                                    PRIMARY KEY (`id`),
                                                    UNIQUE INDEX `townId_UNIQUE` (`id` ASC) VISIBLE,
                                                    INDEX `fk_Town_PostalCode1_idx` (`postalCodeId` ASC) VISIBLE,
                                                    CONSTRAINT `fk_Town_PostalCode1`
                                                        FOREIGN KEY (`postalCodeId`)
                                                            REFERENCES `fog_carport`.`PostalCode` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`Address` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`Address` (
                                                       `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                       `address` VARCHAR(45) NOT NULL,
                                                       `townId` INT UNSIGNED NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE INDEX `townId_UNIQUE` (`id` ASC) VISIBLE,
                                                       INDEX `fk_Address_Town1_idx` (`townId` ASC) VISIBLE,
                                                       CONSTRAINT `fk_Address_Town1`
                                                           FOREIGN KEY (`townId`)
                                                               REFERENCES `fog_carport`.`Town` (`id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`User` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`User` (
                                                    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                    `email` VARCHAR(45) NOT NULL,
                                                    `password` VARCHAR(45) NOT NULL,
                                                    `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
                                                    `name` VARCHAR(45) NOT NULL,
                                                    `phone` INT UNSIGNED NOT NULL,
                                                    `adressId` INT UNSIGNED NULL,
                                                    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                    PRIMARY KEY (`id`),
                                                    INDEX `fk_User_Address1_idx` (`adressId` ASC) VISIBLE,
                                                    CONSTRAINT `fk_User_Address1`
                                                        FOREIGN KEY (`adressId`)
                                                            REFERENCES `fog_carport`.`Address` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`Query`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`Query` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`Query` (
                                                     `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                     `userId` INT UNSIGNED NOT NULL,
                                                     `carportId` INT UNSIGNED NOT NULL,
                                                     `status` VARCHAR(45) NOT NULL DEFAULT 'initiated',
                                                     `message` TINYBLOB NULL,
                                                     PRIMARY KEY (`id`),
                                                     UNIQUE INDEX `Id_UNIQUE` (`id` ASC) VISIBLE,
                                                     INDEX `fk_Query_Customer_idx` (`userId` ASC) VISIBLE,
                                                     CONSTRAINT `fk_Query_Customer`
                                                         FOREIGN KEY (`userId`)
                                                             REFERENCES `fog_carport`.`User` (`id`)
                                                             ON DELETE NO ACTION
                                                             ON UPDATE NO ACTION,
                                                     CONSTRAINT `fk_Query_Carport1`
                                                         FOREIGN KEY (`carportId`)
                                                             REFERENCES `fog_carport`.`Carport` (`id`)
                                                             ON DELETE NO ACTION
                                                             ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`Response`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`Response` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`Response` (
                                                        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                        `queryId` INT UNSIGNED NOT NULL,
                                                        `userId` INT UNSIGNED NOT NULL,
                                                        `message` TINYBLOB NOT NULL,
                                                        `price` DECIMAL(12,2) UNSIGNED NULL,
                                                        PRIMARY KEY (`id`),
                                                        UNIQUE INDEX `Id_UNIQUE` (`id` ASC) VISIBLE,
                                                        INDEX `fk_response_Query1_idx` (`queryId` ASC) VISIBLE,
                                                        INDEX `fk_Response_User1_idx` (`userId` ASC) VISIBLE,
                                                        CONSTRAINT `fk_response_Query1`
                                                            FOREIGN KEY (`queryId`)
                                                                REFERENCES `fog_carport`.`Query` (`id`)
                                                                ON DELETE NO ACTION
                                                                ON UPDATE NO ACTION,
                                                        CONSTRAINT `fk_Response_User1`
                                                            FOREIGN KEY (`userId`)
                                                                REFERENCES `fog_carport`.`User` (`id`)
                                                                ON DELETE NO ACTION
                                                                ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`MaterialColor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`MaterialColor` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`MaterialColor` (
                                                             `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                             `materialId` INT UNSIGNED NOT NULL,
                                                             `name` VARCHAR(45) NOT NULL,
                                                             `hexcode` VARCHAR(6) NOT NULL,
                                                             PRIMARY KEY (`id`),
                                                             UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                             INDEX `fk_MaterialVariant_Material1_idx` (`materialId` ASC) VISIBLE,
                                                             CONSTRAINT `fk_MaterialVariant_Material1`
                                                                 FOREIGN KEY (`materialId`)
                                                                     REFERENCES `fog_carport`.`Material` (`id`)
                                                                     ON DELETE NO ACTION
                                                                     ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_carport`.`TaggedMaterial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`TaggedMaterial` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`TaggedMaterial` (
                                                              `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                              `amount` INT UNSIGNED NOT NULL,
                                                              `carportId` INT UNSIGNED NOT NULL,
                                                              `materialId` INT UNSIGNED NOT NULL,
                                                              `materialColorId` INT UNSIGNED NULL DEFAULT 0,
                                                              PRIMARY KEY (`id`),
                                                              UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                              INDEX `fk_BillOfMaterialItem_Material1_idx` (`materialId` ASC) VISIBLE,
                                                              INDEX `fk_BillOfMaterialItem_MaterialVariant1_idx` (`materialColorId` ASC) VISIBLE,
                                                              INDEX `fk_BilledMaterial_Carport1_idx` (`carportId` ASC) VISIBLE,
                                                              CONSTRAINT `fk_BillOfMaterialItem_Material1`
                                                                  FOREIGN KEY (`materialId`)
                                                                      REFERENCES `fog_carport`.`Material` (`id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION,
                                                              CONSTRAINT `fk_BillOfMaterialItem_MaterialVariant1`
                                                                  FOREIGN KEY (`materialColorId`)
                                                                      REFERENCES `fog_carport`.`MaterialColor` (`id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION,
                                                              CONSTRAINT `fk_BilledMaterial_Carport1`
                                                                  FOREIGN KEY (`carportId`)
                                                                      REFERENCES `fog_carport`.`Carport` (`id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
