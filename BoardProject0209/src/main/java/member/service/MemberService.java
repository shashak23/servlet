package member.service;

import member.dao.memberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// LoginServlet에 있음 
		// login이라는 작업은 로직처리할 게 없어요, 데이터 베이스 처리만 하면 되서요~
		// db처리는 여기서 하는 것이 아닌 DAO에서 하지요?
		memberDao dao = new memberDao(); //dao 생성 및 임포트하고
		
		Member result = dao.select(member);
		
		return result;
	}


}
