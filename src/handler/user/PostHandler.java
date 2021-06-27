package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.PostService;

@Controller
public class PostHandler {
	
	@Resource
	PostService postService;

	//게시글 콘텐트
	@RequestMapping("/post.do")
	public ModelAndView post(String post_id) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/post/post");
		
		mav.addObject("postContentDto", postService.getPost(Integer.parseInt(post_id)));
			
		return mav;
	}	
}
