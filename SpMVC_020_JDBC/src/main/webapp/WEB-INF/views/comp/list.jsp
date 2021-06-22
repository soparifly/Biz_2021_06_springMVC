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
			<td>CODE</td>
			<td>출판사명</td>
			<td>대표</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>주요장르</td>
		</tr>
		<c:choose>
		<c:when test="${empty COMPS}">
			<tr><td colspan="6">데이터가 없음 </td>
		</c:when>
		<c:otherwise>
			<c:forEach items="${COMPS}" var="COMP" varStatus="seq">
				<tr>
					<td>${COMP.cp_code}</td>
					<td>${COMP.cp_title}</td>
					<td>${COMP.cp_ceo}</td>
					<td>${COMP.cp_tel}</td>
					<td>${COMP.cp_addr}</td>
					<td>${COMP.cp_genre}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</table>

	<div class="btn_box">
		<button class="btn_insert comp">출판사등록</button>

	</div>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_insert.comp").addEventListener("click",()=>{
 location.href="${rootPath}/comp/insert";
});
</script>

</html>