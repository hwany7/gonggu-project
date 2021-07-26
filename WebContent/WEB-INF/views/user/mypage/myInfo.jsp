<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div class="max-width-1500 div-center">
			<div class="container-fluid font-DH">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 border-under-a">
						<div class="col-md-12">
							<h3 class="mar-top-50 ">내정보</h3>
						</div>
					</div>
				</div>

				<!-- 리스트 박스 -->
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
						<div class="col-md-12 col-xs-12">
							<div class="mar-top-20">
								<h6 class="text-color-g2">닉네임</h6>
								<h4>${memberDto.nickname}</h4>
								<hr>
							</div>
							<div class="mar-top-20">
								<h6 class="text-color-g2">이메일</h6>
								<h4>${memberDto.member_email}</h4>
								<hr>
							</div>
							<div class="mar-top-20">
								<h6 class="text-color-g2">전화번호</h6>
								<h4>${memberDto.tel}</h4>
								<hr>
							</div>
							<div class="mar-top-20">
								<h6 class="text-color-g2">가입날짜</h6>
								<h4><fmt:formatDate value="${memberDto.join_date}" pattern="yyyy-MM-dd"/></h4>
								<hr>
							</div>
							<c:if test="${memberDto.gender ne null}">
								<div class="mar-top-20">
									<h6 class="text-color-g2">성별</h6>
									<h4>${memberDto.gender}</h4>
									<hr>
								</div>
							</c:if>
							<c:if test="${memberDto.birth_date ne null}">
								<div class="mar-top-20">
									<h6 class="text-color-g2">생년월일</h6>
									<fmt:parseDate value="${memberDto.birth_date}" var="Date" pattern="yyyy-MM-dd"/>
									<h4><fmt:formatDate value="${Date}" pattern="yyyy-MM-dd"/></h4>
									<hr>
								</div>
							</c:if>

							<div class="mar-top-20">
								<input type="button" class="btn btn-default" value="수정" onclick="location='member/check'">
								<hr>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

