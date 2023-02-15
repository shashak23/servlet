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

	public int delete(String bNum) {
		// 연결
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		// int는 수행된 row값이어서 1나오면 한줄이 제대로 지워진거고 0이면 안된거고 
		int result = sqlSession.delete("myBoard.deleteBoards", bNum);
		
		if(result ==1) {
			
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}

	public int update(Board board) {
		// 로직
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.update("myBoard.updateBoards", board);
		
		if(result ==1) {
			
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return result;
	}


//	public int update(String bNum) {
//		SqlSession sqlSession = 
//				MybatisConnectionFactory.getSqlSessionFactory().openSession();
//		// 업데이트로 하기 
//		int list = sqlSession.update("myBoard.updateBoards", bNum);
//		
//		if(list ==1) {
//			
//			sqlSession.commit();
//		} else {
//			sqlSession.rollback();
//		}
//		sqlSession.close();
//		
//		return list;
//	}
}
    