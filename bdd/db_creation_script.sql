CREATE TABLE SCRUM_USER (
  usr_id       SERIAL PRIMARY KEY,
  usr_login    VARCHAR(60) UNIQUE,
  usr_password VARCHAR(60)
);

CREATE TABLE TASK (
  tsk_id          SERIAL PRIMARY KEY,
  tsk_name        VARCHAR(60) NOT NULL,
  tsk_description VARCHAR(1024),
  tsk_id_usr      INTEGER REFERENCES SCRUM_USER (usr_id),
  tsk_id_str      INTEGER REFERENCES STORIES (str_id) NOT NULL ,
  tsk_id_state    INTEGER     NOT NULL
);

CREATE TABLE TEST (
  tst_id       SERIAL PRIMARY KEY,
  tst_name     VARCHAR(128)          NOT NULL,
  tst_validate BOOLEAN DEFAULT FALSE NOT NULL
);

CREATE TABLE ASSOCIATION (
  ass_id     SERIAL PRIMARY KEY,
  ass_id_tsk INTEGER NOT NULL REFERENCES TASK (tsk_id),
  ass_id_tst INTEGER NOT NULL REFERENCES TEST (tst_id)
);

CREATE TABLE STORIES (
  str_id   SERIAL PRIMARY KEY,
  str_text VARCHAR(140) NOT NULL
);
