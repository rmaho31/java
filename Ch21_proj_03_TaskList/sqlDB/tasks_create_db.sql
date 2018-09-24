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
	DateCompleted			DATETIME					 on update current_timestamp
);

insert into tasks (Task, CompleteBy)
values
("Get groceries", "2018-12-31 23:59:59"),
("Train for marathon", "2018-9-29 12:00:00"),
("Cut the grass", "2018-9-24 12:00:00"),
("Learn to play the piano", "2048-12-31 22:00:00");


CREATE USER taskDB_user@localhost IDENTIFIED BY 'sesame';
GRANT SELECT, INSERT, DELETE, UPDATE ON taskDB.* TO taskDB_user@localhost;