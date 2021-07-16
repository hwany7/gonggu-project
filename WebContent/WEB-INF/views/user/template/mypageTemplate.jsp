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
		<div class="container-fluid border-bottom-g4">
			<jsp:include page="/WEB-INF/views/user/template/mainNav.jsp"/>
		</div>
		
		<!-- 마이페이지 네비게이션 -->
		<div class="container-fluid max-width-1300">
			<jsp:include page="/WEB-INF/views/user/template/mypageNav.jsp"/>
		</div>
		
		<hr>
				
		<!-- 마이페이지 콘텐트 -->
		<div class="container-fluid max-width-1300"  id="mypage_content">
			<jsp:include page="${page}.jsp"/>
		</div>	
	
		<!-- 테스트용 아래여백 -->
		<div class="height-300 mar-top-50"></div>
		
		
		<!-- 푸터 페이지 -->
		<div class="container-fluid">
			<jsp:include page="/WEB-INF/views/user/template/footer.jsp"/>
		</div>
			
	</body>
</html>