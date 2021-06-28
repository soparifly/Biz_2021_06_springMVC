# client request parameter 보내기

## LINK( a tag ) ,script href=,를 통해서 Request 할때 
* URL ? 변수 = 값 형태로 전송한다 
* 여러개를 보낼때는 URL?변수?=값&변수?=값
	이때 전송되는 데이터는 변수값 구분없이 무조건, 문자열로 전송된다 
	이런 type의 parameter를 queryString이라고 한다
* form 에 입력된 데이터를 method=GET 방식으로 보낼때도 같다
* URL을 포함하여 전체 문자열이 256자를 넘으면 잘린다
* Query String이 client(web browser)의 주소창에 노출된다
* 쉽게 가로채기(데이터 탈취)를 하기쉽다
* 데이터를 암호화하기가 매우 어렵다

## form 에 담긴 데이터를 method = POST로 보낼때
* 데이터가 HTTP 프로토콜의 Body에 담겨서 전달된다 
* Body영역을 정보통신에서는 payload영역이라고한다
* 이론 상의 데이터 크기가 제한이 없다
* 데이터를 암호화 하기가 쉽다
* 데이터가 전송되는 동안에 감추기가 쉽다 
* body Parameter 라고 부른다 

## Spring에서 파라메터 받기
* 변수 개수가 한-2개 정도될때는 String, primitive 형식으로 매개변수를 선언 해
 두면 자동으로 변수 값을 받을 수 있다.
 
 * VO,DTO 클래스를 서언하고, query String, body parameter의 이름과 같은 변수를 갖도록 만들어서, 
 VO, DTO를파라메터로 선언해두면 각가의 변수에 값을 채워서 받을 수 있다 .
 
 
 ## Parameter 설정과 client 에서의 데이터 설정 주의
 * query String, body parameter 관계 없이 client 에서 데이터를 보낼때는 특별한 언급이 없는 한 모두 문자열 형식이다
 * 만약 client에서 보낸 데이터가 숫자형이고, valueOF, Parse* 등을 사용하여 형변환이 가능하다면, 매개변수를 선언할때, 
 String 이외의 타입으로 선언가능하
 
 * age =33이라고 전송을 하고나이라는 amge라는 변수에는 실내 숫자형 이외의 데이터가 닼ㅁㅁ겨있어서 전송되지않는다 라는 보장이 있으면메소들처럼 매개변수를 선언하고 데ㅌ이터를 방을 수 있다 이때 만약 나이또는 a ㅊ와 같은 이터가 전송된다면 client		
 400오류를 만나게된다대량의 데이터를 한꺼번에 입력 받고 서버로 전서ㅗㅇ하여 처리를 해야하는 경우고유의 데이터 타보다는 문자형 데이터타입으로 파마ㄹ테러를 선언하고 ㅡ 이후에 적절한데이터 타입으로 변환하여 사용 하는 것도 좋은 방법이다 