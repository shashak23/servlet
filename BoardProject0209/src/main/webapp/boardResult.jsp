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
	<h1><% ((Board)session.getAttribute("board")).getBoardTitle()  %></h1>
<form action="Result.html"></form>
	<table>
		<thead>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>내용</th>
			<th>댓글수</th>
			<th>좋아요</th>
		</thead>
			<tbody>
				
				 <%
						 List<Board> list = (List<Board>)request.getAttribute("boardList");
						 		    
						 		    for(Board board: list)  {
						 %>
				
						<tr>
							<td><%= board.getBoardNum() %></td>
							<td><%= board.getBoardTitle() %></a></td>
							<td><%= board.getBoardAuthor() %></td>
							<td><%= board.getBoardDate() %></td>
							<td><%= board.getBoardContent() %></td>
							<td></td>
							<td><%= board.getboardLike() %></td>
						</tr>
				<%
				    } 
				%>	
			</tbody>	
	</table>

</body>
</html>