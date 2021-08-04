package dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.inter.PaymentRepository;
import dto.PaymentDto;

@Repository
public class MyBatisPaymentRepository implements PaymentRepository {
	
	private final SqlSession session;
	
	@Autowired
	public MyBatisPaymentRepository(SqlSession session) {
		
		this.session = session;
	}
	
	//페이먼트 등록
	@Override
	public int insertPayment(PaymentDto payment) {
		
		return session.insert("payment.insertPayment", payment);
	}
	
	//리뷰등록 상태 업로드 
	@Override
	public int updateWritable(int payment_id){
		
		return session.update("payment.updateWritable", payment_id);
	}	
	
}
