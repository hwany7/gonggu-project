package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.ReplyDao;
import dao.inter.ReviewDao;
import dto.ReplyDto;
import dto.join.ReviewContentDto;
import service.inter.PageService;
import service.inter.ReplyService;
import util.PageInfo;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Resource
	ReplyDao replyDao;
	
	@Resource
	ReviewDao reviewDao; 
	
	@Resource
	PageService pageService;
	
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
	
	@Override
	public Map<String, Object> getMyReply(String pageNum, int member_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = replyDao.getMyReplyCount(member_id);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setMember_id(member_id);
			
			List<ReplyDto> replys = replyDao.getMyReplyList(info);	
					
			map.put("replyDto", replys);
		}
		
		map.put("info", info);
		
		return map;
	}
}
