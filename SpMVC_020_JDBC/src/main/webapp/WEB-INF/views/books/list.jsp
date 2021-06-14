<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPatd" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<h1 class="page_title">도서정보</h1>

	<table>

		<tr>
			<td>ISBN</td>
			<td>도서</td>
			<td>출판사</td>
			<td>저자</td>
			<td>출판연도</td>
			<td>가격</td>
			<td>페이지수</td>
		</tr>
		<tr>
			<td>ISBN</td>
			<td>도서</td>
			<td>출판사</td>
			<td>저자</td>
			<td>출판연도</td>
			<td>가격</td>
			<td>페이지수</td>
		</tr>
	</table>

	<div class="btn_box">
		<button class="btn_insert books">도서등록</button>

	</div>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_insert.books").addEventListener("click",()=>{
 location.href="${rootPath}/books/insert";
});
</script>

</html>