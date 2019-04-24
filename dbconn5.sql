DROP DATABASE IF EXISTS dbconn5;
CREATE DATABASE dbconn5;
USE dbconn5;

CREATE TABLE Users(
	userID int(4) ZEROFILL AUTO_INCREMENT NOT NULL,
	userName varchar(25) DEFAULT 'Admin',
	password varchar(25) DEFAULT 'password',
	role ENUM("Student", "Faculty") NOT NULL,
	PRIMARY KEY (userID)
);

CREATE TABLE Faculty(
	userID int,
	facName varchar(25),
	departmentCode char(3),
	topicCode char(4),
	interviewID int,
	presentationID int,
	PRIMARY KEY (userID),
	CONSTRAINT FK_DepartmentCode FOREIGN KEY (departmentCode) REFERENCES Department(departmentCode),
	CONSTRAINT FK_UserID FOREIGN KEY (userID) REFERENCES Users(userID),
	CONSTRAINT FK_InterviewID FOREIGN KEY (interviewID) REFERENCES Interview(interviewID),
	CONSTRAINT FK_PresentationID FOREIGN KEY (presentationID) REFERENCES Presentation(presentationID),
    UNIQUE (facName)
);

CREATE TABLE Student(
	userID int,
	studName varchar(25),
	email varchar(35),
	topicID int,
	PRIMARY KEY (userID),
	FOREIGN KEY (userID) REFERENCES Users(userID),
            FOREIGN KEY (topicID) REFERENCES Topic(topicID)
);

CREATE TABLE  Department(
	departmentID int,
	departmentName varchar(25),
	departmentCode char(3),
	PRIMARY KEY(departmentID),
    UNIQUE (departmentCode)
);

CREATE TABLE  Topic(
	topicID int AUTO_INCREMENT,
	topicName varchar(25),
	facID int,
	tags char(4),
	topicDescription varchar(250),
	PRIMARY KEY (topicID),
	FOREIGN KEY (facID) REFERENCES Faculty(facID)
);

CREATE TABLE  Interview(
	interviewID int AUTO_INCREMENT,
	interviewName varchar(25),
	interviewDate date,
	facName varchar(25),
	PRIMARY KEY(interviewID),
	FOREIGN KEY (facName) REFERENCES Faculty(facName)
);

CREATE TABLE  Presentation(
	presentationID int AUTO_INCREMENT,
	presentationName varchar(25),
	presentationDate date,
	facName varchar(25),
	PRIMARY KEY(presentationID),
	FOREIGN KEY (facName) REFERENCES Faculty(facName)
);