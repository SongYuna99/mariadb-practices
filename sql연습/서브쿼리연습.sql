--
-- subquery
--

--
-- 1) select절의 컬럼 프로젝션의 서브쿼리, insert into t values(서브쿼리)
--

--
-- 2) select의 from 절의 서브쿼리
--
select a.n, a.s, a.r
  from (select now() as n, sysdate() as s, 3 + 1 as r from dual) a;

--
-- 3) select의 where절(having절)의 서브쿼리
--  

-- 예제: 현재, Fai Bale 이 근무하는 부서에서 근무하는 다름 직원의 사번, 이름을 출력
-- sol1) 비추
select b.dept_no
  from employees a, dept_emp b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01'
   and concat(first_name, ' ', last_name) = 'Fai Bale';

-- 'd004'
select a.emp_no, a.first_name
  from employees a, dept_emp b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01'
   and b.dept_no = 'd004';  

-- sol2) subquery 사용
select a.emp_no, a.first_name
  from employees a, dept_emp b
 where a.emp_no = b.emp_no
   and b.to_date = '9999-01-01'
   and b.dept_no = (select b.dept_no
					  from employees a, dept_emp b
					 where a.emp_no = b.emp_no
                       and b.to_date = '9999-01-01'
                       and concat(first_name, ' ', last_name) = 'Fai Bale');

-- 3-1) 단일행 연산자: =, >, <, >=, <=, <>, !=
-- 예제1: 현재, 전체 사원의 평균 연봉보다 적은 급여를 받는 사원의 이름과 급여를 출력
select avg(salary) from salaries where to_date='9999-01-01';

  select a.first_name, b.salary
    from employees a, salaries b
   where a.emp_no = b.emp_no
     and b.to_date = '9999-01-01'
     and b.salary < (select avg(salary)
                       from salaries
					  where to_date='9999-01-01')
order by b.salary desc;                    

-- 예제2: 현재, 가장 적은 평균 급여의 직책과 그 급여를 출력
-- Engineer 20000
  select a.title, avg(b.salary)
    from titles a, salaries b
   where a.emp_no = b.emp_no
     and a.to_date = '9999-01-01'
     and b.to_date = '9999-01-01'
group by a.title;

  select min(avg_salary)	
  from (select avg(b.salary) as avg_salary
    from titles a, salaries b
   where a.emp_no = b.emp_no
     and a.to_date = '9999-01-01'
     and b.to_date = '9999-01-01'
group by a.title) a;    
 
-- 예제 2 : 현재, 가장 적은 평균 급여의 직책과 그 급여를 출력
SELECT 
    b.title, MIN(avg_salary)
FROM
    (SELECT 
        AVG(b.salary) avg_salary, a.title
    FROM
        titles a, salaries b
    WHERE
        a.emp_no = b.emp_no
            AND a.to_date = '9999-01-01'
            AND b.to_date = '9999-01-01'
    GROUP BY a.title) a,
    titles b
WHERE
    b.title = a.title;

-- limit 활용 -> oracle sql은 안되니 주의!
SELECT 
    AVG(b.salary) avg_salary, a.title
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.title
ORDER BY AVG(b.salary) ASC
LIMIT 0 , 1;

-- 3-2) 복수행 연산자: in, not in, 비교연산자 + any(=any, >any, ...), 비교연산자 + all(>all, <all, ...)

-- any 사용법
-- 1. =any : in
-- 2. >any, >=any : 최소값
-- 3. <any, <=any : 최대값
-- 4. !=any, <>any : not in

-- all 사용법
-- 1. =all : (x)
-- 2. >all, >=all : 최대값
-- 3. <all, <=all : 최소값
-- 4. !=all, <>all 

-- 예제 3. 현재, 급여가 50000이상인 직원의 이름과 급여를 출력 (급여 내림차순)
-- 내 풀이 
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND (a.emp_no , b.salary) IN (SELECT 
            emp_no, salary
        FROM
            salaries
        WHERE
            to_date = '9999-01-01'
                AND salary >= 50000)
ORDER BY b.salary DESC;

-- sol1) join
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND b.salary >= 50000
ORDER BY b.salary DESC;

-- sol2) subquery
SELECT 
    a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
        AND (a.emp_no , b.salary) = ANY (SELECT 
            a.first_name, b.salary
        FROM
            employees a,
            salaries b
        WHERE
            a.emp_no = b.emp_no
                AND b.to_date = '9999-01-01'
                AND b.salary >= 50000)
ORDER BY b.salary DESC;

-- 예제 4 : 현재, 각 부서별로 최고 급여를 받고 있는 직원의 이름과 연봉
-- 내 풀이
select d.dept_name '부서명', e.first_name '사원명', s.salary '연봉'
from employees e, salaries s, (select a.dept_name, a.dept_no, b.emp_no
										from departments a, dept_emp b
										where a.dept_no=b.dept_no
                                        and b.to_date='9999-01-01') d
where e.emp_no=s.emp_no
and e.emp_no=d.emp_no
and s.to_date='9999-01-01'
and (d.dept_no, s.salary) in (select b.dept_no, max(salary) from salaries a, dept_emp b
									where a.emp_no=b.emp_no
									and a.to_date='9999-01-01'
									and b.to_date='9999-01-01'
									group by b.dept_no);

--
select a.dept_no, max(b.salary)
from dept_emp a, salaries b
where a.emp_no=b.emp_no
and a.to_date='9999-01-01'
and b.to_date='9999-01-01'
group by a.dept_no;

-- sol1) where절 subquery in, 복수행/복수컬럼 
SELECT 
    c.dept_name, a.first_name, d.salary
FROM
    employees a,
    dept_emp b,
    departments c,
    salaries d
WHERE
    a.emp_no = b.emp_no
        AND b.dept_no = c.dept_no
        AND a.emp_no = d.emp_no
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND (b.dept_no , d.salary) IN (SELECT 
            a.dept_no, MAX(b.salary)
        FROM
            dept_emp a,
            salaries b
        WHERE
            a.emp_no = b.emp_no
                AND a.to_date = '9999-01-01'
                AND b.to_date = '9999-01-01'
        GROUP BY a.dept_no);

-- sol2) from절 subquery, join
select c.dept_name, a.first_name, d.salary
from employees a, dept_emp b, departments c, 
		salaries d, ( select a.dept_no, max(b.salary) as max_salary
						from dept_emp a, salaries b
						where a.emp_no = b.emp_no
						and a.to_date = '9999-01-01'
						and b.to_date = '9999-01-01'
						group by a.dept_no) e
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and a.emp_no = d.emp_no
and b.to_date = '9999-01-01'
and d.to_date = '9999-01-01'
and c.dept_no=e.dept_no
and d.salary=e.max_salary;
