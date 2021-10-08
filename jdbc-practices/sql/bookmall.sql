-- category --
-- insert 
insert into category values(null, '소설');
select * from category;

-- select
select no, name from category;

-- update
update category set name = '성경' where no = 6;
select * from category;

-- book --
-- insert
insert into book values (null, '클라이밍의 정석', 15000, 6);

-- select
select * from book;

-- update
update book set price = 12000 where no = 1;

-- Member --
-- insert
insert into member values (null, '김수형', '010-1111-1111', 'soo@mail.com', 1111);
-- select
select * from member;

-- update
update member set password = 2222 where name = '김수형';

-- Cart --
-- insert
insert into cart values (1, 2, 30);
-- select
select * from cart;

-- update
update cart set amount = 60 where member_no = 1 and book_no = 2;

-- Order --
-- insert
insert into orders values (null, 1, 330000, '부산시 금정구', 2);
-- select
select * from orders;

-- update
update orders set shipping_address = '부산시 동래구' where member_no = 2 and order_number = 1;
