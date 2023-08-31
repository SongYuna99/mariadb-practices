--
-- Inner Join : 조건의 개수 = 조인하는 테이블의 개수 -1
--

-- 예제 1. 현재, 근무하고 있는 직원의 사번, 이름과 직책을 모두 출력
select a.emp_no, a.first_name, b.title from employees a, titles b
where a.emp_no=b.emp_no 			-- join 조건
	and b.to_date='9999-01-01';		-- row 선택 조건 
    
-- 예제 1. 현재, 근무하고 있는 직원의 사번, 이름과 직책을 모두 출력gkehl
-- 		  여성 엔지니어(Engineer)만 출력
select a.emp_no 사번, a.first_name 이름, a.gender 성별, b.title 직책
from employees a, titles b
where a.emp_no=b.emp_no 
	and a.gender='f' 
	and b.title='engineer' 
    and b.to_date='9999-01-01';
    
-- 
-- ANSI / ISO SQL1999 JOIN 표준 문법  
-- 

-- 1) join ~ on **
-- 예제 : 현재, 직책별 평균 연봉을 큰 순서대로 출력
select title as '직책', avg(b.salary) as '평균 연봉' 
from titles a
join salaries b on a.emp_no=b.emp_no
where a.to_date='9999-01-01'
and b.to_date='9999-01-01'
group by title
order by avg(b.salary) desc;

-- 2) natufal join
-- 	: 조인 대상이 되는 데이블들에 이름이 같은 공통 컬럼이 있는 경우
-- 	  조인 조건을 명시적으로 암묵적으로 조인이 된다,
-- 예제) 현재 근무하고 있는 직원의 이름과 직책을 출력
select a.first_name, b.title 
from employees a 
join titles b on a.emp_no=b.emp_no
where b.to_date='9999-01-01'
order by a.first_name asc;

select a.first_name, b.title 
from employees a 
natural join titles b
where b.to_date='9999-01-01'
order by a.first_name asc;

-- 3) join ~ using
-- 	natural join의 문제점 
-- 예제 : 현재, 근무하고 있는 직원의 직책과 연봉을 출력
select a.title, b.salary
from titles a 
natural join salaries b
where a.to_date='9999-01-01'
and b.to_date='9999-01-01';

-- 해결 1 : join ~ using
select a.title, b.salary
from titles a 
join salaries b using(emp_no) 
where a.to_date='9999-01-01'
and b.to_date='9999-01-01';

-- 해결 2 : join ~ on
select a.title, b.salary
from titles a 
join salaries b on a.emp_no=b.emp_no
where a.to_date='9999-01-01'
and b.to_date='9999-01-01';

-- 실습문제 1. 현재, 직원별 근무 부서를 출력 
-- 사번, 직원이름(first_name), 부서명 순으로 출력
select e.emp_no '사번', e.first_name '이름', d.dept_name '부서명'
from employees e, departments d, dept_emp de
where e.emp_no = de.emp_no
and d.dept_no = de.dept_no
and de.to_date = '9999-01-01'
order by e.first_name , d.dept_name, d.dept_name;

select a.emp_no, a.first_name, b.dept_name
from employees a, departments b, dept_emp c
where a.emp_no=c.emp_no
and b.dept_no=c.dept_no
and c.to_date='9999-01-01';

-- 실습문제 2. 현재, 직책별 평균 연봉과 직원수를 구하되
-- 				직책별 직원수가 100명 이상인 직책만 출력
-- 직책, 평균 연봉, 직원 수 순으로 출력
select t.title '직책', avg(s.salary) '평균연봉', count(s.emp_no) '직원 수'
from salaries s join titles t using(emp_no)
where s.to_date='9999-01-01'
and t.to_date='9999-01-01'
group by t.title
having count(s.emp_no)>=100
order by t.title;

select title, avg(salary), count(*)
from titles a, salaries b
where a.emp_no=b.emp_no
and a.to_date='9999-01-01'
and b.to_date='9999-01-01'
group by a.title
having count(*)>=100;

-- 실습문제 3. 현재, 부서별로 직책이 Engineer인 직원들에 대해서만 평균 연봉을 출력 
-- 				부서 이름, 평균 급여 순으로 출력
select d.dept_name '부서명', avg(salary) '평균 급여'
from salaries s join (select * from dept_emp
              left join departments using(dept_no)) d
          using(emp_no)
where s.to_date='9999-01-01'
and d.to_date='9999-01-01'
group by d.dept_name;
                            
select a.dept_name, c.title, avg(d.salary)
from departments a, dept_emp b, titles c, salaries d
where a.dept_no=b.dept_no
and b.emp_no=c.emp_no
and c.emp_no=d.emp_no
and b.to_date='9999-01-01'
and c.to_date='9999-01-01'
and d.to_date='9999-01-01'
and c.title='engineer'
group by a.dept_name, c.title;