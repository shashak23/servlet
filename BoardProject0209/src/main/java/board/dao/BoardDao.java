package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MybatisConnectionFactory;

public class BoardDao {

	public List<Board> selectAll() {
		// Database처리만 하면 되요!
		// MyBatis이용해요!
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<Board> result = sqlSession.selectList("myBoard.allBoards");
		
		sqlSession.close();
		
		return result;
	}

	public int insert(Board board) {
		// DB에 데이터 전달
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.insert("myBoard.listBoards", board);
		
		if(result ==1) {
			
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		  
		return result;
	}

	public Board selectOne(String bNum) {
		// 데이터를 다 요쳥을 db에게 하고 
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Board board = sqlSession.selectOne("myBoard.oneBoard", bNum);
		
		sqlSession.close();
		
		return board;
	}

	public int delete(Board board) {
		// 연결
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		
		int result = sqlSession.selectOne("myBoard.deleteBoards", board);
		
		if(result ==1) {
			
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}
	
}
    