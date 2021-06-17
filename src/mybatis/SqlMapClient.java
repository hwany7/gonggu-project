package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClient {
	private static SqlSession session = null;
	static {
		try {
			//설정 읽어오기
			Reader reader =  Resources.getResourceAsReader("mybatis/sqlMapConfig.xml");
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		return session;
	}
}
