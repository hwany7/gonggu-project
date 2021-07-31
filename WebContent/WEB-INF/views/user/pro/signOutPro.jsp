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
			<c:if test="${result eq 0}">	
				alert("탈퇴에 실패했습니다")		
				location.href="/gonggu/mypage/info";
			</c:if>
			
			<c:if test="${result eq 1}">
				alert("탈퇴에 성공했습니다")
				location.href="/gonggu/login";
			</c:if>
		</script>
	</body>
</html>