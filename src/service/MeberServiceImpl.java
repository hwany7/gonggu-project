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

}
