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
		
		<input type="hidden" class="navIndex" value="2">
		
		<div class="container-fluid font-DH">	
			<div class="row max-width-1300 div-center">
				<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2 border-under-a">	
					<div class="col-md-12">
						<h3 class="font-DH mar-top-50 ">리뷰작성</h3>
					</div>
				</div>	
			</div>
			
			<div class="row max-width-1300 div-center">
				<div class="col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">	
					<form method="post" role="form" action="/gonggu/reviews/review/writePro" name="writeReviewForm" onsubmit="return checkReview()">
						<input type="hidden" name="payment_id" value="${payment_id}"> 
						<div class="form-group">
							<label class="mar-top-20">글제목</label>
							<input class="form-control" name="title">
						</div>
						
						<div class="form-group">
							<textarea id="editor" name="content"></textarea>
						</div>
						
						<div class="form-group text-right">
							<input type="submit" class="btn btn-info" value="작성하기">
						</div>
					</form>	
				</div>
			</div>
		</div>