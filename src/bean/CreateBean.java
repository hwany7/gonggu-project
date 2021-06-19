package bean;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public SqlSession sqlSession() throws IOException {
		
		Reader reader =  Resources.getResourceAsReader("/mybatis/mybatis-config.xml");
		
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		
		return sqlMapper.openSession(true);
		
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
