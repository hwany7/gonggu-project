package dao;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ApplicationDao;
import dto.ApplicationDto;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {
	
	@Resource
	SqlSession session;

	//신청하기
	@Override
	public int registerAppFromPostContent(Map<String, Integer> map) {
		
		return session.insert("application.registerAppFromPostContent", map);
	}
	
	//신청수량 업데이트
	@Override
	public int updateAppFromPostPostContent(Map<String, Integer> map) {
		
		return session.update("application.updateAppFromPostContent", map);
	}
	
	//app id 찾기
	@Override
	public ApplicationDto getApplication(int application_id) {
		
		return session.selectOne("application.getApplication", application_id);
	}
	
	//신청 취소하기
	@Override
	public int deleteApplication(int application_id) {

		return session.delete("application.deleteApplication", application_id);
	}
	
	//신청 취소후 수량감소
	@Override
	public int updateApplicationAndDecreaseComments(ApplicationDto applicationDto) {

		return session.update("application.updateApplicationForDecreaseComments", applicationDto);
	}
	

	
}
