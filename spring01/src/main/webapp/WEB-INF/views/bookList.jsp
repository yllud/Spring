<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: yellow;
}

td {
	width: 150px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>url</td>
			<td>img</td>
		</tr>
		<c:forEach items="${list}" var="bag">
			<tr>
				<td>${bag.id}</td>
				<td><a href="bookOne?id=${bag.id}"> ${bag.name}</a></td>
				<td><a href="http://${bag.url}"> ${bag.url}</a></td>
				<td><img alt="" src="resources/img/${bag.img}" width="200"
					height="200"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>