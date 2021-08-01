package dao.inter;

import dto.PaymentDto;

public interface PaymentDao {
	
	public int insertPayment(PaymentDto paymentDto);
	public int updateWritable(int payment_id);
	
}
