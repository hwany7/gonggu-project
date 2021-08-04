package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.inter.ReplyRepository;
import dao.inter.ReviewRepository;
import dto.ReplyDto;
import dto.join.ReplyContentDto;
import service.inter.PageService;
import service.inter.ReplyService;
import util.PageInfo;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyRepository replyRepository;
	private final ReviewRepository reviewRepository; 
	private final PageService pageService;
	
	@Autowired
	public ReplyServiceImpl(ReplyRepository replyRepository, ReviewRepository reviewRepository,  PageService pageService) {
		
		this.replyRepository = replyRepository;
		this.reviewRepository = reviewRepository;
		this.pageService = pageService;
	}
	
	@Transactional
	@Override
	public int writeReply(int member_id, int review_num, String content) {
		
		ReplyDto replyDto = new ReplyDto(member_id, review_num, content);
		
		int result = replyRepository.insertReply(replyDto);
		
		if(result == 1) {
			reviewRepository.addReplyCount(review_num);
		}
		
		return result;
	}
	
	@Transactional
	@Override
	public int deleteReply(int reply_num, int review_num) {
		
		int result = replyRepository.deleteReply(reply_num);;

		if(result == 1) {
			reviewRepository.subtractReplyCount(review_num);
			
		}

		return result;
	}
	
	@Override
	public Map<String, Object> getMyReply(String pageNum, int member_id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = replyRepository.getMyReplyCount(member_id);
		
		PageInfo info = pageService.process(cnt, pageNum);
		
		if(info.getCnt()>0) {
			
			info.setMember_id(member_id);
			
			List<ReplyContentDto> replys = replyRepository.getMyReplysByInfo(info);	
					
			map.put("replys", replys);
		}
		
		map.put("info", info);
		
		return map;
	}
}
