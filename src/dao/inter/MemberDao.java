package dao.inter;

import dto.MemberDto;

public interface MemberDao {
	public MemberDto getMemberFromLogin(String member_email);
	int check(String member_email, String password);
}
