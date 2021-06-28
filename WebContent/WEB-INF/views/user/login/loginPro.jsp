<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/setting.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GongGu</title>
	</head>
	<body>
		<c:if test="${member.result eq '0'}">
		<!-- 아이디 X / 비밀번호 불일치 / 탈퇴회원 -->
			<script type="text/javascript">
				<!--
				alert("로그인 정보를 다시한번 확인해주세요");
				history.back();				
				//-->
			</script>
		</c:if>
		<c:if test="${member.result ne '0'}">
			<c:if test="${member.result eq '1'}">
			<!-- 활동 회원 -->
				${sessionScope.member_id = member.member_id}
				${sessionScope.nickname = member.nickname}
				${sessionScope.gender = member.gender}
				<c:redirect url="main.do"/>
			</c:if>
			<c:if test="${member.result eq '2'}">
			<!-- 활동 정지 회원 -->
				<script type="text/javascript">
					<!--
					alert("활동이 정지된 회원입니다");
					history.back();
					//-->
				</script>
			</c:if>
			<c:if test="${member.result eq '3'}">
			<!-- 휴면상태 회원 -->
				${sessionScope.member_id = member.member_id}
				<c:redirect url="activateStatus.do"/>
			</c:if>
		</c:if>
	</body>
</html>