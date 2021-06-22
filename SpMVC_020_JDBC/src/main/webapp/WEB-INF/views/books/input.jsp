<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPatd" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
form#book_input input.search {
	width: 50%
}

form#book_input span.name {
	color: blue;
	font-weight: bold;
	margin-left: 10px;
}
</style>
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/book_input.js?ver=2021-06-22-010"></script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section class="main_sec">
		<form id="book_input" method="POST">
			<fieldset>
				<legend>도서정보 등록</legend>
				<div>
					<label>ISBN</label> <input name="bk_isbn" id="bk_isbn"
						placeholder="">

				</div>
				<div>
					<label>도서명</label> <input name="bk_title" id="bk_title"
						placeholder="">

				</div>
				<div>
					<label>출판사</label> <input class="search" name="bk_ccode"
						id="bk_ccode" placeholder=""> <span id="cp_title"
						class="name">출판사명</span>

				</div>
				<div>
					<label>저자</label> <input class="search" name="bk_acode"
						id="bk_acode" placeholder=""> <span id="au_name"
						class="name">저자명</span>

				</div>
				<div>
					<label>가격</label> <input name="bk_price" id="bk_price"
						placeholder="" value="0">
				</div>
				<div>
					<label>페이지수</label> <input name="bk_pages" id="bk_pages"
						placeholder="" value="0">
				</div>
			</fieldset>
		<div class="btn_box">
			<button type="button" class="btn_save books">저장</button>
			<button type="reset" class="btn_reset books">다시작성</button>
			<button type="button" class="btn_list books">리스트로</button>
		</div>
		</form>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
/* 동적으로(fetch 로 가져온 HTML) 만들어진 dom에 evnet 설정하기
	동적으로 생성된 tag는 document.querySelector()에 의해서 선택되지 않는다
	이벤트는 document(가장 상위 DOM)에 설정하
*/
document.addEventListener("click",(e) =>{
	let target = e.target
	let tagName = target.tagName
	if(tagName ==="TD"){
		
		let parentTag = target.closest("TR")
		let parentClassName = parentTag.className
		
		if(parentClassName === "search_comp"){
		
			/* let ccode = parentTag.dataset.ccode  => */
			let tds = parentTag.childNodes
			/* 현재 선택된 tr의 child를 가져와서 각각 td컬럼에 담겨 있는 값을 추출하기 */
			let ccode = tds[1].textContent
			let ctitle = tds[3].textContent
			let cceo = tds[5].textContent
			let ctel = tds[7].textContent
			
			
			let msg = ctitle +",";
			msg += cceo +  ",";
			msg += ctel	;
			alert("출판사코드 : " + ccode + " :" + ctitle);
			
			document.querySelector("input#bk_ccode").value = ccode;
			document.querySelector("span#cp_title").innerText = msg;
			
		} else if (parentClassName ==="search_author") {
		
			let tds = parentTag.childNodes
			let acode = tds[1].textContent
			let aname = tds[3].textContent
			let atel = tds[5].textContent
			
		     let msg = aname + ", ";
	         msg += atel;
	         
			document.querySelector("input#bk_acode").value = acode;
			document.querySelector("span#au_name").innerText = msg;
			
			alert("저자코드: "+ acode);
		}		
		document.querySelector("div#modal").style.display="none";
		document.querySelector("div#div_search").innerHTML ="";
		document.querySelector("div#div_search").remove();
	}
});
</script>
</html>