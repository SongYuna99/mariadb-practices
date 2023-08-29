SELECT VERSION(), CURRENT_DATE(), NOW() FROM DUAL;

-- 수학 함수도 사용할 수 있다. (사칙연산도 가능)
SELECT SIN(PI() / 4) FROM DUAL;

-- 대소문자를 구분하지 않는다.
sELECT VERSIoN(), CURRENT_DAte(), NOW() FROM DuAL;

-- 테이블 생성 (DDL)
CREATE TABLE pet (
    name VARCHAR(100),
    owner VARCHAR(20),
    species VARCHAR(20),
    gender CHAR(1),
    birth DATE,
    death DATE
);

-- schema
show tables;
describe pet;		-- desc pet;

-- 테이블 삭제 (DDL)
drop table pet;

-- INSERT (DML-C)
insert into pet values('코코', '송유나', 'dog', 'm', '2021-09-21', null);

-- SELECT (DML-R)
select * from pet;

-- UPDATE (DML-U)
update pet set name='송코코' where name='코코';



