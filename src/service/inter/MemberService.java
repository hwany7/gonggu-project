package service.inter;

import javax.servlet.http.HttpServletRequest;

import dto.MemberDto;

public interface MemberService {
	
	public int directLogin(String member_email, String password, HttpServletRequest request);
	public int activateUser(int member_id, String password);
	public MemberDto getMember(int member_id);
	public int checkMember(int member_id, String password);
	public int modifyMember(MemberDto member);
	public int signout(int member_id, String password);
	
	public int checkDuplicateForEmail(String member_email);
	public int checkDuplicateForNickname(String nickname);
	public String sendMailGetCode(String member_email);
	public int registeMember(MemberDto member);
	
}
