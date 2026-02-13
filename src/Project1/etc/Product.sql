drop database if exists product;
create database product;
use product;

create table products(
	pno int auto_increment,
    constraint primary key(pno),
    snickname varchar(3) not null,
	pname varchar(100) not null,
    pcontent text,
    pprice int not null,
    ppwd int not null,
    sphone varchar(50) not null,
    is_sold varchar(10) default '판매중',
    reg_date datetime default now()
);


INSERT INTO products (snickname, pname, pcontent, pprice, ppwd, sphone)
VALUES ('심준현', '자바 기본서', '상태 아주 좋습니다.', 15000, 1234, '010-1234-5678');
INSERT INTO products (snickname, pname, pcontent, pprice, ppwd, sphone)
VALUES ('성결이', '기계식 키보드', '청축이고 사용감 적어요.', 45000, 4321, '010-1111-2222');
INSERT INTO products (snickname, pname, pcontent, pprice, ppwd, sphone, is_sold)
VALUES ('관리자', '중고 모니터', '24인치 모니터입니다.', 80000, 0000, '010-0000-0000', '판매완료');