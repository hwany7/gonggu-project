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
		<c:if test="${result eq 0}">
			<script type="text/javascript">
				<!--
				alert("로그인 정보를 다시한번 확인해주세요");
				history.back();				
				//-->
			</script>
		</c:if>
		<c:if test="${result eq 1}">
			<script type="text/javascript">
					<!--
					alert("상태가 변경되었습니다");
					//-->
				</script>
			<c:redirect url="login.do"/>
		</c:if>
	</body>
</html>