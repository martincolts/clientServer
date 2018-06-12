--drop table if exists customer cascade ;
--drop table if exists sale cascade ;
--drop table if exists quota cascade ;
--drop if exists sequence customer_sequence ;
--drop if exists sequence sale_sequence ;
--drop if exists sequence quota_sequence ;  

CREATE SEQUENCE if not exists customer_sequence start with 1;
CREATE SEQUENCE if not exists sale_sequence start with 1;
CREATE SEQUENCE if not exists quota_sequence start with 1;
CREATE SEQUENCE if not exists app_user_sequence start with 1;

create table if not exists customer (
  id numeric not null,
  name varchar(32) not null,
  lastname varchar(32) not null,
  phone_number varchar (32) ,
  dni varchar(12) not null unique,
  address varchar(32)
);

alter table customer add constraint customer_pk PRIMARY KEY (id);


create table if not exists sale (
  id numeric not null,
  sale_date date not null,
  customer_id numeric,
  fees numeric not null,
  product varchar(32) not null,
  amount numeric(10,2) not null
);

alter table sale add CONSTRAINT sale_pk PRIMARY KEY (id);
alter table sale add CONSTRAINT customer_sale_fk FOREIGN KEY (customer_id) references customer(id) on delete set null;

create table if not exists quota (
  id numeric not NULL ,
  due_date DATE not null,
  paid_out boolean default false, 
  amount numeric (10,2) not null,
  sale_id numeric not null
);

alter table quota add CONSTRAINT quota_pk PRIMARY KEY (id);
alter table quota add constraint sale_quota_fk FOREIGN KEY (sale_id) REFERENCES sale (id);

create table if not exists application_user (
  id numeric not null ,
  username varchar(250) not null,
  password varchar(250) not null
);

alter table user add CONSTRAINT  user_pk PRIMARY KEY (id);