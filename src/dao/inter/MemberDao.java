package dao.inter;

import dto.MemberDto;

public interface MemberDao {
	
	//로그인
	public MemberDto getMemberFromLogin(String member_email);
	public String checkStatus(String member_email);
	
	//계정 활성화
	public int activateStatusFromLogin(int member_id);
	public MemberDto getMemberFromMypage(int member_id);
	
	//회원가입
	public int checkEmail(String member_email);
	public int checkNickname(String nickname);
	public int insertMember(MemberDto member);
	
}
