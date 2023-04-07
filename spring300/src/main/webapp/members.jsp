<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <%if(session.getAttribute("id")==null){ %> --%>
	<h3>회원가입 화면입니다.</h3>
	<hr color="red">
	<form action="insert" method="get">
		id : <input name="id"><br> pw : <input
			name="pw"><br> name : <input name="name"
			><br> tel : <input name="tel"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">
<%-- <%} else{ %> --%>
	<h3>회원수정 화면입니다.</h3>
	<hr color="red">
	<form action="update" method="get">
		id : <input name="id" value="${id}"><br> tel : <input
			name="tel"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>회원탈퇴 화면입니다.</h3>
	<hr color="red">
	<form action="delete" method="get">
		id : <input name="id" value="${id}"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">
<%-- <%} %> --%>
	<h3>회원검색 화면입니다.</h3>
	<hr color="red">
	<form action="one" method="get">
		id : <input name="id"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>로그인 화면입니다.</h3>
	<hr color="red">
	<form action="login" method="get">
		id : <input name="id" value="apple"><br>
		pw : <input name="pw" value="apple"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">
	
	<h3>회원리스트 화면입니다.</h3>
	<hr color="red">
	<form action="list" method="get">
		<button type="submit">리스트보기</button>
	</form>
	<hr color="red">

</body>
</html>