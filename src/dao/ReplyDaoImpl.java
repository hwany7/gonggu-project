package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ReplyDao;
import dto.join.ReplyContentDto;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Resource
	SqlSession session;
	
	//ReviewContent 에서 reply 가져오기
	@Override
	public List<ReplyContentDto> getReplyContentFromReview(int review_num){
		
		return session.selectList("reply.getReplyContentFromReview", review_num);
	}
}
