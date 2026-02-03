create database mydb0203;
use mydb0203;

-- [1] 테이블 생성
-- create table 테이블명(속성명 타입 제약조건, 속성명 타입 제약조건);
create table test(속성명 int);

-- [2] 테이블 목록보기
-- show tables; : 현재 테이터베이스의 목록 출력
show tables;

-- 2개 이상의 속성명 정의한 테이블
create table test2(속성명1 int,속성명2 double);

-- [3] 테이블 삭제, drop table 테이블명, drop table/database if exists 테이블/데이터베이스명
drop table test2;

-- [4] 테이블 간단 조회, select 속성명1, 속성명2 from 테이블명; select * from 테이블명
select * from test;

-- [5] 다양한 데이터타입의 테입ㄹ 생성
create table test3(
    정수속성 tinyint, 정수속성2 smallint, 정수속성3 mediumint, 정수속성4 int, 정수속성5 bigint, 정수속성6 int unsigned, -- signed 부호있는(+-) unsigned(부호없음)
    실수속성1 float, 실수속성2 double, 실수속성3 decimal(10,2), 
    -- decimal:문자타입으로 실수표현(오차X/부동소수점X)
    날짜속성 date, 시간속성 time, 날짜시간속성 datetime,
    문자속성1 char(10), 문자속성2 varchar(100), 문자속성3 text, 문자속성4 longtext,
    -- char(5):고정길이 문자타입 [유][재][석][][] => 2칸이 남는다
    -- varchar(5):가변길이 문자타입 [유][재][석][][]=>나머지 2칸 삭제=>[유][재][석]
    -- long text:4G로 대용량임
    논리속성 bool -- true or flase,tinyint 취급,1또는 0
);

select * from test3;

-- [*] 방문록 기록하는 테이블 설계
create table comment(
	content varchar(255), -- 내용물 최대 255글자
    writer varchar(20) -- 작성자 최대 20글자
);
select * from comment;

-- [*] 대기명단 기록하는 테이블 설계
create table waiting(
	count tinyint unsigned, -- 최대 정수 255까지
    phone char(13) -- 연락처 최대 13글자 까지 고정길이 문자
);
select * from waiting;

-- [6] 제약조건:테이블 내 데이터들의 문제와 결함이 되는 입력 방지/해결
create table test4(
	# 속성명 타입 제약조건명
    속성명1 tinyint not null,	-- not null:해당 속성값들은 null 저장할 수 없다
	속성명2 smallint unique, -- unique:해당 속성값들은 중복이 불가능하다
    속성명3 int default 10, -- default 자료:만일 해당 속성에 초기값이 생략되면 기본값 자료 사용
    속성명4 bigint auto_increment, -- auto_increament:만일 해당 속성에 초기값이 생략되면 자동번호 부여한다.1부터~
	constraint primary key(속성명4) -- primary key;PK(식별/기본)키, 식별 가능한 고유한 값을 가진 키auto_increment
								-- 중복없음(unique)+빈칸없음(not null),학번이나 사번, 주민등록번호 등등
								-- constraint primary key(속성명)
);
select * from test4;
create table test5(
	속섬명1 bigint,
    FK속성명 bigint,
    constraint foreign key(FK속성명) references test4(속성명4) on delete set null
    -- constraint foreign key(FK속성명) references 테이블명(PK필드명)  -- 중복,빈칸(null) 가능
    -- foreign:fk(참조/외래)zl,다른 테이블의PK를 참조한다 				 -- pk(1):fk(n) 관계에서 수강신청학번,휴가신청한사번,구매한제품번호
    -- on update/delete restrict:pk와 fk 참조관계일때 pk 삭제/수정 불가능 관계<자식이 있으면 부모 삭제 불가능>, 기본값
    -- on update/delete cascade: pk가 삭제/수정될때 fk도 같이 삭제 관계,<게시물이 삭제되면 댓글도 삭제>
    -- on update/delete set null:pk가 삭제/수정되면 fk는 null로 변경,<게시물이 삭제/수정 되면 fk는 null로 변경>
);
select * from test5;

-- [5] 회원제 게시판 설계 -- 관례 순서
drop database if exists boardservice6;
create database boardservice6;
use boardservice6;
create table member(
	mno int auto_increment, -- 회원번호, 정수타입, 자동번호 부여
    mid varchar(30) not null unique, -- 회원아이디, 문자타입(~30),빈칸불가능,중복 불가능
    mpw varchar(30) not null, -- 회원비밀번호, 문자타입(~30),빈칸 불가능
    mname varchar(10), -- 회원 닉네임, 문자타입(~10)
    mphone char(13), -- 회원 연락처,문자타입(~13)
    constraint primary key(mno) -- 회원번호를 pk로 선정
);
create table product(
    pno int auto_increment, -- 제품번호,정수타입,자동번호 부여
    pname varchar(100) not null unique,
    pprice int unsigned default 0, -- 가격이므로 음수는 필요없음
    pcomment longtext, -- 최대 4G가능한 문자타입
    pdate datetime default now(),
    mno int, -- FK로 사용할 필드명의 타입은 PK필드명과 일치
    constraint foreign key(mno) references member(mno) on delete cascade, -- 회원이 탈퇴하면 그 회원 제품도 같이 삭제
    constraint primary key(pno)
);
select * from product;

-- ER다이어그램: 여러 테이블 들 간의 관게 시각적, ERD 다이어그램:데이터베이스 테이블 간의 관계를 시작적으로 표현한것
-- 워크벤치 메뉴 상단에 -> [ Database] -> [Reserves enginner]->