package dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.MemberDao;
import dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	SqlSession session;
	
	//로그인시 멤버 정보 가져오기
	@Override
	public MemberDto getMemberFromLogin(String member_email) {
		
		return session.selectOne("member.getMemberFromLogin", member_email);
	}
			
	//로그인시 상태 체크
	@Override
	public String checkStatus(String member_email) {
		
		return session.selectOne("member.checkStatus", member_email);
	}
	
	//계정 활성화시 멤버 정보 보기
	@Override
	public MemberDto getMemberFromMypage(int member_id){
		
		return session.selectOne("member.getMemberFromMypage", member_id);
	}
	
	//휴면상태 -> 활동상태 변경
	@Override
	public int activateStatusFromLogin(int member_id) {
		
		return session.update("member.activateStatusFromLogin", member_id);
	}
	
	//이메일 중복 검사
	@Override
	public int checkEmail(String member_email) {
		
		return session.selectOne("member.checkEmail", member_email);
	}
	
	//닉네임 중복 검사
	@Override
	public int checkNickname(String nickname) {
		
		return session.selectOne("member.checkNickname", nickname);
	}
	
	
}
