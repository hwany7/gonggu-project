package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.inter.MemberRepository;
import dto.MemberDto;
import service.inter.MemberService;
import util.MailSend;
import util.RandomCode;

@Service
public class MeberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;
	
	@Autowired
    public MeberServiceImpl(MemberRepository memberRepository) {
		
        this.memberRepository = memberRepository;
    }
	
	
	/**
	 * 메인 로그인 방식
	 */
	
	@Override
	public int directLogin(String member_email, String password, HttpServletRequest request) {
		
		int result = 0;
		HttpSession session = request.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_email", member_email);
		map.put("password", password);
		
		MemberDto memberDto = memberRepository.getMemberByEmailAndPassword(map);
		
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
		MemberDto memberDto = memberRepository.getMember(member_id);
		
		if(memberDto.getPassword().equals(password)) {
			memberRepository.activateStatus(member_id);
			result = 1;
		}
		
		return result;
	}
	
	//멤버 정보 얻기
	@Override
	public MemberDto getMember(int member_id) {

		return memberRepository.getMember(member_id);
	}
	
	//멤버 체크하기
	@Override
	public int checkMember(int member_id, String password) {
		
		MemberDto memberDto = memberRepository.getMember(member_id);

		int result = (memberDto.getPassword().equals(password)) ? 1 : 0;
		
		return result;
	}
	
	//멤버 수정하기
	@Override
	public int modifyMember(MemberDto member) {

		int result = memberRepository.updateMember(member);
		
		return result;
	}
	
	//멤버 탈퇴하기
	@Override
	public int signout(int member_id, String password) {
		
		MemberDto member = memberRepository.getMember(member_id);
		
		int result = 0;

		if(member.getPassword().equals(password)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("member_id", member_id);
			map.put("member_status", "inactive");
			
			result = memberRepository.updateStatus(map);

		}

		return result;
	}
	
	//이메일 중복 검사 기능
	@Override
	public int checkDuplicateForEmail(String member_email) {
		
		return memberRepository.checkEmail(member_email);
	}
	
	//닉네임 중복 검사 기능
	@Override
	public int checkDuplicateForNickname(String nickname) {
		
		return memberRepository.checkNickname(nickname);
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
				
		return memberRepository.insertMember(member);
	}

}
