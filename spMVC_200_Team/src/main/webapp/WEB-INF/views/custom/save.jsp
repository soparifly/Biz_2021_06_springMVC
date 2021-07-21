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
		method="POST"
		id="savemenu"
		enctype="multipart/form-data">
		<div id="inputlist">
			<input
				name="menu_name"
				id="menu_name"
				value="${CHOISEMENU.menu_name}"
				placeholder="${CHOISEMENU.menu_name}"
				disabled="disabled" />
			<input
				name="user_id"
				id="user_id"
				value="${LOGIN.user_id}"
				placeholder="${LOGIN.user_id}"
				disabled="disabled">
			<input
				name="menu_title"
				id="menu_title"
				placeholder="메뉴 이름 입력해주세요">
			<input
				name="menu_option"
				id="menu_option"
				placeholder="추가하시려는 퍼스널옵션만 적어주세요..">
			<input
				type="file"
				name="one_file"
				placeholder="사진을 올려주세요">
		</div>
		<button
			type="button"
			class="save">저장</button>
		<button
			type="button"
			class="list">돌아가기</button>
	</form>
</fieldset>
<script>
	const menu_submit = ()=> {
		let menu_name = document.querySelector("input#menu_name")
		let menu_title = document.querySelector("input#menu_title")
		let menu_option = document.querySelector("input#menu_option")
		let one_file = document.querySelector("input#one_file")
	
		if(menu_title.value === ""){
			 alert("메뉴 이름은 반드시 정해주세요")
			menu_title.focus()
			return false;
		}
		if(menu_option.value === ""){
			alert("메뉴옵션은 입력해주세요")
			menu_option.focus()
			return false;
		}
		document.querySelector("form#savemenu").submit()
	}
	document.querySelector("form#savemenu").addEventListener("click",(e)=>{
		
			let target = e.target
				
			if(target.tagName === "BUTTON"){
				if(target.className.includes("save")){
						menu_submit();
						
				} else if(target.className.includes("list")){
						location.href ="${rootPath}"
				}
			}
			
	})
	
	
		
</script>
