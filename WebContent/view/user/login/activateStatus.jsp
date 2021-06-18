<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/setting.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GongGu</title>
	</head>
	<body>
		<!-- 컨테이너 -->
		<div class="container-fluid">
		
			<!-- 상단 메뉴바-->
			<div class="row">
				<div class="height-60 pd-top-15 hf login-menu line-a">
					<div class="col-xs-6 col-md-6">
						<div class="mar-left-100"><h4><a href="mainPage.do">GongGu</a></h4></div>
					</div>
					
					<div class="col-xs-6 col-md-6">
						<div class="text-right mar-right-150">
							<h4>
								<span><a href="loginForm.do" >로그인</a></span>
								<span><a href="signUpForm.do">회원가입</a></span>
							</h4>
						</div>
					</div>
				</div>
			</div>
			
	         <!-- 로그인 폼 -->   
             <div class="row">       
	            <div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4">
					<div class="div-center max-width-400">
						<div class="mar-top-150">
			                <h2>휴먼상태 해제하기</h2>
			            </div>
		                <form method="post" action="activateStatusPro.do" name="passwordform" onsubmit="return passwordcheck()">
		                    <div class="form-group">
		                        <input type="password" class="form-control height-40"  name="password" placeholder="비밀번호를 입력하세요">
		                    </div>
		                    <div class="form-group">
		                    	<div class="row">
		                    	<div class="col-md-6 col-xs-6">
		                    		<button type="submit" class="btn btn-info width-100p height-40">휴먼 계정 풀기</button>
		                    	</div>
		                    	<div class="col-md-6 col-xs-6">
		                    		<button type="button" class="btn btn-danger width-100p height-40" onclick="location='loginForm.do'">취소</button>
		                    	</div> 
            				</div>
		                    </div>
		                </form>
	                </div>
	            </div>
            </div>	   
		</div>
	</body>
</html>