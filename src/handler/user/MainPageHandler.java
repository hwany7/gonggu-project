package handler.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageHandler {
	
	@RequestMapping("/main.do")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page","/WEB-INF/views/user/main/main");
			
		return mav;
	}

}
