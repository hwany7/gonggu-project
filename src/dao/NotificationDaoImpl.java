package dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.NotificationDao;
import dto.NotificationDto;

@Repository
public class NotificationDaoImpl implements NotificationDao {
	
	@Resource
	SqlSession session;
	
	//ID로 안 읽은 알림 받아오기
	@Override
	public List<NotificationDto> getNotificationById(int member_id) {
		
		return session.selectList("notification.getNotificationById", member_id);
	}
	
	//읽은 상태로 바꾸기
	@Override
	public int updateReadStatus(int member_id) {
		
		return session.update("notification.updateReadStatus", member_id);
	}
	
	//안 읽은 알림 체크
	@Override
	public int checkNotificationNotRead(int member_id) {
		
		return session.selectOne("notification.checkNotificationNotRead", member_id);
	}
	
	//유저 알림 전부 지우기
	@Override
	public int deleteAllNotification(int member_id) {
		
		return session.delete("notification.deleteAllNotification", member_id);
		
	}
}
