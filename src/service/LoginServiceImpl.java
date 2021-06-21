package service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.MemberDao;
import dto.MemberDto;
import service.inter.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Resource
	MemberDao memberDao;
	
	//메인 로그인 방식
	@Override
	public Map<String, String> directLogin(String member_email, String password) {
		
		MemberDto memberDto = memberDao.getMemberFromLogin(member_email);
		Map<String, String> memSession  = new HashMap<String, String>();
		
		int cnt = memberDao.checkEmail(member_email);
		String status = memberDao.checkStatus(member_email);
		
		if(cnt == 0 || !memberDto.getPassword().equals(password)) {
			// 아이디가 없거나 비밀번호가 일치하지 않음
			memSession.put("result", "0");
		} else {
			// 아이디 있고 비밀번호 일치
			if(status.equals("active")) {
				// 활동 회원
				memSession.put("result", "1");
				memSession.put("nickname", memberDto.getNickname());
				memSession.put("gender", memberDto.getGender());
				memSession.put("member_id", Integer.toString(memberDto.getMember_id()));
			} else if(status.equals("suspended")){
				// 활동 정지 회원
				memSession.put("result", "2");
			} else if(status.equals("dormant")) {
				//휴면상태 회원
				memSession.put("result", "3");
				memSession.put("member_id", Integer.toString(memberDto.getMember_id()));
			} else if(status.equals("inactive")) {
				// 탈퇴한 회원 --> 로그인 정보 틀린 것과 동일한 result
				memSession.put("result", "0");
			}
		}
		
		return memSession;
	}
	
	//휴면유저 활성화
	@Override
	public int activateUser(int member_id, String password) {
		
		int result = 0;
		MemberDto memberDto = memberDao.getMemberFromMypage(member_id);
		
		if(memberDto.getPassword().equals(password)) {
			memberDao.activateStatusFromLogin(member_id);
			result = 1;
		}
		
		return result;
	}
	
}
