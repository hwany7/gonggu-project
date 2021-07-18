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
			alert("신청 취소에 실패했습니다");
			history.back();
		</c:if>
		<c:if test="${result eq 1}">
			alert("신청 취소 완료");
			getMyPosts('${info.pageNum}','A');
		</c:if>
		</script>
	</body>
</html>