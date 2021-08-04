package dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.ReviewRepository;
import dto.ReviewDto;
import dto.join.ReviewContentDto;
import util.PageInfo;

@Repository
public class MyBatisReviewRepository implements ReviewRepository{
	
	private final SqlSession session;
	
	@Autowired
	public MyBatisReviewRepository(SqlSession session) {
		
		this.session = session;
	}
	
	
	//post Content 에 들어갈 탑리뷰 3개
	@Override
	public List<ReviewContentDto> getReviewsTopThree(int product_id) {
		
		return session.selectList("review.getReviewsTopThree", product_id);
	}
	
	//리뷰 리스트 가져오기
	@Override
	public List<ReviewContentDto> getReviewsByInfo(PageInfo info) {
		
		return session.selectList("review.getReviewsByInfo", info);
	}
	
	//내 리뷰 리스트 가져오기
	@Override
	public List<ReviewContentDto> getMyReviewsByInfo(PageInfo info) {
		
		return session.selectList("review.getMyReviewsByInfo", info);
	}
	
	//리뷰 가져오기_테이블 그대로
	@Override
	public ReviewDto getReviewDto(int review_num) {
		
		return session.selectOne("review.getReviewDto", review_num);
	}
	
	//리뷰 컨텐트
	@Override
	public ReviewContentDto getReview(int review_num) {
		
		return session.selectOne("review.getReview", review_num);
	}	
	
	//리뷰 전체 개수
	@Override
	public int getReviewCount() {
		
		return session.selectOne("review.getReviewCount");
	}
	
	//검색된 전체 리뷰 개수
	@Override
	public int getReviewCountBySearch(String search) {
		
		return session.selectOne("review.geReviewCountBySearch", search);
	}
	
	//내리뷰 전체 개수 가져오기
	@Override
	public int getMyReviewCount(int member_id) {

		return session.selectOne("review.getMyReviewCount", member_id);
	}	
	
	//like 중복체크
	@Override
	public int getCheckLike(Map<String, Integer> map) {

		return session.selectOne("review.getCheckLike", map);
	}	
	
	//조회수 올리기
	@Override
	public int addReadCount(int review_num) {
		
		return session.update("review.addReadCount", review_num);
	}	
	
	//좋아요 올리기
	@Override
	public int addLikeCount(int review_num) {
		
		return session.update("review.addLikeCount",review_num);
	}
	
	//댓글 작성 시 replycount update +1
	@Override
	public int addReplyCount(int review_num) {
		
		return session.update("review.addReplyCount", review_num);
	}	
	
	//리뷰 수정하기
	@Override
	public int updateReview(ReviewDto reviewDto) {
		
		return session.update("review.updateReview", reviewDto);
	}
	
	// 댓글 삭제 시 replycount update -1
	@Override
	public int subtractReplyCount(int review_num) {
		
		return session.update("review.subtractReplyCount", review_num);
	}

	//리뷰 등록하기
	@Override
	public int insertReview(ReviewDto reviewDto) {

		return session.insert("review.insertReview", reviewDto);
	}	
	
	//like 추가하기
	@Override
	public int insertLike(Map<String, Integer> map) {
		
		return session.insert("review.insertLike", map);
	}
	
	//리뷰 삽입
	@Override
	public int insertReviewToDeletedReview(ReviewDto reviewDto) {
		
		return session.insert("review.insertReviewToDeletedReview", reviewDto);
	}

	//리뷰 삭제하기
	@Override
	public int deleteReview(int review_num) {

		return session.delete("review.deleteReview", review_num);
	}
	
}
