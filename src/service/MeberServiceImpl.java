package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
