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
public class MyPageHandler {
	
	@Resource
	PostService postService;
	
	@RequestMapping("/myPage")
	public ModelAndView myPage(String pageNum) {
		
		ModelAndView mav = new ModelAndView("/user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/mypage/myPosts");
	
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		Map<String, Object> map = postService.myPostListByStatus(pageNum, member_id, "P");
		
		mav.addObject("postListDto", map.get("postListDto"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}
}
