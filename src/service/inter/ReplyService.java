package service.inter;

public interface ReplyService {

	public int writeReply(int member_id, int review_num, String content);
	public int deleteReply(int reply_num, int review_num);
}
