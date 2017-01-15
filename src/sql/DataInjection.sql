USE `temp`;

insert into ROLES (ROLE_NAME) values ('USER');
insert into ROLES (ROLE_NAME) values ('ADMIN');

insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('System_Programmer', 'sysprog', 'sysprog');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('Admin', 'admin', 'admin');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('PlainUser', 'user', 'user');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('QwertyUser', 'qwerty', 'qwerty');

insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('1', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('2', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('3', '1');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('4', '1');



insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA) values ('database.label', 'ru', 'Хуйня');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.emptyField', 'ru', 'Поле не должно быть пустым', 'Форма логина - проверка на пустое поле');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.outOfBounds', 'ru', 'Количество символов логина должно быть от 6 до 32', 'Форма логина - проверка на логин');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.passOutOfBounds', 'ru', 'Количество символов пароля должно быть от 8 до 32', 'Форма логина - проверка на пароль');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('login.loginError', 'ru', 'Логин/пароль не найден', 'Форма логина - проверка на несовпадение данных с БД');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('userCreation.alreadyExist', 'ru', 'Такой пользователь уже существует', 'Форма создания пользователя - проверка на занятость логина');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('userCreation.passwordConfirmFalse', 'ru', 'Поля пароль и подтверждение пароля не совпадают', 'Форма создания пользователя - проверка на совпадение двух паролей');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractAccessDecisionManager.accessDenied', 'ru', 'Вход запрещён', 'Spring Message - 403 (Access denied)');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractUserDetailsAuthenticationProvider.onlySupports', 'ru', 'Only UsernamePasswordAuthenticationToken is supported', 'Special Spring Error Message');
insert into INTERNATIONAL_MESSAGES (IM_CODE, IM_LOCALE, IM_DATA, IM_COMMENT) values ('AbstractUserDetailsAuthenticationProvider.badCredentials', 'ru', 'Login or password is incorrect', 'Ошибка логина/пароля');