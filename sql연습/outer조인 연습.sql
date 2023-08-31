desc emp;
desc dept;

-- test data : dept
-- select * from dept;
-- insert into dept values(null, '총무');
-- insert into dept values(null, '개발');
-- insert into dept values(null, '영업');
-- insert into dept values(null, '기획');

-- test data : emp
-- select *from emp;
-- insert into emp values(null, '둘리', 1);
-- insert into emp values(null, '마이콜', 2);
-- insert into emp values(null, '또치', 3);
-- insert into emp values(null, '길동', null);

-- inner join
select emp.name, dept.name
from emp
join dept on emp.dept_no=dept.no;

-- left join (outer join)
select emp.name name, ifnull(dept.name, '없음') department
from emp
left join dept on emp.dept_no=dept.no;

-- right join (outer join)
select ifnull(emp.name, 'none') name, dept.name department
from emp
right join dept on emp.dept_no=dept.no;
