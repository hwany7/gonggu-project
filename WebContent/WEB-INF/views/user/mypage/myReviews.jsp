<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

				<input type="hidden" class="navIndex" value="3">
				
				<c:if test="${reviews[0].review_num eq null }">
					<div class="container-fluid font-DH">	
						<div class="row">
							<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">	
								<div class="col-md-12">
									<h4 class="mar-top-50 text-color-g2">리뷰가 없습니다.</h4>
								</div>
							</div>
						</div>
					</div>
				</c:if>	
				
				<c:if test="${reviews[0].review_num ne null }">
					<c:forEach var="review" items="${reviews}">
					<div class="row font-DH">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
							<div class="col-md-12 col-xs-12">
								<div id="${review.review_num}" class="reivewListBox reviewContent hf">
									<h4 class="mar-top-20"><a href="/gonggu/reviews/review?review_num=${review.review_num}" >${review.title}</a></h4>
									<h5 class="etcOneLine text-color-g2">${review.content}</h5>
									
									<div class="col-md-6 h6-g2 pd-zero">
										<span><fmt:formatDate value="${review.upload_date}" type="both" pattern="MM-dd-hh:mm"/> </span>
										<span>${review.nickname}</span>
									</div>
									
									<div class="col-md-6 text-right">
										<img src="/gonggu/resources/img/like.png" width="15px" height="15px"> <span>${review.likecount}</span>
										<img src="/gonggu/resources/img/reply.png" width="15px" height="15px"> <span>${review.replycount}</span>							
									</div>
								</div>
							</div>	
						</div>
					</div>
					</c:forEach>
				
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
								<div class="row">
									<c:if test="${info.cnt gt 0}">
										<div class="col-md-2 text-center">
											<c:if test="${info.startPage gt info.pageBlock}">
												<a href="/gonggu/myReviews?pageNum=${info.startPage-info.pageBlock}">◀</a>
											</c:if>
										</div>
										
										<div class="col-md-8">
										<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
											<c:if test="${i eq info.currentPage}">
												<span style="color: #5BC0DE;">[${i}]</span>
											</c:if>
											<c:if test="${i ne info.currentPage}">
												<a href="/gonggu/myReviews?pageNum=${i}">[${i}]</a>
											</c:if>
										</c:forEach>
										</div>
										
										<div class="col-md-2">
											<c:if test="${info.pageCount gt info.endPage}">
												<a href="/gonggu/myReviews?pageNum=${info.startPage+info.pageBlock}">▶</a>	
											</c:if>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>	
				</c:if>	