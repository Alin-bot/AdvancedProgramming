For movie table:

CREATE TABLE `newdb`.`movies` (
`ID` INT NOT NULL AUTO_INCREMENT,
`Title` VARCHAR(45) NOT NULL,
`Release_date` DATETIME NOT NULL,
`Duration` FLOAT NOT NULL,
`Score` VARCHAR(45) NOT NULL,
PRIMARY KEY (`ID`));


For genres table:

CREATE TABLE `newdb`.`genres` (
`ID` INT NOT NULL AUTO_INCREMENT,
`Name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`ID`));


For conection table:

CREATE TABLE `newdb`.connection (
`ID_movie` INT NOT NULL,
`ID_genres` INT NOT NULL,
INDEX `ID_genres_idx` (`ID_genres` ASC) VISIBLE,
CONSTRAINT `ID_movie`
FOREIGN KEY (`ID_movie`)
REFERENCES `newdb`.`movies` (`ID`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `ID_genres`
FOREIGN KEY (`ID_genres`)
REFERENCES `newdb`.`genres` (`ID`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);
