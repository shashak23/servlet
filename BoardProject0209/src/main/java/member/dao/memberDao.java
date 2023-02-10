package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.mybatisconnectionfactory;
import member.vo.Member;



public class memberDao {
	// 사용자에 관련된 db처리하는 것

	public Member select(Member member) {
		// 여기서 db처리를 하면 되요
		// 순수? mybatis? 우리는 mybatis 이용할거에요 
		// mybatis를 쓰려면 sqlsession이 있어야해요 -> 이걸 가지고 xml에 있는 query를 실행할 수 있어요
		// xml을 mapping이라고 함
		// sqlsession은 facotry가 찍어주죠? -> 그걸 이용해요
		// sqlsessionfactory가 있어야 해요 -> 이 공장을 만들려면 데이터베이스 연결정도봐 같은 xml정보를 줘서 이 공장을 만들어야해요
		// 그래서 2개를 만들어야 해요?
		SqlSession sqlSession = 
				mybatisconnectionfactory.getSqlSessionFactory().openSession();
		
		Member result = sqlSession.selectOne("myMember.login", member);
		// result에 넣을 sqlsession의 selectone구문을 쓰는 myMember에 하단에 위치한 login(id)을 찾고
		// member라는 인자를 주고 members(namespace).xml에서는 member라는 인자를 받는다 
		// member는 그리고 sqlmapconfig.xml의 alias로 연결된다.
		
		sqlSession.close();
		
		return result;
		// 이 공장을 짓는 코드는 이미 정해져있어요! 

	}
	
}
