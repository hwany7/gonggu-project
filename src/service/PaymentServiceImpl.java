package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.inter.MemberRepository;
import dao.inter.PaymentRepository;
import dto.MemberDto;
import dto.PaymentDto;
import service.inter.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private MemberRepository memberDao;
	
	@Resource
	private PaymentRepository paymentDao;
	
	
	//결제폼에 사용할 회원 정보 가져오기(지금은 간단해서 멤버정보)
	@Override
	public MemberDto getUserInfo(int member_id) {
	
		return memberDao.getMember(member_id);
	}
	
	//결제하기
	@Override
	public int payment(PaymentDto paymentDto) {

		return paymentDao.insertPayment(paymentDto);
	}
	
}
