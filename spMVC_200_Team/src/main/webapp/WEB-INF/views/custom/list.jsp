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
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<fieldset id="custom">
		<h1 id="costom">커스텀게시판</h1>
			<div class="btn_box">
			<button class="btn_insert menu">메뉴 등록</button>
			</div>
		<table id="customlist">
			<c:choose>
				<c:when test="${empty CATELIST}">
					<td colspan="2">데이터없음</td>
				</c:when>
				<c:otherwise>
					<c:forEach
						items="${CATELIST}"
						var="CATE">
						<tr date-catecode="${cate_code}">
							<td>${CATE.cate_code}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</fieldset>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>
<script>
let menu_code = document.querySelector("table#customlist")
	if(menu_code){
		cate_code.addEventListener("click",(e)=>{
		let td = e.target
		if(td.tagName ==="TD"){   
			let tr = td.closest("TR")
			let menu_code = tr.dataset.catecode
			alert(cate_code)
				}
			})
		}
</script>