--
-- 날짜 함수
-- 

-- curdate(), current_date : 오늘 날짜만 (시간 X)
select curdate(), current_date() from dual;

-- now() : 오늘 날짜 + 지금 시간 -> 쿼리가 실행되는 시간 (게시판 작성일, 작성시간)
-- sysdate() : 오늘 날짜 + 지금 시간 () -> 함수가 호출되는 시간
select now(), sysdate() from dual;
select now(), sleep(2), now() from dual;
select sysdate(), sleep(2), sysdate() from dual;

-- date_format
-- 2023년 8월 30일 11시 37분 57초
select date_format(now(), '%Y년 %m월 %d일 %h시 %i분 %s초') as now from dual;

-- period_diff : 날짜 포맷을 맞춰주어야 함
-- formatting : yymm, YYYYmm
-- 예) 근무 개월수 (2023년 기준) 
SELECT 
    first_name,
    hire_date,
    PERIOD_DIFF(DATE_FORMAT(CURDATE(), '%y%m'),
            DATE_FORMAT(hire_date, '%y%m')) 근무기간
FROM
    employees;
    
-- date_add(adddate), date_sub(subdate)
-- 날짜를 date 타입의 컬럼이나 값에 type(year, month, day)의 표현식으로 더하거나 뺄 수 있다.
-- 각 사원의 근속 년 수가 5년이 되는 날에 휴가를 보내준다면 각 사원들의 근속 휴가 날짜
SELECT 
    first_name, hire_date, date_add(hire_date, interval 5 year) 근속휴가
FROM
    employees;
    
-- cast


-- type




