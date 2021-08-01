<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			<div class="row">
				<div class="cropping" style="height: 100px;">
					<img src="/gonggu/resources/img/tamplate3.jpg">
				</div>
			</div>

			<div class="container-fluid font-DH">	
				<div class="row max-width-1300 div-center">
					<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 mar-top-50">
						<div class="font-GD">
							${review.content}
							<hr class="mar-top-50">
						</div>
						
						<div class="text-right">
							<c:if test= "${sessionScope.member_id eq review.member_id}">
								<input class="modifyReview btn btn-default" id="${review.review_num}" type="button" value="수정하기" onclick="location='/gonggu/reviews/review/modify?review_num=${review.review_num}'">
							</c:if>
							
							<c:if test= "${sessionScope.member_id eq review.member_id}">
								<input class="deleteReview btn btn-danger" type="button" value="삭제하기" onclick="deleteReview(${review.review_num})">
							</c:if>
							
							<input class="likeReviewPro btn btn-info" id="${review.review_num}"  type="button" value="추천하기" onclick="likeReview(${sessionScope.member_id})">
						</div>
					</div>
				</div>

				<div class="row max-width-1300 div-center ">
					<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
						<div class="cropping mar-top-100" style="height: 50px;">
							<img src="/gonggu/resources/img/tamplate2.jpg">
						</div>
					</div>
				</div>

				<div class="row max-width-1300 div-center">
					<c:if test= "${sessionScope.member_id ne null }">
						<div class="row">
							<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 border-under-a">
								<div class="col-md-12">
									<h3 class="font-DH mar-top-100 ">댓글 쓰기</h3>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 mar-top-10">
								<form method="post" action="/gonggu/reviews/review/reply/writepro" name="replyForm" onsubmit="return checkReply()">
									<input type="hidden" name="review_num" value="${review.review_num}">
									
									<div class="form-group">
										<textarea class="review-textarea form-cotrol" name="content"></textarea>
									</div>
									
									<div class="form-group text-right">
										<input type="submit" class="btn btn-default" value="작성">
									</div>
								</form>
							</div>
						</div>
					</c:if>

					<c:forEach var="reply" items="${replys}">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
							<div class="col-md-12 col-xs-12 mar-top-20">
								<h5>${reply.nickname}
									<span style="text-align: right;"><fmt:formatDate value="${reply.upload_date}" type="both" pattern="MM-dd-hh:mm"/> </span>
								</h5>
								
								<div id="${reply.review_num}" class="mar-top-10">
									<h5 class="text-color-g2">${reply.content}</h5>
								</div>

								<c:if test= "${sessionScope.member_id eq reply.member_id}">
									<div id="${reply.review_num}">
										<input id="${reply.reply_num}" type="button" value="삭제" class="btn btn-default deleteReply" onclick="deleteReply()">
									</div>
								</c:if>
								<hr>
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>