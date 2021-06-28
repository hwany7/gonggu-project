package dao.inter;

import java.util.Map;

public interface ApplicationDao {

	//포스트 페이지
	public int registerAppFromPostContent(Map<String, Integer> map);
	public int updateAppFromPostPostContent(Map<String, Integer> map);
}

