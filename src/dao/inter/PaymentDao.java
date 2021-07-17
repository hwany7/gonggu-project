package dao.inter;

import dto.PaymentDto;

public interface PaymentDao {
	
	//마이페이지
	int insertPayment(PaymentDto paymentDto);
	
}
