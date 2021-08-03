package dao.inter;

import java.util.List;

import dto.ReplyDto;
import dto.join.ReplyContentDto;
import util.PageInfo;

public interface ReplyRepository {	

	public List<ReplyContentDto> getReplys(int review_num);
	public List<ReplyContentDto> getMyReplysByInfo(PageInfo info);
	
	public int insertReply(ReplyDto replyDto);
	public int deleteReply(int reply_num);
	
	public int getMyReplyCount(int member_id);
	
	public List<ReplyContentDto> getMyReplys(int member_id);//미사용(리팩토링 후)
		
}
