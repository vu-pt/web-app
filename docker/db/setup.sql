create database test_db character set utf8mb4 collate utf8mb4_bin;
create user test@'%' identified by 'test';
create user test@'localhost' identified by 'test';
GRANT ALL PRIVILEGES ON test_db.* TO 'test'@'%' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON test_db.* TO 'test'@'localhost' IDENTIFIED BY 'test';
FLUSH PRIVILEGES;
set names utf8mb4;
use test_db;
