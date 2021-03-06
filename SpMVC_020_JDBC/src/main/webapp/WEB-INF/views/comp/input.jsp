<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPatd" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>

<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
<section class="main_sec">
	<form method="POST">
		<fieldset>
			<legend>출판사정보</legend>
			<div>
				<label>CODE</label> <input name="cp_code" id="cp_code" placeholder="">

			</div>
			<div>
				<label>출판사명</label> <input name="cp_name" id="cp_name"
					placeholder=""><span id="cp_title">출판사명</span>

			</div>
			<div>
				<label>대표</label> <input name="cp_ceo" id="cp_ceo"
					placeholder=""><span id="cp_ceo">대표</span>

			</div>
			<div>
				<label>주소</label> <input name="cp_addr" id="cp_addr" placeholder="">

			</div>
			<div>
				<label>전화번호</label> <input type="tel" name="cp_tel" id="cp_tel"
					placeholder="">
			</div>
			<div>
				<label>주요장르</label> <input name="cp_genre" id="cp_genre"
					placeholder="">
			</div>
		</fieldset>
	<div class="btn_box">
		<button type="button" class="btn_save comp">저장</button>
		<button type="reset" class="btn_reset comp">다시작성</button>
		<button type="button" class="btn_list comp">리스트로</button>
	</div>
	</form>
</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_book_comp").addEventListener("click",()=>{
 location.href="${rootPath}/comp/insert";
});
</script>

</html>