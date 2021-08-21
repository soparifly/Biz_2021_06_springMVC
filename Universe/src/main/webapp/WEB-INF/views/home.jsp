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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
			<c:forEach items="${GALLERY}" var="G">
				<div>
				<img src="${rootPath}/files/${G.g_image}" width="300px">
				
				</div>
			</c:forEach>	
			</section>
			<section>
			
			
	<form method="POST" enctype="multipart/form-data">
		<div>
		<label>작성자</label>
		<input type="text" name="g_writer" value="${galleryDTO.g_writer}" placeholder="작성자이">
		</div>
		<div>
		<label>작성일자</label>
		<input type="date" name="g_date" value="${galleryDTO.g_date}" placeholder="작성자이">
		</div>
		<div>
		<label>작성일자</label>
		<input type="time" name="g_time" value="${galleryDTO.g_time}" placeholder="작성자이">
		</div>
		<div>
		<label>제목</label>
		<input type="text" name="g_title" value="${galleryDTO.g_writer}" placeholder="작성자이">
		</div>
		<div>
			<label>내</label>
			<input type="text" value="${galleryDTO.g_content}" name="g_content"></textarea>
		</div>
		<div>
		<label>사진 Test 단일</label>
		<input
			type="file"
			name="one_file">
		<button id="one_send">전송</button>
		<label>사진 Test 목록</label>
		</div>
		<div>
			<input
				type="file"
				multiple="multiple"
				name="multi_file" />
			<button id="multi_send">전송</button>
		</div>
	</form>
	
	</section>
</body>
</html>