<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/setting.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GongGu</title>
		<style type="text/css"> body { min-width: 500px; } </style>
	</head>
	<body>
		<!-- mailConfirmForm.jsp -->
		<div class="container-fluid">	
	         <!-- 로그인 폼 -->   
             <div class="row">       
	            <div class="col-md-10 col-md-offset-1 ">
					<div class="div-center">
						<div>
			                <h3>메일인증</h3>
			            </div>
		                <form name="mailConfirmForm" role="form">
		                    <div class="form-group">
		                        <input type="text" class="inputCode form-control height-40" placeholder="인증 번호를 입력하세요">
		                    </div>               
		                    <div class="form-group">
		                        <button type="button" id="${codeMsg}" name="confim_btn" class="confirmBtn btn btn-info width-100p height-40" onclick="mailConfirm()">인증하기</button>
		                    </div>
		                </form>
	                </div>
	            </div>
            </div>	   
		</div>
	</body>
</html>