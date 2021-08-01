package bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfigBean {
	
	@Autowired
    private ApplicationContext applicationContext;
	
    @Bean
    public DriverManagerDataSource dataSource() {
    	
        DriverManagerDataSource source = new DriverManagerDataSource();
        
        source.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        source.setUsername("encore");
        source.setPassword("encore");
        
        return source;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
    	
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mappers/*.xml"));
        
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSession sqlSession() throws Exception {
    	
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        
        return sqlSessionTemplate;
    }
    
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
    	
    	DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
    	dataSourceTransactionManager.setDataSource(dataSource());
  
    	return dataSourceTransactionManager;
    }
}
