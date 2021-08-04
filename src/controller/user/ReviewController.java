package controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import dto.ReviewDto;
import dto.join.ReviewContentDto;
import service.inter.ReviewService;

@Controller
public class ReviewController {
	
	private final ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		
		this.reviewService = reviewService;
	}
	
	//리뷰 리스트보기
	@RequestMapping("/reviews")
	public ModelAndView reviews(String pageNum, String search) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		mav.addObject("page", "/WEB-INF/views/user/review/reviews");
		
		Map<String, Object> map = reviewService.getReviewList(pageNum, search);
		mav.addObject("reviews", map.get("reviews"));
		mav.addObject("info", map.get("info"));
	
		
		return mav;
	}
	
	//리뷰 콘텐트 보기
	@RequestMapping("/reviews/review")
	public ModelAndView review(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/review/review");

		Map<String, Object> map = reviewService.getReviewAndReplys(review_num);

		mav.addObject("review", map.get("review"));
		mav.addObject("replys", map.get("replys"));
	
		return mav;
	}
	
	//좋아요 누르기
	@RequestMapping("/reviews/review/likepro")
	public ModelAndView likeReviewPro(int review_num) {
			
		ModelAndView mav = new ModelAndView("user/pro/likeReviewPro");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
					
		mav.addObject("result", reviewService.likeReview(member_id, review_num));
		mav.addObject("review_num", review_num);
	
		return mav;
	}
	
	//리뷰 수정 폼으로 가기
	@RequestMapping("/reviews/review/modify")
	public ModelAndView modifyReview(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/template/mainTemplate");
		
		mav.addObject("page", "/WEB-INF/views/user/review/modifyReview");

		ReviewContentDto review = reviewService.getReview(review_num);
		mav.addObject("review", review);

		return mav;
	}
	
	//리뷰 수정하기
	@RequestMapping("/reviews/review/modifypro")
	public ModelAndView modifyReviewPro(ReviewDto reviewDto) {
		
		ModelAndView mav = new ModelAndView("user/pro/modifyReviewPro");
	
		mav.addObject("result", reviewService.modifyReview(reviewDto));
		mav.addObject("review_num", reviewDto.getReview_num());

		return mav;
	}
	
	//리뷰 삭제하기
	@RequestMapping("/reviews/review/deletepro")
	public ModelAndView deleteReviewPro(int review_num) {
		
		ModelAndView mav = new ModelAndView("user/pro/deleteReviewPro");
		
		mav.addObject("result", reviewService.deleteReview(review_num));
		mav.addObject("review_num",review_num);
		
		return mav;
	}
	
	//리뷰 작성 폼 가기
	@RequestMapping("/reviews/review/write")
	public ModelAndView writeReview(int payment_id) {
		
		ModelAndView mav = new ModelAndView("user/template/mypageTemplate");
		mav.addObject("page","/WEB-INF/views/user/review/writeReview");
		
		mav.addObject("payment_id", payment_id);

		return mav;
	}	
	
	//리뷰 작성하기
	@RequestMapping("/reviews/review/writePro")
	public ModelAndView writeReviewPro(ReviewDto reviewDto) {
		
		ModelAndView mav = new ModelAndView("user/pro/writeReviewPro");
			
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		reviewDto.setMember_id(member_id);
			
		mav.addObject("result", reviewService.addReview(reviewDto));

		return mav;
	}
	
}
