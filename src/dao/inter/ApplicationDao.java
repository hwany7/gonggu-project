package dao.inter;

import java.util.Map;

import dto.ApplicationDto;

public interface ApplicationDao {

	//포스트 페이지
	public int registerAppFromPostContent(Map<String, Integer> map);
	public int updateAppFromPostPostContent(Map<String, Integer> map);
	
	//마이페이지
	public ApplicationDto getApplication(int application_id);
	public int deleteApplication(int application_id);
	public int updateApplicationAndDecreaseComments(ApplicationDto applicationDto);
}

