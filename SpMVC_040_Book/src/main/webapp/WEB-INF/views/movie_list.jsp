<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var ="rootPath" value="${pageContext.request.contextPath}" />
	<c:forEach var="MOVIE" items="${MOVIES}">
			<div>
				<img src="${MOVIE.image}">
				<div class="content">
					<p class="title">${MOVIE.title}</p>
					<a href="${MOVIE.link}"> ${MOVIE.title} </a>
					<p class="desc">${MOVIE.description}</p>
					<p class="author">
						<strong>저자 : </strong>${MOVIE.author}
					<p class="publisher">
						<strong>출판사 : </strong>${MOVIE.publisher}
					</p>
					<button class="insert">내책</button>
				</div>
			</div>
		</c:forEach>