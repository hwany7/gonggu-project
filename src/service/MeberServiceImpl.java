package service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import dao.inter.MemberDao;
import dto.MemberDto;
import service.inter.MemberService;

@Service
public class MeberServiceImpl implements MemberService{
	
	@Resource
	MemberDao memberDao;
	
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

		//수정하기	
		int result = memberDao.updateMember(member);
		
		if(result == 1) {
			((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().setAttribute("nickname", member.getNickname());
		}

		return result;
	}

}
