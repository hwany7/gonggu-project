package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.SignupService;

@Controller
public class SignUpHandler {
	
	@Resource(name="signupServiceImpl")
	SignupService signupService;
	
	//회원가입 폼으로 이동
	@RequestMapping("/signUpForm.do")
	public String signUp() {
		
		return "user/signup/signUpForm";
	}
	
	//이메일 중복 검사
	@RequestMapping("/checkEmail.do")
	public ModelAndView checkEmail(String member_email) {

		ModelAndView mav = new ModelAndView("user/common/ajaxResult");
		
		mav.addObject("result", signupService.CheckDuplicateForEmail(member_email));
	
		return mav;
	}
	
	//닉네임 중복 체크
	@RequestMapping("/checkNickname.do")
	public ModelAndView checkNickname(String nickname) {
		
		ModelAndView mav = new ModelAndView("user/common/ajaxResult");
			
	    mav.addObject("result", signupService.CheckDuplicateForNickname(nickname));

	    return mav;
	}
	
	//이메일 인증
	@RequestMapping("/mailConfirmForm.do")
	public ModelAndView mailConfirmForm(String member_email) {
		
		ModelAndView mav = new ModelAndView("user/signup/mailConfirmForm");
		
		mav.addObject("codeMsg", signupService.SendMailGetCode(member_email));
		
		return mav;
	}
	
}
