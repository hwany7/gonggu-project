//유저 로그인 체크
function loginCheck(){
	var idValue = loginForm.member_email.value;
	var passwdValue = loginForm.password.value;
	if(!idValue){
		alert( "이메일을 입력하세요" );
		loginForm.member_email.focus();
		return false;
	}else if(!passwdValue){
		alert( "비밀번호를 입력하세요" ); 
		loginForm.password.focus();
		return false;
	}
}