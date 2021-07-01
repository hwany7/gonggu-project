package dao.inter;

import java.util.List;

import dto.ReviewDto;
import dto.join.ReviewContentDto;

public interface ReviewDao {	
	
	//포스트 페이지
	public List<ReviewDto> getReviewFromContent(int product_id);
	
	//리뷰 페이지
	public ReviewContentDto getReviewContent(int review_num);
	public int addCountFromReview(int review_num);
	
}
