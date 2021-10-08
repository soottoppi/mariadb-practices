-- 서브쿼리(SUBQUERY) SQL 문제입니다

-- 문제 1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
	from salaries s
where s.to_date = '9999-01-01'
	and s.salary > (select avg(salary)
					from salaries s
				  where s.to_date = '9999-01-01');

-- 문제 2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select e.emp_no '사번' , concat(e.first_name, ' ' , e.last_name ) '이름', d.dept_name '부서', s.salary '최고 연봉'
	from employees e, salaries s, dept_emp de, departments d
where e.emp_no = s.emp_no
	and de.emp_no = e.emp_no
    and de.dept_no = d.dept_no
    and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and s.salary in (select max(s.salary)
						from departments d, dept_emp de, salaries s
					where de.emp_no = s.emp_no
						and d.dept_no = de.dept_no
						and s.to_date = '9999-01-01'
					group by d.dept_name)
group by d.dept_name
order by s.salary desc;

-- 문제 3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select e.emp_no, concat(e.first_name, ' ' , e.last_name ) '이름', s.salary
	from employees e, salaries s, dept_emp de,
		(select de.dept_no, avg(salary) as avg_salary
			from salaries s, departments d, dept_emp de
		where s.to_date = '9999-01-01'
			and de.to_date = '9999-01-01'
			and s.emp_no = de.emp_no
			and de.dept_no = d.dept_no
		group by de.dept_no) a
where e.emp_no = s.emp_no
	and s.emp_no = de.emp_no
    and a.dept_no = de.dept_no
	and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and s.salary > a.avg_salary;
    

-- 문제 4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select e.emp_no, concat(e.first_name, ' ' , e.last_name ) '이름', d.dept_name
	from employees e, dept_manager dm, departments d
where e.emp_no = dm.emp_no
	and d.dept_no = dm.dept_no
    and dm.to_date = '9999-01-01';


-- 문제 5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select e.emp_no, concat(e.first_name, ' ' , e.last_name ) '이름', t.title, s.salary
	from employees e, titles t, salaries s, dept_emp de
where e.emp_no = t.emp_no
	and s.emp_no = t.emp_no
    and de.emp_no = e.emp_no
    and t.to_date = '9999-01-01'
    and s.to_date = '9999-01-01'
    and de.to_date = '9999-01-01'
    and de.dept_no = (select dept_no
						from (select de.dept_no, avg(s.salary) as avg_salary
									from salaries s, dept_emp de
								where s.emp_no = de.emp_no
									and s.to_date = '9999-01-01'
									and de.to_date = '9999-01-01'
								group by de.dept_no
                                order by avg_salary desc
                                limit 0, 1) a)
order by s.salary desc;


-- 문제 6.
-- 평균 연봉이 가장 높은 부서는? 
select d.dept_name, avg(s.salary) as avg_salary
	from salaries s, departments d, dept_emp de
where s.to_date = '9999-01-01'
	and de.to_date = '9999-01-01'
	and de.emp_no = s.emp_no
	and d.dept_no = de.dept_no
group by d.dept_name
order by avg_salary desc
limit 0, 1;

-- 문제 7.
-- 평균 연봉이 가장 높은 직책?
select t.title, avg(s.salary) as avg_salary
	from salaries s, titles t
where s.to_date = '9999-01-01'
	and t.to_date = '9999-01-01'
    and s.emp_no = t.emp_no
group by t.title
order by avg_salary desc
limit 0, 1;

-- 문제 8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
select d.dept_name, e.first_name, e.last_name, s.salary
	from employees e, salaries s, departments d,
    ( select dm.dept_no as managerDeptNo, s.salary as manager_salary
		from salaries s, dept_manager dm
	where s.to_date = '9999-01-01'
		and dm.to_date = '9999-01-01'
		and s.emp_no = dm.emp_no) as a
where e.emp_no = s.emp_no
    and s.to_date = '9999-01-01'
	and s.salary > a.manager_salary
    and a.managerDeptNo = d.dept_no;

select	dm.dept_no, s.salary
	from salaries s, dept_manager dm
where s.to_date = '9999-01-01'
	and dm.to_date = '9999-01-01'
    and s.emp_no = dm.emp_no;
    
select *
	from employees e, salaries s, dept_manager dm, departments d
where e.emp = s.emp_no
	and dm.emp_no = e.emp_no
    and d.dept_no = dm.dept_no
    and dm.to_date = '9999-01-01'
    and s.to_date = '9999-01-01'
    and s.salary >= ;
    
SELECT 
    f.dept_name AS '부서이름',
    a.first_name AS '사원이름',
    d.salary AS '연봉',
    g.first_name AS '매니저 이름',
    e.salary AS '매니저 연봉'
FROM
    employees a,
    dept_emp b,
    dept_manager c,
    salaries d,
    salaries e,
    departments f,
    employees g
WHERE
    a.emp_no = b.emp_no
        AND c.dept_no = b.dept_no
        AND a.emp_no = d.emp_no
        AND c.emp_no = e.emp_no
        AND c.dept_no = f.dept_no
        AND c.emp_no = g.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND e.to_date = '9999-01-01'
        AND d.salary > e.salary;