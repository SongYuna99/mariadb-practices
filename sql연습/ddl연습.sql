-- ddl
CREATE TABLE member (
    no INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(64) NOT NULL,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    PRIMARY KEY (no)
);

desc member;

alter table member add column juminbunho char(13) not null;
alter table member drop column juminbunho;
alter table member add column juminbunho char(13) not null after email;

alter table member change column department dept varchar(200) not null;

alter table member add column self_intro text;

-- 
-- dml
-- 