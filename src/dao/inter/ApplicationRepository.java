package dao.inter;

import java.util.Map;

import dto.ApplicationDto;

public interface ApplicationRepository {
	
	public ApplicationDto getApplication(int application_id);
	
	public int insertApplication(Map<String, Object> map);
	public int deleteApplication(int application_id);
	public int decreaseCurrentAmount(ApplicationDto applicationDto);
	
}

