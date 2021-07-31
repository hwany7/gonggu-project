//메일 인증창 열기
function openMailConfimForm(){
	
	var member_email = $('input[name=member_email]').val();
	   
	var w = 500;
	var h = 500;
	var popupY= (window.screen.height/2) - (h/2);
	var popupX = (window.screen.width/2) - (w/2);
	var url = "/gonggu/signup/mailconfirm?member_email=" + member_email;
	
	open(url, 'mailConfirmForm', 'menubar=no,statusbar=no,scrollbar=no, width=' + w + ', height=' + h + ', left=' + popupX + ', top=' + popupY);
}

//메일 인증
function mailConfirm(){
	
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

//다음 주소 찾기(sample4_execDaumPostcode)
function openDaumPostcode() {
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

//알림창 오픈하기
function openNotifycation(){
	
	$(".notifyBox").toggleClass("notifyBox-toggled");
	
	if($('.notifyBox').hasClass("notifyBox-toggled")){
	   $.ajax({
	      type : 'get',
	       url : "/gonggu/notifications",
	       dataType : "text",
	       success : function(data){
	    	   $('#notify2').removeClass('dispNotify');
	    	   $('#notify2').addClass('nonDispNotify');
	    	   $('#notify1').removeClass('nonDispNotify');
	    	   $('#notify1').addClass('dispNotify');
	    	   $(".notifyBox").html(data);
	       },
	       error : function(e){
	           alert("에러입니다");
	        }
	   });
	}
}

//안읽은 알람 체크
function checkNotification(member_id){
	if(member_id != ''){
		
		$.ajax({
	           url : '/gonggu/notificationscheck',
	           type : 'get',
	           dataType : 'text',
	           success : function(result) {
	              if(result == 1 ){
	                 $('#notify1').removeClass('dispNotify');
	                 $('#notify1').addClass('nonDispNotify');
	                 $('#notify2').removeClass('nonDispNotify');
	                 $('#notify2').addClass('dispNotify');
	              }else{
	                 $('#notify2').removeClass('dispNotify');
	                 $('#notify2').addClass('nonDispNotify');
	                 $('#notify1').removeClass('nonDispNotify');
	                 $('#notify1').addClass('dispNotify');
	              }
	           },
	           error : function(e) {}               
	        });
		
		setInterval(function(){
	        $.ajax({
	           url : '/gonggu/notificationscheck',
	           type : 'get',
	           dataType : 'text',
	           success : function(result) {
	              if(result == 1 ){
	                 $('#notify1').removeClass('dispNotify');
	                 $('#notify1').addClass('nonDispNotify');
	                 $('#notify2').removeClass('nonDispNotify');
	                 $('#notify2').addClass('dispNotify');
	              }else{
	                 $('#notify2').removeClass('dispNotify');
	                 $('#notify2').addClass('nonDispNotify');
	                 $('#notify1').removeClass('nonDispNotify');
	                 $('#notify1').addClass('dispNotify');
	              }
	           },
	           error : function(e) {}               
	        });
	     }, 3000);
	}
}

//알림 전체 지우기
function deleteAllNotification(){
    $.ajax({
        type : 'get',
         url : "/gonggu/notifications/deleteall",
         dataType : "text",
         success : function(data){
        	 $(".notifyBox").html(data);
         },
         error : function(e){
             alert("에러입니다");
          }
     });
}

//신청 추가
function addApply(member_id){	
	
	if(!member_id){
		alert("로그인을 해주세요");
		return window.document.location="/gonggu/login";
	}

	var post_id = $('input[name=post_id]').val();
	var amount = $('input[name=amount]').val();
	
	if(amount == ""|| amount == 0){
		alert("신청 개수를 입력해 주세요");
	}else{
		window.document.location="/gonggu/posts/post/applypro?post_id=" + post_id + "&amount=" + amount;	
	}
}

//리뷰 좋아요
function likeReview(member_id){
	
	if(!member_id){
		alert("로그인을 해주세요");
		return false;
	}
	var review_num = $(".likeReviewPro").attr('id');
	window.document.location="/gonggu/reviews/review/likepro?review_num=" + review_num;
}

function deleteReply(){

	var reply = confirm("삭제하시겠습니까 ?");
	
	if( reply == true ) {
		var reply_num = $(".deleteReply").attr('id');
		var review_num = $(".deleteReply").parent().attr('id');
		window.document.location="/gonggu/reviews/review/reply/deletepro?reply_num=" + reply_num +"&review_num=" + review_num;
	}	
}

//리뷰 삭제
function deleteReview(review_num){

	if(confirm("삭제하시겠습니까 ?")){
		window.document.location="/gonggu/reviews/review/deletepro?review_num=" + review_num;
	}
}

//모달 닫기
function closeModal(){
	$('#modal').modal("hide");
}

//마이페이지 네비게이션 CSS
function navNarColorChange(){
	
	var navIndex = $('.navIndex').val();
	var li = $('.nav-myPage').children();
	
	li.eq(navIndex).children().css('color', '#5BC0DE');
}