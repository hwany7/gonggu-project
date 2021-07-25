package service.inter;

import java.util.List;

import dto.ReplyDto;

public interface ReplyService {

	public int writeReply(int member_id, int review_num, String content);
	public int deleteReply(int reply_num, int review_num);
	public List<ReplyDto> getMyReply(int member_id);
}
