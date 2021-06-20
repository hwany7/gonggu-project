package service.inter;

public interface SignupService {
	
	public int CheckDuplicateForEmail(String member_email);
	public int CheckDuplicateForNickname(String nickname);
	public String SendMailGetCode(String member_email);
	
}
