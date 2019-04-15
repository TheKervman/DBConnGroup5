DROP DATABASE IF EXISTS dbconn5;

CREATE DATABASE dbconn5;

CREATE TABLE Users(
	userID int,
	userName varchar(25),
	password varchar(25),
	role varchar(25),
	PRIMARY KEY (userID)
);

CREATE TABLE Faculty(
	facID int,
	facName varchar(25),
	departmentCode char(3),
	topicCode char(4),
	interviewDate date,
	presentationDate date,
	PRIMARY KEY (facID)
);

CREATE TABLE Student(
	studID int,
	studName varchar(25),
	email varchar(35),
	interestID int,
	PRIMARY KEY (studID)
);

CREATE TABLE Guest(

);

CREATE TABLE  Department(
	departmentID int,
	departmentName varchar(25),
	departmentCode char(3),
	PRIMARY KEY(departmentID)
);

CREATE TABLE  Topic(
	topicID int,
	topicName varchar(25),
	facID int,
	tags char(4),
	topicDescription varchar(250),
	PRIMARY KEY(topicID),
	FOREIGN KEY(facID)
);

CREATE TABLE  Interview(
	interviewID int,
	interviewName varchar(25),
	interviewDate date,
	facultyMemeber char(4),
	PRIMARY KEY(interviewID)
);

CREATE TABLE  Presentation(
	presentationID int,
	presentationName varchar(25),
	presentationDate date,
	facultyMemeber char(4),
	PRIMARY KEY(presentationID)
);