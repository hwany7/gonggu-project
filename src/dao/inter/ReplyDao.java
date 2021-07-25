package dao.inter;

import java.util.List;

import dto.ReplyDto;
import dto.join.ReplyContentDto;

public interface ReplyDao {	

	//리뷰 페이지
	public List<ReplyContentDto> getReplyContentFromReview(int review_num);
	public int uploadReplyFromReview(ReplyDto replyDto);
	public int deleteReplyFromReview(int reply_num);
	
	//마이페이지
	public List<ReplyDto> getMyReply(int member_id);

}
