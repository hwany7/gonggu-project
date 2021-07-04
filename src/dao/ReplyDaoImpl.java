package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ReplyDao;
import dto.ReplyDto;
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
	
	//댓글 등록하기
	@Override
	public int uploadReplyFromReview(ReplyDto replyDto) {
		
		return session.insert("reply.uploadReplyFromReview", replyDto);
	}	
	
	//댓글 삭제하기
	@Override
	public int deleteReplyFromReview(int reply_num) {
		
		return session.delete("reply.deleteReplyFromReview", reply_num);
	}
}
