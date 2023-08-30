-- 집계(통계) SQL 문제입니다.

-- 문제 1. 
-- 최고임금(salary)과  최저임금을 “최고임금, “최저임금”프로젝션 타이틀로 함께 출력해 보세요. 
-- 두 임금의 차이는 얼마인가요? 함께 “최고임금 – 최저임금”이란 타이틀로 출력해 보세요.
SELECT MAX(salary) AS '최고임금', MIN(salary) AS '최저임금', 
			(MAX(salary) - MIN(salary)) AS '최고임금 - 최저임금' 
FROM salaries;

-- 문제2.
-- 마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
SELECT DATE_FORMAT(hire_date,'%Y년 %m월 %d일') AS '입사일' 
FROM employees 
ORDER BY hire_date DESC 
LIMIT 0, 1;

-- 문제3.
-- 가장 오래 근속한 직원의 입사일은 언제인가요? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
select from_date as '입사일' from salaries 
group by emp_no
order by sum(to_date-from_date) desc limit 0,1;

-- 문제4.
-- 현재 이 회사의 평균 연봉은 얼마입니까?
select avg(salary) as '평균 연봉' from salaries;

-- 문제5.
-- 현재 이 회사의 최고/최저 연봉은 얼마입니까?
select max(salary) as '최고 연봉', min(salary) as '최저 연봉' from salaries
where to_date='9999-01-01';

-- 문제6.
-- 최고 어린 사원의 나이와 최 연장자의 나이는?
select max(year(curdate())-year(birth_date)) as '최연장자', 
		min(year(curdate())-year(birth_date)) as '최연소' 
from employees;