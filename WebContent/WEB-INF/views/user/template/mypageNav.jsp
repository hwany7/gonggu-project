<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

			<div class="row div-center">
				<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 mar-top-50 font-GD ">
					<!-- 고정 정보 -->
					<div class="col-md-8 col-xs-8">
						<h2>${sessionScope.nickname}님<span style="font-size: 20px;"> 마이페이지</span></h2>
						<h6 class="text-color-g2 mar-left-5">개인 회원</h6>	
					</div>
					<!-- 이미지 -->
					<div class="col-md-4 col-xs-4">
						<img src="resources/img/profile.jpg" class="myPageProfile"><br>
					</div>
				</div>
			</div>		
			<div class="row div-center">
				<div class="nav-bar height-30 hf font-SP mar-top-40">			
					<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
					<input type="hidden" class="navIndex" value="0">
						<div class="col-md-12 com-xs-12">
							<ul class="list-inline nav-myPage">		
								<li id="payableMyPosts"><a onclick="getMyPosts('${info.pageNum}','P')" style="color: #5BC0DE ; cursor:pointer;"> 결제 가능</a></li> 					
								<li id="notPayableMyPosts"><a onclick="getMyPosts('${info.pageNum}','A')" style="cursor:pointer">신청 제품</a></li>					
								<li id="payedMyPosts"><a onclick="getMyPosts('${info.pageNum}','S')" style="cursor:pointer">구매 내역</a></li>					
								<li id="myReviews" style="cursor:pointer"><a onclick="getMyReviews()">내가 쓴 리뷰</a></li>				
								<li id="myReplys" style="cursor:pointer"><a onclick="getMyReply()">내가 쓴 댓글</a></li>				
								<li id="myInfor" style="cursor:pointer"><a>내정보</a></li>					
							</ul>
						</div>	
					</div>	
				</div>
			</div>			
