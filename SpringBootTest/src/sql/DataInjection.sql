USE `temp`;

insert into ROLES (ROLE_NAME) values ('admin');
insert into ROLES (ROLE_NAME) values ('user');

insert into USERS (USER_NAME, LOGIN, PSWD) values ('System_Programmer', 'sysprog', 'sysprog');
insert into USERS (USER_NAME, LOGIN, PSWD) values ('Admin', 'admin', 'admin');
insert into USERS (USER_NAME, LOGIN, PSWD) values ('PlainUser', 'user', 'user');
insert into USERS (USER_NAME, LOGIN, PSWD) values ('QwertyUser', 'qwerty', 'qwerty');

insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('1', '1');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('2', '1');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('3', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('4', '2');

insert into USER_STATISTIC (USER_STATISTIC_ID) values ('1');
insert into USER_STATISTIC (USER_STATISTIC_ID) values ('2');
insert into USER_STATISTIC (USER_STATISTIC_ID) values ('3');
insert into USER_STATISTIC (USER_STATISTIC_ID) values ('4');

insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA) values ('tests.label', 'ru', '"NJCERFGBPLW!');