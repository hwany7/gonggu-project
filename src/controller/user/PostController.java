package controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.inter.PostService;

@Controller
public class PostController {
	
	private final PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		
		this.postService = postService;
	}
	
	@RequestMapping("/posts")
	public ModelAndView posts(String pageNum, String search, int category_id) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		mav.addObject("page", "/WEB-INF/views/user/post/posts");
		
		Map<String, Object> map = postService.getPostList(pageNum, search, category_id);
		mav.addObject("posts", map.get("posts"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}

	//게시글 콘텐트
	@RequestMapping("/posts/post")
	public ModelAndView post(int post_id) {
	
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/post/post");
		
		Map<String, Object> map = postService.getPost(post_id);
		mav.addObject("post", map.get("post"));
		mav.addObject("reviews", map.get("reviews"));
		
		return mav;
	}	
	
	//구매 신청하기
	@RequestMapping("/posts/post/applypro")
	public ModelAndView applyPro(int post_id, int amount, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("user/pro/applyPro");
		
		int member_id = Integer.parseInt(request.getSession().getAttribute("member_id").toString());
		
		mav.addObject("result", postService.addPostApply(member_id, post_id, amount));
		
		return mav;
	}
		
}
