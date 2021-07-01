package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ReviewDao;
import dto.ReviewDto;
import dto.join.ReviewContentDto;

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
	
}





