<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	            <div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4">
					<div class="div-center max-width-400">
						<div class="mar-top-150">
			                <h2>휴먼상태 해제하기</h2>
			            </div>
		                <form method="post" action="activateStatusPro" name="passwordform" onsubmit="return checkNullPassword">
		                	<input type="hidden" name="member_id" value="${member_id}">
		                    <div class="form-group">
		                        <input type="password" class="form-control height-40"  name="password" placeholder="비밀번호를 입력하세요">
		                    </div>
		                    <div class="form-group">
		                    	<div class="row">
		                    	<div class="col-md-6 col-xs-6">
		                    		<button type="submit" class="btn btn-info width-100p height-40">휴먼 계정 풀기</button>
		                    	</div>
		                    	<div class="col-md-6 col-xs-6">
		                    		<button type="button" class="btn btn-danger width-100p height-40" onclick="location='/gonggu/login'">취소</button>
		                    	</div> 
            				</div>
		                    </div>
		                </form>
	                </div>
	            </div>
	            