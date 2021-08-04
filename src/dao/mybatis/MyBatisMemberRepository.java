package dao.mybatis;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.MemberRepository;
import dto.MemberDto;

@Repository
public class MyBatisMemberRepository implements MemberRepository {
	
	private final SqlSession session;
	
	@Autowired
	public MyBatisMemberRepository(SqlSession session) {
		
		this.session = session;
	}
	
	//멤버 가져오기
	@Override
	public MemberDto getMember(int member_id) {

		return session.selectOne("member.getMember", member_id);
	}
	
	//로그인시 멤버 정보 가져오기
	@Override
	public MemberDto getMemberByEmailAndPassword(Map<String, Object> map) {
			
		return session.selectOne("member.getMemberByEmailAndPassword", map);
	}
			
	//멤버 등록
	@Override
	public int insertMember(MemberDto member) {
		
		return session.insert("member.insertMember", member);
	}
	
	//멤버 수정하기
	@Override
	public int updateMember(MemberDto member) {

		return session.update("member.updateMember", member);
	}
	
	//멤버 상태 수정하기
	@Override
	public int updateStatus(Map<String, Object> map) {

		return session.update("member.updateStatus", map);
	}
	
	//휴면상태 -> 활동상태 변경
	@Override
	public int activateStatus(int member_id) {
		
		return session.update("member.activateStatus", member_id);
	}
	
	//닉네임 중복 검사
	@Override
	public int checkNickname(String nickname) {
		
		return session.selectOne("member.checkNickname", nickname);
	}	
	
	//이메일 중복 검사
	@Override
	public int checkEmail(String member_email) {
		
		return session.selectOne("member.checkEmail", member_email);
	}	
	
	//로그인시 상태 체크(미사용)
	@Override
	public String checkStatus(String member_email) {
		
		return session.selectOne("member.checkStatus", member_email);
	}
	
	//계정 활성화시 멤버 정보 보기(미사용)
	@Override
	public MemberDto getMemberFromMypage(int member_id){
		
		return session.selectOne("member.getMemberFromMypage", member_id);
	}
	
}
