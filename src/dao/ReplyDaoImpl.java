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
	private SqlSession session;
	
	//ReviewContent 에서 reply 가져오기
	@Override
	public List<ReplyContentDto> getReplys(int review_num){
		
		return session.selectList("reply.getReplys", review_num);
	}
	
	//내 리플 가져오기
	@Override
	public List<ReplyContentDto> getMyReplysByInfo(PageInfo info) {

		return session.selectList("reply.getMyReplyList", info);
	}
	
	//댓글 등록하기
	@Override
	public int insertReply(ReplyDto replyDto) {
		
		return session.insert("reply.insertReply", replyDto);
	}	
	
	//댓글 삭제하기
	@Override
	public int deleteReply(int reply_num) {
		
		return session.delete("reply.deleteReply", reply_num);
	}
	
	//내가 쓴 리플 전체 개수 가져오기
	@Override
	public int getMyReplyCount(int member_id) {

		return session.selectOne("reply.getMyReplyCount", member_id);
	}
	
	//내가쓴 리플 가져오기 (미사용)
	@Override
	public List<ReplyContentDto> getMyReplys(int member_id) {

		return session.selectList("reply.getMyReplys", member_id);
	}
}
