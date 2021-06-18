package dao.inter;

import dto.MemberDto;

public interface MemberDao {
	
	//로그인
	public MemberDto getMemberFromLogin(String member_email);
	int check(String member_email, String password);
	
	//계정 활성화
	public int check(int member_id, String password);
	public int activateStatusFromLogin(int member_id);
	
}
