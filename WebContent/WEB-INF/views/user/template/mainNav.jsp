<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<script>document.addEventListener("DOMContentLoaded", checkNotification('${sessionScope.member_id}'));</script>		
			    <!-- 최상단 노티스 -->
			<div class="row">
			        <div class="col-md-12 col-xs-12 height-50 bg-black text-center text-white font-DH pd-top-15" >
			          <span class="text-main-color">모두에게 드리는 혜택!</span>
			           <span>지금 바로 신청 마감이 종료되는 제품을 찾아보세요</span>
			        </div>
			    </div>
			    <!-- 상단 메뉴바-->
			<div class="row">
				<div class="nav-bar height-50 hf">
					<div class="col-md-2 col-xs-2">
						<ul class="list-inline text-right mar-right-15 pd-top-15">
			                	<li><a href="main.do">GongGu</a></li>
			             	</ul>
			          	</div>
				<div class="col-md-5 col-xs-5 pd-top-15 text-center">
					<ul class="list-inline ">
						<li><a href="#">전체보기</a></li>
						<li><a href="#">핸드폰</a></li>
						<li><a href="#">PC/노트북</a></li>
						<li><a href="#">카메라</a></li>
						<li><a href="#">웨어러블</a></li>
						<li><a href="#">태블릿</a></li>
						<li><a href="#" style="color: #3DB7CC;">리뷰보기</a></li>
						<li><a href="#" style="color: #FF0000;">판매종료</a></li>
					</ul>
				</div>
			          	<!-- 검색 -->
					<div class="col-md-2 col-xs-2 main_search_bar">
			          		<form name="searchForm" action="mainPostList.do">
			          			<input type="text" class=" form-control" placeholder="어떤 제품을 찾고 계신가요?" name="nav_search">
			          		</form>
					</div>
					
			          	<div class="col-md-3 col-xs-3 pd-top-15 " >
			            	<ul class="list-inline nav-bar hf">
			                	<c:if test="${sessionScope.member_id eq null}">
			                    	<li><a href="loginForm.do">로그인</a></li>
			                    	<li><a href="signUpForm.do">회원가입</a></li>
			                 	</c:if>
			                 	<c:if test="${sessionScope.member_id ne null}">
				                    <li>
				                       <a class="notifycation"><img src="resources/img/notify1.png" id="notify1" class="dispNotify" onclick="openNotifycation()"></a>
				                       <a class="notifycation"><img src="resources/img/notify2.png" id="notify2" class="nonDispNotify" onclick="openNotifycation()"></a>
				                    </li>		                     	
			                    	<li><a href="payablePost.do">마이페이지</a></li>
			                    	<li><a href="logout.do">로그아웃</a></li>
			                 	</c:if>
			              	</ul>
			           	</div>						
				</div>
			</div>
	      	<!-- 알림박스 -->
			<div class="container-fluid">
	         	<div class="row">
	           		<div class="col-md-4 col-md-offset-8 col-xs-4 col-xs-offset-8">
	            			<div class="notifyBox text-center font-DH"></div>
	           		</div>
	         	</div>
	      	</div>				
