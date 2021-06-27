package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.inter.LoginService;

@Controller
public class LoginHandler {
	
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
	//로그인 폼으로 이동
	@RequestMapping("/login.do")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/login/login");
		
		return mav;
	}
	
	//로그인 기능
	@RequestMapping("/loginPro.do")
	public ModelAndView logInPro(String member_email, String password) {
		
		ModelAndView mav = new ModelAndView("user/login/loginPro");

		mav.addObject("memSession", loginService.directLogin(member_email, password));
		
		return mav;
	}
	
	//휴면 계정 활성화 폼으로 이동
	@RequestMapping("/activateStatus.do")
	public ModelAndView activateStatus() {
		
		ModelAndView mav = new ModelAndView("user/template/beginTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/login/activateStatus");
		
		return mav;
	}
	
	//휴면 계정 활성화
	@RequestMapping("/activateStatusPro.do")
	public ModelAndView activateStatusPro(String password) {
		
		ModelAndView mav = new ModelAndView("user/login/activateStatusPro");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		mav.addObject("result", loginService.activateUser(member_id, password));
	
		return mav;
	}
	
	//로그 아웃
	@RequestMapping("/logout.do")
	public String logOutPro() {
		
		((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().invalidate();
	
		return "redirect:/login.do";
	}
	
}