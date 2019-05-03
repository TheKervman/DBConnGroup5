-- -------------------------------------------------
-- Create and Use the Database
-- -------------------------------------------------
DROP DATABASE IF EXISTS dbconn5;
CREATE DATABASE dbconn5;
USE dbconn5;
-- -------------------------------------------------
-- Create Tables
-- -------------------------------------------------
-- Create Users
CREATE TABLE Users(
	userID int(4) ZEROFILL AUTO_INCREMENT NOT NULL,
	userName varchar(25) DEFAULT 'Admin',
	password varchar(25) DEFAULT 'password',
	role ENUM("Student", "Faculty") NOT NULL,
	PRIMARY KEY (userID)
);
-- Create Faculty
CREATE TABLE Faculty(
	facID int(4) ZEROFILL,
	facName varchar(25),
	departmentCode varchar(3),
	PRIMARY KEY (facID)
);
-- Create Student
CREATE TABLE Student(
	studID int(4) ZEROFILL,
   topicOne varchar(25),
   topicTwo varchar(25),
   topicThree varchar(25),
	studName varchar(25),
	email varchar(35),
	PRIMARY KEY (studID)
);
-- Create Department
CREATE TABLE Department(
	departmentID int(4) ZEROFILL AUTO_INCREMENT NOT NULL,
	departmentName varchar(50),
	departmentCode varchar(3),
	PRIMARY KEY(departmentID),
    UNIQUE (departmentCode)
);
-- Create Topic
CREATE TABLE Topic(
	topicID int AUTO_INCREMENT,
	topicName varchar(25),
	facID int(4) ZEROFILL,
	topicDescription varchar(250),
	PRIMARY KEY (topicID)
);
-- Create Interview
CREATE TABLE Interview(
	interviewID int AUTO_INCREMENT,
	interviewName varchar(25),
	interviewDate date,
	facID int(4) ZEROFILL,
	PRIMARY KEY(interviewID)
);
-- Create Presentation
CREATE TABLE Presentation(
	presentationID int AUTO_INCREMENT,
	presentationName varchar(25),
	presentationDate date,
	facID int(4) ZEROFILL,
	PRIMARY KEY(presentationID)
);
-- -------------------------------------------------
-- Add Foreign Key Constraints
-- -------------------------------------------------
-- Faculty Constraints
ALTER TABLE Faculty ADD CONSTRAINT FK_Faculty_DepartmentCode FOREIGN KEY (departmentCode) REFERENCES Department(departmentCode);
ALTER TABLE Faculty ADD CONSTRAINT FK_Faculty_UserID FOREIGN KEY (facID) REFERENCES Users(userID);
-- ALTER TABLE Faculty ADD CONSTRAINT FK_InterviewID FOREIGN KEY (interviewID) REFERENCES Interview(interviewID);
-- ALTER TABLE Faculty ADD CONSTRAINT FK_PresentationID FOREIGN KEY (presentationID) REFERENCES Presentation(presentationID);
-- Student Constraints
ALTER TABLE Student ADD CONSTRAINT FK_Student_UserID FOREIGN KEY (studID) REFERENCES Users(userID);
ALTER TABLE Student ADD CONSTRAINT FK_Student_InterestID FOREIGN KEY (interestID) REFERENCES Topic(topicID);
-- Topic Constraint
ALTER TABLE Topic ADD CONSTRAINT FK_Topic_FacID FOREIGN KEY (facID) REFERENCES Faculty(facID);
-- Interview Constraint
ALTER TABLE Interview ADD CONSTRAINT FK_Int_facName FOREIGN KEY (facID) REFERENCES Faculty(facID);
-- Presentation Constraint
ALTER TABLE Presentation ADD CONSTRAINT FK_Pres_facName FOREIGN KEY (facID) REFERENCES Faculty(facID);
-- -------------------------------------------------
-- Populate Users Table
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
-- Populate Department Table
-- -------------------------------------------------
INSERT INTO Department (departmentName, departmentCode) VALUES ('Computer Science', 'CS');
INSERT INTO Department (departmentName, departmentCode) VALUES ('Interactive Games and Media', 'IGM');
INSERT INTO Department (departmentName, departmentCode) VALUES ('Information Sciences and Technologies', 'IST');
-- -------------------------------------------------
-- Populate Faculty Table
-- -------------------------------------------------
INSERT INTO Faculty (facID, facName, departmentCode) VALUES (1, 'Sophia Ga', 'CS');
INSERT INTO Faculty (facID, facName, departmentCode) VALUES (3, 'Harper Waack', 'IGM');
INSERT INTO Faculty (facID, facName, departmentCode) VALUES (4, 'Noel Qadir', 'IST');
INSERT INTO Faculty (facID, facName, departmentCode) VALUES (6, 'Gaagii Vaal', 'CS');
INSERT INTO Faculty (facID, facName, departmentCode) VALUES (9, 'Oakley Saad', 'IGM');
-- -------------------------------------------------
-- Populate Student Table
-- -------------------------------------------------
INSERT INTO Student (studID, studName, email,topicOne,topicTwo,topicThree) VALUES (2, 'Isaac Irving', 'ibi9854@rit.edu','Coding Fun','More Coding Fun','AI');
INSERT INTO Student (studID, studName, email,topicOne,topicTwo,topicThree) VALUES (5, 'Fabia Grayson', 'fig9890@rit.edu', 'Gaming Stuff', 'Action RPGS','FPS');
INSERT INTO Student (studID, studName, email,topicOne,topicTwo,topicThree) VALUES (7, 'Usain Maddox', 'utm6592@rit.edu','Coding Fun','More Coding Fun','AI');
INSERT INTO Student (studID, studName, email,topicOne,topicTwo,topicThree) VALUES (8, 'Lily Tamar', 'ljt7409@rit.edu','Gaming Stuff','Action RPGS','FPS');
INSERT INTO Student (studID, studName, email,topicOne,topicTwo,topicThree) VALUES (10, 'Jabin Kaile', 'jik8373@rit.edu', 'Coding Fun','More Coding Fun','AI');
-- -------------------------------------------------
-- Populate Topic Table
-- -------------------------------------------------
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('Coding Fun', 1, 'Learn how to have fun while coding');
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('Gaming Stuff', 3, 'Meet other gamers in the program');
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('It\'s not that bad', 6, 'Don\'t let the coding get you down, it\'s still fun');
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('More Coding Fun', 1, 'Learn even more fun things');
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('Action RPGS', 3, 'Learn everything about Action Role-Playing Games');
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('FPS', 3, 'Learn everything about FPS Games');
INSERT INTO Topic (topicName, facID, topicDescription) VALUES ('AI', 1, 'Learn everything about AI');




-- -------------------------------------------------
-- Populate Interview Table
-- -------------------------------------------------
INSERT INTO Interview (interviewName, interviewDate, facID) VALUES ('Initial Interview', '2019-08-14', 1);
INSERT INTO Interview (interviewName, interviewDate, facID) VALUES ('Final Interview', '2019-08-17', 1);
INSERT INTO Interview (interviewName, interviewDate, facID) VALUES ('Internship', '2019-06-23', 3);
-- -------------------------------------------------
-- Populate Presentation Table
-- -------------------------------------------------
INSERT INTO Presentation (presentationName, presentationDate, facID) VALUES ('Coding Fun', '2019-05-31', 9);

-- -------------------------------------------------
-- Next Steps
-- -------------------------------------------------
select faculty.facid, faculty.facname, interview.interviewname, interview.interviewdate from faculty join interview on faculty.facid=interview.facid where faculty.facid=1;

select faculty.facid, faculty.facname, presentation.presentationName, presentation.presentationDate from faculty join presentation on faculty.facid=presentation.facid;

update student set interestID = 4 where studID = 7;
select student.studName, student.interestID, topic.topicName, topic.topicDescription from student join topic on student.interestID=topic.topicID;
