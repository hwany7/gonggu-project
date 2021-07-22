package dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dao.inter.PaymentDao;
import dto.PaymentDto;

@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	@Resource
	SqlSession session;
	
	//페이먼트 등록
	@Override
	public int insertPayment(PaymentDto payment) {
		
		return session.insert("payment.insertPayment", payment);
	}
	
	//리뷰등록 상태 업로드 
	@Override
	public int updateWritableFromReview(int payment_id){
		
		return session.update("payment.updateWritableFromReview", payment_id);
	}	
	

}
