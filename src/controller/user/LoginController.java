package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.MemberService;

@Controller
public class LoginController {

	private final MemberService memberService;
	
	@Autowired
	public LoginController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	
	//로그인 폼으로 이동
	@RequestMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/login/login");
		
		return mav;
	}
	
	//로그인 기능
	@RequestMapping("/loginpro")
	public ModelAndView logInPro(String member_email, String password, HttpServletRequest request) {
			
		ModelAndView mav = new ModelAndView("user/pro/loginPro");

		mav.addObject("result", memberService.directLogin(member_email, password, request));
		
		return mav;
	}
	
	//휴면 계정 활성화 폼으로 이동
	@RequestMapping("/login/activatestatus")
	public ModelAndView activateStatus(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		mav.addObject("page", "/WEB-INF/views/user/login/activateStatus");
		
		HttpSession session = request.getSession();

		int member_id = Integer.parseInt(session.getAttribute("member_id").toString());
		session.invalidate();

		mav.addObject("member_id", member_id);
		
		return mav;
	}
	
	//휴면 계정 활성화
	@RequestMapping("/login/activatestatuspro")
	public ModelAndView activateStatusPro(int member_id, String password) {
		
		ModelAndView mav = new ModelAndView("user/pro/activateStatusPro");
		
		mav.addObject("result", memberService.activateUser(member_id, password));
	
		return mav;
	}
	
	//로그 아웃
	@RequestMapping("/logout")
	public String logOutPro(HttpServletRequest request) {
		
		request.getSession().invalidate();
		
		return "redirect:/login";
	}
	
}