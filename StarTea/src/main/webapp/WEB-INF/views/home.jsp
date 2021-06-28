<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Startea project
	<form>
		<fieldset>
			<tr>
				<td><label for="category1">음료종류</label>
				<c:forEach items="${ctList}">
				<select id="category1">
				<option data-cate value="${ctList}">${ctList}</option>
				</select>
				</c:forEach>
			</tr>
		</fieldset>
	</form>
</body>
</html>