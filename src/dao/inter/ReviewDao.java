package dao.inter;

import java.util.List;
import java.util.Map;

import dto.ReviewDto;
import dto.join.ReviewContentDto;
import util.PageInfo;

public interface ReviewDao {	
	
	//포스트 페이지
	public List<ReviewDto> getReviewFromContent(int product_id);
	
	//리뷰 페이지
	public ReviewContentDto getReviewContent(int review_num);
	public int addCountFromReview(int review_num);
	public int checkLike(Map<String, Integer> map);
	public int insertLike(Map<String, Integer> map);
	public int addlike(int review_num);
	public int updateReplycountFromReview(int review_num);	
	public int deleteupdateReplycountFromReview(int review_num);
	public ReviewDto getReview(int review_num);
	public int insetReviewToDeletedReview(ReviewDto reviewDto);
	public int deleteReview(int review_num);
	public int updateReview(ReviewDto reviewDto);
	
	//리뷰 리스트
	public int getReviewCount();
	public int geReviewCountBySearch(String search);
	public List<ReviewContentDto> getReviewtFromReviewList(PageInfo info);
	
	//마이 페이지
	public List<ReviewContentDto> getMyReviewList(PageInfo info);
	public int getMyReviewCount(int member_id);
	public int insertReview(ReviewDto reviewDto);

}
