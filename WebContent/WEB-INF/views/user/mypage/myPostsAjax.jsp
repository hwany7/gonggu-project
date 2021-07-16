<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>				
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				<div class="container-fluid">
					<!-- 내역이 없을경우 -->
					<c:if test="${postListDto[0].post_id eq null }">
						<div class="row">
							<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">	
								<div class="col-md-12">
									<h4 class="font-DH mar-top-50 text-color-g2">결제 가능한 제품이 없습니다. 제품 신청을 해주세요!</h4>
								</div>
							</div>
						</div>
					</c:if>		
				</div>
			
				<!-- 리스트 박스 -->
				<div class="container-fluid">
					<c:forEach var="postListDto" items="${postListDto}">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
							<div class="postListBox">
								<div class="col-md-4 col-xs-4">
									<div class="div-center">
										<a href="post?post_id=${postListDto.post_id}">
											<img class="postListImage" src="${postListDto.thumbnail}">
										</a>
									</div>
									<input class="postList-amount-absolute" type="button" value="${postListDto.current_amount}명 신청" onclick="location='post?post_id=${postListDto.post_id}'">
								</div>
								<div class="col-md-8 col-xs-8">
									<div class="postListInfo">
										<h6 class="text-main-color">[${postListDto.product_name}]</h6>
										<h4>${postListDto.post_title}</h4>			
										<div class="etc text-color-g2">${postListDto.content}</div>
										<c:if test="${info.post_status eq 'P'}">
											<input type="button" value="결제" class="btn btn-default" onclick="pay_post('${postListDto.total_price}', '${postListDto.application_id}')">					
										</c:if>
										<c:if test="${info.post_status eq 'A'}">
											<input type="button" value="취소" class="btn btn-default" >
										</c:if>
									</div>							
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					
					<!-- 페이지 넘버 -->
					<div class="row">
						<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
							<div class="row">
							<c:if test="${info.cnt gt 0}">
								<div class="col-md-2 text-center">
								<c:if test="${info.startPage gt info.pageBlock}">
									<a onclick="getMyPosts('${info.startPage-info.pageBlock}', '${info.post_status}')">◀</a>
								</c:if>
								</div>
								<div class="col-md-8">
								<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
									<c:if test="${i eq info.currentPage}">
										<span style="color: #5BC0DE;">[${i}]</span>
									</c:if>
									<c:if test="${i ne info.currentPage}">
										<a onclick="getMyPosts('${i}', '${info.post_status}')">[${i}]</a>
									</c:if>
								</c:forEach>
								</div>
								<div class="col-md-2">
								<c:if test="${info.pageCount gt info.endPage}">	
									<a onclick="getMyPosts('${info.startPage+info.pageBlock}', '${info.post_status}')">▶</a>
								</c:if>
								</div>
							</c:if>
							</div>
						</div>
					</div>
				</div>