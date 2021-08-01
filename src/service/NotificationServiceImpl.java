package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.NotificationDao;
import dto.NotificationDto;
import service.inter.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Resource
	private NotificationDao notificationDao;
	
	//알림 받아오기
	@Override
	public List<NotificationDto> getNotification(int member_id) {
		
		//알림 가져오기
		List<NotificationDto> notifications = notificationDao.getNotifications(member_id);
		
		//알림 상태 읽기로 바꾸기
		notificationDao.updateStatusToRead(member_id);
		
		return notifications;
	}

	//안 읽은 알림 체크하기 
	@Override
	public int checkNotificationNotRead(int member_id) {
		
		int result = 0;
		int count = notificationDao.checkStatusNotRead(member_id);
		
		if(count != 0) {
			result = 1;
		}
		
		return result;
	}
	
	//알림 전부 삭제하기
	@Override
	public List<NotificationDto> deleteAllNotification(int member_id) {
		
		notificationDao.deleteAllNotification(member_id);
		
		return notificationDao.getNotifications(member_id);
	}
	
}
