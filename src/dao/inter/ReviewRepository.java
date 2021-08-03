package dao.inter;

import java.util.List;
import java.util.Map;

import dto.ReviewDto;
import dto.join.ReviewContentDto;
import util.PageInfo;

public interface ReviewRepository {	
	
	public List<ReviewContentDto> getReviewsTopThree(int product_id);
	public List<ReviewContentDto> getReviewsByInfo(PageInfo info);
	public List<ReviewContentDto> getMyReviewsByInfo(PageInfo info);
	
	public ReviewDto getReviewDto(int review_num);
	public ReviewContentDto getReview(int review_num);
	
	public int getReviewCount();
	public int getReviewCountBySearch(String search);
	public int getMyReviewCount(int member_id);
	
	public int getCheckLike(Map<String, Integer> map);
	
	public int addReadCount(int review_num);
	public int addLikeCount(int review_num);	
	public int addReplyCount(int review_num);	
	public int subtractReplyCount(int review_num);
	
	public int updateReview(ReviewDto reviewDto);
	
	public int insertReview(ReviewDto reviewDto);
	public int insertLike(Map<String, Integer> map);
	public int insertReviewToDeletedReview(ReviewDto reviewDto);
	
	public int deleteReview(int review_num);
	
}
