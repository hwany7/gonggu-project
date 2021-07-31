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
				alert('결제에 실패했습니다. 다시 시도해주세요.');
				location.href="/gonggu/mypage/posts/payable";
			</c:if>
			
			<c:if test="${result eq 1}">
				alert('결제 완료되었습니다');
				location.href="/gonggu/mypage/posts/payable";
			</c:if>
		</script>
	</body>
</html>