package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import comment.vo.Comment;
import common.mybatis.MybatisConnectionFactory;

public class CommentDao {
//
//	public List<Comment> selectAll() {
//		// TODO Auto-generated method stub
//		SqlSession sqlSession = 
//				MybatisConnectionFactory.getSqlSessionFactory().openSession();
//		List<Comment> result = sqlSession.selectList("myComment.allCommnet");
//		
//		sqlSession.close();
//
//		return result;
//	}

	public int insert(Comment comment) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.insert("myComment.insertComment", comment);
	
		if(result ==1) {
			
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		  
		return result;
	}

	public List<Comment> selectAll(int boardNum) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = 
				MybatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Comment> result = sqlSession.selectList("myComment.allCommnet", boardNum);
	
		sqlSession.close();
		  
		return result;
	}


}
