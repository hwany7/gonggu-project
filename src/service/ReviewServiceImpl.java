package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.PaymentDao;
import dao.inter.ReplyDao;
import dao.inter.ReviewDao;
import dto.ReviewDto;
import dto.join.ReviewContentDto;
import service.inter.PageService;
import service.inter.ReviewService;
import util.PageInfo;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Resource
	ReviewDao reviewDao;
	
	@Resource
	ReplyDao replyDao;
	
	@Resource
	PaymentDao paymentDao;
	
	@Resource
	PageService pageService;
	
	@Override
	public Map<String, Object> getReviewList(String pageNum, String search) {

		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = (search == null) ? reviewDao.getReviewCount() : reviewDao.geReviewCountBySearch(search);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setSearch(search);	
			
			List<ReviewContentDto> reviewContentDtos = reviewDao.getReviewtFromReviewList(info);	
								
			map.put("reviewContentDtos", pageService.preprocessingFromReviewList(reviewContentDtos));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	
	//리뷰 가져오기
	@Override
	public Map<String, Object> getReview(int review_num) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("reviewContentDto", reviewDao.getReviewContent(review_num));	
		reviewDao.addCountFromReview(review_num);
		
		map.put("replyContentDtos", replyDao.getReplyContentFromReview(review_num));
	
		return map;
	}
	
	//리뷰 좋아요 누르기
	@Override
	public int likeReview(int member_id, int review_num) {
	
		int result = 0;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("member_id", member_id);
		map.put("review_num", review_num);
		
		if( reviewDao.checkLike(map) == 0 ) {
			
			reviewDao.insertLike(map);
			result = reviewDao.addlike(review_num);
		}
	
		return result;
	}
	
	//리뷰 삭제
	@Override
	public int deleteReview(int review_num) {
		
		ReviewDto reviewDto = reviewDao.getReview(review_num);
		int result = reviewDao.insetReviewToDeletedReview(reviewDto);
		
		if(result == 1) {
			result = reviewDao.deleteReview(review_num);
		}
		
		return result;
	}
	
	//내리뷰 리스트 얻기
	@Override
	public Map<String, Object>  getMyReviewList(String pageNum, int member_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = reviewDao.getMyReviewCount(member_id);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setMember_id(member_id);
			
			List<ReviewContentDto> reviewContentDtos = reviewDao.getMyReviewList(info);	
								
			map.put("reviewContentDtos", pageService.preprocessingFromReviewList(reviewContentDtos));
		}
		
		map.put("info", info);
		
		return map;
	}
	
	
	//리뷰 추가하기
	@Override
	public int addReview(ReviewDto reviewDto) {
		
		int result = reviewDao.insertReview(reviewDto);
			
		if(result == 1) {
			result = paymentDao.updateWritableFromReview(reviewDto.getPayment_id());
		}

		return result;
	}
	
	//리뷰 수정하기
	@Override
	public int modifyReview(ReviewDto reviewDto) {
		
		return reviewDao.updateReview(reviewDto);
	}
	
}
