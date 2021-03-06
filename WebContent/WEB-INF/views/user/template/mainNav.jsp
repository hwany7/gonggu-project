<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

			<script>document.addEventListener("DOMContentLoaded", checkNotification('${sessionScope.member_id}'));</script>		

			<div class="row">
			  	<div class="col-md-12 col-xs-12 height-50 bg-black text-center text-white font-DH pd-top-15" >
			    	<span class="text-main-color">모두에게 드리는 혜택!</span>
			    	<span>지금 바로 신청 마감이 종료되는 제품을 찾아보세요</span>
				</div>
			</div>

			<div class="row max-width-1800 div-center">
				<div class="nav-bar height-50 hf">
					<div class="col-md-2 col-xs-2">
						<ul class="list-inline text-right mar-right-15 pd-top-15">
			            	<li><a href="/gonggu/main">GongGu</a></li>
			        	</ul>
			     	</div>
			     	
					<div class="col-md-5 col-xs-5 pd-top-15 text-center">
						<ul class="list-inline ">
							<li><a href="/gonggu/posts?category_id=0">전체보기</a></li>
							<li><a href="/gonggu/posts?category_id=1">핸드폰</a></li>
							<li><a href="/gonggu/posts?category_id=2">PC/노트북</a></li>
							<li><a href="/gonggu/posts?category_id=3">카메라</a></li>
							<li><a href="/gonggu/posts?category_id=4">웨어러블</a></li>
							<li><a href="/gonggu/posts?category_id=5">태블릿</a></li>
							<li><a href="/gonggu/posts?category_id=-1" style="color: #FF0000;">판매종료</a></li>
							<li><a href="/gonggu/reviews" style="color: #3DB7CC;">리뷰보기</a></li>
						</ul>
					</div>
					
					<div class="col-md-2 col-xs-2 main_search_bar">
			          	<form method="get" name="searchForm" action="/gonggu/posts">
			          		<input type="hidden" name="category_id" value="0">
			          		<input type="text" class=" form-control" name="search" autocomplete="off" placeholder="검색어를 입력해 주세요.">
			          	</form>
					</div>
					
			        <div class="col-md-3 col-xs-3 pd-top-15 " >
			           <ul class="list-inline nav-bar hf">
			            	<c:if test="${sessionScope.member_id eq null}">
			                	<li><a href="/gonggu/login">로그인</a></li>
			                	<li><a href="/gonggu/signup">회원가입</a></li>
			             	</c:if>
			             	
			             	<c:if test="${sessionScope.member_id ne null}">
				                <li>
				                   <a class="notifycation"><img src="/gonggu/resources/img/notify1.png" id="notify1" class="dispNotify" onclick="openNotifycation()"></a>
				                   <a class="notifycation"><img src="/gonggu/resources/img/notify2.png" id="notify2" class="nonDispNotify" onclick="openNotifycation()"></a>
				                </li>		                     	
			                	<li><a href="/gonggu/mypage/posts/payable">마이페이지</a></li>
			                	<li><a href="/gonggu/logout">로그아웃</a></li>
			             	</c:if>
			            </ul>
			    	</div>						
				</div>
			</div>

			<div class="container-fluid">
	         	<div class="row">
	           		<div class="col-md-4 col-md-offset-8 col-xs-4 col-xs-offset-8">
	            		<div class="notifyBox text-center font-DH"></div>
	           		</div>
	         	</div>
	      	</div>				