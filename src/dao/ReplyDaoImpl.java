package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ReplyDao;
import dto.ReplyDto;
import dto.join.ReplyContentDto;
import util.PageInfo;

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
	
	//내가쓴 리플 가져오기
	@Override
	public List<ReplyDto> getMyReply(int member_id) {

		return session.selectList("reply.getMyReply", member_id);
	}
	
	//내가 쓴 리플 전체 개수 가져오기
	@Override
	public int getMyReplyCount(int member_id) {

		return session.selectOne("reply.getMyReplyCount", member_id);
	}
	
	@Override
	public List<ReplyDto> getMyReplyList(PageInfo info) {

		return session.selectList("reply.getMyReplyList", info);
	}
}
