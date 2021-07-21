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
<fieldset id="MYLISTfieldset">
	<form action="${rootPath}/user/update">
		<h3 id="mylistuser">
			<p>${LOGIN.user_id}님</p>
			안녕하세요!
		</h3>
		<button
			name="user_id"
			value="${LOGIN.user_id}">회원정보수정</button>
	</form>
	<table id="MYLIST">
		<c:choose>
			<c:when test="${empty MYLIST}">
				<td colspan="5">데이터없음</td>
			</c:when>
			<c:otherwise>
				<c:forEach
					items="${MYLIST}"
					var="MYLIST">
					<tr>
						<td><c:if test="${empty MYLIST.file_upname}">
								<img
									src="${rootPath}/files/noImage.png"
									alt="main_image">
							</c:if> <c:if test="${not empty MYLIST.file_upname}">
								<img src="${rootPath}/files/${MYLIST.file_upname}">
							</c:if>
						<td>메뉴 제목 : ${MYLIST.menu_title}</td>
						<td>퍼스널 옵션 :${MYLIST.menu_option}</td>
						<td>메뉴종류 : ${MYLIST.menu_name}</td>
						<td
							class="mylistlasttd">
							<div>
							
								<input
									class="deletepic"
									type="button"
									value="삭제"
									data-mnseq="${MYLIST.menu_seq}"
									name="${MYLIST.menu_seq}">
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</fieldset>
<script>
	const deletepic = document.querySelectorAll("input.deletepic")
		
		for(let i = 0; i < deletepic.length; i++){
			
		deletepic[i].addEventListener("click",(e)=>{
			if(confirm("삭제하시겠습니까??")){
				alert("게시물을 삭제합니다" );
				location.href = "${rootPath}/custom/delete?menu_seq=" + e.currentTarget.dataset.mnseq;
			}
		})
	}
</script>
