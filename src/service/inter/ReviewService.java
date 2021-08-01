package service.inter;

import java.util.Map;

import dto.ReviewDto;
import dto.join.ReviewContentDto;

public interface ReviewService {

	public Map<String, Object> getReviewList(String pageNum, String search);
	public Map<String, Object> getReviewAndReplys(int review_num);
	public ReviewContentDto getReview(int review_num);
	public int likeReview(int member_id, int review_num);
	public int deleteReview(int review_num);
	public Map<String, Object> getMyReviewList(String pageNum, int member_id);
	public int addReview(ReviewDto reviewDto);
	public int modifyReview(ReviewDto reviewDto);
	
	
}
