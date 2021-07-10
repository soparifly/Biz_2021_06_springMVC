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
<script>	document.querySelector("option").addEventListener("click",()=>{
		let cate = e.target.tagName
	})	
}
</script>
<body>
	<form method="GET" id="menu_kinds">
		<button>1</button>
		<fieldset>
		<c:choose>
			<c:when test="${empty menukindsList}">
				<td colspan="1" >데이터 없음</td>
			</c:when>
			<c:otherwise>
				<c:forEach items="${menukindsList}" var="kinds">
					<tr>
					<td>${kinds.menu_kinds}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
			<legend>커스텀등록</legend>
			<select onchange="categoryChange(this)">
				<option>메뉴를 선택해주세요</option>
				<option value="a">콜드브루</option>
				<option value="b">브루드커피</option>
				<option value="c">에스프레소</option>
				<option value="d">프라푸치노</option>
				<option value="e">블렌디드</option>
				<option value="f">스타벅스피지오</option>
				<option value="g">티(티바나)</option>
				<option value="h">기타제조음료</option>
				<option value="i">스타벅스주스(병음료)</option>
			</select>
			
			<select id="good">
				<option>하위 메뉴를 선택해주세요</option>
			</select>
			<div>
				<!-- 게시글순서 -->
				<label>NO</label><input name="" id="" placeholder="">
			</div>
			<div>
				<!-- 사용자가 작성하려고하는 메뉴이름 -->
				<label>메뉴 이름</label><input type="" name="" id="" placeholder="">
			</div>
			<div>
				<!-- 베이스음료에 기본으로 제공되는 옵션을 제외한 추가옵션 -->
				<label>추가된 퍼스널옵션</label><input name="" id="" placeholder="">
			</div>
			<div>
				<label>작성자</label><input name="" id="" placeholder="">
			</div>
			<div>
				<label>작성시간</label><input name="" id="" placeholder="">
			</div>
		</fieldset>
	</form>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
</body>
</html>