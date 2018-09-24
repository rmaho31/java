-- create and select the database
DROP DATABASE IF EXISTS taskDB;
CREATE DATABASE taskDB;
USE taskDB;

CREATE TABLE Tasks (
	ID						INT 						 PRIMARY KEY  AUTO_INCREMENT,
	Task 					VARCHAR(100)				 NOT NULL,
	CompleteBy				DATETIME					 NOT NULL,
	IsCompleted				TinyInt(1)					 NOT NULL DEFAULT 0,
	DateCreated				DATETIME					 NOT NULL DEFAULT current_timestamp,
	DateCompleted			DATETIME					 NOT NULL on update current_timestamp
);

CREATE USER taskDB_user@localhost IDENTIFIED BY 'sesame';
GRANT SELECT, INSERT, DELETE, UPDATE ON taskDB.* TO taskDB_user@localhost;