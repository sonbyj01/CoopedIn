create table if not exists users (
    id varchar(3) primary key not null,
    name varchar(256) not null,
    location varchar(2) not null
);