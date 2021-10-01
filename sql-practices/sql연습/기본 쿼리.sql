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

-- update  death
UPDATE pet 
SET 
    death = NULL
WHERE
    name != 'Bowser';


-- 조회 연습1  :  where

-- 1990년 이후에 태어난 아이들은?
SELECT 
    name, species, birth
FROM
    pet
WHERE
    birth > '1990-12-31';
    
-- Gwen과 함께 사는 아이들은?
SELECT 
    name, species, owner
FROM
    pet
WHERE
    owner = 'Gwen';
    
-- null 다루기 1 : 살아있는  애들은?
SELECT 
    name
FROM
    pet
WHERE
    death IS NULL;
    
-- null 다루기 2 : 죽은 애들은?
SELECT 
    name
FROM
    pet
WHERE
    death IS NOT NULL;
    
-- like 검색(패턴 매칭) : 이름이 b로 시작하는 아이들은?
SELECT 
    name
FROM
    pet
WHERE
    name LIKE 'b%';

-- like 검색(패턴 매칭) : 이름이 b로 시작하는 아이들중에 이름이 6자인 아이는?
SELECT 
    name
FROM
    pet
WHERE
    name LIKE 'b_____';
    
-- 집계 (통계) 함수
SELECT count(*) FROM pet;
SELECT count(death) FROM pet;
SELECT count(*) FROM pet WHERE death IS NOT NULL;