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
#inputsection {
	background: white;
	margin: 10px;
}

div {
	display: flex;
}

label {
	width: 30%;
	margin-right: 10px;
	text-align: right;
}

input {
	width: 50%;
}

form {
	width: 100%;
}

button#sendbox {
	display:inline-block;
	width: 80%;
	background-color: #eee;
}
</style>
<section id="inputsection">
	<form
		method="POST"
		enctype="multipart/form-data">
		<div>
			<label>작성자</label>
			<input
				name="g_writer"
				value="${CMD.g_writer}">
		</div>
		<div>
			<label>작성일자</label>
			<input
				name="g_date"
				value="${CMD.g_date}">
		</div>
		<div>
			<label>작성시각</label>
			<input
				name="g_time"
				value="${CMD.g_time}">
		</div>
		<div>
			<label>제목</label>
			<input name="g_subject">
		</div>
		<div>
			<label>작성내용</label>
			<textarea name="g_content"></textarea>
		</div>

		<div>
			<label>대표이미지</label>
			<input
				type="file"
				name="one_file">

		</div>
		<div>
			<label>갤러리</label>
			<input
				type="file"
				multiple="multiple"
				name="m_file" />
		</div>
		<button id="sendbox">전송</button>
	</form>
</section>
