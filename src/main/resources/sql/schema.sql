create table if not exists users (
    id varchar(3) primary key not null,
    name varchar(256) not null,
    location varchar(2) not null
);

create table if not exists jobs (
    id varchar(3) primary key not null,
    company varchar(256) not null,
    location varchar(2) not null,
    job_title varchar(256) not null
    );

create type position_type as enum ('Internship', 'Coop', 'FullTime', 'PartTime');

create table if not exists job_types (
    job_id varchar(3) not null,
    job_type position_type,
    primary key (job_id, job_type),
    foreign key (job_id) references jobs(id)
);