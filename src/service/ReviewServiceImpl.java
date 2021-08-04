package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.PaymentRepository;
import dao.inter.ReplyRepository;
import dao.inter.ReviewRepository;
import dto.ReviewDto;
import dto.join.ReplyContentDto;
import dto.join.ReviewContentDto;
import service.inter.PageService;
import service.inter.ReviewService;
import util.PageInfo;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;
	private final ReplyRepository replyRepository;
	private final PaymentRepository paymentRepository;
	private final PageService pageService;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository, ReplyRepository replyRepository, PaymentRepository paymentRepository, PageService pageService) {
		
		this.reviewRepository = reviewRepository;
		this.replyRepository = replyRepository;
		this.paymentRepository = paymentRepository;
		this.pageService = pageService;
	}
	
	@Override
	public Map<String, Object> getReviewList(String pageNum, String search) {

		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = (search == null) ? reviewRepository.getReviewCount() : reviewRepository.getReviewCountBySearch(search);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setSearch(search);	
			
			List<ReviewContentDto> reviews = reviewRepository.getReviewsByInfo(info);	
								
			map.put("reviews", pageService.preprocessingFromReviewList(reviews));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//리뷰랑 댓글리스트 가져오기
	@Override
	public Map<String, Object> getReviewAndReplys(int review_num) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		ReviewContentDto review = reviewRepository.getReview(review_num);
		map.put("review", review);	
		
		reviewRepository.addReadCount(review_num);
		
		List<ReplyContentDto> replys = replyRepository.getReplys(review_num);
		map.put("replys", replys);
	
		return map;
	}
	
	//리뷰 가져오기
	@Override
	public ReviewContentDto getReview(int review_num) {
		
		ReviewContentDto review = reviewRepository.getReview(review_num);
		
		return review;
	}
	
	//리뷰 좋아요 누르기
	@Transactional
	@Override
	public int likeReview(int member_id, int review_num) {
	
		int result = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("member_id", member_id);
		map.put("review_num", review_num);
		
		if( reviewRepository.getCheckLike(map) == 0 ) {
			
			reviewRepository.insertLike(map);
			result = reviewRepository.addLikeCount(review_num);
		}
	
		return result;
	}
	
	//리뷰 삭제
	@Transactional
	@Override
	public int deleteReview(int review_num) {
		
		ReviewDto reviewDto = reviewRepository.getReviewDto(review_num);
		int result = reviewRepository.insertReviewToDeletedReview(reviewDto);
		
		if(result == 1) {
			result = reviewRepository.deleteReview(review_num);
		}
		
		return result;
	}
	
	//내리뷰 리스트 얻기
	@Override
	public Map<String, Object> getMyReviewList(String pageNum, int member_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = reviewRepository.getMyReviewCount(member_id);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setMember_id(member_id);
			
			List<ReviewContentDto> reviews = reviewRepository.getMyReviewsByInfo(info);	
								
			map.put("reviews", pageService.preprocessingFromReviewList(reviews));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//리뷰 추가하기
	@Transactional
	@Override
	public int addReview(ReviewDto reviewDto) {
		
		int result = reviewRepository.insertReview(reviewDto);
			
		if(result == 1) {
			result = paymentRepository.updateWritable(reviewDto.getPayment_id());
		}

		return result;
	}
	
	//리뷰 수정하기
	@Override
	public int modifyReview(ReviewDto reviewDto) {
		
		return reviewRepository.updateReview(reviewDto);
	}
	
}
