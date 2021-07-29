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
			alert('리뷰 삭제에 실패하였습니다');
			history.back();
		</c:if>
		<c:if test="${result eq 1}">
			alert('리뷰가 삭제되었습니다');
			location.href="/gonggu/reviews";
		</c:if>
		</script>
	</body>
</html>