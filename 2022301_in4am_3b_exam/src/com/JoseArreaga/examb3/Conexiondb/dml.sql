create database if not exists db_kinal_in4am;
use db_kinal_in4am;

create table usuarios(
id_usuario int auto_increment primary key,
nombre_completo varchar(100) not null,
username varchar(50) not null unique,
correo varchar(100) not null unique,
password varchar(50) not null
);