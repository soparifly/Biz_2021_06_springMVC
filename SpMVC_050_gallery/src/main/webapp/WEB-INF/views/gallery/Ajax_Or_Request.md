# Web에서 Server에 요청하기
 

## 웹에서 서버에 요청하는 방법 

* request 로 요청하고 response로 받는다 , Server의 Controller에게 요청을하고 , 이때 데이터도 보낼수 있다.
* Server에게 요청을 하면 Server는 Web에게 보여줄 데이터를 준비하고 데이터를 가공하여보기 좋게 UI까지 구성하여
	Response하는 구조 - > 전통적인 Client / Server WebApp의 흐름이다
* 어떤 방식으로 Server에게 요청을 하든 서버는 결국 자신의 view와 데이터를 결합하여 
	사용하게(web) HTML의 결과를 response한다.
	
## Ajax(Fetch)로 요청하고 Response로 받기
* Web의 Script에서 Server의 Controller에게 요청을 하고 (이때, 데이터도 보낼수 있다)
* Ajax로 요청을 할때는 Server가 형식이 갖추어진 데이터 (XML, JSON)를 응답하고
	뒷일은 Web의 Script에서 처리한다 라는 무언의 약속이 있다.
	
* Web에서 요청을 할때 단순한 요청(ex. Delete 등 ) 을 하면 요청한 데이터에 따라 
	Server에서 처리를 수행하고, 응답은 성공, 실패, 또는 기타 등등의 단순한 메시지만
	보내게 된다.
	
* Web에서는 단순한 응답을 받고 , Script를 사용하여 다른일들을 수행한다 

* Ajax로 요청을 한다는 것은 서버로부터 단순한 응답만을 받을 것을 기대하고 요청을 한다