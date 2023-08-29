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

-- DELETE (DML-D)
delete from pet where name='송코코';

-- Load Data
load data local infile 'C:\Dev\pet.txt' into table pet;

update pet set death = null where death = '0000-00-00';

-- select 연습
-- 문제1. bowser의 주인 이름은?
select owner from pet where name='bowser';

-- 문제2. 1998년 이후에 태어난 동물 리스트
select * from pet where birth>='1998-01-01';

-- 문제3. 종이 뱀이거나 새인 동물 리스트
select *from pet where species='snake' or species='bird';

-- 문제4. order by ~ (asc/desc)
select name, birth from pet order by birth asc;

-- 문제5. where 절에 null 다루기 
select name, birth, death from pet where death is not null;

-- 문제6. like 검색 (패턴검색)
select name from pet where name like 'b%';
select name from pet where name like '%fy';
select name from pet where name like '%w%';

-- 문제7. 이름이 5글자인 동물
select name from pet where name like '_____';		
select name from pet where name like 'b_____';

-- 문제8. 집계 : count, avg, sum, max, min ... 
select count(*) from pet;	
select max(birth) from pet;






