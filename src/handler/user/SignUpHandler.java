package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.MemberDto;
import service.inter.MemberService;

@Controller
public class SignUpHandler {
	
	@Resource
	private MemberService memberService;
	
	//회원가입 폼으로 이동
	@RequestMapping("/signup")
	public ModelAndView signup() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/signup/signup");
		
		return mav;
	}
	
	//회원 가입
	@RequestMapping("/signuppro")
	public ModelAndView signUpPro(MemberDto member) {
		
		ModelAndView mav = new ModelAndView("user/pro/signUpPro");

		mav.addObject("result", memberService.registeMember(member));
		
		return mav;
	}	
	
	//이메일 중복 검사
	@ResponseBody
	@RequestMapping("/signup/emailcheck")
	public String checkEmail(String member_email) {

		return Integer.toString(memberService.checkDuplicateForEmail(member_email));
	}
	
	//닉네임 중복 체크
	@ResponseBody
	@RequestMapping("/signup/nicknamecheck")
	public String checkNickname(String nickname) {
		
	    return Integer.toString(memberService.checkDuplicateForNickname(nickname));
	}
	
	//이메일 인증
	@RequestMapping("/signup/mailconfirm")
	public ModelAndView mailConfirmForm(String member_email) {
		
		ModelAndView mav = new ModelAndView("user/signup/mailConfirmForm");
		
		String codeMsg = memberService.sendMailGetCode(member_email);
		mav.addObject("codeMsg", codeMsg);
		
		return mav;
	}
	
}
