USE `temp`;

insert into ROLES (ROLE_NAME) values ('USER');
insert into ROLES (ROLE_NAME) values ('ADMIN');

insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('System_Programmer', 'sysprog', '$2a$11$NKNItd8V/02afxJVGhFouefDE3R8YttZ0moUAA0.Grwu.keU7qE32');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('Admin', 'admin', '$2a$11$iXOUawTHBNAswdVWdHF9EuveOseXTB88egGfzBb.9Y.T.96ipQrte');
insert into USERS (FULL_NAME, USER_NAME, PSWD) values ('QwertyUser', 'qwerty', '$2a$11$mYwze2v1YQgcj7kwvXLkOOWgwqwMwimWVaCloEzA0ibfLLEYcgxXm');

insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('1', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('2', '2');
insert into USER_ROLES (UR_USER_ID, UR_ROLE_ID) values ('3', '1');



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