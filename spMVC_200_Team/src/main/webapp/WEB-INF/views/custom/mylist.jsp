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
#MYLISTfieldset {
	padding: 0;
	margin: 20px auto;
	width: 100%;
	border: 1px solid transparent;
	text-align: center;
	justify-content: center;
/* 	display: flex; */
}

#MYLISTtable {
	display: flex;
	margin: 19px auto;
	padding: 0;
	justify-content: center;
}

#MYLISTTr {
	margin: 30px auto;
	margin-bottom: 100px;
}

#MYLISTtable td {
	margin: 10px;
	display: flex;
	font-size: 50px;
	font-weight: 400;
}

#MYLISTtable td:nth-of-type(1) {
	margin-top: 80px;
}

#MYLISTlast {
	border-bottom: 1px double #aaa;
	padding-bottom: 70px;
}

#MYLISTimg img {
	display: inline-block;
	border-radius: 30px;
	width: 800px;
	margin: 0 auto;
}

h3#mylistuser {
	margin: 10px auto;
	font-size: 80px;
	font-weight: 400;
}

h3#mylistuser:before {
	content: ' \2730';
	color: green;
	font-size: 100px;
}
</style>
<fieldset id="MYLISTfieldset">
	<h3 id="mylistuser">${USERVO.user_id}님 안녕하세요!</h3>
	<table id="MYLISTtable">
		<c:choose>
			<c:when test="${empty MYLIST}">
				<td colspan="5">데이터없음</td>
			</c:when>
			<c:otherwise>
				<c:forEach
					items="${MYLIST}"
					var="MYLIST">
					<tr id="MYLISTTr">
						<td id="MYLISTimg"><img
							src="${rootPath}/files/${MYLIST.file_upname}"></td>
						<td>메뉴 제목 : ${MYLIST.menu_title}</td>
						<td>퍼스널 옵션 :${MYLIST.menu_option}</td>
						<td id="MYLISTlast">메뉴종류 : ${MYLIST.menu_name}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</fieldset>
