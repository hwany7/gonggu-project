<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

		<input type="hidden" class="navIndex" value="1">
		
		<div class="max-width-1500 div-center">
			<c:if test="${posts[0].post_id eq null }">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">	
							<div class="col-md-12">
								<h4 class="font-DH mar-top-50 text-color-g2">제품이 없습니다.</h4>
							</div>
						</div>
					</div>
				</div>
			</c:if>		
			
			<c:if test="${posts[0].post_id ne null }">
				<div class="container-fluid">
					<c:forEach var="post" items="${posts}">
						<div class="row">
							<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
								<div class="postListBox">
									<div class="col-md-4 col-xs-4">
										<div class="div-center">
											<a href="/gonggu/posts/post?post_id=${post.post_id}">
												<img class="postListImage" src="${post.thumbnail}">
											</a>
										</div>
										<input class="postList-amount-absolute" type="button" value="${post.current_amount}명 신청" onclick="location='/gonggu/posts/post?post_id=${post.post_id}'">
									</div>
									
									<div class="col-md-8 col-xs-8">
										<div class="postListInfo">
											<h6 class="text-main-color">[${post.product_name}]</h6>
											<h4>${post.post_title}</h4>			
											<div class="etc text-color-g2">${post.content}</div> 
											 
											<c:if test="${info.post_status eq 'A'}">
												<button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModal">신청취소</button>  
												    
	                       						<form method="get" action="/gonggu/mypage/posts/apply/cancelpro" name="poll" onsubmit="return checkPoll()" >
	                        						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	                          							<div class="modal-dialog" role="document">
	                            							<div class="modal-content">
	                              								<div class="modal-header">
	                                								<h5 class="modal-title" id="exampleModalLabel">신청 취소한 이유를 선정해주세요 (중복체크 OK)</h5>
	                                								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                                  									<span aria-hidden="true">&times;</span>
	                                								</button>
	                              								</div>
	                              								
		                              							<div class="modal-body">
		                                  							<input type="radio" name="cancel_price" value="비싼것 같아서" ondblclick="this.checked=false">&nbsp; 1.내가 생각한 가격대가 아니라서<br>
		                                  							<input type="radio" name="cancel_function" value="내가  원하는 제품의 기능과 목적이 달라서" ondblclick="this.checked=false">&nbsp; 2.내가  원하는 제품의 기능과 목적이 달라서<br>
		                                							<input type="radio" name="cancel_product" value="다른 제품 신청하기 위해서" ondblclick="this.checked=false">&nbsp; 3.다른 제품 신청하기 위해서<br>
									                                <input type="radio" name="cancel_site" value="타사이트에서 주문하기 위해서" ondblclick="this.checked=false">&nbsp; 4.타사이트에서 주문하기 위해서<br>
									                                <input type="radio" name="cancel_mind" value="기타" ondblclick="this.checked=false">&nbsp; 5.기타<br>
								                                	<div class="form-group">
								                           				 <label for="message-text" class="col-form-label">취소하신 사유를 작성해주시면 개선에 많은 도움이됩니다!</label>
								                           			 	<textarea class="form-control" id="message-text" name="cancel_content"></textarea>
								                 					 </div>
		                             							 </div>
		                             							 
		                              							<div class="modal-footer">
		                              	 							<input type="hidden" name="application_id" value="${post.application_id}">
		                                 							<button type="submit" class="btn btn-primary">확인</button>
		                                 							<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="closeModal()">취소</button>
		                             							</div>                              
						                           	 		</div>
						                          		</div>
						                        	</div>
						                        </form> 
											</c:if>																				
										</div>							
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					
					<div class="row">
						<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
							<div class="row">
								<c:if test="${info.cnt gt 0}">
									<div class="col-md-2 text-center">
										<c:if test="${info.startPage gt info.pageBlock}"> 
											<a href="/gonggu/mypage/posts/apply?pageNum=${info.startPage-info.pageBlock}">◀</a>
										</c:if>
									</div>
									
									<div class="col-md-8">
									<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
										<c:if test="${i eq info.currentPage}">
											<span style="color: #5BC0DE;">[${i}]</span>
										</c:if>
										
										<c:if test="${i ne info.currentPage}">
											<a href="/gonggu/mypage/posts/apply?pageNum=${i}">[${i}]</a>
										</c:if>
									</c:forEach>
									</div>
									
									<div class="col-md-2">
										<c:if test="${info.pageCount gt info.endPage}">	
											<a href="/gonggu/mypage/posts/apply?pageNum=${info.startPage+info.pageBlock}">▶</a>
										</c:if>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		

