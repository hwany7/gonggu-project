package handler.user;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import dto.ReviewDto;
import service.inter.ReviewService;

@Controller
public class ReviewHandler {
	
	@Resource
	ReviewService reviewService;
	
	//리뷰 리스트보기
	@RequestMapping("/reviews")
	public ModelAndView reviews(String pageNum, String search) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		mav.addObject("page", "/WEB-INF/views/user/review/reviews");
		
		Map<String, Object> map = reviewService.getReviewList(pageNum, search);

		mav.addObject("reviewContentDtos", map.get("reviewContentDtos"));
		mav.addObject("info", map.get("info"));
	
		
		return mav;
	}
	
	//리뷰 콘텐트 보기
	@RequestMapping("/review")
	public ModelAndView review(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/review/review");

		Map<String, Object> map = reviewService.getReview(review_num);

		mav.addObject("reviewContentDto", map.get("reviewContentDto"));
		mav.addObject("replyContentDtos", map.get("replyContentDtos"));
	
		return mav;
	}
	
	//좋아요 누르기
	@RequestMapping("/likeReviewPro")
	public ModelAndView likeReviewPro(int review_num) {
			
		ModelAndView mav = new ModelAndView("user/pro/likeReviewPro");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
					
		mav.addObject("result", reviewService.likeReview(member_id, review_num));
		mav.addObject("review_num", review_num);
	
		return mav;
	}	
	
	//리뷰 삭제하기
	@RequestMapping("/deleteReviewPro")
	public ModelAndView deleteReviewPro(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/pro/deleteReviewPro");
		
		mav.addObject("result", reviewService.deleteReview(review_num));
		mav.addObject("review_num",review_num);
		
		return mav;
	}
	
	//리뷰 작성 폼 가기
	@RequestMapping("/review/write")
	public ModelAndView writeReview(int payment_id) {
		
		ModelAndView mav = new ModelAndView("user/review/writeReview");
		
		mav.addObject("payment_id", payment_id);

		return mav;
	}	
	
	//리뷰 작성하기
	@RequestMapping("/review/write/pro")
	public ModelAndView writeReviewPro(ReviewDto reviewDto) {
		
		ModelAndView mav = new ModelAndView("user/pro/writeReviewPro");
			
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		reviewDto.setMember_id(member_id);
			
		mav.addObject("result", reviewService.addReview(reviewDto));

		return mav;
	}
	
	@RequestMapping("/review/modify")
	public ModelAndView modifyReview(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/review/modifyReview");

		mav.addObject("reviewDto", reviewService.getReview(review_num).put("reviewContentDto", mav));

		return mav;
	}
	
	//리뷰 작성하기
	@RequestMapping("/review/modify/pro")
	public ModelAndView modifyReviewPro(ReviewDto reviewDto) {
		
		ModelAndView mav = new ModelAndView("user/pro/modifyReviewPro");
	
		mav.addObject("result", reviewService.modifyReview(reviewDto));
		mav.addObject("review_num", reviewDto.getReview_num());

		return mav;
	}
			
}
