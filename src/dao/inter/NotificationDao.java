package dao.inter;

import java.util.List;

import dto.NotificationDto;

public interface NotificationDao {
	
	//메인페이지
	public List<NotificationDto> getNotificationById(int member_id);
	public int updateReadStatus(int member_id);
	public int checkNotificationNotRead(int member_id);
	public int deleteAllNotification(int member_id);

}
