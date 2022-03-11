set names utf8mb4;
set charset utf8mb4;
drop database if exists todoapp;
create database todoapp charset utf8mb4;
use todoapp;

create table users (
  id int unsigned not null auto_increment primary key,
  email varchar(100) not null,
`password` varchar(255) not null);

create table todoitems (
	id int unsigned not null auto_increment primary key,
    itemDescription varchar(100) not null,
    itemDone boolean default 0,
    userId int unsigned not null,
    constraint itemsUsers foreign key(userId) references users(id)
);

create user if not exists fedei91 identified by 'fedei91';
grant select,insert on users to fedei91;
grant select,insert,update on todoitems to fedei91;