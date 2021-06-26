package service.inter;

import java.util.List;

import dto.NotificationDto;

public interface NotificationService {
	
	public List<NotificationDto> getNotification(int member_id);
	public int checkNotificationNotRead(int member_id);
	public List<NotificationDto> deleteAllNotification(int member_id);
	
}
