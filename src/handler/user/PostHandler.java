package handler.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.inter.PostService;

@Controller
public class PostHandler {
	
	@Resource
	PostService postService;

	//게시글 콘텐트
	@RequestMapping("/post.do")
	public ModelAndView post(int post_id) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/post/post");
		
		Map<String, Object> map = postService.getPost(post_id);
		
		mav.addObject("postContentDto", map.get("postContentDto"));
		mav.addObject("postContentReview", map.get("postContentReview"));
		
		return mav;
	}	
	
	//구매 신청하기
	@RequestMapping("/applyPro.do")
	public ModelAndView applyPro(int post_id, int amount) {
		
		ModelAndView mav = new ModelAndView("user/pro/applyPro");
		mav.addObject("re", postService.addPostApply(Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString()), post_id,amount));
		
		return mav;
	}
}
