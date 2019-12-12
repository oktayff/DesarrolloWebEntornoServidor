SET GLOBAL time_zone = '+3:00';

create database cine;

use cine;

create table pelicula(
director varchar(128) NOT NULL,
titulo varchar(128) PRIMARY KEY NOT NULL,
fecha varchar(128));

create table user(
username varchar(128) PRIMARY KEY NOT NULL,
password varchar(128) NOT NULL);

insert into pelicula values ("oktay", "peli1", "8-12-2019");

insert into user values ("oktayff", "123");