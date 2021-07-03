<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var ="rootPath" value="${pageContext.request.contextPath}" />
	<c:forEach var="MOVIE" items="${MOVIE_LIST}">
			<div>
				<img src="${MOVIE.image}">
				<div class="content">
					<p class="title">${MOVIE.title}</p>
					<a href="${MOVIE.link}"> ${MOVIE.title} </a>
					<p class="author">
						<strong>감독 : </strong>${MOVIE.director}
					<p class="publisher">
						<strong>등장인물 : </strong>${MOVIE.actor}
					</p>
					<p class="userRating">
						<strong>평점: </strong>${MOVIE.userRating}
					</p>
				</div>
			</div>
		</c:forEach>