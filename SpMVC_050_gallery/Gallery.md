# 이미지가 있는 갤러리게시판

## Text위주의 게시판에 이미지 첨부를 하여 이미지 갤러리를 만들기

## 서버에서 이미지갤러리 게시판 데이터 insert 절차

* input box에 담긴 text는 DTO , VO 를 통하여 데이터를 받는다 

* 이미지는 single, multi로 구분하여 Multpart...클래스를 사용하여 받기

1. 이미지를 먼저 서버의 upload(file)폴더에 업로드를 수행한다
2. 원래 이미지의 이름을 UUID가 첨가된 이름으로 변경하여 업로드한다 
3. 변경된 이름을 List<String> 데이터로 만들고 
4. 게시판정보를 Table에 insert하기
5. 게시판 정보를 Table 에 insert한 후 새로 생성된 PK(SEQ)을 추출하기
6. 게시판 Table 에서 가져온 PK와 List<String> 타입의 파일이름을 묶어서 
7. 파일 정보 테이블에 insert하기 
