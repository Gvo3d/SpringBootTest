USE `temp`;

insert into ROLES (ROLE_NAME) values ('RoleAdmin');
insert into ROLES (ROLE_NAME) values ('RoleUser');

insert into USER_STATISTIC (US_ID) values ('1');
insert into USER_STATISTIC (US_ID) values ('2');
insert into USER_STATISTIC (US_ID) values ('3');
insert into USER_STATISTIC (US_ID) values ('4');

insert into USERS (USER_NAME, LOGIN, PSWD, USER_US_ID) values ('System_Programmer', 'sysprog', 'sysprog', '1');
insert into USERS (USER_NAME, LOGIN, PSWD, USER_US_ID) values ('Admin', 'admin', 'admin', '2');
insert into USERS (USER_NAME, LOGIN, PSWD, USER_US_ID) values ('PlainUser', 'user', 'user', '3');
insert into USERS (USER_NAME, LOGIN, PSWD, USER_US_ID) values ('QwertyUser', 'qwerty', 'qwerty', '4');

insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('1', '1');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('2', '1');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('3', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('4', '2');



insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA) values ('database.label', 'ru', 'Хуйня');