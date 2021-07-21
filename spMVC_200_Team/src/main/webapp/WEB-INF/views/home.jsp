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
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta
	http-equiv="X-UA-Compatible"
	content="IE=edge" />
<meta
	name="viewport"
	content="width=device-width, initial-scale=1.0" />
<title>HOME : STARBUCKS CUSTOM</title>
	<link href="${rootPath}/static/css/home.css?ver2021-07-21-005" rel="stylesheet" />
</head>
<header id="home_header">
	<h1>STARBUCKS CUSTOM<h1>
	<%@ include file="/WEB-INF/views/include/include_nav.jspf"%>
</header>
<body>
	<%@ include file="/WEB-INF/views/include/include_subnav.jspf"%>
	<section id="main_sec">
		<c:choose>
			<c:when test="${BODY eq 'INPUT-HOME'}">
				<%@ include file="/WEB-INF/views/custom/input.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'INPUT-KINDS'}">
				<%@ include file="/WEB-INF/views/custom/input2.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'INPUT-SAVE'}">
				<%@ include file="/WEB-INF/views/custom/save.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'CUSTOM-LIST'}">
				<%@ include file="/WEB-INF/views/custom/list.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'CUSTOM-MYLIST'}">
				<%@ include file="/WEB-INF/views/custom/mylist.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'CUSTOM-DETAIL'}">
				<%@ include file="/WEB-INF/views/custom/detail.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'SEARCH-LIST'}">
				<%@ include file="/WEB-INF/views/custom/searchlist.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'LOGIN'}">
				<%@ include file="/WEB-INF/views/user/login.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'JOIN'}">
				<%@ include file="/WEB-INF/views/user/join.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'UPDATE-ID'}">
				<%@ include file="/WEB-INF/views/user/userupdate.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'FAIL_LOGIN'}">
				<%@ include file="/WEB-INF/views/custom/mylist.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/custom/smallList.jsp"%>
			</c:otherwise>
		</c:choose>
		<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
	</section>
</body>
<script>
	var rootPath = "${rootPath}";
	document.addEventListener("DOMContentLoaded", () => {
		  const nav = document.querySelector("nav#main_nav");

		  nav.addEventListener("click", (e) => {
		    let tagName = e.target.tagName;
		    let urlPath = `${rootPath}`;
		    if (tagName === "LI") {
		      let menuText = e.target.textContent;
		      if (menuText === "HOME") {
		        urlPath += "/";
		      } else if (menuText === "CUSTOM") {
		        urlPath += "/custom/input";
		      } else if (menuText === "BOARD") {
		       /*  urlPath += "/board"; */
		      } else if (menuText === "LOGIN") {
		        urlPath += "/user/login";
		      } else if (menuText === "LOGOUT") {
	            urlPath += "/user/logout";
	          }
		      location.href = urlPath;
		    }
		  });
		});
	</script>
	</html>
	
	