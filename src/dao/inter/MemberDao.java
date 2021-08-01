package dao.inter;

import java.util.Map;

import dto.MemberDto;

public interface MemberDao {
	
	public MemberDto getMember(int member_id);	
	public MemberDto getMemberByEmailAndPassword(Map<String, Object> map);

	public int insertMember(MemberDto member);
	public int updateMember(MemberDto member);
	public int updateStatus(Map<String, Object> map);
	
	public int activateStatus(int member_id);
	public int checkNickname(String nickname);
	public int checkEmail(String member_email);

	public String checkStatus(String member_email);//미사용(리패토링 후)
	public MemberDto getMemberFromMypage(int member_id);//미사용(리팩토링 후)

}
