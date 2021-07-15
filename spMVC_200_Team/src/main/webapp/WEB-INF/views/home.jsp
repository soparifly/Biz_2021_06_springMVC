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

</style>
</head>
<body>
	<header>
		<h1>STARBUCKS CUSTOM</h1>
	</header>
	<section id="content">
		<article>
			<div class="images">
				<img src="${rootPath}/static/img/1.jpg" /> <img
					src="${rootPath}/static/img/2.jpg" /> <img
					src="${rootPath}/static/img/3.jpg" /> <img
					src="${rootPath}/static/img/4.jpg" /> <img
					src="${rootPath}/static/img/5.jpg" /> <img
					src="${rootPath}/static/img/6.jpg" /> <img
					src="${rootPath}/static/img/7.jpg" /> <img
					src="${rootPath}/static/img/8.jpg" /> <img
					src="${rootPath}/static/img/10.jpg" /> <img
					src="${rootPath}/static/img/11.jpg" /> <img
					src="${rootPath}/static/img/12.jpg" /> <img
					src="${rootPath}/static/img/13.jpg" /> <img
					src="${rootPath}/static/img/14.jpg" /> <img
					src="${rootPath}/static/img/15.jpg" /> <img
					src="${rootPath}/static/img/17.jpg" /> <img
					src="${rootPath}/static/img/18.jpg" /> <img
					src="${rootPath}/static/img/19.jpg" /> <img
					src="${rootPath}/static/img/20.jpg" /> <img
					src="${rootPath}/static/img/21.jpg" /> <img
					src="${rootPath}/static/img/22.jpg" /> <img
					src="${rootPath}/static/img/23.jpg" /> <img
					src="${rootPath}/static/img/24.jpg" />
			</div>
		</article>
		<table>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
	</section>
</body>
