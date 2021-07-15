# Pagination

* 많은 양의 데이터가 리스트로 select되었을때 전체 리스트를 한화면에 보여주면
	보는데 상당한 불편사항이 있다.
* 한 화면에 일정 list의 분량만 보여주고
* 리스트 하단에 페이지 네비게이션을 포현하여 
* fageNumber를 클릭하면 이후 list를 포함하여 보여주는 방식

## pagination 설계할때 요구사항
1. 한 화면에 표현할 리스트의 갯수
2. 페이지 갯수 : 평균 5~ 10개정도로 표현한다
3. 처음으로 가기 : 1page List 보기
4. 끝으로 가기 : 제일 마지막 list중에 보이기
5. 이전으로, 이후로 가기 : 현재 보고있는 page앞에서 앞 , 뒤로 가기
6. 보고있는 화면에서 page nav번호를 클릭했을때 controller에 전달하는 값 
7. page num만 전달하기, 검색어와 함께 전달하기, 검색어 정렬기준과 함께 전달하기

## 이 프로젝트에서 pagination 구현하기
* SQL의 SELECT는 표준 SQL SELECT만 사용하기
* Java코드에서 pagination 구현하기
* 1.8미만에서 사용하는 코드 , 1.8이상에서 구현하는코드
* 1.8이상의 코드 : Lambda, Stream(List데이터에 대한 Stream)