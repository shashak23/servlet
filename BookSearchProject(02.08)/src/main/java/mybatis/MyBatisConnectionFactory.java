package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
		// 팩토리가 있으면 세션만들 수 있어 세션잇으면 쿼리 만들 수 잇어
		// 이 파일이 있는 이유는 이 세션을 가지고 팩토리를 만들고 아래의 내용이 바로 그걸 하는 이유입니다
	   private static SqlSessionFactory sqlSessionFactory;
	   
	   static {
	      
	      String resource = "./SqlMapConfig.xml"; //설정화일? -> 어딘가에 만들어서 설정해야해요
	      // 이런거를 리소스라고 부르고 이거는 리소스라는 폴더에 넣으면 되요!
	      try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         
	         if( sqlSessionFactory == null ) {
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
