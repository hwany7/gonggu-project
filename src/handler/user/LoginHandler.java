package handler.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginHandler {

	//로그인 폼
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse respons) {
		
		//로그인 폼으로 이동
		return new ModelAndView("user/loginForm");
	}
}
