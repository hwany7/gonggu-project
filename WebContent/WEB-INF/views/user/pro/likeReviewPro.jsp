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
				alert("이미 추천한 리뷰입니다.");
				location.href="/gonggu/reviews/review?review_num=${review_num}";
			</c:if>
			
			<c:if test="${result eq 1}">
				alert("좋아요 성공");
				location.href="/gonggu/reviews/review?review_num=${review_num}";
			</c:if>
		</script>
	</body>
</html>