---- Structure for database `nirmaanam` ----
USE nirmaanam;

CREATE TABLE Activity
(
id INT PRIMARY KEY AUTO_INCREMENT,
name text,
description text,
report text,
head int,
event int
);

CREATE TABLE Activity_assignees(
	activity INT,
	volunteer INT,
	availability INT
);



CREATE TABLE Discussion
(
id INT PRIMARY KEY AUTO_INCREMENT,
title text,
event INT
);

CREATE TABLE Discussion_posts(
	id INT PRIMARY KEY AUTO_INCREMENT,
	discussion INT,
	post text,
	poster INT
);

CREATE TABLE Event
(
id INT PRIMARY KEY AUTO_INCREMENT,
name text,
description text,
vertical INT,
head INT
);

CREATE TABLE EventUpdate
(
id INT PRIMARY KEY AUTO_INCREMENT,
message text,
event int,
timeStamp int
);

CREATE TABLE Meeting
(
id INT PRIMARY KEY AUTO_INCREMENT,
time int,
location text,
purpose text
);


CREATE TABLE Meeting_attendees(
	meeting INT,
	volunteer INT
);


CREATE TABLE Notice
(
id INT PRIMARY KEY AUTO_INCREMENT,
message text,
event int
);

CREATE TABLE TimeTable
(
volunteer INT,
day INT,
starttime INT
);

CREATE TABLE Vertical
(
id INT PRIMARY KEY AUTO_INCREMENT,
name text,
description text,
head int
);

CREATE TABLE Volunteer
(
id INT PRIMARY KEY AUTO_INCREMENT,
name text,
bitsID VARCHAR(12),
vertical int,
email VARCHAR(100),
password CHAR(32)
);
