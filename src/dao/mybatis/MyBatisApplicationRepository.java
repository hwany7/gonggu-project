package dao.mybatis;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.ApplicationRepository;
import dto.ApplicationDto;

@Repository
public class MyBatisApplicationRepository implements ApplicationRepository {
	
	private final SqlSession session;
	
	@Autowired
	public MyBatisApplicationRepository(SqlSession session) {
		
		this.session = session;
	}
	
	//app id 찾기
	@Override
	public ApplicationDto getApplication(int application_id) {
		
		return session.selectOne("application.getApplication", application_id);
	}

	//신청하기
	@Override
	public int insertApplication(Map<String, Object> map) {
		
		return session.insert("application.insertApplication", map);
	}
		
	//신청 취소하기
	@Override
	public int deleteApplication(int application_id) {

		return session.delete("application.deleteApplication", application_id);
	}
	
	//신청 취소후 수량감소
	@Override
	public int decreaseCurrentAmount(ApplicationDto applicationDto) {

		return session.update("application.decreaseCurrentAmount", applicationDto);
	}
	
}
