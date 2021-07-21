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
<fieldset>
	<form
		id="bs2form"
		method="GET">
		<table id="input2">
			<c:choose>
				<c:when test="${empty KINDS}">
					<li>데이터 없음</li>
				</c:when>
				<c:otherwise>
					<c:forEach
						items="${KINDS}"
						var="BS">
						<tr
							id="bs2tr"
							data-menucode="${BS.menu_code}">
							<td>${BS.menu_name}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
</fieldset>
<script>
let base1 = document.querySelector("table#input2")
if(base1){
	base1.addEventListener("click",(e)=>{
			let td = e.target
			if(td.tagName === "TD"){
					let tr = td.closest("TR")
					let menucode = tr.dataset.menucode
					let sendcode = menucode/100
					location.href="${rootPath}/custom/save?menucode=" + menucode
			}
		})
}

</script>
