create table TASK (
   tsk_id serial primary key,
   tsk_name varchar(60) not null,
   tsk_description varchar(1024)
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
