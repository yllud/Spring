<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>북마크 화면</h3>
	<hr color="red">
	<form action="bookInsert.multi" method="get">
<!-- 		id : <input name="id" value="apple"><br>  -->
		name : <input name="name" value="ahn"><br>
		url : <input name="url" value=".com"><br> 
		img : <input name="img" value="0.jpg"><br>
		<button type="submit">서버로 전송</button>
	</form>
	
	
	<hr color="red">
		<h3>북마크 검색 화면입니다.</h3>
	<hr color="red">
	<form action="bookOne" method="get">
		id : <input name="id"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">
	
	<hr color="red">
		<h3>북마크 리스트 화면입니다.</h3>
	<hr color="red">
	<form action="bookList" method="get">
		<button type="submit">리스트보기</button>
	</form>
	<hr color="red">




	
</body>
</html>