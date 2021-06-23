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
	
		<!-- 네비게이션-->
		<div class="container-fluid">	
			<div class="row">
				<jsp:include page="/WEB-INF/views/user/template/beginNav.jsp"></jsp:include>
			</div>
		</div>
		
		<!-- 페이지 -->
		<div class="container-fluid">
			<div class="row">
				<jsp:include page="${page}.jsp" />
			</div>
		</div>	
		
	</body>
</html>