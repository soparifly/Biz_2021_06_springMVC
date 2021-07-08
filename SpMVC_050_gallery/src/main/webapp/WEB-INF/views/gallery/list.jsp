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
	width:60%;
	margin:0 auto;
	border: 10px inset #aaa;
	border-radius: 3px;
	height: 300px;
	text-align: center;
	padding:30px;
	background: white;
}
div.listimg{
	display: inline-block;
	width : 300px;
	padding:0 auto;
}
div.text{
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
<c:forEach
	items="${GALLERYS}"
	var="GALLERY"
	varStatus="ST">
	<div class="ga_box">
		<div class="listimg">
			<img
				src="${rootPath}/files/${GALLERY.g_image}"
				width="100px">
		</div>
		<div id="text">
			<h3>
				<a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">
					${GALLERY.g_subject}
				</a>
			</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>

</c:forEach>