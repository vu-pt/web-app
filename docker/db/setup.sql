create database test_db character set utf8mb4 collate utf8mb4_bin;
create user test@'%' identified by 'test';
create user test@'localhost' identified by 'test';
GRANT ALL PRIVILEGES ON test_db.* TO 'test'@'%' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON test_db.* TO 'test'@'localhost' IDENTIFIED BY 'test';
FLUSH PRIVILEGES;
set names utf8mb4;
use test_db;

create table twat_user
(
    `id`        int not null auto_increment,
    `username`  varchar(50) not null,
    `password`  varchar(255) not null,
    `email`     varchar(255) not null,
    `fullname`  varchar(255) not null,
    `last_login` timestamp null,
    `status`    boolean not null default 1,
    `cre_ts`    timestamp not null default current_timestamp,
    `cre_uid`   varchar(50) not null default 'system',
    `mod_ts`    timestamp null,
    `mod_uid`   varchar(50) null,
    primary key (id),
    constraint `twat_user_username_un` unique (`username`),
    constraint `twat_user_email_un` unique (`email`)
);

CREATE TABLE twat_role (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE twat_user_role (
    `id`        int not null auto_increment,
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    constraint `twat_user_role_un` unique (`user_id`, `role_id`),
    CONSTRAINT `fk_ur_user_id`
    FOREIGN KEY (user_id) REFERENCES twat_user (id)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
    CONSTRAINT `fk_ur_role_id`
    FOREIGN KEY (role_id) REFERENCES twat_role (id)
);