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
<fieldset>
		<table id="detail">
			<tr>
				<td><h3 id="detailID">${DETAIL.user_id}</h3></td>
			</tr>
			<tr>
				<td id="detailImg"><img
					src="${rootPath}/files/${DETAIL.file_upname}"></td>
			</tr>
			<tr>
				<td id="detailTitle">${DETAIL.menu_title}</td>
			</tr>
			<tr>
				<td id="detailOption">${DETAIL.menu_option}</td>
			</tr>
			<tr>
				<td id="detailMenu">${DETAIL.menu_name}</td>
			</tr>
		</table>
</fieldset>
<section>
	<c:if test="${SECTION eq 'COMMENT' }">
		<%@ include file="/WEB-INF/views/include/comment.jsp"%>
		<%@ include file="/WEB-INF/views/include/comment_input.jsp"%>
	</c:if>
	
</section>