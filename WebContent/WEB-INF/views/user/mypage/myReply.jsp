<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div class="max-width-1500 div-center">
			<div class="container-fluid font-DH">		
				<!-- 내역이 없을경우 -->
				<c:if test="${replyDto[0].review_num eq null }">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">	
							<div class="col-md-12">
								<h4 class="mar-top-50 text-color-g2">댓글이 없습니다. 첫 댓글을 달아보세요!</h4>
							</div>
						</div>
					</div>
				</c:if>
					
				<!-- 리스트 박스 -->
				<c:forEach var="replyDto" items="${replyDto}">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3" onclick="location='review?review_num=${replyDto.review_num}'" style="cursor:pointer">
						<div class="col-md-12 col-xs-12">
							<div id="${replyDto.review_num}" class="replyListBox replyContent mar-top-10">
							<h5 class="etcOneLine ">${replyDto.content}</h5>	
							<h5 class="etcOneLine text-color-g2">${replyDto.upload_date}</h5>
							</div>
						</div>	
					</div>
				</div>
				</c:forEach>
			</div>
		</div>		