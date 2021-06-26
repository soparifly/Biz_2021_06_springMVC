<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
form#student_detail input {
	width: 34%;
}

fieldset#st_detail {
	background-color: blue;
	border: 1px dotted smokewhite;
	align-content: center;
	padding: 0 auto;
}

table.student_detail th, table.student_detail td {
	border-top: #333;
	border-bottom: #222;
	border-left: #aaa;
	border: 1px solid;
}

table.student_datail th {
	width: 15%;
}

table.student_datail td {
	width: 30%;
}
</style>
<table class="student_detail">
	<tr>
		<th>학번</th>
		<td>${STD.st_num}</td>
		<th>이름</th>
		<td>${ST.st_name}</td>
	</tr>
	<tr>
		<th>학과</th>
		<td>${STD.dept}</td>
		<th>학년</th>
		<td>${STD.grade}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${STD.tel}</td>
		<th>주소</th>
		<td>${STD.addr}</td>
	</tr>
</table>
<div class="btn_box">
	<button type="button" class="student update">수정</button>
	<!-- 1보다 작음으로 설정한 이유는 간혹 -1 값이 나올수 있기때문에 -->
	<c:if test="${SC_COUNT < 1}">
		<button type="button" class="student delete">삭제</button>
	</c:if>
</div>

<form id="student_detail" method="POST">
	<fieldset id="st_detail">
		<c:forEach items="${SSLIST}" var="SS">
			<div>
				<span><label>${SS.ss_stname}</label></span> <input name="subject"
					value="${SS.ss_code}" type="hidden"> <input name="score"
					value="${SS.ss_score}">
			</div>
		</c:forEach>

		<div class="btn_box">
			<button type="submit" class="save">저장</button>
			<button type="button" class="list">리스트로</button>
			<button type="button" class="student home">처음으로</button>
		</div>
	</fieldset>
</form>