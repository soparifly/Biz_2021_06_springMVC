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
	border-radius:10px;
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
	border-radius:25px;
	border:2px solid #926e6f;
	text-align: center;
	transition : 0.3s;
}
form#login_form input:focus{
width :280px;
border-color:#926e6f;

}
form#login_form button{
	border:0;
	outline:none;
	background:none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 1px solid #999b84;
	color: white;
	border-radious: 25px;
	cursor:pointer;
}
form#login_form button:hover{
background-color: #926e6f;
transition : 0.6s
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<form id="login_form" method="POST">
	<h2>LOGIN</h2>
		<input name="m_username" placeholder="사용자ID"> <input
			type="password" name="m_password" placeholder="비밀번호">
		<button>로그인</button>
	</form>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_book_insert").addEventListener("click",()=>{
 location.href="${rootPath}/books/insert";
});
</script>

</html>