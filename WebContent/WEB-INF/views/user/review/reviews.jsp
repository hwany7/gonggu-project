<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

		<div class="row">
			<div class="cropping" style="height:100px;">
				<img src="/gonggu/resources/img/tamplate2.jpg">
			</div>
		</div>
		
		<div class="max-width-1500 div-center font-DH">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 border-under-a">	
						<div class="col-md-12">
							<h3 class="mar-top-50 ">리뷰보기</h3>
						</div>
					</div>
				</div>
				
				<c:forEach var="reviews" items="${reviews}">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
						<div class="col-md-12 col-xs-12">
							<div id="${reviews.review_num}" class="reivewListBox reviewContent hf">
								<h4 class="mar-top-20"><a href="/gonggu/reviews/review?review_num=${reviews.review_num}" >${reviews.title}</a></h4>
								<h5 class="etcOneLine text-color-g2">${reviews.content}</h5>
								
								<div class="col-md-6 h6-g2 pd-zero">
									<span><fmt:formatDate value="${reviews.upload_date}" type="both" pattern="MM-dd-hh:mm"/> </span>
									<span>${reviews.nickname}</span>
								</div>
								
								<div class="col-md-6 text-right">
									<img src="/gonggu/resources/img/like.png" width="15px" height="15px"> <span>${reviews.likecount}</span>
									<img src="/gonggu/resources/img/reply.png" width="15px" height="15px"> <span>${reviews.replycount}</span>							
								</div>
							</div>
						</div>	
					</div>
				</div>
				</c:forEach>
			</div>
			
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 mar-top-20">
					<form method="post" action="reviews">
						<div class="col-md-2 col-xs-2 pd-right-0">
				        	<select class="form-control" name="select">
								<option value="title+nickname">공통</option>
							</select>
						</div>		
							
						<div class="col-md-8 col-xs-8">
				           	<input type="text" class="form-control" name="search" autocomplete="off" placeholder="검색어를 입력해 주세요.">
						</div>	
									
						<div class="col-md-2 col-xs-2">
							<button type="submit" class="btn btn-info width-100p">검색</button>	
						</div>	
					</form>	
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
						<div class="row">
							<c:if test="${info.cnt gt 0}">
								<div class="col-md-2 text-center">
									<c:if test="${info.startPage gt info.pageBlock}">
										<a href="/gonggu/reviews?pageNum=${info.startPage-info.pageBlock}&search=${info.search}">◀</a>
									</c:if>
								</div>
								
								<div class="col-md-8">
								<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
									<c:if test="${i eq info.currentPage}">
										<span style="color: #5BC0DE;">[${i}]</span>
									</c:if>
									
									<c:if test="${i ne info.currentPage}">
										<a href="/gonggu/reviews?pageNum=${i}&search=${info.search}">[${i}]</a>
									</c:if>
								</c:forEach>
								</div>
								
								<div class="col-md-2">
									<c:if test="${info.pageCount gt info.endPage}">
										<a href="/gonggu/reviews?pageNum=${info.startPage+info.pageBlock}&search=${info.search}">▶</a>	
									</c:if>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>		
		</div>	