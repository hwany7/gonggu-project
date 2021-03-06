<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

			<div class="row">
				<div class="cropping" style="height:100px;">
					<img src="/gonggu/resources/img/tamplate2.jpg">
				</div>
			</div>

			<div class="container-fluid font-DH max-width-1300">		
				<div class="row div-center">
					<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 mar-top-50">	
						<div class="row postContentTop">
							<div class="col-md-8 col-xs-8" >	
								<img class="postContentImg" src="${post.image}" >
							</div>
							
							<div class="col-md-4 col-xs-4">
								<h4 class="mar-top-10">${post.post_title}</h4>		
								<hr class="hr-color-main">
								
								<div>
									<h4>${post.product_name}</h4>
									<hr>
								</div>	
								
								<div class="mar-top-20">
									<h6 class="text-color-g2">인터넷 최저가</h6>
									<h4>${post.default_price}원</h4>
									<hr>
								</div>	
												
								<div class="mar-top-20">
									<h6 class="text-color-g2">신청 현황</h6>
									<c:if test="${post.post_status ne 'A'}">
										<h4 class="mar-top-10">${post.current_amount}개 모집완료</h4>		
									</c:if>
									
									<c:if test="${post.post_status eq 'A'}">
										<h4 class="mar-top-10">${post.current_amount}개 신청중</h4>		
									</c:if>
									<hr>
								</div>
								
								<c:if test="${post.post_status ne 'A'}">
									<button type="button" class="btn btn-danger width-100p">마감된 제품</button>
								</c:if>
								
								<c:if test="${post.post_status eq 'A'}">
									<div class="row">
										<div class="col-md-4 col-xs-4">
											<input type="text" class="form-control" name="amount" placeholder="개수" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
											<input type="hidden" name="post_id" value="${post.post_id}">
										</div>
										
										<div class="col-md-8 col-xs-8">
											<button type="button" class="applyBtn btn btn-info width-100p" onclick="addApply(${sessionScope.member_id})">신청하기</button>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>				
				</div>

				<div class="row div-center">
					<div class="row mar-top-50">
						<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
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

				<div class="tab-content">
					<div class="tab-pane active" id="home">			
						<div class="row div-center">
							<div class="row mar-top-50">
								<div class="font-GD">${post.content}</div>							
							</div>
						</div>	
					</div>
					
					<div class="tab-pane container fade" id="review">			
						<c:if test="${reviews[0].title eq null}">
							<div class="row">
								<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
									<div class="col-md-12">
										<h4 class="mar-top-50 text-color-g2 text-center">리뷰가 없습니다. 첫 리뷰를 남겨주세요!</h4>
									</div>
								</div>
							</div>
						</c:if>
						
						<c:if test="${reviews[0].title ne null}">	
							<div class="row div-center">
								<div class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-1 mar-top-20">
									<c:forEach var="review" items="${reviews}">
									<div class="reivewListBox">
										<h4 class="mar-top-20 hf">
											<a href="/gonggu/reviews/review?review_num=${review.review_num}">${review.title}</a>
										</h4>
										
										<h5 class="etcOneLine text-color-g2">
											${review.content}
										</h5>
										<div class="text-right">
											<img src="/gonggu/resources/img/like.png" width="15px" height="15px">
											<span>${review.likecount}</span>
											<img src="/gonggu/resources/img/reply.png" width="15px" height="15px">
											<span>${review.replycount}</span>
										</div>
									</div>
									</c:forEach>
								</div>				
							</div>	
						</c:if>	
					</div>								
				</div>									
			</div>