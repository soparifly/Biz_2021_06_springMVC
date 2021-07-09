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
<div>
	<h3>제목: ${GALLERY.g_subject}</h3>
	<h2>SEQ : ${GALLERY.g_seq}</h2>
	<p>작성일 : ${GALLERY.g_date}</p>
	<p>작성일 : ${GALLERY.g_time}</p>
	<p>작성일 : ${GALLERY.g_writer}</p>
	<p>작성일 : ${GALLERY.g_content}</p>
</div>
<style>
div#gallery_file {
	display: flex;
	flex-wrap: wrap;
}

div#gallery_file img {
	margin: 2px;
}
</style>
<div id="gallery_file">
	<c:forEach
		items="${GALLERY.fileList}" 
		var="FILE">
		<c:if test="${empty FILE.file_upname}">
		<img
			src="${rootPath}/files/Noimage.png"
			height="100px">
		</c:if>
		<img
			src="${rootPath}/files/${FILE.file_upname}"
			height="100px">
	</c:forEach>
</div>
<div>
	<button class="gallery update">수정</button>
	<button class="gallery delete">삭제</button>
</div>

<script>
 	let update_button = document.querySelector("button.gallery.update")
 	let delete_button = document.querySelector("button.gallery.delete")

 	update_button.addEventListener("click",()=>{
 			alert("일련번호 ${GALLERY.g_seq}인 게시물수정 ")	
 	
 			location.href="${rootPath}/gallery/update" + "?g_seq=${GALLERY.g_seq}"
 	
 	})
 	
 	delete_button.addEventListener("click",()=>{
 		
 		if(confirm("일련번호 ${GALLERY.g_seq}인 게시물삭제 ??"))	{
 	 	location.replace("${rootPath}/gallery/delete"
 	 				+	"?g_seq=${GALLERY.g_seq}")
 		}
 	})
</script>
