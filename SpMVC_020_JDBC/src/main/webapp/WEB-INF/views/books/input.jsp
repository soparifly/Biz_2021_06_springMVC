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
			<legend>도서정보 등록</legend>
			<div>
				<label>ISBN</label> <input name="bk_isbn" id="bk_isbn" placeholder="">

			</div>
			<div>
				<label>도서명</label> <input name="bk_title" id="bk_title"
					placeholder="">

			</div>
			<div>
				<label>출판사</label> <input name="bk_ccode" id="bk_ccode"
					placeholder="">

			</div>
			<div>
				<label>저자</label> <input name="bk_acode" id="bk_acode" placeholder="">

			</div>
			<div>
				<label>가격</label> <input name="bk_price" id="bk_price"
					placeholder="">
			</div>
			<div>
				<label>페이지수</label> <input name="bk_pages" id="bk_pages"
					placeholder="">
			</div>
		</fieldset>
	</form>

	<div class="btn_box">
		<button type="button" class="btn_save books">저장</button>
		<button type="reset" class="btn_reset books">다시작성</button>
		<button type="button" class="btn_list books">리스트로</button>
	</div>

</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_book_insert").addEventListener("click",()=>{
 location.href="${rootPath}/books/insert";
});
</script>

</html>