<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/out.css">

<script type="text/javascript" src="resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() {
// 		document.write("body를 다 읽었엉")
// 		alert("body 다읽었엉")
	})
</script>
</head>
<body>
	<h3>회원가입 화면입니다.</h3>
	<hr color="red">
	<!-- <img src="resources/img/yes.jpg"> -->
	<form action="member_insert.jsp" method="get"> 
<!-- 		method="get" 생략가능	 -->
		아이디 : <input name="id" value="test2"><br> 
		패스워드 : <input name="pw" value="test2"><br> 
		이름 : <input name="name" value="test2"><br> 
		전화번호 : <input name="tel" value="test2"><br>
		<button type="submit">서버로 전송</button>
<!-- 	type="submit" 생략가능 -->
	</form>
</body>

</html>