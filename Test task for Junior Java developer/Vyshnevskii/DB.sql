drop database if exists one;
create database one;

use one;

create table customer(
id bigint,
created bigint,
updated bigint,
full_name varchar(50),
email varchar(100),
phone varchar(14),
is_active bool);

select * from one.customer; 