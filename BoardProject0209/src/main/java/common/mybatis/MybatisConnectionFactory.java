package common.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	
	 private static SqlSessionFactory sqlSessionFactory;
	   
	   static {
	      // 공장을 만들 때 필요한 xml 설정 파일
	      String resource = "./SqlMapConfig.xml"; 
	      // 설정화일? -> 어딘가에 만들어서 설정해야해요
	      // 이런거를 리소스라고 부르고 이거는 리소스라는 폴더에 넣으면 되요!
	      try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         
	         if( sqlSessionFactory == null ) {
	        	 // xml 설정을 이용해서 공장 객체를 만들어요
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	         }
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	   
	   public static SqlSessionFactory getSqlSessionFactory() {
	      return sqlSessionFactory;
	   }

}
