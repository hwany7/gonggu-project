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
			alert("댓글 작성에 실패했습니다");
			history.back();
		</c:if>
		<c:if test="${result eq 1}">
			alert("댓글 작성 완료");
			location.href="/gonggu/reviews/review?review_num=${review_num}";
		</c:if>
		</script>
	</body>
</html>