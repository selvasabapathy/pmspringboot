DROP TABLE IF EXISTS `pm`.`parent_task`;
DROP TABLE IF EXISTS `pm`.`project`;
DROP TABLE IF EXISTS `pm`.`user`;

DROP DATABASE IF EXISTS `pm`;

CREATE DATABASE IF NOT EXISTS `pm`;

USE `pm`;

CREATE TABLE IF NOT EXISTS `pm`.`user` (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    employee_id BIGINT NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    PRIMARY KEY (user_id)
);


CREATE TABLE IF NOT EXISTS `pm`.`project` (
    project_id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    priority INT NOT NULL,
    PRIMARY KEY (project_id)
);

CREATE TABLE IF NOT EXISTS `pm`.`parent_task` (
    parent_task_id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY (parent_task_id)
);