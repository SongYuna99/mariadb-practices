-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*) '직원 수'
from salaries
where salary > (select avg(salary)
					from salaries
                    where to_date='9999-01-01');

-- 문제2. (x)
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 
-- 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select e.emp_no '사번', concat(e.first_name, ' ', e.last_name) '이름', s.salary '연봉'
from employees e, salaries s, (select d.dept_no, avg(salary) avg_sal
										from dept_emp d, salaries s
										where d.emp_no=s.emp_no
										and d.to_date='9999-01-01'
										and s.to_date='9999-01-01'
										group by d.dept_no) d, dept_emp de
where e.emp_no=s.emp_no
and d.dept_no=de.dept_no
and s.to_date='9999-01-01'
and s.salary > d.avg_sal;

-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select e.emp_no '사번', concat(e.first_name, ' ', e.last_name) '이름', 
		concat(dm.first_name, ' ', dm.last_name) '매니저 이름', d.dept_name '부서 이름'
from employees e, departments d, dept_emp de, 
		(select e.first_name, e.last_name, a.dept_no, a.emp_no
		from employees e, 
				(select dept_no, emp_no
				from dept_manager
				where to_date='9999-01-01'
				group by dept_no, emp_no) a
		where e.emp_no=a.emp_no)dm 
where e.emp_no=de.emp_no
and de.to_date='9999-01-01'
and de.dept_no=dm.dept_no
and de.dept_no=d.dept_no
order by e.emp_no asc;

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select e.emp_no '사번', t.title '직책', s.salary '연봉'
from employees e, titles t, salaries s, dept_emp de
where e.emp_no=t.emp_no
and e.emp_no=s.emp_no
and e.emp_no=de.emp_no
and t.to_date='9999-01-01'
and s.to_date='9999-01-01'
and de.to_date='9999-01-01'
and de.dept_no=(select distinct de.dept_no
					from dept_emp de, salaries s, 
							(select max(avg_salary), a.dept_no
							from (select avg(b.salary) as avg_salary, de.dept_no
							from dept_emp de, salaries b
							where b.emp_no = de.emp_no
							and b.to_date = '9999-01-01'
							and de.to_date = '9999-01-01'
							group by de.dept_no) a) a
					where de.emp_no=s.emp_no
					and s.to_date='9999-01-01'
					and de.to_date='9999-01-01'
					and de.dept_no=a.dept_no);

-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 
select avg(s.salary) avg_sal, de.dept_no
from salaries s, dept_emp de
where s.to_date='9999-01-01'
and de.to_date='9999-01-01'
and s.emp_no=de.emp_no
group by de.dept_no
order by avg(s.salary) desc
limit 0, 1;

-- 문제7.
-- 평균 연봉이 가장 높은 직책?
select distinct t.title '직책'
from titles t, salaries s, 
		(select max(avg_salary), a.title
		from (select avg(b.salary) as avg_salary, a.title
		from titles a, salaries b
		where a.emp_no = b.emp_no
		and a.to_date = '9999-01-01'
		and b.to_date = '9999-01-01'
		group by a.title) a) a
where t.emp_no=s.emp_no
and s.to_date='9999-01-01'
and t.to_date='9999-01-01'
and t.title=a.title;

-- 문제8. (순수 join 문제)
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 매니저 연봉 순으로 출력합니다.
select d.dept_name '부서 이름', concat(e.first_name, ' ', e.last_name) '이름', s.salary '연봉', 
		concat(dm.first_name, ' ', dm.last_name) '매니저 이름', dm.salary '매니저 연봉'
from employees e, salaries s,
		(select de.emp_no, de.dept_no, d.dept_name
		from departments d, dept_emp de 
		where d.dept_no=de.dept_no
		and de.to_date='9999-01-01') d,
		(select e.first_name, e.last_name, a.dept_no, a.emp_no, s.salary
		from employees e, salaries s,
				(select dept_no, emp_no
				from dept_manager
				where to_date='9999-01-01'
				group by dept_no, emp_no) a
		where e.emp_no=a.emp_no
		and e.emp_no=s.emp_no
		and s.to_date='9999-01-01') dm
where e.emp_no=d.emp_no
and e.emp_no=s.emp_no
and s.to_date='9999-01-01'
and d.dept_no=dm.dept_no
and s.salary>dm.salary
order by e.emp_no asc;

