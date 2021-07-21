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
<table id="sList">
	<c:choose>
		<c:when test="${empty CustomList}">
			<td colspan="2">데이터없음</td>
		</c:when>
		<c:otherwise>
			<c:forEach
				items="${CustomList}"
				var="CUS">
						<tr>
							<c:if test="${empty CUS.file_upname}">
							<td data-seq="${CUS.menu_seq}">
								<img src="${rootPath}/files/noImage.png">
							</td>
							</c:if>
						</tr>
						<tr>
							<c:if test="${not empty CUS.file_upname}">
							<td data-seq="${CUS.menu_seq}">
								<img src="${rootPath}/files/${CUS.file_upname}">
								<h2 id="dot"></h2>
							</td>
							</c:if>
						</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<script>
let tablesList = document.querySelector("table#sList")
if(tablesList) {
	tablesList.addEventListener("click",(e)=>{
		let target = e.target
		let tagName = target.tagName
		if(tagName === "IMG") {
			let td = target.closest("TD")
			let menuSeq = td.dataset.seq
				location.href="${rootPath}/custom/detail?menu_seq=" + menuSeq;
		}
	})
}
</script>