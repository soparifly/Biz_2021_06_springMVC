<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-cale:1" />
<title>대한고교 성적처리 V1</title>
<style>
@font-face {
	font-family: 'LAB디지털';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/LAB디지털.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'LAB디지털';
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	color: whitesmoke;
}

h1, p {
	color: whitesmoke;
	margin: 0 auto;
}

body {
	height: 100vh;
	width: 100wv;
	display: flex;
	flex-direction: column;
	width: 100wv;
}

header {
	height: 40vh;
	/* 	background: url("${rootPath}/static/images/header_background.jpg")
		no-repeat;
 */
	display: flex;
	padding: 10px;
	justify-content: center;
	align-items: center;
	border: 1px dotted white;
	background-color: blue;
	background-size: 100% 100%;
	background-position: top;
	background-attachment: fiexd;
	text-align: center;
	text-shadow: 2px 2px 2px 2px blue;
	color: whitesmoke;
	/* padding: 3rem;/*  * */
	/
}

header div {
	width: 100%;
	height: 100%;
	padding: 2rem;
	border: 1px dotted white;
}

nav{
 	background-color:blue;
 	color:whitesmoke; 
	width:100wv;
 }

nav ul{
	list-style: none;
	display:flex;
	margin:0 20px;
	
}
nav li {
	padding: 16px 12px;
	border-bottom: 3px dotted transparent;
	transition:1s;
	cursor: pointer;
}

nav li:hover{
	border-bottom: 3px solid yellow;
}

nav li:nth-of-type(2){
	margin-left: 0 auto;

}

nav.fixed{
	positon: fixed;
	top:0;
	left:0;
	right: 10px;
	border-bottom-right-radious:20px;
	box-shadow: 3px 3px 3px rba(0,0,0,0.5);
	
}

section#main_sec {
	flex: 1;
	width: 100wv;
	display: flex;
	flex-direction: column;
	/* 	background: url("${rootPath}/static/images/section_background.jpeg")
		no-repeat; */
	background-color: blue;
	/* background: linear-gradient(to bottom, blue, red); */
	background-size: 100% 100%;
	background-attachment: fixed;
	
	/*
	
	overflow:auto;
	header 와 nav를 화면에 고정하고
	data가 보이는 부분만 scroll 하기 위하여
	section#main_sec 에 overflow 속성 부여하기

	  */

}

table {
	border: 1px dotted whitesmoke;
	width: 90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin: 10px auto;
	color: whitesmoke;
}

tr {
	/* 	border-top: 1px solid green; */
	
}

tr:last-child {
	border-bottom: 1px solid BFFF00;
}

tr:nth-of-type(odd) {
	/* background-color: #eee; */
	
}

tr:nth-of-type(even) {
	/* 	background-color: #ccc; */
	
}

tr:hover {
	/* background-color: #aaa; */
	cursor: pointer;
}

td, th {
	/* 	border-right: 1px solid green; */
	padding: 8px 12px;
	text-align: center;
}

td:last-child, th:last-child {
	border: none;
}

td.class {
	text-align: right;
}

div.btn_box {
	width: 90%;
	/* 테이블의 margin은 10px auto 로 설정되어 있기 때문에 
top margin 0 으로 bottom margin은 10px 좌우는 auto  
*/
	margin: 0px auto 10px auto;
	padding: 5px;
	text-align: right;
}

div.btn_box button {
	border: 0;
	/* 버튼을 클릭했을때 테두리가 남지않는 효 */
	outline: 0;
	padding: 12px 16px;
	margin-left: 10xp;
	border-radius: 5px
}

button:hover {
	box-shadow: 0px 0px 1px 0px white;
	cursor: pointer;
}

button.save {
	 background-color: blue;
	border: 1px dotted smokewhite;
	color: white;
}

button.reset {
	background-color: blue;
	border: 1px dotted smokewhite;
	color: white;
}

button.student.list {
	border: 1px dotted smokewhite;
	background-color: blue; 
	color: smokewhite;
}

button.home {
	border: 1px dotted smokewhite;
	background-color: blue;
	color: smokewhite;
}

button.update {
	border: 1px dotted smokewhite;
	background-color: blue;
	color: smokewhite;
}

button.delete {
	border: 1px dotted smokewhite;
	background-color: blue;
	color: smokewhite;
}
button.list {
	background-color: blue;
	border: 1px dotted smokewhite;
	color: smokewhite;
}
button.student.insert {
	background-color: blue;
	border: 1px dotted smokewhite;
	color: smokewhite;
}

button.student.home {
	background-color: blue;
	border: 1px dotted smokewhite;
	color: smokewhite;
}

form {
	width: 90%;
	margin: 0 auto 10px auto;
	padding: 20px;
}

form label, form input {
	display: inline-block;
	margin: 5px;
	padding: 5px;
}

form label {
	width: 30%;
	text-align: right;
}

form input {
	width: 60%;
	outline: 0;
	border: 1px dotted whitesmoke;
	border-radius: 50px;
	background-color: blue;
}

fieldset {
	background-color: blue;
	border: 1px solid whitesmoke;
	border-radius: 10px;
	padding: 0.7rem;
	margin: 0.7rem;
}

form input:hover {
	background: #bbb
}
</style>
</head>
<body>
	<header>
		<div>
			<h1>대한고교 성적처리 V1</h1>
			<p>대한 고교 성적 처리 시스템 2021</p>
		</div>
	</header>
		<nav id="main_nav">
			<ul>
				<li>HOME</li>
				<li>로그인</li>
				<li>로그아웃</li>
				<li>관리자</li>
			</ul>
		</nav>
	<section id="main_sec">
		<c:choose>
			<c:when test="${ BODY == 'SCORE_VIEW' }">
				<%@ include file="/WEB-INF/views/score/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_LIST' }">
				<%@ include file="/WEB-INF/views/student/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_INPUT' }">
				<%@ include file="/WEB-INF/views/student/input.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_DETAIL' }">
				<%@ include file="/WEB-INF/views/student/detail.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
</body>
<script>
/* JS 코드에서 event를 등록할때 현재 화면에 없는 DOM 요소에 addEventListener를 설정하면 없는 함수라는 오류가 발생한다
 * 	그이유는 현재 화면에 없는 DOM 요소를 querySelector하면 그 결과 값이 null 이기때문에 발생하는 문제이다
 JS 코드를 통합하여 모음으로 관리할때는 addEvent를 수행하려고 하는 요소가 있는 지를 먼저 검사한 후 add EventListener를 수행해주어야한다.
 */
let std_list = document.querySelector("button.student.list");
let std_insert = document.querySelector("button.student.insert");
let home = document.querySelector("button.student.home");

	if(std_list){
		document.querySelector("button.student.list")
			.addEventListener("click",(e)=>{
					location.href="${rootPath}/student"
		})
	}
	if(std_insert){
		document.querySelector("button.student.insert")
			.addEventListener("click",(e)=>{
		
					location.href="${rootPath}/student/insert"
		})
	}
	if(home){
		document.querySelector("button.student.home")
			.addEventListener("click",(e)=>{
		
					location.href="${rootPath}/score"
	})
	}
	
let table = document.querySelector("table.detail")
	if (table){
		document.querySelector("table")
			.addEventListener("click",(e)=>{
				let target = e.target
				let tagName = target.tagName
	
			if(tagName === "TD"){
				let tr = target.closest("TR")
				let stNum = tr.dataset.st_num
							/* 	alert(stNum) */
				location.href="${rootPath}/student/detail?st_num="+stNum;	
				}
		
		})
	}
	/* 화면이 아래 방향으로 스크롤될때
	화면문서의 top 좌표를 추출하여
	header box의 높와 비교한다
	header bxo의 높이에 -1 을 곱하고 그 값보다 작아지면===headerbox가화면에서 사라지면

	*/
let main_nav = document.querySelector("nav#main_nav")
let main_header = document.querySelector("header")
/* header box의 높이가 얼마 */
let main_header_height = main_header.offsetHeight;

	document.addEventListener("scroll",()=>{
		/* HTML 문서 전체의 크기 , 좌표 등을 추출하기 */
		let doc_bound = document.querySelector("HTML")
						.getBoundingClientRect();
		let doc_top = doc_bound.top
		
		if (doc_top < main_header_height * -1 ){
			main_nav.classList.add("fixed")
		} else {
			main_nav.classList.remove("fixed")
		}
})


</script>
</html>