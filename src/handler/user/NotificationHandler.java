package handler.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.inter.NotificationService;

@Controller
public class NotificationHandler {
	
	@Resource
	private NotificationService notificationService;
	
	//알림 얻기
	@RequestMapping("/notifications")
	public ModelAndView getNotification() {
		
		//세션 받기
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		ModelAndView mav = new ModelAndView("user/notification/notificationList");
			
		mav.addObject("notifications", notificationService.getNotification(member_id)) ;
		
		return mav;
	}
	
	//안읽은 알림 얻기(상태가 0)
	@ResponseBody
	@RequestMapping("/notificationscheck")
	public String checkNotification() {
				
		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
						
		return Integer.toString(notificationService.checkNotificationNotRead(member_id));
	}
	
	//알림 전부 삭제하기
	@RequestMapping("/notifications/deleteall")
	public ModelAndView deleteAllNotification() {

		int member_id = Integer.parseInt(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("member_id").toString());
		
		ModelAndView mav = new ModelAndView("user/notification/notificationList");

		mav.addObject("notifications", notificationService.deleteAllNotification(member_id));
		
		return mav;
	}
	
}
