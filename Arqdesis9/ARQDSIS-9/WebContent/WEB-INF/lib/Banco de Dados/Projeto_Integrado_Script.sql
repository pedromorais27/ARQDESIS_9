SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `projeto` ;
CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`Cliente` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`Cliente` (
  `codigoCliente` INT NULL ,
  `nomeCliente` VARCHAR(45) NULL ,
  PRIMARY KEY (`codigoCliente`) )
ENGINE = InnoDB;

INSERT INTO Cliente (codigoCliente, nomeCliente) VALUES ("1", "Anderson Santos");
INSERT INTO Cliente (codigoCliente, nomeCliente) VALUES ("2", "Gabrielle Rodrigues Castelo");

select * from Cliente;
-- -----------------------------------------------------
-- Table `projeto`.`Conta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`Conta` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`Conta` (
  `conta` INT NULL ,
  `codigoCliente` INT NULL ,
  `banco` INT NULL ,
  `agencia` INT NULL ,
  `saldo` DECIMAL NULL ,
  PRIMARY KEY (`conta`) ,
  INDEX `codigoCliente_idx` (`codigoCliente` ASC) ,
  CONSTRAINT `codigoCliente`
    FOREIGN KEY (`codigoCliente` )
    REFERENCES `projeto`.`Cliente` (`codigoCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO Conta (conta, codigoCliente, banco, agencia, saldo ) VALUES ("206107", "1", "1", "6234", "20000");
INSERT INTO Conta (conta, codigoCliente, banco, agencia, saldo ) VALUES ("655070", "2", "1", "169", "30000");

select * from Conta;

-- -----------------------------------------------------
-- Table `projeto`.`dedbitoAutomatico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`dedbitoAutomatico` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`dedbitoAutomatico` (
  `codigoDebito` INT AUTO_INCREMENT,
  `tipoDebito` VARCHAR(45) NULL ,
  `operadora` VARCHAR(45) NULL ,
  `codigoConsumidor` INT NULL ,
  `dataDebitol` DATETIME NULL ,
  `valorDebito` DECIMAL NULL ,
  `conta` INT NULL ,
  PRIMARY KEY (`codigoDebito`) ,
  INDEX `conta_idx` (`conta` ASC) ,
  CONSTRAINT `conta`
    FOREIGN KEY (`conta` )
    REFERENCES `projeto`.`Conta` (`conta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

select * from dedbitoAutomatico;

-- -----------------------------------------------------
-- Table `projeto`.`Dispenser`
-- -----------------------------------------------------
drop table Dispenser;

CREATE  TABLE IF NOT EXISTS `projeto`.`Dispenser` (
  `Nota` INT NULL ,
  `QuantidadeDeNotas`INT NULL ,
  PRIMARY KEY (`Nota`) )
ENGINE = InnoDB;
INSERT INTO Dispenser (Nota) VALUES (20);
INSERT INTO Dispenser (Nota) VALUES (10);
INSERT INTO Dispenser (Nota) VALUES (50);

select * from Dispenser;

-- -----------------------------------------------------
-- Table `projeto`.`Movimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`Movimento` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`Movimento` (
  `codigoMovimento` INT AUTO_INCREMENT ,
  `numConta` INT NULL ,
  `dataOperacao` DATETIME NULL ,
  `valorOperacao` DECIMAL NULL ,
  `agenciaDestino` INT  NULL,
  `contaDestino` INT NULL ,
  `codCli` INT NULL ,
  `codDebito` INT NULL ,
  `tipoMovimento` VARCHAR(45) NULL ,
  PRIMARY KEY (`codigoMovimento`) ,
  INDEX `conta_idx` (`numConta` ASC) ,
  INDEX `codCli_idx` (`codCli` ASC) ,
  INDEX `codDebito_idx` (`codDebito` ASC) ,
  CONSTRAINT `numConta`
    FOREIGN KEY (`numConta` )
    REFERENCES `projeto`.`Conta` (`conta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codCli`
    FOREIGN KEY (`codCli` )
    REFERENCES `projeto`.`Cliente` (`codigoCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codDebito`
    FOREIGN KEY (`codDebito` )
    REFERENCES `projeto`.`dedbitoAutomatico` (`codigoDebito` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

select * from Movimento;

-- -----------------------------------------------------
-- Table `projeto`.`Log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`Log` ;																							

CREATE  TABLE IF NOT EXISTS `projeto`.`Log` (
  `codigoItemLog` INT AUTO_INCREMENT ,
  `codigoDoMovimento` INT NULL ,
  `tipoOperacao` VARCHAR(45) NULL ,
  `valor` DECIMAL NULL ,
  `Conta` INT NULL ,
  `agencia` INT NULL ,
  `codigoDoCliente` INT NULL ,
  `dataOperacao` DATETIME NULL ,
  PRIMARY KEY (`codigoItemLog`) ,
  INDEX `codigoMovimento_idx` (`codigoDoMovimento` ASC) ,
  INDEX `codCli_idx` (`codigoDoCliente` ASC) ,
  INDEX `codConta_idx` (`Conta` ASC) ,
  CONSTRAINT `codigoDoMovimento`
    FOREIGN KEY (`codigoDoMovimento` )
    REFERENCES `projeto`.`Movimento` (`codigoMovimento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codigoDaConta`
    FOREIGN KEY (`Conta` )
    REFERENCES `projeto`.`Conta` (`conta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codigoDoCliente`
    FOREIGN KEY (`codigoDoCliente` )
    REFERENCES `projeto`.`Cliente` (`codigoCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

select * from log;

USE `projeto` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
