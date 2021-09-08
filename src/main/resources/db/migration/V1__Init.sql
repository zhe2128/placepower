create table USER
(
    ID       BIGINT auto_increment,
    USERNAME CHARACTER(20) not null,
    constraint USER_PK
        primary key (ID)
);

comment
on table USER is 'Пользователи';

create unique index USER_ID_UINDEX
    on USER (ID);

create unique index USER_USERNAME_UINDEX
    on USER (USERNAME);

create table MESSAGE
(
    ID        BIGINT auto_increment,
    TEXT      TEXT      not null,
    USER_ID   BIGINT    not null,
    DATE_TIME TIMESTAMP not null,
    constraint MESSAGE_USER_ID_FK
        foreign key (USER_ID) references USER (ID)
);

comment
on table MESSAGE is 'Сообщения';

create unique index MESSAGE_ID_UINDEX
    on MESSAGE (ID);

alter table MESSAGE
    add constraint MESSAGE_PK
        primary key (ID);

