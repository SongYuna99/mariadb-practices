--
-- Inner Join : 조건의 개수 = 조인하는 테이블의 개수 -1
--

-- 예제 1. 현재, 근무하고 있는 직원의 사번, 이름과 직책을 모두 출력
select a.emp_no, a.first_name, b.title from employees a, titles b
where a.emp_no=b.emp_no 			-- join 조건
	and b.to_date='9999-01-01';		-- row 선택 조건 