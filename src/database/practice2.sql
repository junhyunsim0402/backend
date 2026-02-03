create database practice2;
use practice2;
drop database practice2;
-- 문제1
create table members(
    member_id int auto_increment,
    member_name varchar(50) not null,
    email varchar(100) unique not null,
    join_date datetime default now(),
    is_active bool default true,
    constraint primary key(member_id)
);

-- 문제2
create table products(
    products_id int auto_increment,
    product_name varchar(100) not null,
    price int unsigned not null,
    stock tinyint default 0 not null,
    created_at datetime default now(),
    constraint primary key(products_id)
);

-- 문제3
create table orders(
    order_id bigint auto_increment,
    member_id int,
    order_date datetime default now(),
    total_price int unsigned not null,
    constraint primary key(order_id),
    constraint foreign key(member_id) references members(member_id)
);

-- 문제4
create table order_items(
    item_id int auto_increment,
    order_id bigint,
    product_id int,
    quantity tinyint default 1,
    price int unsigned not null,
    constraint primary key(item_id),
    constraint foreign key(order_id) references orders(order_id),
    -- [수정] products_id (복수형) 로 이름 일치시킴
    constraint foreign key(product_id) references products(products_id)
);

-- 문제5
create table students(
    student_id char(10),
    student_name varchar(30) not null,
    major varchar(50),
    grade tinyint unsigned,
    enrolled_date date,
    constraint primary key(student_id)
);

-- 문제6
create table employees(
    emp_id int auto_increment,
    emp_name varchar(40) not null,
    salary int unsigned not null,
    hire_date date not null,
    department varchar(50),
    constraint primary key(emp_id)
);

-- 문제7
create table boards(
    board_id int auto_increment,
    title varchar(200) not null,
    content text not null,
    writer_id int, -- t 하나 제거 (선택사항)
    created_at datetime default now(), -- created_id를 created_at으로 수정(관례)
    constraint primary key(board_id),
    constraint foreign key(writer_id) references members(member_id)
);

-- 문제8
create table comments(
    comment_id int auto_increment,
    board_id int,
    content varchar(300) not null,
    created_at datetime default now(),
    constraint primary key(comment_id),
    -- [수정] 게시글을 참조하도록 boards(board_id)로 변경
    constraint foreign key(board_id) references boards(board_id)
);

-- 문제9
create table payments(
    payment_id bigint auto_increment,
    order_id bigint,
    payment_amount int unsigned not null,
    payment_method varchar(30),
    payment_date datetime default now(),
    constraint primary key(payment_id),
    constraint foreign key(order_id) references orders(order_id)
);

-- 문제10
create table reviews(
    review_id int auto_increment,
    product_id int,
    member_id int,
    rating tinyint unsigned not null,
    review_text text,
    created_at datetime default now(),
    constraint primary key(review_id),
    constraint foreign key(product_id) references products(products_id),
    constraint foreign key(member_id) references members(member_id)
);