package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.PostService;

@Controller
public class MainPageController {
	
	private final PostService postService;
	
	@Autowired
	public MainPageController(PostService postService) {
		
		this.postService = postService;
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page","/WEB-INF/views/user/main/main");
		
		mav.addObject("posts", postService.getMainPost());
			
		return mav;
	}

}
