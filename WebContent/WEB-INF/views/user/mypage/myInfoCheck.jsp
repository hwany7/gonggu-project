<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    	<input type="hidden" class="navIndex" value="5">
    	
		<div class="max-width-1500 div-center">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3 border-under-a">	
						<div class="col-md-12">
							<h3 class="font-DH mar-top-50 ">비밀번호 확인</h3>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
						<form method="post" action="/gonggu/mypage/info/checkpro" name="passwordForm" onsubmit="retrun checkMyInfo()">
							<div class="col-md-12 col-xs-12">								
								<div class="mar-top-20">
									<h6 class="text-color-g2">비밀번호 입력</h6>
									
									<div class="row">
										<div class="col-md-8 col-xs-8">
											<input type="password" name="password" class="form-control">
										</div>
										
										<div class="col-md-4 col-xs-4">
											<input type="submit" class="btn btn-default" value="확인">
										</div>
									</div>
									
									<hr>
								</div>
							</div>
						</form>	
					</div>
				</div>
			</div>
		</div>				
