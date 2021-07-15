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
div#gallery_box {
	width: 90%;
	margin: 10px auto;
	border: 1px solid #aaa;
	display: flex;
}

div#gallery_box img {
	margin: 2px;
	height: 100%;
}

div#gallery_files {
	width: 90%;
	display: flex;
	flex-wrap: wrap;
	margin: 10px auto;
	border: 2px solid green;
}

div#gallery_file {
	margins: 2px;
	width: 100px;
}

div#gallery_box div:first-of-type {
	flex: 1;
	align-items: center;
	padding: 100px;
}

div#gallery_bx div:last-of-type {
	flex: 3;
}

div#gallery_files img {
	display: flex;
	flex-wrap: wrap;
}

div#gallery_files div.gallery_file {
	height: 200px;
	width: 200px;
	display: flex;
	padding: 5px;
	overflow: hidden;
	position:relative;
}
/* after 가상태그 */
div.gallery_file:after {
	content: '';
	position: absolute;
	left:0;
	top:0;
	bottom:0;
	right:0;
	background-color: transparent;
	color: transparent;
	z-index: 10;
	/* box내의 text의 그려지는 높이 box의 높이와 같게 
	만들면 거기에있는 텍스트가 박스의 세로방향으로 가운데 정렬이된다  */
	/* 그림안에 가운데 text를 넣는방법 */
	line-height: 200px;
	text-align:center;
		
	transition:1s;
}
div.gallery_file:hover:after{
	content:'\f2ed';

	font-size : 30px;
	font-family:"Font Awesome 5 Free";
	color:white;
	
	background-color: rgba(0,0,0,0.5);
	vertical-align: middle;
	
	cursor:pointer;

}
div#gallery_button_box {
	width: 90%;
	border: 1px solid blue;
	text-align: center;
}

div#gallery_button_box button {
	dispaly: inline-block;
	padding: 12px 20px;
	outline: 0;
	border: 0;
	border-radius: 10px;
}

div#gallery_button_box button:hover {
	box-shadow: 2px 2px 2px #333;
	cursor: pointer;
}

div#gallery_button_box button:nth-last-of-type(1) {
	background-color: blue;
	color: white;
}

div#gallery_button_box button:nth-last-of-type(2) {
	background-color: yellow;
	color: black;
}
</style>
<div id="galley_box">
	<c:if test="${empty GALLERY.g_image}">
		<img
			src="${rootPath}/files/Noimage.png"
			alt="main_image"
			width="150px">
	</c:if>
	<c:if test="${not empty GALLERY.g_image}">
		<img src="${rootPath}/files/${GALLERY.g_image}">
	</c:if>
</div>
<div id="info">
	<h3>제목: ${GALLERY.g_subject}</h3>
	<h2>SEQ : ${GALLERY.g_seq}</h2>
	<p>작성일 : ${GALLERY.g_date}</p>
	<p>작성시간 : ${GALLERY.g_time}</p>
	<p>작성자 : ${GALLERY.g_writer}</p>
	<p>작성내용 : ${GALLERY.g_content}</p>
</div>
<div id="gallery_files">
	<c:forEach
		items="${GALLERY.fileList}"
		var="FILE">
		<div class="gallery_file" data-fseq="${FILE.file_seq}">
			<c:if test="${empty FILE.file_upname}">
				<img
					src="${rootPath}/files/Noimage.png"
					height="100px">
			</c:if>
			<c:if test="${not empty FILE.file_upname}">
				<img src="${rootPath}/files/${FILE.file_upname}" >
			</c:if>
		</div>
	</c:forEach>
</div>
<div id="galley_button_box">
	<button class="gallery update">수정</button>
	<button class="gallery delete">삭제</button>
</div>

<script>
/* 현재 Galley.g_seq값은 숫자형이다
	만약 g_seq값이 S0001 등과 같이 문자열 형이라면
	이코드는 JS문법 오류가 발생할 것이다
	현재 작성한 코드는 JS코드 이다
	이코드는 Response가 될때 HTML코드로 변환이되고
	Script부분도 변환이되는데
	아래코드는 "/root-context/gallery/update?g_seq=? + S0001처럼 변환이된다
	결국 JS코드가 실행될때 + S0001처럼 변환되어 변수를 찾게된다그리고
	S0001이라는 변수가 정의되지않아 문법 오류가 발생한다
**EL tag를 사용하여 
*스크립트 부분에서 직접 값을 부착할때는 DQ("")를 부착하여 문법오류를 방지한
*/
 	let update_button = document.querySelector("button.gallery.update")
 	let delete_button = document.querySelector("button.gallery.delete")

 	update_button.addEventListener("click",()=>{
 		/* 	alert("일련번호 ${GALLERY.g_seq}인 게시물수정 ") */	
 			location.href="${rootPath}/gallery/update?g_seq=${GALLERY.g_seq}"
 	})
 	
 	delete_button.addEventListener("click",()=>{
 		
 		if(confirm("일련번호 ${GALLERY.g_seq}인 게시물삭제 ??"))	{
 	 		location.replace("${rootPath}/gallery/delete"+"?g_seq=${GALLERY.g_seq}")
 		}
 	})
 	/* 
 		<const>
	 	JS에서 상수를 선언하기
	 	다른언어 에서는 상수선언이 메모리적 문제를 해결하고
	 	
	 	동시성처리 (멀티 환경에서 서로 변수가 간섭하는 현상)
	 	을 쉽게 하기위한 방안으로 사용한다
	 	상수를 선언하는 이유 
	 	여기에 설정된 값이 코드중간에 어떤 이유로 변경되는 것을 방지하는 역할도 한다
	 	자바스크립트는 한개의 선언된 변수에 코드가 진행되는동안 
	 	(의도하던 그렇지않던)
	 	다른 값이저장되거나 변경되어도 오류를 발생시켜주지않는다
	 	그러한 문제를 방지하기 위하여 const 키워드를 상당히 권장한다
	 	
	*/
 	/* 상수설정 , 어떠한 이유로 변수설정내용이 변경되는것을 방지하기위해선언해주는이유  */
 	const galley_files = document.querySelector("div#gallery_files")
 	if(gallery_files){
 		
 		gallery_files.addEventListener("click", (e)=>{
 			
 			const tag = e.target
 			
 			/* tag에 걸려있는 class 이름을 챙겨서 조건을 걸때
 				tag.className ==="gallery_file"와 같이 사용할 수 있지만
 				혹시 tag에 다수 클래스가 설정될수 있기때문에
 				이런경우에는 className만 사용하지 않고
 						 className.include()함수를 사용하여 조건 검사를 하는것이 좋다 
 						 
 			*/
 			
 			/* 태그명이 DIV이고 Class이름이 gallery_file인 대상 */
 			if(tag.tagName === "DIV" && tag.className.includes("gallery_file")){
 				/* 내부에있는 dataset되어있는 fseq를 추출한다 */
 				let seq = tag.dataset.fseq
 				if(confirm(seq + "이미지 삭제")){
 					/* seq='A001' */
 					/* Get method방식으로 Ajax요청 */
 					fetch("${rootPath}/gallery/file/delete/" + seq)
 					/* 서버에서 응닿바는 respose를 추출하여 text값으로확인 */
 					.then( response -> response.text())
 					/* 결과값 result가 ok이면 성공하는것으로 if문을 지정함
 						이때 Controller 에서는 @ResponsBody 라고 응답하고있는 내용을 확인한다 */
 					.then(result=>{
 						if(result ==="OK"){
 							alert("삭제성공")
 							/* 현재 클릭된 DIV tag요소를 화면에서 제거하라는뜻 */
 							tag.remove()
 						}else if(result ==="FAIL_SEQ"){
 							alert("이미지 코드가 잘못되어 삭제할 수 없음")	
 						}else if( result === "모름") {
 							alert("서버 무응답")
 						} else {
 							alert("삭제 실패")
 						}
 					})
 				}
 			}
 		})
 		
 		
 	}
</script>
