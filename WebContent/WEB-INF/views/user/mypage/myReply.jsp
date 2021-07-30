<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<input type="hidden" class="navIndex" value="4">
		<div class="max-width-1500 div-center">
			<div class="container-fluid font-DH">		
				<!-- 내역이 없을경우 -->
				<c:if test="${replyDto[0].review_num eq null}">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">	
							<div class="col-md-12">
								<h4 class="mar-top-50 text-color-g2">댓글이 없습니다. 첫 댓글을 달아보세요!</h4>
							</div>
						</div>
					</div>
				</c:if>
				
				<c:if test="${replyDto[0].review_num ne null}">
				<!-- 리스트 박스 -->
				<c:forEach var="replyDto" items="${replyDto}">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3" onclick="location='/gonggu/reviews/review?review_num=${replyDto.review_num}'" style="cursor:pointer">
						<div class="col-md-12 col-xs-12">
							<div id="${replyDto.review_num}" class="replyListBox replyContent mar-top-10">
							<h5 class="etcOneLine ">${replyDto.content}</h5>	
							<h5 class="etcOneLine text-color-g2">${replyDto.upload_date}</h5>
							</div>
						</div>	
					</div>
				</div>
				</c:forEach>
			
			
			<!-- 페이지 넘버 -->
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
						<div class="row">
						<c:if test="${info.cnt gt 0}">
							<div class="col-md-2 text-center">
							<c:if test="${info.startPage gt info.pageBlock}">
								<a href="/gonggu/mypage/replys?pageNum=${info.startPage-info.pageBlock}">◀</a>
							</c:if>
							</div>
							<div class="col-md-8">
							<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
								<c:if test="${i eq info.currentPage}">
									<span style="color: #5BC0DE;">[${i}]</span>
								</c:if>
								<c:if test="${i ne info.currentPage}">
									<a href="/gonggu/mypage/replys?pageNum=${i}">[${i}]</a>
								</c:if>
							</c:forEach>
							</div>
							<div class="col-md-2">
							<c:if test="${info.pageCount gt info.endPage}">
								<a href="/gonggu/mypage/replys?pageNum=${info.startPage+info.pageBlock}">▶</a>	
							</c:if>
							</div>
						</c:if>
						</div>
					</div>
				</div>
			</div>
			</c:if>
			</div>
		</div>		