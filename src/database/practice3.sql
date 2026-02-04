drop database if exists practice3;
create database practice3;
use practice3;
-- 문제1
create table books(
	book_id int not null,
    title varchar(50) not null,
    author varchar(20) not null,
    genre varchar(10) not null,
    price int not null,
    stock int,
    pub_date date,
    constraint primary key(book_id)
);
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT,
    book_id INT NOT NULL,
    customer VARCHAR(20) NOT NULL,
    order_qty INT NOT NULL,
    order_date DATE,
    CONSTRAINT PRIMARY KEY (order_id),
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(book_id)
);
insert into books values
(1001,"혼공 SQL","우재남","컴퓨터",22000,15,"2020-01-01"),
(1002,"이것이 자바다","신용권","컴퓨터",30000,30,"2018-05-20"),
(1003,"불편한 편의점","김호연","소셜",14000,5,"2021-04-20"),
(1004,"달러구트 꿈 백화점","이미예","소셜",13800,25,"2020-07-08"),
(1005,"트렌드 코리아2023","김남도","경제",19000,50,"2022-10-05"),
(1006,"원씩(THE ONE THINGS","게리 켈러","자기계발",14000,12,"2013-08-20"),
(1007,"역사의 쓸모","최태성","역사",16000,0,"2018-11-26"),
(1008,"파친코","이민진","소셜",15800,3,"2022-07-14"),
(1009,"Do it!점프 투 파이썬","박응용","컴퓨터",18800,null,"2019-06-20"),
(1010,"코스모스","칼 세이건","과학",19500,8,"2006-12-20"),
(1011,"혼공 JAVA","우재남","컴퓨터",24000,17,"2019-01-01");

INSERT INTO orders VALUES
(NULL, 1001, '김민준', 2, '2023-01-15'),
(NULL, 1002, '이서연', 1, '2023-01-18'),
(NULL, 1003, '박지훈', 1, '2023-02-01'),
(NULL, 1004, '김민준', 3, '2023-02-05'),
(NULL, 1005, '최수아', 1, '2023-02-11'),
(NULL, 1001, '박지훈', 1, '2023-02-12'),
(NULL, 1008, '이서연', 2, '2023-03-02'),
(NULL, 1009, '정현우', 5, '2023-03-05'),
(NULL, 1002, '김민준', 2, '2023-03-10'),
(NULL, 1006, '최수아', 1, '2023-04-01'),
(NULL, 1003, '박지훈', 3, '2023-04-02'),
(NULL, 1001, '이서연', 1, '2023-04-08'),
(NULL, 1005, '김민준', 2, '2023-04-15'),
(NULL, 1004, '정현우', 1, '2023-04-20'),
(NULL, 1008, '최수아', 1, '2023-05-01'),
(NULL, 1010, '박지훈', 2, '2023-05-05'),
(NULL, 1002, '최수아', 1, '2023-05-12'),
(NULL, 1006, '이서연', 2, '2023-05-20'),
(NULL, 1009, '김민준', 1, '2023-06-01'),
(NULL, 1001, '정현우', 3, '2023-06-07'),
(NULL, 1003, '이서연', 2, '2023-06-15'),
(NULL, 1005, '박지훈', 1, '2023-07-01'),
(NULL, 1010, '김민준', 1, '2023-07-03'),
(NULL, 1004, '최수아', 2, '2023-07-10');

-- 문제1
insert into books values(1012,"MySQL실습","김민수",'컴퓨터',17000,25,"2023-01-01");
-- 문제2
insert into books values(1013,"데이터베이스 개론","이영희","컴퓨터",22000,null,"2022-09-10");
-- 문제3
insert into orders values(null,1002,"최지훈",1,"2023-08-15");
-- 문제4
update books set price=15000 where book_id=1004;
-- 문제5
update books set price=price+2000 where genre='소셜';
-- 문제6
update books set stock=0 where stock=null;
-- 문제7
delete from orders where customer='이서연';
-- 문제8
delete from books where stock<=0;
-- 문제9
delete from orders where order_qty>=3;
-- 문제10
select * from books;
-- 문제11
select title,price from books;
-- 문제12
select title,price from books where price>20000;
-- 문제13
select title,price,stock from books where price>=15000 and stock>=10;
-- 문제14
select title,genre from books where genre in ('컴퓨터','경제');
-- 문제15
select * from books where genre!='소셜';
-- 문제16
select title,stock from books where stock is null;
-- 문제17
select title,genre from books where stock is not null;
-- 문제18
select title,price from books where price between 14000 and 18000;
-- 문제19
select title,author from books where title like '%자%';
-- 문제20
select title,author from books where author like '김__';