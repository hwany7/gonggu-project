<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<!-- 컨테이너 -->
		<div class="max-width-1500 div-center">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 border-under-a">	
						<div class="col-md-12">
							<h3 class="font-DH mar-top-50 ">결제하기</h3>
						</div>
					</div>
				</div>	
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 border-under-a">
						<!-- 로그인 폼 -->
		           		<form method="post" name="paymentForm" action="payPostPro" onsubmit="return paymentFormCheck()">
		 					<input type="hidden" name="total_price" value="${total_price}">
							<input type="hidden" name="application_id" value="${application_id}">		     			
		                    <div class="form-group">
			                	<input type="text" class="form-control mar-top-30" name="receiver_name" placeholder="받는 사람 이름" >                    
		                    </div>	                  
		                  
		                    <div class="form-group mar-top-30">
		                    	<div class="row">
			                    	<div class="col-md-5 col-xs-5">
			                       		<input type="text" class="form-control" name="zipcode" id="zipcode"  value="${memberDto.zipcode}" placeholder="우편번호" readonly="readonly">
			                        </div>
			                    	<div class="col-md-7 col-xs-7">
			                       		<input type="text" class="form-control" name="address1" id="address1" value="${memberDto.address1}" placeholder="도로명주소" readonly="readonly">
			                        </div>
		                        </div>
		                    </div>
		                    <div class="form-group">
		                    	<div class="row">
			                    	<div class="col-md-8 col-xs-8">
			                       		<input type="text" class="form-control" name="address2" id="address2" value="${memberDto.address2}" placeholder="상세주소">
			                        </div>
			                    	<div class="col-md-4 col-xs-4">
			                       		<input type="button" class="btn btn-info width-100p" value="찾기" onclick="sample4_execDaumPostcode();">
			                        </div>
		                        </div>
		                    </div>                    
		                     <div class="form-group">
		                    	<input type="text" class="form-control" name="request" placeholder="배송시 요청사항">
		                    	
		                    </div>  
		                   
		                     <div class="form-group">
		                    	<input type="text" class="form-control" name="total_price" placeholder="결제금액" value="${total_price}" readonly="readonly">
		                    
		                    </div>
		                     <div class="form-group">
		                    	<select class="form-control" name="method" >
									<option value="카드 결제">카드 결제</option>
								    <option value="휴대폰 결제">휴대폰 결제</option>
								    <option value="무통장 입금">무통장 입금</option>
								    <option value="카카오페이">카카오페이</option>
								</select>  
		                    </div>	     	                    
		                    <div class="form-group">
		                    	<div class="row">
		                    		<div class="col-md-6 col-xs-6">
		                    			<button type="submit" class="btn btn-info width-100p height-40">결제하기</button>
		                    		</div>
		                    		<div class="col-md-6 col-xs-6">
		                    			<button type="button" class="btn btn-danger width-100p height-40" onclick="location='myPage'">결제취소</button>
		                    		</div>
		                    	</div>
		                        
		                    </div>
		                </form>        
					</div>
				</div>		
			<!-- 컨테이너 -->	
			</div>
		</div>
		
