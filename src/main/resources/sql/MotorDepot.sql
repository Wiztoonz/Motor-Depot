create schema MotorDepot collate utf8mb4_0900_ai_ci;

use MotorDepot;

create table Cars
(
	Id int auto_increment,
	Car varchar(40) not null,
	Car_status varchar(40) not null,
	Description varchar(500) null,
	primary key (Id, Car)
);

create table Flights
(
	Flight_number int auto_increment primary key,
	Car_id int not null,
	User_id int not null,
	Description varchar(255) not null,
	Creation_date date not null,
	Status varchar(20) not null,
	constraint Flights_ibfk_1
	foreign key (Car_id) references Cars (Id) on update cascade on delete cascade
);

create index Car_id on Flights (Car_id);

create table Users
(
	Id int auto_increment primary key,
	First_name varchar(60) not null,
	Second_name varchar(60) not null,
	Password varchar(100) not null,
	Email varchar(320) not null,
	Role varchar(20) not null,
	constraint Email unique (Email)
);

create table Request
(
	Id int auto_increment
	primary key,
	Flight_number int not null,
	Car_characteristics varchar(255) not null,
	Creation_date date not null,
	User_id int not null,
	constraint Request_ibfk_1 foreign key (Flight_number) references Flights (Flight_number) on update cascade on delete cascade,
	constraint Request_ibfk_2 foreign key (User_id) references Users (Id)
);

create index Flight_number on Request (Flight_number);

create index User_id on Request (User_id);

INSERT INTO Cars (Car, Car_status, Description) VALUES ("Valkswagen Passat Estate", "B", "Passenger car with trailer"),
						       ("Audi Q3 Sportback", "BE", "Passenger car (up to 3.5 tons)"),
						       ("SCANIA - R380", "CE", "Truck (from 3.5 tons)"),
						       ("RENAULT - T 460", "C", "Small truck (up to 3.5 tons)");


