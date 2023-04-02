<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	오늘 조회수:<%=session.getAttribute("view")%><br>


	<%
		if (session.getAttribute("view") == null) {
			out.print("아무도 방문x");
		} else {
			out.print("방문횟수: " + session.getAttribute("view"));
		}
	%>
</body>
</html>