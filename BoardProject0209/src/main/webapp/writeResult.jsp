<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.vo.Member,board.vo.Board,comment.vo.Comment,java.util.List" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" 
    integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" 
    crossorigin="anonymous">
</script>
</head>
<body>
<!-- 얘는 정보를 가지고 오는 애고  -->
	<h3><%=((Member)session.getAttribute("member")).getMemberName()%>님 로그인중입니다. </h3>
	<form action="logout">
		<button type="submit" name="logout">로그아웃</button>
	</form>
	<!-- 서블렛에서 어떻게 처리를 한담? 이건 좀 생각해봐야겠따 -->


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
				내 용:  <%= board.getBoardContent() %><br><br>
		</form>
			<form action="modifyJsp" method="post">
					<br><button type="submit" name="modify">수정</button>
					<input type="hidden" name="bNum" value="<%= board.getBoardNum() %>">
					<input type="hidden" name="bTitle" value="<%= board.getBoardTitle() %>">
			</form> 
					<!-- get방식에서 데이터를 넘겨주는 방식인데 post에서도 가능한 과정이다 --> 
			 <form action="deleteservlet?bNum=<%= board.getBoardNum() %>" method="post">	
					<button type="submit" name="delete">삭제</button>
		   	 </form><br>
			<table id="replyList"></table>

		 		<textarea id="commentT" rows="3" cols="30" placeholder="댓글달기"></textarea>
	              <button onclick="commentWrite(<%= board.getBoardNum() %>)">등록</button>
				  <button>수정</button>
		          <button onclick="commentDelete()">삭제</button>

		
</body>
<script>
function commentWrite(boardNum) {
	let commentText = $('#commentT').val();
	
	$.ajax({
		url: 'commentwrite',
		async: true,
		method: 'POST',
		data: {
			'commentT' : commentText,
			'bNum' : boardNum
		},
		dataType: 'json',
		success: function(data) {
			console.log(data);
			 $('#replyList').empty();
			$.each(data, function(idx, item){
				let head = $("<tr></tr>");    
                let commentContent = $("<td class='content'></td>").text(item.commentContent);  
                let commentAuthor = $("<td></td>").text(item.commentAuthor);  
                let boardNum = $("<td></td>").text(item.boardNum);  
                head.append(commentContent);
                head.append(commentAuthor);
                head.append(boardNum);
                
                $('#replyList').append(head);
			})
			$('#commentT').val('');
		} ,
		error: function(){
			
		}
		
    }); 
}

</script>
</html>