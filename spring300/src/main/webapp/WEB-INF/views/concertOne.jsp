<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background: yellow;
}

</style>
</head>
<body>
<h3>공연 검색</h3>
공연번호: ${bag.no}<br>
제목: ${bag.title}<br>
장르: ${bag.genre}<br>
장소: ${bag.place}<br>

</body>
</html>