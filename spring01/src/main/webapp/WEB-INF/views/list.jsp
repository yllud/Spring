<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: yellow;
}
</style>
</head>
<body>
	<c:forEach items="${list}" var="bag">
	아이디: ${bag.id}
	<br> 패스워드: ${bag.pw}
	<br> 이름: ${bag.name}
	<br> 전화번호: ${bag.tel}
	<br><br>
	</c:forEach>
</body>
</html>