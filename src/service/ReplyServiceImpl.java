package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.ReplyDao;
import dao.inter.ReviewDao;
import dto.ReplyDto;
import dto.join.ReplyContentDto;
import service.inter.PageService;
import service.inter.ReplyService;
import util.PageInfo;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Resource
	private ReplyDao replyDao;
	
	@Resource
	private ReviewDao reviewDao; 
	
	@Resource
	private PageService pageService;
	
	@Transactional
	@Override
	public int writeReply(int member_id, int review_num, String content) {
		
		ReplyDto replyDto = new ReplyDto(member_id, review_num, content);
		
		int result = replyDao.insertReply(replyDto);
		
		if(result == 1) {
			reviewDao.addReplyCount(review_num);
		}
		
		return result;
	}
	
	@Transactional
	@Override
	public int deleteReply(int reply_num, int review_num) {
		
		int result = replyDao.deleteReply(reply_num);;

		if(result == 1) {
			reviewDao.subtractReplyCount(review_num);
			
		}

		return result;
	}
	
	@Override
	public Map<String, Object> getMyReply(String pageNum, int member_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = replyDao.getMyReplyCount(member_id);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setMember_id(member_id);
			
			List<ReplyContentDto> replys = replyDao.getMyReplysByInfo(info);	
					
			map.put("replys", replys);
		}
		
		map.put("info", info);
		
		return map;
	}
}
