<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPatd" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<section class="search_sec">
		<table>
			<tr>
				<td>CODE</td>
				<td>저자명</td>
				<td>전화번호</td>
				<td>주소</td>
				<td>주요장르</td>
			</tr>
			<c:choose>
				<c:when test="${empty AUTHORS}">
					<tr>
						<td colspan="5">데이터가 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${AUTHORS}" var="AUTH">
						<tr data-acode = "${AUTH.au_code}" class="search_author">
							<td>${AUTH.au_code}</td>
							<td>${AUTH.au_name}</td>
							<td>${AUTH.au_tel}</td>
							<td>${AUTH.au_addr}</td>
							<td>${AUTH.au_genre}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</section>
</body>
<script>
document.querySelector("button.btn_insert.author").addEventListener("click",()=>{
 location.href="${rootPath}/author/insert";
});
</script>

</html>