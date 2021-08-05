<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>
		<script type="text/javascript">
			$(function(){
				CKEDITOR.replace( 'editor', {
					filebrowserUploadUrl: '/gonggu/upload/image/ckedit',
					height : 300,
					language: 'ko'
				});
			});
		</script>
	
		<div class="row">
			<div class="cropping" style="height: 100px;">
				<img src="/gonggu/resources/img/tamplate3.jpg">
			</div>
		</div>	
	
		<div class="container-fluid font-DH">	
			<div class="row max-width-1300 div-center">
				<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 border-under-a">	
					<div class="col-md-12">
						<h3 class="font-DH mar-top-50 ">리뷰수정</h3>
					</div>
				</div>
			</div>
			
			<div class="row max-width-1300 div-center">
				<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">	
					<form method="post" role="form" action="/gonggu/reviews/review/modifypro" name="writeReviewForm" onclick="return checkReview()">
						<input type="hidden" name="review_num" value="${review.review_num}"> 
						
						<div class="form-group">
							<label class="mar-top-20">글제목</label>
							<input class="form-control" name="title" value="${review.title}">
						</div>
						
						<div class="form-group">
							<textarea id="editor" name="content">${review.content}</textarea>
						</div>
						
						<div class="form-group text-right">
							<input type="submit" class="btn btn-info" value="수정하기">
						</div>
					</form>	
				</div>
			</div>
		</div>	