package service.inter;

import java.util.Map;

public interface ReviewService {

	Map<String, Object> getReviewList(String pageNum, String search);
	public Map<String, Object> getReview(int review_num);
	public int likeReview(int member_id, int review_num);
	public int deleteReview(int review_num);
	
}
