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
			alert("리뷰 수정에 실패했습니다.");
			history.back();
		</c:if>
		<c:if test="${result eq 1}">
			alert("리뷰 수정이 완료되었습니다.");
			location.href="/gonggu/review?review_num=${review_num}"
		</c:if>
		</script>
	</body>
</html>