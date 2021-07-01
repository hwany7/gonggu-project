package dao.inter;

import java.util.List;

import dto.join.ReplyContentDto;

public interface ReplyDao {	

	public List<ReplyContentDto> getReplyContentFromReview(int review_num);
	
}
