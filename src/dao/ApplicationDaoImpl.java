package dao;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.ApplicationDao;

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
}
