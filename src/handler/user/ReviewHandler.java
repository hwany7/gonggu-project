package handler.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
