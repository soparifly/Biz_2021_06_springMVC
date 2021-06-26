use db_school;

create table tbl_student(
st_num	CHAR(8)		primary key,
st_name	VARCHAR(20)	NOT NULL	,
st_dept	VARCHAR(20)	NOT NULL	,
st_grade	INT	NOT NULL	,
st_tel	VARCHAR(15)	NOT NULL,	
st_addr	VARCHAR(125)		
);
drop table tbl_score;
create table tbl_score(
sc_seq	BIGINT	auto_increment primary key,
sc_stnum	CHAR(8)	NOT NULL	,
sc_sbcode	CHAR(4)	NOT NULL,	
sc_score	INT	NOT NULL	
);


INSERT INTO tbl_student(
st_num,
st_name,
st_dept,
st_grade,
st_tel) 
VALUES ('2021001','홍길동','컴퓨터공학과','3');
INSERT INTO tbl_score(
sc_stnum,
sc_sbcode,
sc_score
) values ('2021001','S005','90');


create table tbl_subject(
sb_code	CHAR(4)		primary key,
sb_name	VARCHAR(20)	NOT NULL	,
sb_prof	VARCHAR(20)		
);

drop table tbl_subject;

INSERT INTO tbl_subject(sb_code,
sb_name
) VALUES ('S001','국어');

INSERT INTO tbl_subject(sb_code,
sb_name
) VALUES ('S002','영어');
INSERT INTO tbl_subject(sb_code,
sb_name
) VALUES ('S003','수학');
INSERT INTO tbl_subject(sb_code,
sb_name
) VALUES ('S004','과학');
INSERT INTO tbl_subject(sb_code,
sb_name
) VALUES ('S005','음악');

select * from tbl_subject;
select * from tbl_student;


-- 과목테이블, 점수테이블을 가지고 각 학생의 성적 리스트 출력해보기 
-- 과목 리스트를 출력하고, 각과목의 성적이 입력된 학생의 리스트를 확인하기
--  학번을 조건으로하여 한 학생의 성적 입력 여부를 확인하기 
-- 학생의 점수가 입력된 과목과 입력되지 않은 과목을 확인하고싶을때 

-- subquery를 이용한  -- 
SELECT SB.sb_code, SB.sb_name, SB.sb_prof,
	SC.sc_stnum, SC.sc_score
 FROM tbl_subject SB 
	LEFT JOIN tbl_score(SELECT * FROM tbl_score WHERE st_stnum = '2021001')  SC
		ON SC.sc_sbcode = SB.sb_code
        WHERE SC.sc_stnum = '2021001';
        
 SELECT SB.sb_code, SB.sb_name, SB.sb_prof,
	SC.sc_stnum, SC.sc_score
 FROM tbl_subject SB 
	LEFT JOIN tbl_score SC
		ON SC.sc_sbcode = SB.sb_code ; 
		 AND SC.sc_stnum = '2021001' LIMIT 5;
		
        
		/*
        과목리스트를 전체 보여주고, 
        학생의 성적 table 을 join gkdu
        학생의 점수를. 
        
        
        */