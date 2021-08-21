<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var ="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div id="content">
  <input type="text" placeholder="검색어입력 후 버튼"/>
  <button id="today">Search</button>
</div>
</body>
<script type="text/javascript">

let todaySearchpicture = document.querySelector("#today");

todaySearchpicture.addEventListener("click", () => {
  console.log("button pressed");
  sendApiRequest();
});

async function sendApiRequest() {
  let API_KEY = "GuIVHqK9rdsyCgchxXjSm9YlfvXxBr8FSVaVPQFo";
  let response = await fetch(
    "https://api.nasa.gov/planetary/apod?api_key="+API_KEY
  );

  console.log(response);
  let data = await response.json();
  console.log(data);
  useApiData(data);
}

function useApiData(data) {
  document.querySelector("#content").innerHTML =
    data.explanation + <img src="`${data.url}`">;
}

</script>
</html>