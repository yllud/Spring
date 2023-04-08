<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>공연추가 화면입니다.</h3>
	<hr color="red">
	<form action="concertInsert" method="get">
		title : <input name="title"><br> genre : <input
			name="genre"><br> place : <input name="place"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>공연수정 화면입니다.</h3>
	<hr color="red">
	<form action="concertUpdate" method="get">
		no : <input name="no"><br> place : <input name="place"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>공연삭제 화면입니다.</h3>
	<hr color="red">
	<form action="concertDelete" method="get">
		no : <input name="no"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>공연검색 화면입니다.</h3>
	<hr color="red">
	<form action="concertOne" method="get">
		no : <input name="no"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>공연리스트 화면입니다.</h3>
	<hr color="red">
	<form action="concertList" method="get">
		<button type="submit">리스트 보기</button>
	</form>
	<hr color="red">
</body>
</html>