<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPatd" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
form#login_form {
	width: 400px;
	padding: 40px;
	background-color: #999b84;
	text-align: center;
	margin: 100px auto;
	border-radius: 10px;
}

form#login_form h2 {
	color: #e6c4c0;
	font-weight: 500;
}

form#login_form input {
	background-color: #926e6f;
	outline: 0;
	display: block;
	width: 200px;
	margin: 20px auto;
	padding: 14px 10px;
	color: #e6c4c0;
	border-radius: 25px;
	border: 2px solid #926e6f;
	text-align: center;
	transition: 0.3s;
}

form#login_form input:focus {
	width: 280px;
	border-color: #926e6f;
}

form#login_form button {
	border: 0;
	outline: none;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 1px solid #999b84;
	color: white;
	border-radious: 25px;
	cursor: pointer;
}

from#login_form button.btn_join {
	background-color: #0000aa;
}

form#login_form button:hover {
	background-color: #926e6f;
	transition: 0.6s
}

form#login_form div.msg {
	margin: 0 auto;
	background-color: red;
	color: yellow;
	font-size: 10px
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<form id="login_form" method="POST">
		<h2>LOGIN</h2>
		<div class="msg">${MSG}</div>
		<input name="m_username" placeholder="사용자ID" id="m_username">
		<input type="password" name="m_password" placeholder="비밀번호"
			id="m_password">
		<button type="button" class="btn_login">로그인</button>
		<button type="button" class="btn_join">회원가입</button>
	</form>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("div.msg").style.display="${MSG}"
document.querySelector("button.btn_join").addEventListener("click",()=>{
 location.href="${rootPath}/member/join";
});
document.querySelector("button.btn_login").addEventListener("click",()=>{
	let username= document.querySelector("input#m_username")
	let password= document.querySelector("input#m_password")
	/* view 단에서 입력 유효성 감사하기
	값이 입력되었는가를 검사하기
	입력되지 않으면 alert을 보이고 입력 box에 focus 주기*/
	/* 프론트에서 사용하는 입력단 검사 */
	if(username.value===""){
		alert("사용자 ID를 입력하세요")
	username.focus();
		return false;
	}
	if(password.value===""){
		alert("비밀번호를 입력하세요")
		password.focus()
		return false;
	}
	/* 유효성 검사를 통과하면 서버로 전송하기 */
	document.querySelector("form#login_form").submit();
})
</script>

</html>