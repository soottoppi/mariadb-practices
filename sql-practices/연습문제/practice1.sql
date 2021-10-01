-- prob1
select concat(first_name, ' ' , last_name ) as '이름' from employees where emp_no = 10944;

-- prob2
select concat(first_name, ' ' , last_name ) as '이름' , gender, hire_date from employees order by hire_date;