<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			alert("정보수정에 실패했습니다.");
			history.back();
		</c:if>
		<c:if test="${result eq 1}">
			location.href="/gonggu/mypage/info"
		</c:if>
		</script>
	</body>
</html>