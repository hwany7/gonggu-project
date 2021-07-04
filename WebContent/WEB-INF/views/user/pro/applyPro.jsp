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
		<c:if test="${result eq -1}">
			alert("진행 수량보다 초과한 수량입니다");
			history.back();
		</c:if>
		<c:if test="${result eq 0}">
			alert("신청에 실패하셨습니다");
			history.back();
		</c:if>
		<c:if test="${result eq 1}">
			alert('신청이 완료되었습니다');	
			location.href="main";
		</c:if>
		</script>
	</body>
</html>