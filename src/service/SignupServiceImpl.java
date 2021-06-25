package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.MemberDao;
import dto.MemberDto;
import service.inter.SignupService;
import util.MailSend;
import util.RandomCode;

@Service
public class SignupServiceImpl implements SignupService {
	
	@Resource
	private MemberDao memberDao;
	
	//이메일 중복 검사 기능
	@Override
	public int CheckDuplicateForEmail(String member_email) {
		
		return memberDao.checkEmail(member_email);
	}
	
	//닉네임 중복 검사 기능
	@Override
	public int CheckDuplicateForNickname(String nickname) {
		
		return memberDao.checkNickname(nickname);
	}
	
	//메일 인증 기능
	@Override
	public String SendMailGetCode(String member_email) {
		
		//랜덤 코드 생성
		String codeMsg = new RandomCode().excuteGenerate();
		
		@SuppressWarnings("unused")
		MailSend send = new MailSend(member_email, codeMsg);
		
		return codeMsg;
	}
	
	//멤버 추가 기능
	@Override
	public int RegisteMember(MemberDto member) {
				
		return memberDao.insertMember(member);
	}
	
}
