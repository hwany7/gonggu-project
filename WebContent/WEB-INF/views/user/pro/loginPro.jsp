<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GongGu</title>
	</head>
	<body>
		<script type="text/javascript">
			<c:if test="${result eq '0'}">
				alert("로그인 정보를 다시한번 확인해주세요");
				history.back();				
			</c:if>
			
			<c:if test="${result eq '1'}">
				location.href="/gonggu/main";
			</c:if>
			
			<c:if test="${result eq '2'}">
				alert("활동이 정지된 회원입니다");
				history.back();
			</c:if>
			
			<c:if test="${result eq '3'}">
				location.href="/gonggu/login/activatestatus";
			</c:if>
		</script>
	</body>
</html>