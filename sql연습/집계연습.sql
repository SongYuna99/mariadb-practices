-- 1) 집계 쿼리 : select 절에 통계 함수(avg, max, min, count, std, stddev, ...)
select avg(salary), sum(salary) from salaries;

-- 2) select 절에 그룹함수(통계함수)가 있는 경우, 어떤 컬럼도 select 절에 올 수 없다!!
-- 오류가 나진 않지만 아무런 의미가 없으니 사용하지 말자
select emp_no, avg(salary) from salaries;

-- 3) 쿼리 순서
-- 	1. from : 테이블에 접근
-- 	2. where : 조건에 맞는 row를 선택
-- 	3. projection : 집계 
-- 	4. 결과를 반환 : 출력 

-- 예제 : 사번이 10060인 사원이 받은 평균 연봉
select avg(salary) from salaries
where emp_no=10060;

-- 4) group by에 참여 컬럼은 projection이 가능하다. : select 절에 올수 있다,
-- 예제 : 사원별 평균 연봉을 큰 순서대로
SELECT 
    emp_no, AVG(salary)
FROM
    salaries
GROUP BY emp_no
ORDER BY AVG(salary) DESC;

-- 5) Having : 집계 결과(결과 테이블)에서 row를 선택해야 하는 경우
-- 			  이미 where절은 실행이 되었기 때문에 having절에서 조건을 주어야 한다,

-- 6) order by : 항상 맨 마지막 출력 전에 한다.
-- 예제 : 평균 연봉이 60000 달러 이상인 사원의 사번과 평균 연봉을 낮은 순서대로 출력
SELECT 
    emp_no, AVG(salary)
FROM
    salaries
GROUP BY emp_no
HAVING AVG(salary) >= 60000
ORDER BY AVG(salary) ASC;

-- 주의)
-- 예제 : 사번이 10060인 사원의 사번, 평균 급여, 급여 총합을 출력
-- 문법적으로 오류!! 하지만 의미적으로는 맞음 (where)
select emp_no '사번', avg(salary) '평균 급여', sum(salary) '급여 총합' from salaries
where emp_no=10060;
-- 옳게 작성한 쿼리문
select emp_no '사번', avg(salary) '평균 급여', sum(salary) '급여 총합' from salaries
group by emp_no having emp_no=10060;
