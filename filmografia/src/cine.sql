SET GLOBAL time_zone = '+3:00';

create database cine;

use cine;

create table pelicula(
id varchar(128) PRIMARY KEY,
director varchar(128) NOT NULL,
titulo varchar(128) NOT NULL,
fecha datetime NOT NULL);

insert into pelicula values ("1", "Oktay", "Pelicula1", '2019-11-21 14:00:00');

insert into pelicula values ("2", "Oktay", "Pelicula2", '2019-11-23 16:40:00');

insert into pelicula values ("3", "Oktay", "Pelicula3", '2019-11-23 16:40:00');

insert into pelicula values ("4", "Juan", "Pelicula4", '2019-11-23 16:40:00');

select * from pelicula;

create table user(
username varchar(128) PRIMARY KEY,
password varchar(128));

drop table user;

insert into user values ("oktayff", "12345");

insert into user values ("juan", "123456");