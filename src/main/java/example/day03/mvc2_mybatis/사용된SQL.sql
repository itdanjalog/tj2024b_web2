drop database if exists springweb;
create database springweb;
use springweb;
create table user(
	id int auto_increment,
    name varchar(100),
    age int ,
    constraint primary key(id)
);
