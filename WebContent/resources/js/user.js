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
			dataType : 'String',
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
			dataType : 'String',
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
		signUpForm.checkNickname.value = '0';
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
		opener.document.getElementById('memberEmail').readOnly = true;
		opener.document.getElementById('emailConfirm').value = '1';
		
		
		window.close();
	}else{
		alert('코드를 정확히 입력해 주세요');
		return false;
	}
	
}

//회원가입-패스워드 검사
function checkValidationPassword(){

	var pwd=$('input[name=password]').val();
	var reg=/^(?=.*?[a-zA-z])(?=.*?[0-9])(?=.*?[#?!@\\$%^&*-]).{8,}$/;
	
	if(reg.test(pwd)){
		$("#pwdRegErr").hide();
	}else{
	     $("#pwdRegErr").show().css('color', 'red');
	}
}

function checkValidationRePassword(){
	
	var rePwd=$('input[name=repassword]').val();
	var pwd=$('input[name=password]').val();
	
	if(rePwd==pwd){
	    $("#rePwdErr").hide();
	}else{
	    $("#rePwdErr").show().css('color', 'red');
	}
}

//회원가입-다음 주소 찾기 API
function sample4_execDaumPostcode() {
    new daum.Postcode({
    			oncomplete : function(data) {

                    // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                    var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== ''
                            && /[동|로|가]$/g.test(data.bname)) {
                        extraRoadAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== ''
                            && data.apartment === 'Y') {
                        extraRoadAddr += (extraRoadAddr !== '' ? ', '
                                + data.buildingName : data.buildingName);
                    }
                    // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraRoadAddr !== '') {
                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                    }
                    // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                    if (fullRoadAddr !== '') {
                        fullRoadAddr += extraRoadAddr;
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                    document.getElementById('address1').value = fullRoadAddr;

                    // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                    if (data.autoRoadAddress) {
                        //예상되는 도로명 주소에 조합형 주소를 추가한다.
                        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                        document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    }
                }
            }).open();
}


function checkValidationTeleNum(){

	    var tel=$('input[name=tel]').val();
	    var reg=/^\d{3}-\d{3,4}-\d{4}$/;
	    
	    if(reg.test(tel)){
	    	$("#telErr").hide();
	    	signUpForm.checkTel.value = '1';

	    }else{
	         $("#telErr").show().css('color', 'red');
	         signUpForm.checkTel.value = '0';
	    }  
}

//유저 회원가입 폼 체크
function checkConditionSignUpFrom(){
	var password = signUpForm.password.value;
	var checkEmail = signUpForm.checkEmail.value;
	var emailConfirm = signUpForm.emailConfirm.value;
	var checkNickname = signUpForm.checkNickname.value;
	var address1 = signUpForm.address1.value;
	var address2 = signUpForm.address2.value;
	var tel = signUpForm.tel.value;

	if(checkEmail == 0){
		alert("이메일을 입력 해주세요");
		return false;
	}else if(emailConfirm == 0){
		alert("이메일 인증을 해주세요");
		return false;
	}else if(password == ""){
		alert("비밀번호를 입력해 주세요");
		return false;
	}else if(checkNickname == 0){
		alert("닉네임 중복 확인을 해주세요");
		return false;
	}else if(address1 == ""){
		alert("주소를 입력해 주세요");
		return false;
	}else if(address2 == ""){
		alert("상세 주소를 입력해 주세요");
		signUpForm.address2.focus();
		return false;
	}else if(tel == ""){
		alert("전화번호를 입력해 주세요");
		signUpForm.tel.focus();
		return false;
	}
}
