<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${result eq 0 or result eq null}">
			<script type="text/javascript">
				alert("이미 추천한 리뷰입니다.");
			</script>
			<meta http-equiv="refresh" content="0.5; url='review.do?review_num=${review_num}">
		</c:if>
		<c:if test="${result eq 1}">
			<script type="text/javascript">
				alert("좋아요 성공");
			</script>
			<meta http-equiv="refresh" content="0.5; url=review.do?review_num=${review_num}">
		</c:if>
	</body>
</html>