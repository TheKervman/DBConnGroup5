-- -------------------------------------------------
-- Create and Use the Database
-- -------------------------------------------------
DROP DATABASE IF EXISTS dbconn5;
CREATE DATABASE dbconn5;
USE dbconn5;
-- -------------------------------------------------
-- Create Tables
-- -------------------------------------------------
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
    UNIQUE (facName)
);

CREATE TABLE Student(
	userID int,
	studName varchar(25),
	email varchar(35),
	topicID int,
	PRIMARY KEY (userID)
);

CREATE TABLE Department(
	departmentID int,
	departmentName varchar(25),
	departmentCode char(3),
	PRIMARY KEY(departmentID),
    UNIQUE (departmentCode)
);

CREATE TABLE Topic(
	topicID int AUTO_INCREMENT,
	topicName varchar(25),
	facID int,
	tags char(4),
	topicDescription varchar(250),
	PRIMARY KEY (topicID)
);

CREATE TABLE Interview(
	interviewID int AUTO_INCREMENT,
	interviewName varchar(25),
	interviewDate date,
	facName varchar(25),
	PRIMARY KEY(interviewID)
);

CREATE TABLE Presentation(
	presentationID int AUTO_INCREMENT,
	presentationName varchar(25),
	presentationDate date,
	facName varchar(25),
	PRIMARY KEY(presentationID)
);
-- -------------------------------------------------
-- Add Foreign Key Constraints
-- -------------------------------------------------
ALTER TABLE Faculty ADD CONSTRAINT FK_Faculty_DepartmentCode FOREIGN KEY (departmentCode) REFERENCES Department(departmentCode);
-- ALTER TABLE Faculty ADD CONSTRAINT FK_Faculty_UserID FOREIGN KEY (userID) REFERENCES Users(userID);
ALTER TABLE Faculty ADD CONSTRAINT FK_InterviewID FOREIGN KEY (interviewID) REFERENCES Interview(interviewID);
ALTER TABLE Faculty ADD CONSTRAINT FK_PresentationID FOREIGN KEY (presentationID) REFERENCES Presentation(presentationID);

-- ALTER TABLE Student ADD CONSTRAINT FK_Student_UserID FOREIGN KEY (userID) REFERENCES Users(userID);
ALTER TABLE Student ADD CONSTRAINT FK_Student_TopicID FOREIGN KEY (topicID) REFERENCES Topic(topicID);

ALTER TABLE Topic ADD CONSTRAINT FK_Topic_FacID FOREIGN KEY (facID) REFERENCES Faculty(userID);

ALTER TABLE Interview ADD CONSTRAINT FK_Int_facName FOREIGN KEY (facName) REFERENCES Faculty(facName);

ALTER TABLE Presentation ADD CONSTRAINT FK_Pres_facName FOREIGN KEY (facName) REFERENCES Faculty(facName);
-- -------------------------------------------------
-- Add Users to Users Table
-- -------------------------------------------------
INSERT INTO Users (userName, password, role) VALUES ('sng3181', 'prosecute0', 'Faculty');
INSERT INTO Users (userName, password, role) VALUES ('ibi9854', 'bless1', 'Student');
INSERT INTO Users (userName, password, role) VALUES ('hgw6419', 'jittery2', 'Faculty');
INSERT INTO Users (userName, password, role) VALUES ('ncq8003', 'yarn3', 'Faculty');
INSERT INTO Users (userName, password, role) VALUES ('fig9890', 'saddie4', 'Student');
INSERT INTO Users (userName, password, role) VALUES ('gyv9272', 'quizzical05', 'Faculty');
INSERT INTO Users (userName, password, role) VALUES ('utm6592', 'amusement06', 'Student');
INSERT INTO Users (userName, password, role) VALUES ('ljt7409', 'rail07', 'Student');
INSERT INTO Users (userName, password, role) VALUES ('oss730i', 'last08', 'Faculty');
INSERT INTO Users (userName, password, role) VALUES ('jik8373', 'bouncy09', 'Student');
-- -------------------------------------------------
-- Populate Faculty Table
-- -------------------------------------------------


-- -------------------------------------------------
-- Populate Student Table
-- -------------------------------------------------


-- -------------------------------------------------
-- Populate Department Table
-- -------------------------------------------------


-- -------------------------------------------------
-- Populate Topic Table
-- -------------------------------------------------


-- -------------------------------------------------
-- Populate Interview Table
-- -------------------------------------------------


-- -------------------------------------------------
-- Populate Presentation Table
-- -------------------------------------------------


-- -------------------------------------------------
-- Next Steps
-- -------------------------------------------------