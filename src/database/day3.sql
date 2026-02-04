drop database if exists mydb0204;
create database mydb0204;
use mydb0204;
create table test( 
	mno int auto_increment ,
    constraint primary key(mno),
    mname varchar(30) not null unique , 
    mcount int default 2
);
# DML : 조작어 , 1]INSERT 저장 2]SELECT 조회 3]UPDATE 수정 4]DELETE 삭제
# [1] INSERT : 레코드/행/튜플/1줄/*DTO1개 삽입
# 1) insert into 테이블명( 속성명1 , 속성명2 ) values( 값1 , 값2 );
insert into test( mno , mname , mcount ) values( 1 , "유재석" , 30 );
# 2) 속성명의 순서와 대응하는 값은 위치가 일치 해야한다.
insert into test( mcount , mname , mno ) values( 40 , "강호동" , 2 );
# 3) auto_increment 생략해도 된다.
insert into test( mname , mcount ) values( "신동엽" , 50);
# 4) default 기본값 있으므로 생략해도 된다.
insert into test( mname ) values( "서장훈" );
# 5) not null 제약조건 속성은 꼭 삽입 자료가 존재 해야한다.
-- insert into test( mno , mcount ) values( 5 , 25 ); -- 오류발생 
# 6) unique 제약조건 속성은 중복값이 불가능 하다,
-- insert into test( mname ) values( "유재석" ); -- 오류발생 
# 7) 모든 속성에 대해 값 삽입 할 경우 속성명 생략 가능하다. 값 대응시 속성명 순서 일치
insert into test values( 5 , "박명수" , 60 );
# 8) 하나의 명령어에서 다수 레코드 삽입 , values( 레코드1 ) , ( 레코드2 ) , ( 레코드3 );
insert into test values( 6 , "하하" , 70 ) , ( 7 , "바나나" , 31 ) , ( 8 , "수박" , 65 );
# 확인 
select * from test;

-- [2] select , 레코드 조회 , 주의할점 : 조회 결과테이블 과 원본테이블 상관없다.
#1) select * from 테이블명;
select * from test;
#2) select 속성명1 , 속성명2 , 속성명3 from 테이블명;
select mname from test;
select mname , mcount from test;
#3) select 속성명 from 테이블명 where 조건절 
select * from test where mname = "유재석"; -- SQL에서는 = 같다 기호로 사용된다. VS = 대입
select * from test where mcount >= 40; -- 조건절에서는 연산 이용한 조회가 가능하다.

-- [3] update , 레코드의 값 수정 , mysql workbench safeMode해제 : 
set SQL_SAFE_UPDATES = 1; -- 활성화
set SQL_SAFE_UPDATES = 0; -- 해제 : 수정 과 삭제는 위험 하므로 workbench에서는 수정/삭제 차단 상태
#1) update 테이블명 set 수정할속성명1 = 수정할값 , 수정할속성명2 = 수정할값 where 조건 
update test set mcount = 0; -- where조건 이 없으면 전체 수정 
#2) 일반적으로 조건 수정 이다.
update test set mcount = 10 where mname = "유재석"; -- mname 속성값이 '유재석' 이면 mcount 속성값을 10으로 변경해라.
update test set mcount = 20 , mname = "강호동2" where mno = 2;
-- mno 속성값이 2 이면 mcount속성값을 20 , mname속성값을 '강호동2' 변경해라.

-- [4] delete , 레코드 삭제 , delete : 레코드 삭제 VS truncate : 모든레코드삭제 VS drop : 테이블/데이터베이스 삭제
# 1) delete from 테이블명 where 조건 
delete from test where mno = 2; -- mno속성값이 2 이면 (강호동레코드) 삭제 해라.
# 2) 
delete from test; -- 조건 이 없으므로 모든 레코드 삭제 		 - DML 취소가능 
truncate table test; -- 해당 테이블에 모든 내용(레코드) 삭제 - DDL 취소불가능 
drop table test; -- 해당 테이블 삭제 
/*
	DDL : 데이터베이스 정의 어 , 뒤로가기(롤백 = 트랜잭션) 불가능 
		create , drop , truncate 
    DML : 데이터베이스 조작 어 , 뒤로가기(롤백 = 트랜잭션) 가능 
		insert , select , update , delete 
*/

# 기본 연산자
# 1) 산술연산자 : +더하기 -빼기 *곱하기 /나누기 div몫 mod나머지
#	select (산술) from 테이블명 where (산술)
# 2) 비교연산자 : >초과 >=이상 <미만 <=이하 =같다 !=같지않다.
#	select 속성명 from 테이블명 where (비교)
# 3) 논리연산자 : and 이면서 or 이거나 not 부정
# 	select 속성명 from 테이블 where (논리)

# 1. 회원테이블
create table member(    # 아이돌 그룹
 mid char(8) not null ,   # 식별키   최대 8자리
    mname varchar(10) not null , # 그룹명  최대 10자리
    mnumber int not null ,   # 인원수  정수 +-21억정도
    maddr char(2) not null ,   # 지역  최대 2자리
    mphone1 char(3) ,    # 지역번호 최대 2자리
    mphone2 char(8) ,    # 전화번호  최대 8자리
    mheight smallint ,    # 평균키   정수 +-3만정도
 mdebut date ,     # 데뷔일   yyyy-mm-dd
    constraint primary key ( mid )    # 제약조건
);
# 2. 구매테이블
create table buy(
 bnum int auto_increment ,    # 구매번호 정수  자동번호 부여
    mid char(8),      # 구매자  FK
    bpname char(6) not null ,   # 제품명  최대 6자리
    bgname char(4) ,      # 분류명   최대 4자리
    bprice int not null ,    # 가격   정수
    bamount smallint not null ,   # 구매수량 정수
    constraint primary key(bnum) ,     # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

#1] as 별칭 키워드 , 조회결과의 속성명 변경 , as 생략 가능하다. , 속성명/테이블명 길거나 복잡한 경우 사용.  
select mid as 회원아이디 from member;	-- mid 속성명을 회원아이디 로 별칭한다. 
select mid 회원아이디 from member;
select mid from member as m;		-- member 테이블명을 m 으로 별칭한다.
select mid from member m;

#2] distinct 속성명 , 속성값이 중복 인 레코드 제거 
select distinct maddr as 주소 from member; -- 회원테이블의 주소 속성값을 중복제거 해서 조회 한다.

#3] 산술연산자 , 주의할점 : select 결과는 !항상! 표/테이블 단위 이다.
select mnumber + 3 as 더하기 , mnumber - 3 as 빼기 , mnumber / 3 as 나누기 ,
	mnumber * 3 as 곱하기 , mnumber div 3 as 몫 , mnumber mod 3 as 나머지
from member;

#4]비교연산자
select * from member where mname="블랙핑크";
select * from member where mnumber=4;
select * from member where mname!="블랙핑크";		-- 같지않다
select * from member where not mname="블랙핑크";	-- not 비교연산
select * from member where mheight<=162;		-- 이하
select * from member where mheight>=165 and mheight<=170;		-- 165이상 170이하
select * from member where mheight between 165 and 170;			-- 165이상 170이하
select * from member where maddr='경기' or maddr='전남' or maddr='경남';	-- 하나라도 포함
select * from member where maddr in('경기','전남','경남');					-- 하나라도 포함
# 주의할점:null(자료없다)비교연산자 별도 존재
select * from member where mphone1=null;	-- null은 같다(=)로 비교 불가능
select * from member where mphone1 is null;	-- 비교 가능
select * from member where mphone1 is not null;	-- 비교 가능
# 문자패턴: 1) 속성명 like '문자패턴', 1) %:문자대응(개수상관없음) 2)_:문자대응(_개수만큼대응)
select * from member where mname like "에이%";	-- 에이로 시작되는 mname을 찾는다
select * from member where mname like "에이__";	-- mname속성값이 에이로 시작하는 2글자 문자
select * from member where mname like '%핑크';	-- 핑크로 끝나는 문자
select * from member where mname like '%이%';	-- 중간글자에 '이'가 들어가는 문자
select * from member where mname like '_이%';	-- 두번째 글자가 '이'인 문자