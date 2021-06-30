package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ReviewDao;
import dto.ReviewDto;

@Repository
public class ReviewDaoImpl implements ReviewDao{
	
	@Resource
	SqlSession session;
	
	//post Content 에 들어갈 탑리뷰 3개
	@Override
	public List<ReviewDto> getReviewFromContent(int product_id) {
		
		return session.selectList("review.getReviewFromContent", product_id);
	}
}





