drop table customer cascade ;
drop table sale cascade ;
drop table quota cascade ;
drop sequence customer_sequence ;
drop sequence sale_sequence ;
drop sequence quota_sequence ;  

CREATE SEQUENCE if not exists customer_sequence start with 1;
CREATE SEQUENCE if not exists sale_sequence start with 1;
CREATE SEQUENCE if not exists quota_sequence start with 1;

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
alter table sale add CONSTRAINT customer_sale_fk FOREIGN KEY (customer_id) references customer(id) on update set null;

create table if not exists quota (
  id numeric not NULL ,
  due_date DATE not null,
  amount numeric (10,2) not null,
  sale_id numeric not null
);

alter table quota add CONSTRAINT quota_pk PRIMARY KEY (id);
alter table quota add constraint sale_quota_fk FOREIGN KEY (sale_id) REFERENCES sale (id);