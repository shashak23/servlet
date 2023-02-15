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
<% 
/* System.out.println(request.getQueryString());
 */	
 	String bNum = request.getParameter("bNum");
	String bTitle = request.getParameter("bTitle");
%>
	<button onclick="history.back()">뒤로가기</button>

	<h1>고양이 게시판 자유글 수정하기</h1>
		<h3> 내용수정하기 </h3>
		<!-- 제목은 그대로 가고  -->
		글번호:  <%= bNum %><br>
		제목 : <%= bTitle %><br><br>
		
		<!-- 내용만 바꾸는 거 하기 -->
		<form action="modify?bNum=<%= bNum %>" method="post">
			내용 : <br><textarea rows="10" cols="30" name="boardC"></textarea>
			<input type="hidden" name="bNum" >
			<br><br>
			<br><br>
			<button type="submit">수정 완료</button>
		</form>				
</body>
</html>