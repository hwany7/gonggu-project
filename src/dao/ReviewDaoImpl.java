package dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ReviewDao;
import dto.ReviewDto;
import dto.join.ReviewContentDto;
import util.PageInfo;

@Repository
public class ReviewDaoImpl implements ReviewDao{
	
	@Resource
	SqlSession session;
	
	//post Content 에 들어갈 탑리뷰 3개
	@Override
	public List<ReviewDto> getReviewFromContent(int product_id) {
		
		return session.selectList("review.getReviewFromContent", product_id);
	}
	
	//리뷰 컨텐트
	@Override
	public ReviewContentDto getReviewContent(int review_num) {
		
		return session.selectOne("review.getReviewContent", review_num);
	}	
	
	//조회수 올리기
	@Override
	public int addCountFromReview(int review_num) {
		
		return session.update("review.addCountFromReview", review_num);
	}
	
	//like 중복체크
	@Override
	public int checkLike(Map<String, Integer> map) {

		return session.selectOne("review.checkLike", map);
	}
	
	//like 추가하기
	@Override
	public int insertLike(Map<String, Integer> map) {
		
		return session.insert("review.insertLike", map);
	}
	
	//클릭시 like + 1
	@Override
	public int addlike(int review_num) {
		
		return session.update("review.addlike",review_num);
	}
	
	//댓글 작성 시 replycount update +1
	@Override
	public int updateReplycountFromReview(int review_num) {
		
		return session.update("review.updateReplycountFromReview", review_num);
	}	
	
	
	// 댓글 삭제 시 replycount update -1
	@Override
	public int deleteupdateReplycountFromReview(int review_num) {
		
		return session.update("review.deleteupdateReplycountFromReview", review_num);
	}
	
	//리뷰 전체 개수
	@Override
	public int getReviewCount() {
		return session.selectOne("review.getReviewCount");
	}
	
	//검색된 전체 리뷰 개수
	@Override
	public int geReviewCountBySearch(String search) {
		
		return session.selectOne("review.geReviewCountBySearch", search);
	}
	
	//리뷰 리스트 가져오기
	@Override
	public List<ReviewContentDto> getReviewtFromReviewList(PageInfo info) {
		
		return session.selectList("review.getReviewtFromReviewList", info);
	}
	
	//리뷰 가져오기_테이블 그대로
	@Override
	public ReviewDto getReview(int review_num) {
		
		return session.selectOne("review.getReview", review_num);
	}
	
	//리뷰 삽입
	@Override
	public int insetReviewToDeletedReview(ReviewDto reviewDto) {
		
		return session.insert("review.insetReviewToDeletedReview", reviewDto);
	}
	
	//리뷰 삭제하기
	@Override
	public int deleteReview(int review_num) {

		return session.delete("review.deleteReview", review_num);
	}
	
	//내 리뷰 리스트 가져오기
	@Override
	public List<ReviewContentDto> getMyReviewList(PageInfo info) {
		
		return session.selectList("review.getMyReviewList", info);
	}
	
	//내리뷰 전체 개수 가져오기
	@Override
	public int getMyReviewCount(int member_id) {

		return session.selectOne("review.getMyReviewCount", member_id);
	}
	
	//리뷰 등록하기
	@Override
	public int insertReview(ReviewDto reviewDto) {

		return session.insert("review.insertReview", reviewDto);
	}
	
	@Override
	public int updateReview(ReviewDto reviewDto) {
		
		return session.update("review.updateReview", reviewDto);
	}
	
}





