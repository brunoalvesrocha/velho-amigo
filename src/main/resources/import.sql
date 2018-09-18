insert into APP_USER(IDENT_USER, PASSWORD, USERNAME) values(UUID(), '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'bruno@velhoamigo.com.br');
insert into USER_ROLE(APP_USER_ID, ROLE) values((SELECT IDENT_USER FROM APP_USER WHERE USERNAME = 'bruno@velhoamigo.com.br'), 'ADMIN');
insert into USER_ROLE(APP_USER_ID, ROLE) values((SELECT IDENT_USER FROM APP_USER WHERE USERNAME = 'bruno@velhoamigo.com.br'), 'USER');

insert into APP_USER(IDENT_USER, PASSWORD, USERNAME) values(UUID(), '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'chico@velhoamigo.com.br');
insert into USER_ROLE(APP_USER_ID, ROLE) values((SELECT IDENT_USER FROM APP_USER WHERE USERNAME = 'chico@velhoamigo.com.br'), 'ADMIN');
insert into USER_ROLE(APP_USER_ID, ROLE) values((SELECT IDENT_USER FROM APP_USER WHERE USERNAME = 'chico@velhoamigo.com.br'), 'USER');

insert into APP_USER(IDENT_USER, PASSWORD, USERNAME) values(UUID(), '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'celso@velhoamigo.com.br');
insert into USER_ROLE(APP_USER_ID, ROLE) values((SELECT IDENT_USER FROM APP_USER WHERE USERNAME = 'celso@velhoamigo.com.br'), 'ADMIN');
insert into USER_ROLE(APP_USER_ID, ROLE) values((SELECT IDENT_USER FROM APP_USER WHERE USERNAME = 'celso@velhoamigo.com.br'), 'USER');