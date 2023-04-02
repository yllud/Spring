<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

로그인한 사람 id: <%=session.getAttribute("user") %><br>
오늘 방문횟수 <%=session.getAttribute("count") %>
<% 
int count=(int)session.getAttribute("count");
count++;
session.setAttribute("count", count);

%>
<br>
현재 카운트 ${count}
</body>
</html>