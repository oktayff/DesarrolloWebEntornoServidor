SET GLOBAL time_zone = '+3:00';

create database cine;

use cine;

create table pelicula(
director varchar(128) NOT NULL,
titulo varchar(128) PRIMARY KEY NOT NULL,
fecha varchar(128));

insert into pelicula values ("oktay", "peli1", "8-12-2019");

drop table pelicula;

select * from pelicula;


create table user(
username varchar(128) PRIMARY KEY NOT NULL,
password varchar(128) NOT NULL);

select * from user;

insert into user values ("oktayff", "123");

drop table user;
