package service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dao.inter.MemberDao;
import dto.MemberDto;
import service.inter.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private MemberDao memberDao;
	
	//메인 로그인 방식
	@Override
	public int directLogin(String member_email, String password) {
		
		int result = 0;
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_email", member_email);
		map.put("password", password);
		
		MemberDto memberDto = memberDao.getMemberFromLogin(map);
		
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
		MemberDto memberDto = memberDao.getMemberFromMypage(member_id);
		
		if(memberDto.getPassword().equals(password)) {
			memberDao.activateStatusFromLogin(member_id);
			result = 1;
		}
		
		return result;
	}
	
}
