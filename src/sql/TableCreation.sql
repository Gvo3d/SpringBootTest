DROP DATABASE IF EXISTS `temp`;
CREATE DATABASE `temp` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `temp`;


DROP TABLE IF EXISTS `USER_STATISTIC`;
CREATE TABLE USER_STATISTIC (
    US_ID BIGINT NOT NULL AUTO_INCREMENT,
    US_CREATED TIMESTAMP NOT NULL DEFAULT NOW(),
    US_VIEWED_COUNT BIGINT NOT NULL DEFAULT 0,
    UNIQUE UNIQUE_USER_STATISTIC (US_ID),
    PRIMARY KEY (US_ID)
    );

DROP TABLE IF EXISTS `USERS`;
CREATE TABLE USERS (
    USER_ID BIGINT NOT NULL AUTO_INCREMENT,
    USER_NAME VARCHAR(60) NOT NULL,
    LOGIN VARCHAR(20) NOT NULL,
    PSWD VARCHAR(20) NOT NULL,
    USER_ENABLED BIT NOT NULL DEFAULT 1,
    USER_US_ID BIGINT NOT NULL,
    UNIQUE UNIQUE_USER_ID (USER_ID),
    UNIQUE UNIQUE_USER_LOGIN (LOGIN),
    UNIQUE UNIQUE_USER_NAME (USER_NAME),
    FOREIGN KEY(USER_US_ID) REFERENCES USER_STATISTIC(US_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (USER_ID)
    );

DROP TABLE IF EXISTS `ROLES`;
CREATE TABLE ROLES (
    ROLE_ID INT NOT NULL AUTO_INCREMENT,
    ROLE_NAME VARCHAR(20) NOT NULL,
    UNIQUE UNIQUE_ROLE_ID (ROLE_ID),
    PRIMARY KEY (ROLE_ID)
    );

DROP TABLE IF EXISTS `USER_ROLES`;
CREATE TABLE USER_ROLES (
    UR_USER_ID BIGINT NOT NULL,
    UR_ROLE_ID INT NOT NULL,
    UR_CREATED TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE UNIQUE_USER_ROLES (UR_USER_ID, UR_ROLE_ID),
    FOREIGN KEY(UR_USER_ID) REFERENCES USERS(USER_ID) ON DELETE CASCADE,
    FOREIGN KEY(UR_ROLE_ID) REFERENCES ROLES(ROLE_ID) ON DELETE CASCADE
    );

DROP TABLE IF EXISTS `INTERNATIONAL_MESSAGES`;
CREATE TABLE INTERNATIONAL_MESSAGES (
    INTERNATIONAL_MESSAGES_ID BIGINT NOT NULL AUTO_INCREMENT,
    IM_CODE VARCHAR(40) NOT NULL,
    IM_LOCALE VARCHAR(15) NOT NULL,
    IM_DATA TEXT NOT NULL,
    UNIQUE UNIQUE_INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE),
    PRIMARY KEY (INTERNATIONAL_MESSAGES_ID)
);