package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MybatisConnectionFactory;
import member.vo.Member;



public class MemberDao {
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
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Member result = sqlSession.selectOne("myMember.login", member);
		// result에 넣을 sqlsession의 selectone구문을 쓰는 myMember에 하단에 위치한 login(id)을 찾고
		// member라는 인자를 주고 members(namespace).xml에서는 member라는 인자를 받는다 
		// member는 그리고 sqlmapconfig.xml의 alias로 연결된다.
		//select는 알아서 커밋을 해요?
		sqlSession.close();
		
		return result;
		// 이 공장을 짓는 코드는 이미 정해져있어요! 

	}
	
	public int insert(Member member) {
		// 실제 db를 연결하고 데이터를 넘겨주는 역할
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		/*
		 * System.out.println(member.getMemberId());
		 * System.out.println(member.getMemberName());
		 * System.out.println(member.getMemberPw());
		 */
		
		int result = sqlSession.insert("myMember.join", member);
		// 도서 검색 시스템 할때 insert를 실행하면 결과값이 성공한 갯수가 나와요
		// insert는 확정을 할지 뒤로 돌릴지 결정을 해야한다.
		// 세션을 닫기 전에 세션을 컨트롤하면 실패=뒤로 돌리고, 성공=1값1개여서,
		
		// 조건문을 걸고 커밋을 하면 된다, 실패하면 뒤로 돌린다rollback
		if(result==1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		 
		return result;
	}

}
