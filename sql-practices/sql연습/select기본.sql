-- select 연습
select * from departments;
select dept_no, dept_name from departments;

-- alias(as 생략 가능)
-- 예제1 : employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select first_name as '이름', 
			gender as '성별',
            hire_date as '입사일'
	from employees;
    
-- 예제2 : employees 테이블에서 직원의 이름, 성별, 입사일을 출력 + concat 함수
select concat(first_name, ' ' , last_name) as '전체 이름', 
			gender as '성별',
            hire_date as '입사일'
	from employees;
    
-- distinct 
-- 예제 : title 테이블에서 모든 직급의 이름을 출력
select  distinct(title) from titles;

-- where 절 #1
-- 예제 : 1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
select first_name, gender, hire_date
	from employees
    where hire_date < '1991-01-01'
order by hire_date desc;

-- where 절 #2 : 논리 연산자
-- 예제 : 1989년 이전에 입사한 여직원의 이름, 입사일을 출력
select first_name, gender, hire_date
	from employees
    where hire_date < '1989-01-01' and gender = 'f'
order by hire_date desc;

-- where 절 #3 : in 연산자
-- 예제 : dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서번호
select emp_no, dept_no
	from dept_emp
  where dept_no = 'd005' or dept_no = 'd009';
  
select emp_no, dept_no
	from dept_emp
    where dept_no in ('d005', 'd009');
    
-- where 절 #4 : LIKE 검색
-- 예제 : 1989년에 입사한 직원의 이름, 입사일을 출력
select first_name, hire_date
	from employees
	where hire_date  >= '1989-01-01' and hire_date <= '1989-12-31';

    
select first_name, hire_date
	from employees
	where hire_date like '1989%';
    
select first_name, hire_date
	from employees
	where hire_date between '1989-01-01' and '1989-12-31';
    
--  order by  절
-- 예제 1 : 남자 직원의 전체 이름, 성별, 입사일을 입사일 순(선임순)으로 출력
select first_name, gender, hire_date
	from employees
    where gender = 'm'
order by hire_date asc;

-- 예제2 : 직원들의 사번, 월급을 사번, 월급 순으로 출력
select emp_no, salary, from_date, to_date
	from salaries
order by emp_no asc, salary desc;

-- upper
select upper('busan'), upper('busan'), upper('Douzone');
select upper(first_name) from employees;

-- substring(문자열 index, length)
select substring('Hello World', 3, 2);
-- 예제 : 1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date
	from employees
    where hire_date   = substring(hire_date, 1, 4);
    
-- lpad, rpad
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');
-- 예제 : 직원들의 월급을 오른쪽 정렬(빈공간은 *)
select lpad(salary, 10, '*') from salaries;

-- trim, ltrim, rtrim
select concat('---', ltrim('      hello     '), '---'),
		concat('---', rtrim('      hello     '), '---'),
        concat('---', trim(both 'x' from 'xxxhexxxlloxxx'), '---');