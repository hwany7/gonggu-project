package service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dao.inter.MemberRepository;
import dto.MemberDto;
import service.inter.MemberService;
import util.MailSend;
import util.RandomCode;

@Service
public class MeberServiceImpl implements MemberService{
	
	private MemberRepository memberDao;
	
	//메인 로그인 방식
	@Override
	public int directLogin(String member_email, String password) {
		
		int result = 0;
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_email", member_email);
		map.put("password", password);
		
		MemberDto memberDto = memberDao.getMemberByEmailAndPassword(map);
		
		if (memberDto == null) {
			result = 0;
		}else {
			String status = memberDto.getMember_status();
			
			if(status.equals("active")) {
				result = 1;
				session.setAttribute("nickname", memberDto.getNickname());
				session.setAttribute("gender", memberDto.getGender());
				session.setAttribute("member_id", Integer.toString(memberDto.getMember_id()));
			} else if(status.equals("suspended")){
				result = 2;
			} else if(status.equals("dormant")) {
				result = 3;
				session.setAttribute("member_id", Integer.toString(memberDto.getMember_id()));
			} else if(status.equals("inactive")) {
				result = 0;
			}
			
		}
		
		return result;
	}
	
	//휴면유저 활성화
	@Override
	public int activateUser(int member_id, String password) {
		
		int result = 0;
		MemberDto memberDto = memberDao.getMember(member_id);
		
		if(memberDto.getPassword().equals(password)) {
			memberDao.activateStatus(member_id);
			result = 1;
		}
		
		return result;
	}
	
	//멤버 정보 얻기
	@Override
	public MemberDto getMember(int member_id) {

		return memberDao.getMember(member_id);
	}
	
	//멤버 체크하기
	@Override
	public int checkMember(int member_id, String password) {
		
		MemberDto memberDto = memberDao.getMember(member_id);

		int result = (memberDto.getPassword().equals(password)) ? 1 : 0;
		
		return result;
	}
	
	//멤버 수정하기
	@Override
	public int modifyMember(MemberDto member) {

		int result = memberDao.updateMember(member);
		
		if(result == 1) {
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().setAttribute("nickname", member.getNickname());
		}

		return result;
	}
	
	//멤버 탈퇴하기
	@Override
	public int signout(int member_id, String password) {
		
		MemberDto member = memberDao.getMember(member_id);
		
		int result = 0;

		if(member.getPassword().equals(password)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("member_id", member_id);
			map.put("member_status", "inactive");
			
			result = memberDao.updateStatus(map);

			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().invalidate();
		}

		return result;
	}
	
	//이메일 중복 검사 기능
	@Override
	public int checkDuplicateForEmail(String member_email) {
		
		return memberDao.checkEmail(member_email);
	}
	
	//닉네임 중복 검사 기능
	@Override
	public int checkDuplicateForNickname(String nickname) {
		
		return memberDao.checkNickname(nickname);
	}
	
	//메일 인증 기능
	@Override
	public String sendMailGetCode(String member_email) {
		
		//랜덤 코드 생성
		String codeMsg = new RandomCode().excuteGenerate();
		
		@SuppressWarnings("unused")
		MailSend send = new MailSend(member_email, codeMsg);
		
		return codeMsg;
	}
	
	//멤버 추가 기능
	@Override
	public int registeMember(MemberDto member) {
				
		return memberDao.insertMember(member);
	}

}
