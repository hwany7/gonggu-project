<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				<!-- 상단 이미지 -->
				<div class="container-fluid">
					<div class="row">
						<div class="cropping">
							<img src="resources/img/tamplate1.jpg">
						</div>
					</div>
				</div>
				
				<!-- 모듈1, 마감임박 게시글 6개 -->
				<div class="container-fluid">
					<div class="row div-center">
						<jsp:include page="/WEB-INF/views/user/main/main-module-one.jsp"/>
					</div>
				</div>