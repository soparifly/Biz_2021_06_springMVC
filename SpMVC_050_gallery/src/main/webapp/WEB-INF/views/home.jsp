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
	<form
		method="POST"
		enctype="multipart/form-data">
		<div>
			<input
				type="file"
				name="one_file">

		</div>
		<div>
			<input
				type="file"
				multiple="multiple"
				name="m_file" />
		</div>
		<button>전송</button>
	</form>
	
	
	<c:forEach items="${FILES}" var="FILE">
		<a href="${rootPath}/files/${FILE}" target="_NEW">
		<img src="${rootPath}/files/${FILE}"/>
	
	</c:forEach>
</body>
</html>