package service.inter;

import dto.MemberDto;

public interface MemberService {
	
	public MemberDto getMember(int member_id);
	public int checkMember(int member_id, String password);
	public int modifyMember(MemberDto member);
	public int signout(int member_id, String password);
}
