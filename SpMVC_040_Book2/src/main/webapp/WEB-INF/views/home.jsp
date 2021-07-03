<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

p b {
	color: #D7B19D;
}

body {
	display: flex;
	flex-direction: column;
	height: 100vh;
}

nav#main_nav {
	background-color: rgba(0, 255, 0, 0.7);
	display: flex;
	justify-content: center;
	align-items: center;
	background-size: 100% 100%;
}

nav#main_nav form {
	margin: 0.6rem;
	width: 50%;
}

nav#main_nav input {
	padding: 8px;
	border: 0;
	outline: 0;
	width: 100%;
	border-radius: 10px;
}
/* 검색 결과가 표시되는 영역은 scroll지정하고 상단에 검색창 nav는 화면에 고정하기  
1.body에 
display: flex
flex-direction:clum;
height:100vh;
2.검색 결과창에
flex:1
overflow: auto;



*/
section.content_box {
	flex: 1;
	border: 1px solid green;
	padding: 12px 16px;
	display: flex;
	flex-wrap: wrap;
	background-size: 100% 100%;
	overflow: auto;
}

section.content_box div.content {
	border: 1px solid yellowgreen;
	margin: 5px auto;
	display: flex;
	width: 30%;
	height: 30vh;
	overflow: auto;
	transition: 0.5s;
}

section.content_box div.content::-webkit-scrollbar {
	opacity: 0;
	width: 1px;
}

section.content_box div.content::-webkit-scrollbar-thumb, section.content_box div.content::-webkit-scrollbar-track
	{
	background-color: transparent;
	transition: 3s;
}

section.content_box div.content::-webkit-scrollbar {
	opacity: 1;
	width: 1px;
}

section.content_box div.content::-webkit-scrollbar {
	opacity: 1;
	width: 1px;
	background-color: blue;
}

@media ( max-widht :1000px) {
	section.content_box div.content {
		width: 20%;
	}
}

section.content_box img {
	flex: 1;
}

section.content_box div {
	flex: 2;
}

a {
	text-decoration: none;
}

a:hover {
	color: green;
}

nav#main_nav form {
	margin: 0.2rem;
	width: 50%;
}

nav#main_nav input {
	padding: 8px;
	border: 0;
	outline: 0;
	width: 100%;
	border-radius: 10px;
}

nav#main_nav select {
	padding:8px;
	width: 20%;
	border-radius: 10px;
	
}
table{
 	width: 95%;
 	border-collapse: collapse;
 	border-spacing: 0;
	margin: 0;
}
th, td{
	white-space: nowrap;
	padding: 16 12px;
	border-top: 1px solid #ddd;

}
/* 가장 끝에 나타난 td에는 아래쪽에도 선을 만들기 */
tr:last-child td{
	border-bottom: 1px solid #ddd;
	
}


</style>
</head>
<body>
<nav id="main_nav">

	<c:if test="${CAT=='BOOK'}">
		<c:set var="pHolder" value="도서 검색어"/>
	</c:if>
	<c:if test="${CAT=='NEWS'}">
		<c:set var="pHolder" value="도서 검색어"/>
	</c:if>
	<c:if test="${CAT=='MOVIE'}">
		<c:set var="pHolder" value="도서 검색어"/>
	</c:if>
	
	
	<select name="category">
		<option value="BOOK"
		<c:if test="${CAT == 'BOOK'}">selected="selected"
		</c:if>>도서검색</option>
		<option value="MOVIE"
		<c:if test="${CAT == 'MOVIE'}">selected="selected"
		</c:if>>영화검색</option>
		<option value="NEWS"
		<c:if test="${CAT == 'NEWS'}">selected="selected"
		</c:if>>뉴스검색</option>
	</select>
	<form>
		<input name="search" placeholder="${pHolder}를 입력후 enter....">
	</form>
</nav>
	<section class="content_box">
	<%@ include file="/WEB-INF/views/book_list.jsp" %>
	<%@ include file="/WEB-INF/views/movie_list.jsp" %>
	<%@ include file="/WEB-INF/views/news_list.jsp" %>
	
	<c:if test="${not empty MY_BOOKS}">
		<%@include file="/WEB-INF/views/book/list_view.jsp" %>
	</c:if>
	</section>
</body>
<script>
let category = document.querySelector("select[name='category']")

category.addEventListener("change",(e)=>{
	
	let value = category.value
	/* alert(value) */

/* 	location.href= "${rootPath}/?category=" +value; */
	location.href= "${rootPath}/naver/" +value;
})


</script>
</html>