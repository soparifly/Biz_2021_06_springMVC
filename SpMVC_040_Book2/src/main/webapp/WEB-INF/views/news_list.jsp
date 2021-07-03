<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var ="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach var="NEWS" items="${NEWS_LIST}">
	<div>
		<img src="${NEWS.image}">
		<div class="content">
			<p class="title">${NEWS.title}</p>
			<a href="${NEWS.link}"> ${NEWS.title} </a>
			<p class="desc">${NEWS.description}</p>
			<p class="naver">
			<a href="${NEWS.link}" target="_NEWS">		<p class="origin">
				<a href="${NEWS.originallink}">언론사바로가기</a>
				${NEWS.originllink}
			<p class="publisher">
				<strong>출판사 : </strong>${NEWS.publisher}
			</p>
		</div>
	</div>
</c:forEach>