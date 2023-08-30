-- 
-- 문자열 함수
--

-- upper
select upper('seoul') as upper, ucase('seOuL') as ucase from dual;
select upper(first_name) from employees;

-- lower
select lower('SEOUL'), lcase('SEOul') from dual;
select lower(first_name) from employees;

-- substring(문자열, index, length)
select substring('Hello World', 3, 5) from dual; 
select first_name, hire_date from employees
where substring(hire_date, 1, 4) = '1989';

-- lpad, rpad : 정렬함수 
select lpad('1234', 10, '-'), rpad('1234', 10, '-') from dual;
select lpad('1234', 10, 'helloworld') from dual;
-- 예제 : 직원들의 월급을 오른쪽 정렬
select lpad(salary, 10, ' ') salary from salaries;








