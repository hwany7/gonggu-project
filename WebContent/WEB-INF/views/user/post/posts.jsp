<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<!-- 상단 이미지 -->
		<div class="row">
			<div class="cropping" style="height:100px;">
				<img src="/gonggu/resources/img/tamplate2.jpg">
			</div>
		</div>
		
		<div class="max-width-1500 div-center">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 border-under-a">	
						<div class="col-md-12">
							<h3 class="font-DH mar-top-50 ">전체보기</h3>
						</div>
					</div>
				</div>
				
				<!-- 리스트 박스 -->
				<c:forEach var="postListDto" items="${postListDto}">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
						<div class="postListBox">
							<div class="col-md-4 col-xs-4">
								<div class="div-center">
									<a href="/gonggu/post?post_id=${postListDto.post_id}">
										<img class="postListImage" src="${postListDto.thumbnail}">
									</a>
								</div>
								<input class="postList-amount-absolute" type="button" value="${postListDto.current_amount}명 신청" onclick="location='/gonggu/post?post_id=${postListDto.post_id}'">
							</div>
							<div class="col-md-8 col-xs-8">
								<div class="postListInfo">
									<h6 class="text-main-color">[${postListDto.product_name}]</h6>
									<h4>${postListDto.post_title}</h4>			
									<div class="etc text-color-g2">${postListDto.content}</div>
								</div>							
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			
			<!-- 검색창 -->
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 mar-top-20">
					<form method="post" action="posts">
						<input type="hidden" name="category_id" value="${info.category_id}">				
						<div class="col-md-2 col-xs-2">
							<select class="form-control" name="select" >
								<option value="post_title+product_model">공통</option>
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

			<!-- 페이지 넘버 -->
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-2 col-md-offset-5 hf font-DH text-center mar-top-20">
						<div class="row">
						<c:if test="${info.cnt gt 0}">
							<div class="col-md-2 text-center">
							<c:if test="${info.startPage gt info.pageBlock}">
								<a href="/gonggu/posts?pageNum=${info.startPage-info.pageBlock}&category_id=${info.category_id}&search=${info.search}">◀</a>
							</c:if>
							</div>
							<div class="col-md-8">
							<c:forEach var="i" begin="${info.startPage}" end="${info.endPage}">
								<c:if test="${i eq info.currentPage}">
									<span style="color: #5BC0DE;">[${i}]</span>
								</c:if>
								<c:if test="${i ne info.currentPage}">
									<a href="/gonggu/posts?pageNum=${i}&category_id=${info.category_id}&search=${info.search}">[${i}]</a>
								</c:if>
							</c:forEach>
							</div>
							<div class="col-md-2">
							<c:if test="${info.pageCount gt info.endPage}">
								<a href="/gonggu/posts?pageNum=${info.startPage+info.pageBlock}&category_id=${info.category_id}&search=${info.search}">▶</a>	
							</c:if>
							</div>
						</c:if>
						</div>
					</div>
				</div>
			</div>	
		</div>
