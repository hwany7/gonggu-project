package dao.inter;

import java.util.List;

import dto.ReviewDto;

public interface ReviewDao {	
	
	//포스트 페이지
	public List<ReviewDto> getReviewFromContent(int product_id);
	
}
