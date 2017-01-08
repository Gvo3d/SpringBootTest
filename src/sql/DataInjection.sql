USE `temp`;

insert into ROLES (ROLE_NAME) values ('USER');
insert into ROLES (ROLE_NAME) values ('ADMIN');

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
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.emptyField', 'ru', 'Поле не должно быть пустым', 'Форма логина - проверка на пустое поле');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.outOfBounds', 'ru', 'Количество символов логина должно быть от 6 до 32', 'Форма логина - проверка на логин');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.passOutOfBounds', 'ru', 'Количество символов пароля должно быть от 8 до 32', 'Форма логина - проверка на пароль');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.loginError', 'ru', 'Логин/пароль не найден', 'Форма логина - проверка на несовпадение данных с БД');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('userCreation.alreadyExist', 'ru', 'Такой пользователь уже существует', 'Форма создания пользователя - проверка на занятость логина');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('userCreation.passwordConfirmFalse', 'ru', 'Поля пароль и подтверждение пароля не совпадают', 'Форма создания пользователя - проверка на совпадение двух паролей');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractAccessDecisionManager.accessDenied', 'ru', 'Вход запрещён', 'Spring Message - 403 (Access denied)');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractUserDetailsAuthenticationProvider.onlySupports', 'ru', 'Only UsernamePasswordAuthenticationToken is supported', 'Special Spring Error Message');