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

section.content_box div.content::-webkit-scrollbar{
	opacity: 0;
	width:1px;
}
section.content_box div.content::-sebkit-scrollbar-thumb,
section.content_box div.content::-sebkit-scrollbar-track{
	background-color: transparent;
	transition:3s;

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
</style>
</head>
<nav id="main_nav"></nav>
<body>
	<form>
		<input name="search" placeholder="도서명을 입력후 enter....">
	</form>
	<section class="content_box">
		<c:forEach var="BOOK" items="${BOOKS}">
			<div>
				<img src="${BOOK.image}">
				<div class="content">
					<p class="title">${BOOK.title}</p>
					<a href="${BOOK.link}"> ${BOOK.title} </a>
					<p class="desc">${BOOK.description}</p>
					<p class="author">
						<strong>저자 : </strong>${BOOK.author}
					<p class="publisher">
						<strong>출판사 : </strong>${BOOK.publisher}
					</p>
					<button class="insert">내책</button>
				</div>
			</div>
		</c:forEach>
	</section>
</body>
</html>