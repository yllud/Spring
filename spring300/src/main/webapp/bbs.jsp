<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판추가 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_insert" method="get">
		title : <input
			name="title" value="a"><br> writer : <input name="writer"
			value="park"><br> content : <input name="content" value="내요오옹"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시판수정 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_update" method="get">
		no : <input name="no" value="2"><br> content : <input
			name="content" value="내용!"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시판탈퇴 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_delete" method="get">
		no : <input name="no"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시판검색 화면입니다.</h3>
	<hr color="red">
	<form action="bbs_one" method="get">
		no : <input name="no"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

<!-- 	<h3>게시판리스트 화면입니다.</h3> -->
<!-- 	<hr color="red"> -->
<!-- 	<form action="bbs_list" method="get"> -->
<!-- 		<button type="submit">리스트 보기</button> -->
<!-- 	</form> -->
<!-- 	<hr color="red"> -->
</body>
</html>