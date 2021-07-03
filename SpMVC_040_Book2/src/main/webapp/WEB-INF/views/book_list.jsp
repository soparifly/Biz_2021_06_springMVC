<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var ="rootPath" value="${pageContext.request.contextPath}" />
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
					<a href="${rootPath}/book/insert/${BOOK.isbn}">내 서재 등록</a>

				</div>
			</div>
		</c:forEach>