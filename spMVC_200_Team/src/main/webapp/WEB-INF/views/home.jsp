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
<title>HOME : STARBUCKS CUSTOM</title>
<style>
@media screen and (max-width:768px) {
	body {
	 * {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	header {
		background-color: green;
		text-align: center;
	}
	h1 {
		padding-top: 10px;
		color: white;
		text-shadow: 1px 2px 0px gray;
	}
	div.images {
		display: flex;
		animation: myslide 20s linear infinite;
	}
	 @keyframes myslide{
        0%{
        transform: translateX(0);
        }
        100%{
        transform: translateX(calc(-500px*5));
        }
      }
	}
}


</style>
</head>
<body>	
<%@ include file = "/WEB-INF/views/include/include_header.jspf" %>
		<c:if test="${BODY eq 'CUSTOM_LIST'}">
			<%@ include file="/WEB-INF/views/custom/list.jsp" %>
		</c:if>
		<c:if test="${BODY eq 'JOIN'}">
			<%@ include file="/WEB-INF/views/member/join.jsp" %>
		</c:if>
		
		<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
