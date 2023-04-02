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
	//1. 쿠키생성
	
	Cookie c1=new Cookie("name","hong");
	Cookie c2=new Cookie("age","100");
	
	//2 쿠키를 서버에서=>브라우저로 보낸다
	response.addCookie(c1);
	response.addCookie(c2);

%>

<hr>쿠키심었음<br>
<a href="cookie가져오기.jsp">쿠키리스트가지고오기</a>

</body>

</html>