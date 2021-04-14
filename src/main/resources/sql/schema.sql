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

insert into jobs(id, company, location, job_title) values ('1', 'Adobe', 'NY', 'Engineer');
insert into jobs(id, company, location, job_title) values ('2', 'Qualcomm', 'NJ', 'FPGA Developer');
insert into jobs(id, company, location, job_title) values ('3', 'Peloton', 'NY', 'Backend Engineer');
insert into jobs(id, company, location, job_title) values ('4', 'Facebook', 'NY', 'Scrum Master');
insert into jobs(id, company, location, job_title) values ('5', 'Apple', 'NY', 'Graphics Designer');
insert into jobs(id, company, location, job_title) values ('6', 'NVIDA', 'NJ', 'ML Engineer');

insert into job_types(job_id, job_type) values ('1', 'FullTime');
insert into job_types(job_id, job_type) values ('2', 'FullTime');
insert into job_types(job_id, job_type) values ('3', 'Internship');
insert into job_types(job_id, job_type) values ('4', 'PartTime');
insert into job_types(job_id, job_type) values ('5', 'FullTime');
insert into job_types(job_id, job_type) values ('6', 'FullTime');