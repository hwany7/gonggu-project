package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDto;
import service.inter.SignupService;

@Controller
public class SignUpHandler {
	
	@Resource(name="signupServiceImpl")
	SignupService signupService;
	
	//회원가입 폼으로 이동
	@RequestMapping("/signUpForm.do")
	public ModelAndView signUp() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/signup/signUpForm");
		
		return mav;
	}
	
	//이메일 중복 검사
	@ResponseBody
	@RequestMapping("/checkEmail.do")
	public String checkEmail(String member_email) {

		return Integer.toString(signupService.CheckDuplicateForEmail(member_email));
	}
	
	//닉네임 중복 체크
	@ResponseBody
	@RequestMapping("/checkNickname.do")
	public String checkNickname(String nickname) {
		
	    return Integer.toString(signupService.CheckDuplicateForNickname(nickname));
	}
	
	//이메일 인증
	@RequestMapping("/mailConfirmForm.do")
	public ModelAndView mailConfirmForm(String member_email) {
		
		ModelAndView mav = new ModelAndView("user/signup/mailConfirmForm");
		
		mav.addObject("codeMsg", signupService.SendMailGetCode(member_email));
		
		return mav;
	}
	
	//회원 가입
	@RequestMapping("/signUpPro.do")
	public ModelAndView signUpPro(MemberDto member) {
		
		ModelAndView mav = new ModelAndView("user/signup/signUpPro");

		mav.addObject("result", signupService.RegisteMember(member));
		
		return mav;
	}	
	
}
