<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPatd" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section class="main_sec">
		<table>

			<tr>
				<td>NO</td>
				<td>ISBN</td>
				<td>도서</td>
				<td>출판사</td>
				<td>저자</td>
				<td>출판연도</td>
				<td>가격</td>
				<td>페이지수</td>
			</tr>
			<c:choose>
				<c:when test="${empty BOOKS}">
					<tr>
						<td colspan="8">데이터가 없음</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${BOOKS}" var="BOOK" varStatus="ST">
						<tr>
							<td>${ST.index}</td>
							<td>${BOOK.bk_isbl}</td>
							<td>${BOOK.bk_title}</td>
							<td>${BOOK.bk_comp}</td>
							<td>${BOOK.bk_author}</td>
							<td>${BOOK.bk_date}</td>
							<td>${BOOK.bk_price}</td>
							<td>${BOOK.bk_pages}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

		<div class="btn_box">
			<button class="btn_insert books">도서등록</button>

		</div>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_insert.books").addEventListener("click",()=>{
 location.href="${rootPath}/books/insert";
});
</script>

</html>