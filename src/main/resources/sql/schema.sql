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


create table if not exists companies (
    company_id varchar(3) not null,
    company_name varchar(256) not null
    );

insert into companies(company_name, company_id) values ('Adobe', 'C1');
insert into companies(company_name, company_id) values ('Qualcomm', 'C2');
insert into companies(company_name, company_id) values ('Peloton', 'C3');
insert into companies(company_name, company_id) values ('Facebook', 'C4');
insert into companies(company_name, company_id) values ('Apple', 'C5');
insert into companies(company_name, company_id) values ('NVIDIA', 'C6');



insert into jobs(id, company, location, job_title) values ('1', 'Adobe', 'NY', 'Engineer');
insert into jobs(id, company, location, job_title) values ('2', 'Qualcomm', 'NJ', 'FPGA Developer');
insert into jobs(id, company, location, job_title) values ('3', 'Peloton', 'NY', 'Backend Engineer');
insert into jobs(id, company, location, job_title) values ('4', 'Facebook', 'NY', 'Scrum Master');
insert into jobs(id, company, location, job_title) values ('5', 'Apple', 'NY', 'Graphics Designer');
insert into jobs(id, company, location, job_title) values ('6', 'NVIDIA', 'NJ', 'ML Engineer');
insert into jobs(id, company, location, job_title) values ('7', 'NVIDIA', 'NJ', 'Accountant');
insert into jobs(id, company, location, job_title) values ('8', 'NVIDIA', 'NJ', 'Lawyer');

insert into job_types(job_id, job_type) values ('1', 'FullTime');
insert into job_types(job_id, job_type) values ('2', 'FullTime');
insert into job_types(job_id, job_type) values ('3', 'Internship');
insert into job_types(job_id, job_type) values ('4', 'PartTime');
insert into job_types(job_id, job_type) values ('5', 'FullTime');
insert into job_types(job_id, job_type) values ('6', 'FullTime');
insert into job_types(job_id, job_type) values ('7', 'FullTime');
insert into job_types(job_id, job_type) values ('8', 'FullTime');


/*select id, company, location, job_title from jobs j left join job_types jt on j.id = jt.job_id where j.id = '2';*/
select id, company, location, job_title from jobs j left join job_types jt on j.id = jt.job_id where j.company = 'NVIDIA';
select id, company, location, job_title from jobs j left join job_types jt on j.id where j.company = 'NVIDIA';

select * from jobs where jobs.company = 'Adobe';

select id, company, location, job_title, true as available, jt.job_type from jobs j left join job_types jt on j.id = jt.job_id where j.company = 'NVIDA';

select id, company, location, job_title, true as available, jt.job_type from jobs j left join job_types jt on j.id = jt.job_id where j.location = 'NY';

select id, company, location, job_title, true as available from jobs j left join companies c on j.company = c.company_name where j.company = 'Adobe';

select id, company, location, job_title, true as available, jt.job_type from jobs j left join companies c on j.company = c.company_name left join job_types jt on j.id = jt.job_id where c.company_name = 'NVIDIA';

select * from jobs j left join job_types jt on j.id = jt.job_id where company = 'NVIDIA';

select id, company, location, job_title, true as available, jt.job_type from jobs j left join job_types jt on j.id = jt.job_id where j.company = 'NVIDIA';

/*drop table companies;*/

select * from companies where company_name = 'NVIDIA';

