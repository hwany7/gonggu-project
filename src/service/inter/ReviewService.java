package service.inter;

import java.util.Map;

public interface ReviewService {

	public Map<String, Object> getReview(int review_num);
	public int likeReview(int member_id, int review_num);
	
}
