package mybatis.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
//	private static SqlSessionFactory factory = null;
	
	// SqlSessionFactory를 반환해주는 Connector
	public SqlSessionFactory getFactory() {
		SqlSessionFactory factory = null;
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis/config/mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader); 
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return factory;
	}
}
