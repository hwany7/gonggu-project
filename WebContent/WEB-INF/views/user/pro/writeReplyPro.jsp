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
		<c:if test="${result eq 0}">
			<script type="text/javascript">
				<!-- 
				alert("댓글 작성에 실패했습니다");
				history.back();
				 -->
			</script>
		</c:if>
		<c:if test="${result eq 1}">
			<script type="text/javascript">
				<!--
				alert("댓글 작성 완료");
				-->
			</script>
			<meta http-equiv="refresh" content="0.5; url=review.do?review_num=${review_num}">
		</c:if>
	</body>
</html>