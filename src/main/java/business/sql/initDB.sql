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
DROP SCHEMA IF EXISTS `fog_carport`;

-- -----------------------------------------------------
-- Schema fog_carport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fog_carport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fog_carport`;

-- -----------------------------------------------------
-- Table `fog_carport`.`carport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`carport` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`carport` (
                                                       `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                       `roofAngle` INT UNSIGNED NOT NULL,
                                                       `width` INT UNSIGNED NOT NULL,
                                                       `length` INT UNSIGNED NOT NULL,
                                                       `shedWidth` INT UNSIGNED NOT NULL,
                                                       `shedLength` INT UNSIGNED NOT NULL,
                                                       `name` VARCHAR(45) NULL DEFAULT NULL,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                       UNIQUE INDEX `model_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 44
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`material` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`material` (
                                                        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                        `name` VARCHAR(45) NOT NULL,
                                                        `cost` DECIMAL(12,2) NOT NULL,
                                                        `width` INT UNSIGNED NULL DEFAULT NULL,
                                                        `length` INT UNSIGNED NULL DEFAULT NULL,
                                                        `materialCategoryId` INT UNSIGNED NULL DEFAULT NULL,
                                                        PRIMARY KEY (`id`),
                                                        UNIQUE INDEX `Id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 37
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`materialcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`materialcategory` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`materialcategory` (
                                                                `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                                `name` VARCHAR(45) NOT NULL,
                                                                PRIMARY KEY (`id`),
                                                                UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                                UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 28
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`materialcolor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`materialcolor` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`materialcolor` (
                                                             `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                             `materialId` INT UNSIGNED NOT NULL,
                                                             `name` VARCHAR(45) NOT NULL,
                                                             `hexcode` VARCHAR(6) NOT NULL,
                                                             PRIMARY KEY (`id`),
                                                             UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`query`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`query` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`query` (
                                                     `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                     `userId` INT UNSIGNED NOT NULL,
                                                     `carportId` INT UNSIGNED NOT NULL,
                                                     `status` VARCHAR(45) NOT NULL DEFAULT 'initiated',
                                                     `message` TINYBLOB NULL DEFAULT NULL,
                                                     `wantBuilder` VARCHAR(10) NULL DEFAULT NULL,
                                                     PRIMARY KEY (`id`),
                                                     UNIQUE INDEX `Id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 11
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`response`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`response` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`response` (
                                                        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                        `queryId` INT UNSIGNED NOT NULL,
                                                        `userId` INT UNSIGNED NOT NULL,
                                                        `message` TINYBLOB NOT NULL,
                                                        `price` DECIMAL(12,2) UNSIGNED NULL DEFAULT NULL,
                                                        PRIMARY KEY (`id`),
                                                        UNIQUE INDEX `Id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_carport`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fog_carport`.`user` ;

CREATE TABLE IF NOT EXISTS `fog_carport`.`user` (
                                                    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                    `email` VARCHAR(45) NOT NULL,
                                                    `password` VARCHAR(45) NOT NULL,
                                                    `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
                                                    `name` VARCHAR(45) NOT NULL,
                                                    `phone` INT UNSIGNED NOT NULL,
                                                    `street` VARCHAR(45) NOT NULL,
                                                    `town` VARCHAR(45) NOT NULL,
                                                    `zipCode` INT NOT NULL,
                                                    PRIMARY KEY (`id`),
                                                    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 40
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
