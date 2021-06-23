# Spring MyBatis Project
	현재 가장 많이 사용
### Dependency 설정
* mybatis : 최신버젼
* mybatis-spring : 최신버젼
* commons-dbcp2: 최신버젼(commons-dbcp 와는 다름)

### commons-dbcp2

* apache 재단에서 만든 DB Connection 도구
* DB 연결을 pool을 사용하여 많은 동시사용 접속을 효율적으로 처리
* 기본적으로 DB 연결 Connection 미리 다수(10개)를 만들어 두고
	연결 요청이 오면 그중 1개를 연결하는 통로로 제공한다
	
### mybatis 
* mybatis 는 DB연동과 관련된 상당히 많은 부분의 코드를 직접 작성하지 않고, 수행할 수 있도록 도와주는 DB 연결 드라이버(라이브러리)
* 현재 진행형의 DB 연동이 이루어지는 Spring Project 에서는 거의 mybatis 를 활용한 DB 연결이 이루어진다 

# Spring DB 연동 프로젝트 작성
--	한개의 테이블을 작성했을때 기본으로 하는 과정 
1. 기본 SpringMVC 프로젝트 생성
2. pom.xml에 Spring 관련 기본 dependency 설정
3. mybatis 관련 dependency설
4. 여기까지 기본프로젝트가 정상적으로 구동되는지 확인하기 ( home. jsp ) 내용물이 서버를 동작했을때 나와야함
5. mybatis-context.xml을 작성하기
6. DBMS에 table 생성하기, 테스트용 insert만들기 
7. model class(VO,DTO)  생성하기
8. Dao 생성하기, Service생성하기, Controller 생성하기
9. client에서 Request하여 Controller생성하기
	데이터가 정상적으로 select 되는지 log 를 통해서 확인하기 
	
	
	