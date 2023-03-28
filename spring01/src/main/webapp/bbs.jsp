<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_insert" method="get">
		id : <input name="no" value="1"><br> pw : <input
			name="title" value="a"><br> name : <input name="writer"
			value="park"><br> tel : <input name="content" value="내요오옹"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시판수정 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_update" method="get">
		id : <input name="no" value="2"><br> content : <input
			name="content" value="내용!"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시판탈퇴 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_delete" method="get">
		id : <input name="no" value="1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시판검색 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_one" method="get">
		id : <input name="no" value="1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<button type="button">먹통버튼(아무 기능이 없음)</button>
</body>
</html>