package dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.NotificationRepository;
import dto.NotificationDto;

@Repository
public class MyBatisNotificationRepository implements NotificationRepository {
	
	private final SqlSession session;
	
	@Autowired
	public MyBatisNotificationRepository(SqlSession session) {
		
		this.session = session;
	}
	
	//ID로 안 읽은 알림 받아오기
	@Override
	public List<NotificationDto> getNotifications(int member_id) {
		
		return session.selectList("notification.getNotifications", member_id);
	}
	
	//유저 알림 전부 지우기
	@Override
	public int deleteAllNotification(int member_id) {
		
		return session.delete("notification.deleteAllNotification", member_id);
		
	}
	
	//읽은 상태로 바꾸기
	@Override
	public int updateStatusToRead(int member_id) {
		
		return session.update("notification.updateStatusToRead", member_id);
	}
	
	//안 읽은 알림 체크
	@Override
	public int checkStatusNotRead(int member_id) {
		
		return session.selectOne("notification.checkStatusNotRead", member_id);
	}
	
}
