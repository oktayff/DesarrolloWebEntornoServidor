create database cine;

use cine;

create table pelicula(
id varchar(128) PRIMARY KEY,
director varchar(128) NOT NULL,
titulo varchar(128) NOT NULL,
fecha datetime NOT NULL);

insert into pelicula values ("1", "Oktay", "Pelicula1", '2019-11-21 14:00:00');

create table admin(
username varchar(128),
password varchar(128) PRIMARY KEY);

insert into admin values ("oktay", "1245");
