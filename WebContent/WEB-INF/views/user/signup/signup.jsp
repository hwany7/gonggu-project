<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    			<!-- signup.jsp -->
	 			<div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4">
	 				<div class="div-center max-width-400">
		 				<div class="mar-top-100">
			                <h2>회원가입</h2>
			            </div>	
		            	<!-- 회원가입 폼 -->
		           		<form method="post" name="signUpForm" role="form" action="/gonggu/signuppro" onsubmit="return conditionCheckMemberForm()">
		           			<input type="hidden" id="checkEmail" value="0">
		           			<input type="hidden" id="checkNickname" value="0">
		           			<input type="hidden" id="checkPassword" value="0">
		           			<input type="hidden" id="emailConfirm" value="0">
		           			<input type="hidden" id="checkTel" value="0">
		           			
		                    <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-8 col-xs-8">			                    		
			                       		<input type="text" class="form-control" id ="memberEmail" name="member_email" placeholder="이메일 계정" onkeyup="validateEmail()" >
			                        </div>
			                    	<div class="col-md-4 col-xs-4">
			                       		<input type="button" id="mailConfirmForm" class="btn btn-info width-100p" value="인증하기" disabled="disabled" onclick="openMailConfimForm()">
			                        </div>
		                        </div>
		                    </div>	                  
		                    <div class="form-group">
		                    	<h6 id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해 주세요.</h6>
		                    	<div id="email_check"></div>
		                    </div>
		                    <div class="form-group">
		                        <input type="password" class="form-control" name="password" placeholder="비밀번호 입력" onkeyup="validatePassword()">
		                        <h6 id="pwdRegErr" class="help-block">8글자 이상, 특수문자를 조합하여 입력하세요.</h6>
		                    </div>
		                    <div class="form-group">
		                        <input type="password" class="form-control" name="repassword" placeholder="비밀번호 확인" onkeyup="validateRepassword()">
		                        <h6 id="rePwdErr" class="help-block">비밀번호와 일치하지 않습니다. 다시 입력해 주세요.</h6>
		                    </div>
		                    <div class="form-group">
		                        <input type="text" class="form-control" name="nickname" placeholder="닉네임" onkeyup="validateNickname()">
		                        <h6 id="nicknameErr" class="help-block">올바른 닉네임 형식이 아닙니다. 다시 입력해 주세요.</h6>
		                        <div id="nickname_check"></div>
		                    </div>
		                    <div class="form-group mar-top-30">
		                    	<div class="row">
			                    	<div class="col-md-5 col-xs-5">
			                       		<input type="text" class="form-control" name="zipcode" id="zipcode" placeholder="우편번호" readonly="readonly">
			                        </div>
			                    	<div class="col-md-7 col-xs-7">
			                       		<input type="text" class="form-control" name="address1" id="address1" placeholder="도로명주소" readonly="readonly">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-8 col-xs-8">
			                       		<input type="text" class="form-control" name="address2" id="address2" placeholder="상세주소">
			                        </div>
			                    	<div class="col-md-4 col-xs-4">
			                       		<input type="button" class="btn btn-info width-100p" value="찾기" onclick="openDaumPostcode();">
			                        </div>
		                        </div>
		                    </div>	                 
		                     <div class="form-group">
		                    	<input type="text" class="form-control" name="tel" placeholder="전화번호" onkeyup="validationTeleNum()">
		                    	<h6 id="telErr" class="help-block">'-'를 포함해서 입력해주세요.</h6>
		                    </div>
		                    <div class="mar-top-30">
		                    	<h4>상세 정보(선택사항)</h4>
		                    </div>		                                   
		                    <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-4 col-xs-4 text-center">
			                       		<label class="form-control">성별</label>
			                        </div>
			                    	<div class="col-md-8 col-xs-8">
			                       		<select class="form-control" id="inputGender" name="gender" >
								        	<option value= "">선택</option>
								        	<option value="남자">남자</option>
								        	<option value="여자">여자</option>
								        </select>
			                        </div>
		                        </div>
		                    </div>
						            <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-4 col-xs-4 text-center">
			                       		<label class="form-control">생년월일</label>
			                        </div>
			                    	<div class="col-md-8 col-xs-8">
			                       		<input class="form-control" type="date" name="birth_date">
			                        </div>
		                        </div>
		                    </div>
		                     <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-4 col-xs-4 text-center">
			                       		<label class="form-control">방문경로</label>
			                        </div>
			                    	<div class="col-md-8 col-xs-8">	
			                       		<select class="form-control" name="visit_path" >
								        	<option value=0>선택</option>
								        	<option value=1>검색</option>
								        	<option value=2>카페</option>
								        	<option value=3>블로그</option>
								        	<option value=4>SNS</option>
								        </select>
			                        </div>
		                        </div>
		                    </div>	                     
		                    <div class="form-group mar-bottom-100">
		                        <button type="submit" class="btn btn-info width-100p height-40">가입</button>
		                    </div>
		                </form>        
	                </div>
	            </div>
	            <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>