package service.inter;

public interface LoginService {
	
	public int directLogin(String member_email, String password);
	public int activateUser(int member_id, String password);
	
}
