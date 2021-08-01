package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.PaymentDao;
import dao.inter.ReplyDao;
import dao.inter.ReviewDao;
import dto.ReviewDto;
import dto.join.ReplyContentDto;
import dto.join.ReviewContentDto;
import service.inter.PageService;
import service.inter.ReviewService;
import util.PageInfo;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Resource
	private ReviewDao reviewDao;
	
	@Resource
	private ReplyDao replyDao;
	
	@Resource
	private PaymentDao paymentDao;
	
	@Resource
	private PageService pageService;
	
	@Override
	public Map<String, Object> getReviewList(String pageNum, String search) {

		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = (search == null) ? reviewDao.getReviewCount() : reviewDao.getReviewCountBySearch(search);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setSearch(search);	
			
			List<ReviewContentDto> reviews = reviewDao.getReviewsByInfo(info);	
								
			map.put("reviews", pageService.preprocessingFromReviewList(reviews));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//리뷰랑 댓글리스트 가져오기
	@Override
	public Map<String, Object> getReviewAndReplys(int review_num) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		ReviewContentDto review = reviewDao.getReview(review_num);
		map.put("review", review);	
		
		reviewDao.addReadCount(review_num);
		
		List<ReplyContentDto> replys = replyDao.getReplys(review_num);
		map.put("replyContentDtos", replys);
	
		return map;
	}
	
	//리뷰 가져오기
	@Override
	public ReviewContentDto getReview(int review_num) {
		
		ReviewContentDto review = reviewDao.getReview(review_num);
		
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
		
		if( reviewDao.getCheckLike(map) == 0 ) {
			
			reviewDao.insertLike(map);
			result = reviewDao.addLikeCount(review_num);
		}
	
		return result;
	}
	
	//리뷰 삭제
	@Transactional
	@Override
	public int deleteReview(int review_num) {
		
		ReviewDto reviewDto = reviewDao.getReviewDto(review_num);
		int result = reviewDao.insertReviewToDeletedReview(reviewDto);
		
		if(result == 1) {
			result = reviewDao.deleteReview(review_num);
		}
		
		return result;
	}
	
	//내리뷰 리스트 얻기
	@Override
	public Map<String, Object> getMyReviewList(String pageNum, int member_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = reviewDao.getMyReviewCount(member_id);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setMember_id(member_id);
			
			List<ReviewContentDto> reviews = reviewDao.getMyReviewsByInfo(info);	
								
			map.put("reviews", pageService.preprocessingFromReviewList(reviews));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	//리뷰 추가하기
	@Transactional
	@Override
	public int addReview(ReviewDto reviewDto) {
		
		int result = reviewDao.insertReview(reviewDto);
			
		if(result == 1) {
			result = paymentDao.updateWritable(reviewDto.getPayment_id());
		}

		return result;
	}
	
	//리뷰 수정하기
	@Override
	public int modifyReview(ReviewDto reviewDto) {
		
		return reviewDao.updateReview(reviewDto);
	}
	
}
