<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<%@include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<%@include file="/WEB-INF/views/include/include_header.jspf"%>
	<section id="main_sec">
		<article>
			<h3>출판사</h3>
			<ul>
				<c:choose>
					<c:when test="${not empty COMPS}">
						<c:forEach var="index" begin="0" end="4">
							<li>${COMPS[index].cp_title}</li>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<li>출판사정보</li>
						<li>출판사정보</li>
						<li>출판사정보</li>
						<li>출판사정보</li>
						<li>출판사정보</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</article>
		<article>
			<h3>도서정보</h3>
			<ul>
				<c:choose>
					<c:when test="${not empty BOOKS}">
						<c:forEach var="index" begin="0" end="4">
							<li>${BOOKS[index].bk_title},&nbsp;&nbsp;
								${BOOKS[index].bk_ccode} ${BOOKS[index].bk_acode}</li>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<li>도서정보없음</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</article>
		<article>
			<h3>저자정보</h3>
			<ul>
				<c:choose>
					<c:when test="${not empty AUTHORS}">
						<c:forEach var="index" begin="0" end="4">
							<li>${AUTHORS[index].au_name},&nbsp;&nbsp;
								${AUTHORS[index].au_tel} ${AUTHORS[index].au_genre}</li>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<li>도서정보없음</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</article>
	</section>
	<section id="ad_sec">

		<article></article>
		<article></article>
		<article></article>
		<article></article>
		<article></article>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>

</body>
</html>