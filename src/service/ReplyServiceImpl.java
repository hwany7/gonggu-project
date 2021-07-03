package service;

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
		
		//댓글 등록
		int result = replyDao.uploadReplyFromReview(replyDto);
		
		//등록 성공시
		if(result == 1) {
			reviewDao.updateReplycountFromReview(review_num);
		}
		
		return result;
	}
}
