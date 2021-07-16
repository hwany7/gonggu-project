package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.MemberDao;
import dto.MemberDto;
import service.inter.PaymentService;

@Service
public class PatmentServiceImpl implements PaymentService {

	@Resource
	MemberDao memberDao;
	
	
	//결제폼에 사용할 회원 정보 가져오기(지금은 간단해서 멤버정보)
	@Override
	public MemberDto getUserInfo(int member_id) {
	
		return memberDao.getMember(member_id);
	}
	
}
