package dao.inter;

import dto.PaymentDto;

public interface PaymentRepository {
	
	public int insertPayment(PaymentDto paymentDto);
	public int updateWritable(int payment_id);
	
}
