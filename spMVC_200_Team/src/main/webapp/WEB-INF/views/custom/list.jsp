<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
	<style>
	#customlist td{
	display: flex;
	
	}
	
	</style>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
	<fieldset id="custom">
		<h1 id="costom">커스텀게시판</h1>
		<div class="btn_box">
			<button class="btn_insert">메뉴 등록</button>
		</div>
		<table id="customlist">
			<c:choose>
				<c:when test="${empty CustomList}">
					<td colspan="2">데이터없음</td>
				</c:when>
				<c:otherwise>
					<c:forEach
						items="${CustomList}"
						var="CUS">
						<tr>
							<td>메뉴코드 : ${CUS.menu_code}</td>
							<td>퍼스널 옵션 : ${CUS.menu_option}</td>
							<td>메뉴 제목 : ${CUS.menu_title}</td>
							<td>작성자 : ${CUS.user_id}</td>
							<td>그림 : <img src = "${rootPath}/files/${CUS.file_upname}"></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</fieldset>
<script>
let menu_input = document.querySelector("button.btn_insert")
		menu_input.addEventListener("click",()=>{
			location.href = "${rootPath}/custom/input"
	})
	
</script>