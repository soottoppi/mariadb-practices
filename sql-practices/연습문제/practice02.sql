-- practice02

-- 문제 1
-- 최고임금(salary)과  최저임금을 “최고임금, “최저임금”프로젝션 타이틀로 함께 출력해 보세요. 
-- 두 임금의 차이는 얼마인가요? 함께 “최고임금 – 최저임금”이란 타이틀로 출력해 보세요.
select max(salary) - min(salary) as '최고임금 - 최저임금'
	from salaries;

-- 문제 2
-- 마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
select date_format(max(hire_date), '%Y년 %m월 %d일') as '마지막 신입사원 입사일'
	from employees;

-- 문제 3
-- 가장 오래 근속한 직원의 입사일은 언제인가요? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
-- select min(hire_date) from employees;
select emp_no, datediff(b,a)
from employees as e, 
	(select emp_no, min(from_date) as a, if(max(to_date) = '9999-01-01', curdate(), max(to_date)) as b
		from salaries
	  group by emp_no ) as c
where 



-- 문제 4
-- 현재 이 회사의 평균 연봉은 얼마입니까?
-- where 절에서 현재로 골라준다

-- 문제 5
-- 현재 이 회사의 최고/최저 연봉은 얼마입니까?

-- 문제 6
-- 최고 어린 사원의 나이와 최 연장자의 나이는?
-- birth_date 가지고 구한다