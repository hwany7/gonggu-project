package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.inter.ReplyService;

@Controller
public class ReplyHandler {
	
	@Resource
	private ReplyService replyService;

	//댓글 작성하기
	@RequestMapping("/reviews/review/reply/writepro")
	public ModelAndView writeReplyPro(int review_num, String content){
		
		ModelAndView mav = new ModelAndView("user/pro/writeReplyPro");
		
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
				
		mav.addObject("result", replyService.writeReply(member_id, review_num, content));
		mav.addObject("review_num", review_num);
	
		return mav;
	}
	
	//댓글 삭제하기
	@RequestMapping("/reviews/review/reply/deletepro")
	public ModelAndView deleteReplyPro(int reply_num, int review_num) {
		
		ModelAndView mav = new ModelAndView("user/pro/deleteReplyPro");
		
		mav.addObject("result", replyService.deleteReply(reply_num, review_num));
		mav.addObject("review_num", review_num);
	
		return mav;
	}
}
