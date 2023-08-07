#创建库
create database school;

use school;

CREATE table Student(
    sid int primary key auto_increment,
    sname varchar(50),
    spwd varchar(50)
);