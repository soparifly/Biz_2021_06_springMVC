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
<link href="${rootPath}/static/css/input.css?ver=2021-06-11-001"
		rel="stylesheet" />
 <h3>글 작성</h3>
    <hr></hr>
    <div class="input">
      <div class="tit_con">
      <input id="title" type="text" name="st_title" placeholder="제목을 입력하세요"/>
      <input id="user" type="text" name="st_name" placeholder="닉네임입력"/>
        <textarea id="box" name="content" placeholder="내용을 입력하세요"></textarea>
      </div class="under">
      <input name="st_date" type="date">
      <input name="st_time" type="time">
      <button id="save" type="button" class="save_btn">저장</button>
    </div>
    <!--파일 업로드-->
    <div class="file">
      <input multiple="multiple" type="file" name="filename" />
      <div id="preview"></div>
    </div>
</body>
</html>