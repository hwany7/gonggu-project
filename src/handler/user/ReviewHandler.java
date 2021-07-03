package handler.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.inter.ReviewService;

@Controller
public class ReviewHandler {
	
	@Resource
	ReviewService reviewService;
	
	//리뷰 콘텐트 보기
	@RequestMapping("/review.do")
	public ModelAndView review(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/review/review");

		Map<String, Object> map = reviewService.getReview(review_num);

		mav.addObject("reviewContentDto", map.get("reviewContentDto"));
		mav.addObject("replyContentDtos", map.get("replyContentDtos"));
	
		return mav;
	}
	
	//좋아요 누르기
	@RequestMapping("/likeReviewPro.do")
	public ModelAndView likeReviewPro(int review_num) {
			
		ModelAndView mav = new ModelAndView("user/pro/likeReviewPro");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
					
		mav.addObject("result", reviewService.likeReview(member_id, review_num));
		mav.addObject("review_num", review_num);
	
		return mav;
	}	
	
}
