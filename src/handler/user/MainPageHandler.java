package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.PostService;

@Controller
public class MainPageHandler {
	
	@Resource
	private PostService postService;
	
	@RequestMapping("/main.do")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page","/WEB-INF/views/user/main/main");
		
		mav.addObject("hitPostDto", postService.getMainPost());
			
		return mav;
	}

}
