-- Basic Query

-- 테이블 삭제
drop table pet;

-- 테이블 생성 
CREATE TABLE pet (
    name VARCHAR(20),
    owner VARCHAR(20),
    species VARCHAR(20),
    gender CHAR(1),
    birth DATE,
    death DATE
);

-- scheme 확인 
desc pet;

-- 조회
SELECT 
    name, owner, species, gender, birth, death
FROM
    pet;

-- insert
insert
	into pet value('성탄이', '안대혁', 'dog', 'm', '2018-12-25', null);
    
-- 데이터 삭제(delete)
DELETE FROM pet 
WHERE
    name = '성탄이';
    
-- load data local info
load data local infile 'c:\\pet.txt' into table pet;

-- 조회 연습1  :  where

-- 1990년 이후에 태어난 아이들은?
select name, species, birth
	where birth > '1990-00-00';

