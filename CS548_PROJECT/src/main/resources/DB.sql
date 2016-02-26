DROP SCHEMA IF EXISTS `airdb`;
CREATE SCHEMA  airdb;
use airdb;


CREATE TABLE airdb.location (
	ID INT(3) NOT NULL AUTO_INCREMENT,
	CODE VARCHAR(5) NOT NULL,
	NAME VARCHAR(64) NOT NULL,
	CITY VARCHAR(64) NOT NULL,
	COUNTRY VARCHAR(10) NOT NULL,
	PRIMARY KEY (ID)
);
CREATE table airdb.deals (
id int(3),
location_code varchar(5),
price int(11),
discount int(11),
event varchar(256),
date varchar(256),
place varchar(256),
deal_id int(11) primary key auto_increment);

Create table airdb.events (
id int(3) primary key auto_increment,
eventName varchar(255),
eventType varchar(255),
eventArea varchar(255),
eventDate varchar(10),
duration int(2),
location_id int(11),
eventPrice float,
eventCapacity int(11));

Create table airdb.user (
user_id int(11) primary key auto_increment,
username varchar(32),
password varchar(40),
first_name varchar(32),
last_name varchar(32),
gender varchar(1),
birthdate varchar(10),
picture varchar(32),
join_date datetime default current_timestamp);

drop table airdb.user_event
create table airdb.user_event (
id int not null auto_increment PRIMARY KEY,
user_id int,
event_id int,
deal_id int);

insert into airdb.location values (2,'JFK','John F Kennedy Intl','New York', 'USA');
insert into airdb.location values (3,'LHR','London Heathrow','London', 'UK');

insert into airdb.events(eventName,eventType,eventArea,eventDate,duration,location_id,eventPrice,eventCapacity)
Values ("Hadoop Basics","SEMINAR","CLOUD,HADOOP,BIGDATA","23-09-2015",6,3,120,5);
insert into airdb.events(eventName,eventType,eventArea,eventDate,duration,location_id,eventPrice,eventCapacity)
Values ("INTERNET OF THINGS","CONFERENCE","IT","25-12-2015",4,2,489,40);
insert into airdb.events(eventName,eventType,eventArea,eventDate,duration,location_id,eventPrice,eventCapacity)
Values ("CLOUDERA  CD420","TRAINING","CLOUD,HADOOP,IT","15-01-2016",2,3,239,20);

insert into airdb.deals (ID,location_code,Price,Discount,Event,Dates,Place)
values(2,"LHR",20,15,"Churchill Remembrance Day","2016-07-10","IT");
insert into airdb.deals (ID,location_code,Price,Discount,Event,Dates,Place)
values(3,"SFO",25,35,"CHRISTMAS DEAL","2016-01-10","CLOUD");

INSERT INTO airdb.USER VALUES (1, 'peter', 'abc',  'Peter', 'Paul', 'M', '1980-01-01', 'Peter-Paul.jpg', now());
INSERT INTO airdb.USER VALUES (2, 'nancy', 'abc',  'Nancy', 'Clark', 'F', '1980-02-02', 'Nancy-Clark.jpg', now());
INSERT INTO airdb.USER VALUES (3, 'jones', 'abc',  'Jones', 'Wang', 'M', '1980-03-03', 'Jones-Wang.jpg', now());

insert into airdb.USER_event values (1,1,2,3);
insert into airdb.USER_event values (2,4,2,2);

