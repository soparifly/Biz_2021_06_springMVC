<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
/* tr:fir {
	border-bottom: 1px dotted #BFFF00;
}

button.student.insert {
	background-color: black;
	color: #BFFF00;
}

button.student.home {
	background-color: black;
	color: #BFFF00;
} */
</style>
<table class="student_list detail">
	<tr>
		<td>학번</td>
		<td>이름</td>
		<td>학년</td>
		<td>전공</td>
		<td>전화번호</td>
		<td>주소</td>
	</tr>
	<c:choose>
		<c:when test="${empty STUDENTS}">
			<tr>
				<td colspan="6">데이터가 없음</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${STUDENTS}" var="STUDENT">
				<tr data-st_num="${STUDENT.st_num}">
					<td>${STUDENT.st_num}
					<td>${STUDENT.st_name}</td>
					<td>${STUDENT.st_grade}</td>
					<td>${STUDENT.st_dept}</td>
					<td>${STUDENT.st_tel}</td>
					<td>${STUDENT.st_addr}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<div class="btn_box">
	<button class="student insert">학생정보등록</button>
	<button class="student home">처음으로</button>
</div>
<script>
	document.querySelector("table.student_list").addEventListener("click",(e)=>{
	
		let target = e.target
		let tagName = target.tagName
		
		if(tagName === "TD"){
			let tr = target.closest("TR")
			let stNum = tr.dataset.st_num
		/* 	alert(stNum) */
		
		location.href="${rootPath}/student/detail?st_num="+stNum;
		}
})
</script>