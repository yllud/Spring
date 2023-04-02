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
// 	Cookie c3=new Cookie("선호하는카테고리","운동");
// 	Cookie c4=new Cookie("선호하는운동종류","축구");
	
	Cookie c1=new Cookie("category","exercise");
	Cookie c2=new Cookie("exercise","soccer");
	
	response.addCookie(c1);
	response.addCookie(c2);
%>

<hr color="red">
<a href="page02.jsp">쿠키 보러가기</a>




</body>
</html>