package dao.inter;

import java.util.List;

import dto.NotificationDto;

public interface NotificationRepository {
	
	public List<NotificationDto> getNotifications(int member_id);
	
	public int deleteAllNotification(int member_id);
	public int updateStatusToRead(int member_id);
	public int checkStatusNotRead(int member_id);

}
