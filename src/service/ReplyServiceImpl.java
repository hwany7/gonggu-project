package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.ReplyDao;
import dao.inter.ReviewDao;
import dto.ReplyDto;
import service.inter.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Resource
	ReplyDao replyDao;
	
	@Resource
	ReviewDao reviewDao; 
	
	@Override
	public int writeReply(int member_id, int review_num, String content) {
		
		ReplyDto replyDto = new ReplyDto(member_id, review_num, content);
		
		int result = replyDao.uploadReplyFromReview(replyDto);
		
		if(result == 1) {
			reviewDao.updateReplycountFromReview(review_num);
		}
		
		return result;
	}
	
	@Override
	public int deleteReply(int reply_num, int review_num) {
		
		int result = replyDao.deleteReplyFromReview(reply_num);;

		if(result == 1) {
			reviewDao.deleteupdateReplycountFromReview(review_num);
			
		}

		return result;
	}
	
	@Override
	public List<ReplyDto> getMyReply(int member_id) {

		return replyDao.getMyReply(member_id);
	}
}
