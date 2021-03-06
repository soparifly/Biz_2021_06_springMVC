<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="https://kit.fontawesome.com/a0b991b540.js" crossorigin="anonymous"></script> -->
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

header {
	border-bottom: 1px solid #333;
	width: 100%;
	background-color: white;
}

header h2 {
	font-weight: 500;
	padding: 10px;
	color: #D5DBB3;
}



body {
	width: 100%;
	bottom:0;
	height: 100vh;
}

#main_sec {
	dispaly: block;
	background: #D5DBB3;
	font-size: 14px;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<h2>이미지갤러리</h2>
		<%@ include file="/WEB-INF/views/include/include_nav.jspf"%>
		<script src="https://kit.fontawesome.com/a0b991b540.js" crossorigin="anonymous"></script>
	</header>
	<section id="main_sec">
		<c:choose>
			<c:when test="${BODY == 'GA-INPUT'}">
				<%@ include file="/WEB-INF/views/gallery/input.jsp"%>
			</c:when>
			<c:when test="${BODY == 'GA-LIST'}">
				<div id="piclist">
					<%@ include file="/WEB-INF/views/gallery/list.jsp"%>
					<a href="${rootPath}/gallery/input">이미지 등록</a>
				</div>
			</c:when>
			<c:when test="${BODY == 'GA-DETAIL'}">
				<%@ include file="/WEB-INF/views/gallery/detail.jsp"%>
			</c:when>
			<c:when test="${BODY == 'GA-DETAIL-V2'}">
				<%@ include file="/WEB-INF/views/gallery/detail2.jsp"%>
			</c:when>
			<c:when test="${BODY == 'JOIN'}">
				<%@ include file="/WEB-INF/views/member/join.jsp"%>
			</c:when>
			<c:when test="${BODY == 'LOGIN'}">
				<%@ include file="/WEB-INF/views/member/login.jsp"%>
			</c:when>
			<c:otherwise>
				<a href="${rootPath}/gallery/input">이미지 등록</a>
			</c:otherwise>
		</c:choose>
		<c:forEach
			items="${FILES}"
			var="FILE">
			<a
				href="${rootPath}/files/${FILE}"
				target="_NEW"> <img src="${rootPath}/files/${FILE}" />
			</a>
		</c:forEach>
	</section>
	<script>
	let main_nav = document.querySelector("nav#main_nav")
	if(main_nav){
			main_nav.addEventListener("click",(e)=>{
				let menu = e.target
				if(menu.tagName === "LI"){
					if(menu.id === "join"){
						location.href = "${rootPath}/member/join"
					}
					else if(menu.id === "logout"){
						location.href = "${rootPath}/member/logout"
					}
					else if(menu.id === "image_create"){
						location.href ="${rootPath}/gallery/input"
					}
					else if(menu.id === "home"){
						location.href = "${rootPath}/"
					}
					else if(menu.id === "login"){
						location.href = "${rootPath}/member/login/nav"
					}
				}
			})
		}
	</script>
</body>
</html>