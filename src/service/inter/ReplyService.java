package service.inter;

import java.util.Map;

public interface ReplyService {

	public int writeReply(int member_id, int review_num, String content);
	public int deleteReply(int reply_num, int review_num);
	public Map<String, Object> getMyReply(String pageNum, int member_id);
}
