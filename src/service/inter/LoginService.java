package service.inter;

import java.util.Map;

public interface LoginService {
	
	public Map<String, String> directLogin(String member_email, String password);
	public int activateUser(int member_id, String password);
	
}
