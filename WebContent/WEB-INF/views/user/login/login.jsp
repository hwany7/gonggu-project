<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
				<!-- login.jsp -->
				<div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4">
					<div class="div-center max-width-400">
						<div class="mar-top-150">
				        	<h2>로그인</h2>
				        </div>
			            <form name="loginForm" role="form" action="loginPro" onsubmit="return checkNullLogin()">
			            	<div class="form-group">
			                	<input type="text" class="form-control height-40" name="member_email" placeholder="이메일 아이디를 입력하세요">
			                </div>
			                <div class="form-group">
			                    <input type="password" class="form-control height-40"  name="password" placeholder="비밀번호를 입력하세요">
			                </div>
			                <div>
			                	<h6 class="text-right">아이디/비밀번호 찾기></h6>
			                </div>
			                <div class="form-group">
			                    <button type="submit" class="btn btn-primary width-100p height-40">로그인</button>
			                </div>
			                <div>
			                	<h6 class="text-center">아직 계정이 없으시다면..</h6>
			                </div>
			                <div class="form-group">
			                    <button type="button" class="btn btn-info width-100p height-40" onclick="location='/gonggu/signup'">회원가입</button>
			                </div>
			             </form>
				    </div>
				</div> 