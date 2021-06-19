package handler.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageHandler {
	
	@RequestMapping("/mainPage.do")
	public ModelAndView mainPage(HttpServletRequest request, HttpServletResponse respons) {
			
		//메인페이지로 가기(임시 페이지)
		return new ModelAndView("user/main/mainPage");
	}

}
