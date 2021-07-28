<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/setting.jsp" %>
		<script type="text/javascript">
		<c:if test="${result eq 0}">
			alert("비밀번호가 올바르지 않습니다");
		</c:if>
		<c:if test="${result eq 1}">
		</c:if>
		</script>
