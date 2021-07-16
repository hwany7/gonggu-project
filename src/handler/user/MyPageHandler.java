package handler.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.inter.PaymentService;
import service.inter.PostService;


@Controller
public class MyPageHandler {
	
	@Resource
	PostService postService;
	
	@Resource
	PaymentService paymentService;

	
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
	
	@RequestMapping("/myPosts")
	public ModelAndView myPosts(String pageNum, String post_status) {
		
		ModelAndView mav = new ModelAndView("/user/mypage/myPostsAjax");
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		Map<String, Object> map = postService.myPostListByStatus(pageNum, member_id, post_status);
		
		mav.addObject("postListDto", map.get("postListDto"));
		mav.addObject("info", map.get("info"));
		
		return mav;
	}
	
	@RequestMapping("/payPost")
	public ModelAndView payPost(int total_price, int application_id) {
		
		ModelAndView mav = new ModelAndView("/user/mypage/payPost");
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());

		mav.addObject("total_price", total_price);
		mav.addObject("application_id", application_id);
		mav.addObject("memberDto", paymentService.getUserInfo(member_id));
		
		return mav;
	}
}
