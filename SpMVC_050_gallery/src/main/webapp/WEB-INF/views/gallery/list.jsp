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
div.ga_box {
	/* display: flex; */
	width: 60%;
	margin: 0 auto;
	border: 10px inset #aaa;
	border-radius: 3px;
	height: 300px;
	text-align: center;
	padding: 30px;
	background: white;
}

div.listimg {
	display: inline-block;
	width: 300px;
	padding: 0 auto;
}

div.text {
	
}

div.ga_box div:first-of-type {
	flex: 1;
}

div.ga_box div:last-of-type {
	flex: 3;
}

a:link {
	text-decoration: none;
}

a:link:hover {
	cursor: pointer;
}
</style>
<%@ include file="/WEB-INF/views/include/include_gallery_search.jspf"%>
<c:forEach
	items="${GALLERYS}"
	var="GALLERY"
	varStatus="ST">
	<div class="ga_box">
		<div class="listimg">
			<c:if test="${empty GALLERY.g_image}">
				<img
					src="${rootPath}/files/Noimage.png"
					width="100px">
			</c:if>
			<c:if test="${not empty GALLERY.g_image}">
				<img
					src="${rootPath}/files/${GALLERY.g_image}"
					width="100px">
			</c:if>
		</div>
		<div id="text">
			<h3>
				<a href="${rootPath}/gallery/detail2/${GALLERY.g_seq}">
					${GALLERY.g_subject}(${GALLERY.g_seq})</a>
			</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>

</c:forEach>
<%@ include file="/WEB-INF/views/include/include_page_nav.jspf" %>
