<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- navCss 컨트롤 -->
	<input type="hidden" class="navIndex" value="5">
	<div class="max-width-1500 div-center font-DH">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 border-under-a">	
						<div class="col-md-12">
							<h3 class="mar-top-50 ">비밀번호 확인</h3>
						</div>
					</div>
				</div>
				
				<!-- 리스트 박스 -->
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
						<form method="post" action="/gonggu/mypage/info/signoutpro" name="passwordForm" onsubmit="return checkPassword()">
							<div class="col-md-12 col-xs-12">								
								<div class="mar-top-20">
									<h6 class="text-color-g2">비밀번호 입력</h6>
									<div class="row">
										<div class="col-md-8 col-xs-8">
											<input type="password" name="password" class="form-control">
										</div>
										<div class="col-md-4 col-xs-4">
											<input type="submit" class="btn btn-default" value="탈퇴하기">
										</div>
									</div>
									<h5 style="color: red;">탈퇴하기를 정말로 누르면 탈퇴 처리가 진행됩니다</h5>
									<hr>
								</div>
							</div>
						</form>	
					</div>
				</div>
			</div>		
		</div>	