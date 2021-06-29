<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<!-- 상단 이미지 -->
			<div class="row">
				<div class="cropping" style="height:100px;">
					<img src="resources/img/tamplate2.jpg">
				</div>
			</div>
			<!-- 콘텐트 테스트 -->
			<div class="container-fluid font-DH">		
				<!-- 게시글 -->
				<div class="row div-center">
					<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 mar-top-50">	
						<div class="row postContentTop">
							<div class="col-md-8 col-xs-8" >	
								<img class="postContentImg" src="${postContentDto.image}" >
							</div>
							<div class="col-md-4 col-xs-4">
								<h4 class="mar-top-10">${postContentDto.post_title}</h4>		
								<hr class="hr-color-main">
								<div>
									<h4>${postContentDto.product_name}</h4>
									<hr>
								</div>	
								<div class="mar-top-20">
									<h6 class="text-color-g2">인터넷 최저가</h6>
									<h4>${postContentDto.default_price}원</h4>
									<hr>
								</div>					
								<div class="mar-top-20">
									<h6 class="text-color-g2">신청 현황</h6>
									<c:if test="${postContentDto.post_status ne 'A'}">
										<h4 class="mar-top-10">${postContentDto.current_amount}개 모집완료</h4>		
									</c:if>
									<c:if test="${postContentDto.post_status eq 'A'}">
										<h4 class="mar-top-10">${postContentDto.current_amount}개 신청중</h4>		
									</c:if>
									<hr>
								</div>
								<c:if test="${postContentDto.post_status ne 'A'}">
									<button type="button" class="btn btn-info width-100p">마감된 제품</button>
								</c:if>
								<c:if test="${postContentDto.post_status eq 'A'}">
								<div class="row">
									<div class="col-md-4">
										<input type="text" class="form-control" name="amount" placeholder="개수" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
										<!-- 파라미터 값 -->
										<input type="hidden" name="post_id" value="${postContentDto.post_id}">
									</div>
									<div class="col-md-8">
										<button type="button" class="applyBtn btn btn-info width-100p" onclick="addApply(${sessionScope.member_id})">신청하기</button>
									</div>
								</div>
								</c:if>
							</div>
						</div>
					</div>				
				</div>
				<!-- 탭 패널-->
				<div class="row div-center">
					<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 mar-top-50">
						<div class="row">
							<ul class="nav nav-tabs nav-justified">
							  <li class="nav-item">
							    <a class="nav-link active" data-toggle="tab" href="#home">상품상세</a>
							  </li>
							  <li class="nav-item">
							    <a class="nav-link" data-toggle="tab" href="#review">리뷰보기</a>
							  </li>
							</ul>
						</div>
					</div>
				</div>
				<!-- 패널 콘텐트 -->
				<div class="tab-content">
					<div class="tab-pane active" id="home">		
						<!-- 게시글 콘텐트 -->
						<div class="row div-center">
							<div class="row mar-top-50">
								<div class="font-GD post_content">${postContentDto.content}</div>							
							</div>
						</div>	
					</div>
				</div>						
			</div>
