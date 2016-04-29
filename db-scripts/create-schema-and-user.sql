create schema car-rental-system;

CREATE USER 'administrator'@'localhost' IDENTIFIED BY 'administrator';

GRANT ALL PRIVILEGES ON *.* TO 'administrator'@'localhost' IDENTIFIED BY 'administrator' WITH GRANT OPTION;
FLUSH PRIVILEGES;

create table car(
	brand varchar(30) not null,
	name varchar(30) not null,
	plate varchar(10) not null,
	model varchar(15) not null,
	borrowed boolean not null,
	id int not null auto_increment,
	primary key(id)
);

create table customer(
	name varchar(30) not null,
	surname varchar(30) not null,
	cpf varchar(30) not null,
	cel varchar(15) not null,
	id int not null auto_increment,
	primary key(id)
);