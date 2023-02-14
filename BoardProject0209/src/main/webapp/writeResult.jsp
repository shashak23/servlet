<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.vo.Member,board.vo.Board,java.util.List" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 얘는 정보를 가지고 오는 애고  -->

<% 
	Board board = (Board)(request.getAttribute("board"));
%>
	<button onclick="history.back()">뒤로가기</button>
	   <form >	
		<h1>고양이 게시글 세부정보</h1><br>
		<!-- 얘는 정보를 넣어준 애고 -->
		
			글번호:  <%= board.getBoardNum() %><br>
			제 목:  <%= board.getBoardTitle() %><br>
			작성자:  <%= board.getBoardAuthor() %><br>
			작성일:  <%= board.getBoardDate() %><br><br>
			내 용:  <%= board.getBoardContent() %>
		</form>
			  <form>
				<br><button type="submit" name="modify">수정</button></form>  
			  <form action="deleteservlet" method="post">	
				<button type="submit" name="delete">삭제</button>	</form>
				
		<br>댓글남기기
		<form>
			<br><textarea name="commentT" rows="2" cols="30" >
			</textarea>
		</form>
		<form>
		<button type="submit" name="commentInsert">등록</button>	</form>
		
</body>
</html>