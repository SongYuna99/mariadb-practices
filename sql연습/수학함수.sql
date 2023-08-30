-- 
-- 수학 함수 
-- 

-- abs : 절대값
select abs(1), abs(-1) from dual;

-- floor : 내림
select floor(3.14), floor(3.9999) from dual;

-- ceil : 올림
select ceil(3.14), ceiling(3.9999) from dual;

-- mod : 나머지 
select mod(10, 3) from dual;

-- round(x) : x에 가장 가까운 정수 -> 반올림
-- round(x, d) : x 값 중에 소수점 d 자리에 가장 근접한 실수
select round(1.489), round(1.529) from dual;
select round(1.489, 2), round(1.529, 1), round(1.529, 0) from dual;

-- power(x, y), pow(x, y) : x의 y승
select power(2, 10), pow(2, 10) from dual;

-- sign(x) : x가 양수면 1, 음수면 -1, 0이면 0 반환
select sign(20), sign(0), sign(-20) from dual;

-- greatest(x, y, z, ...), least(x, y, z, ...) : 괄호 안의 값중 최대값/최소값 
select greatest(10, -9, 110, 1729, -392, 0), least(10, -9, 110, 1729, -392, 0) from dual;
select greatest('A', 'n', 'K', 'z', 'W'), least('A', 'n', 'K', 'z', 'W') from dual;
select greatest('hello', 'apple', 'nice to meet you', 'zebra', 'Wow')
, least('hello', 'apple', 'nice to meet you', 'zebra', 'Wow') from dual;

