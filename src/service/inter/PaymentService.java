package service.inter;

import dto.MemberDto;
import dto.PaymentDto;

public interface PaymentService {

	public MemberDto getUserInfo(int member_id);
	public int payment(PaymentDto paymentDto);

}
