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
td{
	width:100px;
}
.down{
	background: lime;
}
</style>
</head>
<body>
	<h3>공연 리스트</h3>
	<table>
		<tr>
			<td class="top">번호</td>
			<td class="top">제목</td>
			<td class="top">장르</td>
			<td class="top">장소</td>
		</tr>
		<c:forEach items="${list}" var="bag">
			<tr>
				<!-- el 속성만 받아올 수 있는 표현식 -->
				<td class="down">${bag.no}</td>
				<td class="down"><a href="concertOne?no=${bag.no}">${bag.title}</a></td>
				<td class="down">${bag.genre}</td>
				<td class="down">${bag.place}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>