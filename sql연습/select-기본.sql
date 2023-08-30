--
-- SELECT 연습 (Limit to 1000 rows)
--

-- 예제 1. departments 테이블의 모든 데이터를 출력
select *from departments;

-- 프로젝션 (projection)
-- 예제 2. employees 테이블에서 직원 이름, 성별, 입사일을 출력
select first_name as 이름, gender as 성별, hire_date as 입사일 from employees;

-- distinct
-- 예제 3. titles 테이블에서 모든 직급을 출력
select title from titles;
-- 예제 4. titles 테이블에서 직급은 어떤 것들이 있는지 이름을 한번씩만 출력
select distinct title from titles;
-- limit 인덱스, 개수 : index부터 n개 출력
select title from titles limit 0, 5;

--
-- where 절
-- 

-- 예제 1. 비교 연산자 : employees 테이블에서 1991년 이전에 입사한 직원의 이름, 성별, 입사일
select first_name, gender, hire_date from employees
where year(hire_date) < '1991';

-- 예제 2. 논리 연산자 : employees 테이블에서 1989년 이전에 입사한 여직원의 이름, 성별, 입사일
select first_name, gender, hire_date from employees

where hire_date<'1989-01-01' and gender='f'
order by hire_date desc;

-- 예제 3. in 연산자 : dept_emp 테이블에서 부서 번호가 doo5이거나 d009에 속한 사원의
-- 						   사원번호, 부서번호를 출력
select distinct dept_no from dept_emp;
select emp_no, dept_no from dept_emp
where dept_no in ('d005', 'd009');

-- 예제4. like 검색 : employees 테이블에서 1989년에 입사한 직원들의 이름, 입사일
select first_name, hire_date from employees
where hire_date like '1989%';

select first_name, hire_date from employees
where hire_date between '1989-01-01' and '1989-12-31';

--
-- order by
--

-- 예제1. employees 테이블에서 직원 이름, 성별, 입사일을 입사일이 빠른 순으로 출력
select concat(first_name, ' ', last_name) name, gender, hire_date from employees
order by hire_date asc;

-- 예제2. salaries 테이블에서 2001년 월급이 가장 높은 순으로 사번, 월급 출력
select emp_no, salary, from_date, to_date from salaries
where to_date like '2001%' or from_date like '2001%'
order by salary desc;

select emp_no, salary, from_date, to_date from salaries
where '2001' between year(from_date) and year(to_date)
order by salary desc;

select * from titles where emp_no = 43624; 

-- 예제3. 남자 직원의 이름, 성별, 입사일을 선임순으로 출력
select first_name, gender, hire_date from employees
where gender='m'
order by hire_date asc;

-- 예제4. 직원들의 사번, 월급을 사번 순으로 출력하되 같은 직원의 월급이 높은 순서도 반영
select emp_no, salary from salaries
order by emp_no asc, salary desc;


