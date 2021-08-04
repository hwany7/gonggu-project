package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.inter.NotificationRepository;
import dto.NotificationDto;
import service.inter.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	private final NotificationRepository notificationRepository;
	
	@Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
		
        this.notificationRepository = notificationRepository;
    }
	
	//알림 받아오기
	@Override
	public List<NotificationDto> getNotification(int member_id) {
		
		//알림 가져오기
		List<NotificationDto> notifications = notificationRepository.getNotifications(member_id);
		
		//알림 상태 읽기로 바꾸기
		notificationRepository.updateStatusToRead(member_id);
		
		return notifications;
	}

	//안 읽은 알림 체크하기 
	@Override
	public int checkNotificationNotRead(int member_id) {
		
		int result = 0;
		int count = notificationRepository.checkStatusNotRead(member_id);
		
		if(count != 0) {
			result = 1;
		}
		
		return result;
	}
	
	//알림 전부 삭제하기
	@Override
	public List<NotificationDto> deleteAllNotification(int member_id) {
		
		notificationRepository.deleteAllNotification(member_id);
		
		return notificationRepository.getNotifications(member_id);
	}
	
}
