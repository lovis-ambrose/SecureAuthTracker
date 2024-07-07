/*
 *--- General Rules ---
 * Use underscore names instead of camel case
 * Table names should be plural
 * Spell out id fields (item_id as opposed to id)
 * Use Uppercase for all SQL queries
 * Don't use ambiguous column names
 * Name foreign key columns the same as the columns they refer to
 */

CREATE SCHEMA IF NOT EXISTS secureAuth;
SET NAMES 'UTF8MB4';
SET TIME_ZONE = '+03:00';

USE secureAuth;
# Users Table
DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) DEFAULT NULL,
    address VARCHAR(255) DEFAULT NULL,
    phone VARCHAR(30) DEFAULT NULL,
    title VARCHAR(50) DEFAULT NULL,
    bio VARCHAR(255) DEFAULT NULL,
    date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
    enabled BOOLEAN DEFAULT FALSE,
    non_locked BOOLEAN DEFAULT TRUE,
    using_mfa BOOLEAN DEFAULT FALSE,
    image_url VARCHAR(255) DEFAULT 'https://www.flaticon.com/free-icon/user_149071',
    CONSTRAINT UQ_Users_Email UNIQUE (email)
);


# Roles Table
DROP TABLE IF EXISTS Roles;
CREATE TABLE Roles (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    permission VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Roles_Name UNIQUE (name)
);


# UserRoles Table
DROP TABLE IF EXISTS UserRoles;
CREATE TABLE UserRoles (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    role_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES Roles (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT UQ_UQ_Roles_User_id UNIQUE (user_id)
);


# User Activities Table
DROP TABLE IF EXISTS Roles;
CREATE TABLE Roles (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    permission VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Roles_Name UNIQUE (name)
);