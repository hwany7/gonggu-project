//로그인 널체크
function checkLogin(){
	
	var member_email = loginForm.member_email.value;
	var password = loginForm.password.value;
	
	if(!member_email){
		alert("이메일을 입력하세요");
		loginForm.member_email.focus();
		return false;
	}else if(!password){
		alert("비밀번호를 입력하세요"); 
		loginForm.password.focus();
		return false;
	}
}

//비밀번호 널체크
function checkPassword() {
	
	if(!passwordForm.password.value) {
		alert("비밀번호를 입력해주세요");
		passwordForm.password.focus();
		return false;
	}
}

//패스워크 유효성 검사
function validatePassword(){

	var pwd=$('input[name=password]').val();
	var reg=/^(?=.*?[a-zA-z])(?=.*?[0-9])(?=.*?[#?!@\\$%^&*-]).{8,}$/;
	
	if(reg.test(pwd)){
		$("#pwdRegErr").hide();
	}else{
	     $("#pwdRegErr").show().css('color', 'red');
	}
}

//리 패스워드 유효성 검사
function validateRepassword(){
	
	var rePwd=$('input[name=repassword]').val();
	var pwd=$('input[name=password]').val();
	
	if(rePwd==pwd){
	    $("#rePwdErr").hide();
	    signUpForm.checkPassword.value = '1';
	}else{
	    $("#rePwdErr").show().css('color', 'red');
	}
}

//전화번호 유효성 검사
function validationTeleNum(){

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
function conditionCheckMemberForm(){
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

//리플 널체크
function checkReply(){
	if(!replyForm.content.value){
		alert("댓글을 입력하세요");
		replyForm.content.focus();
		return false;
	}
}

//결제 널체크
function checkPayment(){
	var receiver_name = paymentForm.receiver_name.value;
	var address1 = paymentForm.address1.value;
	var address2 = paymentForm.address2.value;
	
	if( !receiver_name ){
		alert("배송 받는 사람을 입력해주세요");
		return false;
	} 
	if( !address1 ){
		alert("주소를 입력해 주세요");
		return false;
	} 
	if( !address2 ){
		alert("상세 주소를 입력해 주세요");
		paymentForm.address2.focus();
		return false;
	}
}

//결제취소 설문 체크
function checkPoll() {
	var priceValue = poll.cancel_price.value;

	var functionValue = poll.cancel_function.value;
	var productValue = poll.cancel_product.value;
	var siteValue = poll.cancel_site.value;
	var mindValue = poll.cancel_mind.value;
	var contentValue = poll.cancel_content.value;

	if(!priceValue || !functionValue || !productValue || !siteValue || !mindValue || !contentValue ){
		alert( "신청취소한 이유를 선택주세요!" );
		return false;
	}
}

//리뷰쓰기 폼 체크
function checkReview(){
	
	var title = writeReviewForm.title.value;s
	var content = $('textarea[name=content]').val();

	if(!title){
		alert("제목을 입력해 주세요");
		return false;
	}else if(!content){
		alert("내용을 입력해 주세요");
		return false;
	} 	
}

//내정보 체크
function checkMyInfo(){
	
	var password = passwordForm.password.value;
	
	if(!password){
		alert( "비밀번호를 입력해주세요" );
		return false;
	}
}

//이메일 유효성 검사
function validateEmail(){
	
	var email=$('input[name=member_email]').val();
	var reg=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	if(reg.test(email)){
		
	  	$("#emailErr").hide();
	  	$('#mailConfirmForm').removeAttr('disabled');
	  	
		//이메일 중복 검사
		$.ajax({
			url : '/gonggu/signup/emailcheck',
			type : 'get',
			data : {'member_email' : email},
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

//회원가입 유효성 검사
function validateNickname() {
	
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
			url : '/gonggu/signup/nicknamecheck',
			type : 'get',
			data : {'nickname' : nickname},
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







