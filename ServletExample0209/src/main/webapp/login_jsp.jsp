<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String name = "홍길동";   // 지역변수 
		for(int i=0; i<5; i++){
			
	%>
		<h1>반복되요</h1>
	<% 
			}
	%>
	이것은 소리없는 아우성
	사용자의 이름은 : <%= name %> 입니다	
</body>
</html>