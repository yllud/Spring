
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.4.js"></script>

<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			content = $('#reply').val()
			writer = "apple"
				
				$.ajax({
					url : "reply_insert",
					data : {
						bbsno: ${bag.no},
						content : content,
						writer : writer
					},
					success: function(x) {
						console.log('성공')
						alert('성공!')
						$('#result').append(writer+ ": "+ content+ "<br>")
						$('#reply').val('') 
					}
				})
		})
	})
</script>


<style type="text/css">
body {
	background: yellow;
}
</style>
</head>
<body>
	<h3>게시판검색</h3>
	번호: ${bag.no}
	<br> 제목: ${bag.title}
	<br> 작성자: ${bag.writer}
	<br> 내용: ${bag.content}
	<br>

	<hr color="red">
	댓글달기
	<input id="reply">
	<button id="b1">댓글추가</button>

	<hr color="red">
	<h3>댓글</h3>
	<c:forEach items="${list}" var="x">
${x.writer}: ${x.content}<br>
	</c:forEach>
	<div id="result" style="background: yellow"></div>
</body>
</html>