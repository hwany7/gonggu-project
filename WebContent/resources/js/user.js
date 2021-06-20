//유저 로그인 체크
function checkNullLogin(){
	var idValue = loginForm.member_email.value;
	var passwdValue = loginForm.password.value;
	
	if(!idValue){
		alert("이메일을 입력하세요");
		loginForm.member_email.focus();
		return false;
	}else if(!passwdValue){
		alert("비밀번호를 입력하세요"); 
		loginForm.password.focus();
		return false;
	}
}

//계정 활성화 - 비밀번호 체크
function checkNullPassword() {
	if(!passwordform.password.value) {
		alert("비밀번호를 입력해주세요");
		passwordform.password.focus();
		return false;
	}
}

//회원가입 - 이메일 유효성 검사
function checkValidationEmail(){
	
	var email=$('input[name=member_email]').val();
	var reg=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	if(reg.test(email)){
		
	  	$("#emailErr").hide();
	  	$('#mailConfirmForm').removeAttr('disabled');
	  	
		//이메일 중복 검사
		$.ajax({
			url : 'checkEmail.do',
			type : 'get',
			data : {'member_email' : email},
			dataType : 'text',
			success : function(result) {
				if(result != 0){	
					msg = "<h6 id='checkMsg' style='color: red;'>이미 등록된 이메일 입니다</h6>";
					$("#email_check").html(msg);	
					$('#mailConfirmForm').attr('disabled', 'disabled');
					signUpForm.checkEmail.value = '0';
				}else{
					$("#email_check").html('');
					signUpForm.checkEmail.value = '1';
				}
			},
			error : function(e) {
				$('#email_check').html(e+'에러');								
			}				
		});	
	}else{
	    $("#emailErr").show().css('color', 'red');
	    $("#email_check").html('');	
	    $('#mailConfirmForm').attr('disabled', 'disabled');
	}
}

//회원가입 - 닉네임 유효성 검사
function checkValidationNickName() {
	var nickname = signUpForm.nickname.value;
	var nickLength = 0;
	var engCheck = /[a-z]/;
	var numCheck = /[0-9]/;
	var specialCheck = /[`~!@#$%^&*.|\\\'\";:\/?_-]/gi;
	
	for(var i=0; i<nickname.length; i++){
		nick = nickname.charAt(i);
		if(escape(nick).length >4){
			nickLength += 2;
		 }else{
			 nickLength += 1;
		 }
	}
	
	if (!(nickname == null || nickname == "" || nickname.search(/\s/) != -1 || nickLength<2 || nickLength>20 || specialCheck.test(nickname))) {
		
		$("#nicknameErr").hide();
		
		//닉네임 중복 검사
		$.ajax({
			url : 'checkNickname.do',
			type : 'get',
			data : {'nickname' : nickname},
			dataType : 'text',
			success : function(result) {
				if (result != 0) {
					msg = "<h6 id='checkMsg' style='color: red;'>이미 사용중인 닉네임 입니다.</h6>";
					$("#nickname_check").html(msg);
					signUpForm.checkNickname.value = '0';						

				} else {
					$("#nickname_check").html('');	
					signUpForm.checkNickname.value = '1';
				}
			},
			error : function(e) {
				$('#nickname_check').html(e+'에러');			
			}				
		});
	}else{
		$("#nicknameErr").show().css('color', 'red');
		$("#nickname_check").html('');	
	}
}

//회원가입 - 메일 인증
function openMailConfimForm(){
	
	var member_email = $('input[name=member_email]').val();
	   
	var w = 500;
	var h = 500;
	var popupY= (window.screen.height/2) - (h/2);
	var popupX = (window.screen.width/2) - (w/2);
	var url = "mailConfirmForm.do?member_email=" + member_email;
	
	open(url, 'mailConfirmForm', 'menubar=no,statusbar=no,scrollbar=no, width=' + w + ', height=' + h + ', left=' + popupX + ', top=' + popupY);
}

//회원가입 - 메일인증 성공 여부
function clickMailConfimForm(){
	
	var codeMsg = $('button[name=confim_btn]').attr('id');
	var inputCode = $('.inputCode').val();
	
	if(codeMsg == inputCode){
		alert('인증 완료');
		opener.document.getElementById('mailConfirmForm').value = "인증 완료";
		opener.document.getElementById('mailConfirmForm').disabled = true;
		opener.document.getElementById('memberEmail').disabled = true;
		opener.document.getElementById('emailConfirm').value = '1';
		
		
		window.close();
	}else{
		alert('코드를 정확히 입력해 주세요');
		return false;
	}
	
}
