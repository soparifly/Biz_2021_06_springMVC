# WAS(Web Server Application) , (Web Application Server:tomcat)에서 HTTP Status code

## 정상적인 Request 와 Response가 이루어 졌을때

- 200번 코드  (직접 볼수없다 ,가장 완벽한 상태는  왜냐하면 실행이 잘되어서 서버에서 보냇지만 화면은 내가구현한대로만나오기때문)
- 300 : Redirection이 되거나 , 이전 응답과 동일한 결과일때

---

## Request가 잘못되었을 때

- 404 :  URI를 잘못 요청 했을때, Tomcat Server mehtod에서 Rendering 할 JSP 파일을 못찾았을때 (메시지가 포함된다)
- 405 : Request한 URI mapping을 찾을 수 있으나 Request한 method가 해당하는 항목이 없을때
- 400 :  서버에 데이터를 전송했는데, 데이터 type이 잘못되었을때
    - 예) Java method의 매개변수가 숫자형 인데 전송하는 데이터에 공백, 문자열, null 값이 포함되어 있는 경우

---

## 서버 내부 오류

- 500 :  내부에서 코드가 실행 되는 동안 Exception이 발생하는 경우 오류메시지를 검토하여 잘 찾아야한다
- 개발자가 만든 코드에서 메시지 찾기 exception종류 이해하기