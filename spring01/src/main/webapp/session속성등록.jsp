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
	session.setAttribute("count", 0);
	session.setAttribute("user", "root");
%>

<hr>서버에 세션을 심음
<a href="session속성가져오기2.jsp">세션리스트 가져오기</a>
</body>
</html>