package dao;

import org.apache.ibatis.session.SqlSession;

import dao.inter.MemberDao;
import dto.MemberDto;
import mybatis.SqlMapClient;

public class MemberDaoImpl implements MemberDao {

	SqlSession session = SqlMapClient.getSession();
	
	//로그인시 멤버 정보 가져오기
	@Override
	public MemberDto getMemberFromLogin(String member_email) {
		
		return session.selectOne("user.getMemberFromLogin", member_email);
	}
	
	//멤버 로그인 체크
	public int check(String member_email, String password) {
		
		int result = 0;
		int cnt = checkEmail(member_email);
		String status = checkStatus(member_email);
		MemberDto memberDto = getMemberFromLogin(member_email);
		
		if(cnt == 0 || !memberDto.getPassword().equals(password)) {
			// 아이디가 없거나 비밀번호가 일치하지 않음
			result = 0;
		} else {
			// 아이디 있고 비밀번호 일치
			if(status.equals("active")) {
				// 활동 회원
				result = 1;
			} else if(status.equals("suspended")){
				// 활동 정지 회원
				result = 2;
			} else if(status.equals("dormant")) {
				// 휴면상태 회원
				result = 3;
			} else if(status.equals("inactive")) {
				// 탈퇴한 회원 --> 로그인 정보 틀린 것과 동일한 result
				result = 0;
			}
		}
		return result;
	}
	
	//이메일 중복 검사
	public int checkEmail(String member_email) {
		
		return session.selectOne("user.checkEmail", member_email);
	}
	
	//상태 체크하기
	public String checkStatus(String member_email) {
		
		return session.selectOne("user.checkStatus", member_email);
	}
}
