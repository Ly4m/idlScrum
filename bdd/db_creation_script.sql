create table SCRUM_USER (
  usr_id serial primary key,
  usr_login varchar(60) unique,
  usr_password varchar(60)
);

create table TASK (
   tsk_id serial primary key,
   tsk_name varchar(60) not null,
   tsk_description varchar(1024),
   tsk_id_usr integer references SCRUM_USER (usr_id),
   tsk_id_str integer REFERENCES STORIES (str_id),
   tsk_id_state integer not null
);

create table TEST (
  tst_id serial primary key,
  tst_name varchar(128) not null,
  tst_validate boolean default false not null
);

create table ASSOCIATION (
  ass_id serial primary key,
  ass_id_tsk Integer not null references TASK (tsk_id),
  ass_id_tst Integer not null references TEST (tst_id)
);

create table STORIES(
	str_id serial primary key,
	str_text	VARCHAR(140) NOT NULL
);
