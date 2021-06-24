<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/setting.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GongGu</title>
	</head>
	<body>
		<!-- 네이게이션 -->
		<div class="container-fluid">
			<div class="row">
				<jsp:include page="/WEB-INF/views/user/template/mainNav.jsp"/>
			</div>
		</div>
		
		<!-- 메인 콘텐츠 -->
		<div class="container-fluid">
			<div class="row">
				<c:import url="${page}.jsp" />
			</div>
		</div>
		
		<!-- 여백 -->
		<div class="height-300 mar-top-50"></div>
		
		<!-- 푸터 페이지 -->
		<div class="container-fluid">
			<div class="row">
				<c:import url="footer.jsp" />
			</div>
		</div>
	</body>
</html>