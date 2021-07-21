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
<%@ include file="/WEB-INF/views/include/search.jsp"%>
<fieldset>
	<table id="customlist">
		<c:choose>
			<c:when test="${empty CustomList}">
				<td colspan="5">데이터없음</td>
			</c:when>
			<c:otherwise>
				<c:forEach
					items="${CustomList}"
					var="CUS">
					<tr class="customTr">
						<td><h3>${CUS.user_id}</h3></td>
					</tr>
					<c:if test="${empty CUS.file_upname}">
						<tr>
							<td><img src="${rootPath}/files/noImage.png"></td>
						</tr>
					</c:if>
					<c:if test="${not empty CUS.file_upname}">
						<tr>
							<td><img src="${rootPath}/files/${CUS.file_upname}"></td>
						</tr>
						<tr>
							<td>제목 : ${CUS.menu_title}</td>
						</tr>
						<tr>
							<td>옵션 : ${CUS.menu_option}</td>
						</tr>
						<tr>
							<td>종류 : ${CUS.menu_name}</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</fieldset>