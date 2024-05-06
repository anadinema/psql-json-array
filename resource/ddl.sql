--- Create tables
create table student
(
    id            bigint not null
        constraint pk_student
            primary key,
    name          varchar(255),
    email_address varchar(255),
    status        varchar(255),
    courses_opted json
);

--- Create sequence for id generation
create sequence student_seq;
