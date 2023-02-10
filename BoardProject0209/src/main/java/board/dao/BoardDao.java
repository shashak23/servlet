package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.mybatisconnectionfactory;

public class BoardDao {

	public List<Board> selectAll() {
		
		
		// Database처리만 하면 되요!
		// MyBatis이용해요!
		SqlSession sqlSession = 
				mybatisconnectionfactory.getSqlSessionFactory().openSession();
		
		List<Board> result = sqlSession.selectList("myBoard.allBoards");
		
		sqlSession.close();
		
		return result;
	}

}
    