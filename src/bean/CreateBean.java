package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import dao.ApplicationDaoImpl;
import dao.MemberDaoImpl;
import dao.NotificationDaoImpl;
import dao.PaymentDaoImpl;
import dao.PostDaoImpl;
import dao.ProductDaoImpl;
import dao.ReplyDaoImpl;
import dao.ReviewDaoImpl;
import dao.inter.ApplicationDao;
import dao.inter.MemberDao;
import dao.inter.NotificationDao;
import dao.inter.PaymentDao;
import dao.inter.PostDao;
import dao.inter.ProductDao;
import dao.inter.ReplyDao;
import dao.inter.ReviewDao;

@Configuration
public class CreateBean {
	
	@Bean
	public ViewResolver viewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDaoImpl();
	}
	
	@Bean
	public NotificationDao notificationDao() {
		return new NotificationDaoImpl();
	}
	
	@Bean
	public PaymentDao paymentDao() {
		return new PaymentDaoImpl();
	}
	
	@Bean
	public PostDao postDao() {
		return new PostDaoImpl();
	}
	
	@Bean
	public ProductDao productDao() {
		return new ProductDaoImpl();
	}
	
	@Bean
	public ReplyDao replyDao() {
		return new ReplyDaoImpl();
	}
	
	@Bean
	public ReviewDao reviewDao() {
		return new ReviewDaoImpl();
	}
	
	@Bean
	public ApplicationDao applicationDao() {
		return new ApplicationDaoImpl();
	}
	
}
