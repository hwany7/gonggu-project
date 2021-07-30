package dao.inter;

import java.util.Map;

import dto.MemberDto;

public interface MemberDao {
	
	//로그인
	public MemberDto getMemberFromLogin(Map<String, Object> map);
	public String checkStatus(String member_email);//미사용(리팩토링)
	
	//계정 활성화
	public int activateStatusFromLogin(int member_id);
	public MemberDto getMemberFromMypage(int member_id);
	
	//회원가입
	public int checkEmail(String member_email);
	public int checkNickname(String nickname);
	public int insertMember(MemberDto member);
	
	//마이페이지
	public MemberDto getMember(int member_id);
	public int updateMember(MemberDto member);
	public int modifyStatus(Map<String, Object> map);

}
