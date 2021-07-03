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
<style>
td.book_title {
	width: 20%;
	max-width: 0;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

td img {
	padding: 0.5rem;
	border: 1px solid green;
	border-radius: 50%;
	width: 50px;
	height: 50px;
}
</style>
<h1>나의서재</h1>
<table id ="my_books">
	<tr>
		<th>No</th>
		<th>ISBN</th>
		<th>제목</th>
		<th>저자</th>
		<th>출판일</th>
		<th>출판사</th>
	</tr>
	<c:choose>
		<c:when test="${empty MY_BOOKS}">
			<tr>
				<td colspan="6">데이터없음</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach
				items="${MY_BOOKS}"
				var="BOOKS"
				varStatus="ST">
				<tr data-isbn="${BOOKS.isbn}">
					<td>${ST.index}</td>
					<td>${BOOKS.isbn}</td>
					<td class="title">${BOOKS.title}</td>
					<td>${BOOKS.author}</td>
					<td><img
						src="${BOOKS.image}"
						alt="${BOOOKS.title}"
						width="50px" /></td>
					<td>${BKLIST.pubdate}</td>
					<td>${BKLIST.publisher}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<script> 

	let my_books = document.querySelector("table#my_books")
	if(my_books){
		my_books.addEventListener("click",(e)=>{
			let td = e.target
			if(td.tagName ==="TD"){
				let tr = td.closest("TR")
				let isbn = tr.dataset.isbn
				alert(isbn)
			}
		})
	}
</script>

