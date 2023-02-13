package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// LoginServlet에 있음 
		// login이라는 작업은 로직처리할 게 없어요, 데이터 베이스 처리만 하면 되서요~
		// db처리는 여기서 하는 것이 아닌 DAO에서 하지요?
		MemberDao dao = new MemberDao(); //dao 생성 및 임포트하고
		
		Member result = dao.select(member);
		
		return result;
	}

	public int signup(Member member) {
		// 로직처리하는 곳
		MemberDao dao = new MemberDao();
		
		int result = dao.insert(member);
		// 성공만하면 데이터가 들어가고 결과로 인서트가 성공한 갯수가 나와요, 실패하면 0이 나와요
		return result;
	}


}
