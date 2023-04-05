<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			$.ajax({
				url:"json1",
				dataType:"json",
				success: function(json){
					id=json.id
					pw=json.pw
					name=json.name
					tel=json.tel
					//$('#result').append(id+" "+pw+" "+name+" "+tel+"<br>")
					table = "<table><tr><td>항목명</td><td>값</td></tr>" + 
					"<tr><td>아이디</td><td>" + id +"</td></tr>" + 
					"<tr><td>패스워드</td><td>" + pw +"</td></tr>" + 
					"<tr><td>이름</td><td>" + name +"</td></tr>" + 
					"<tr><td>전화번호</td><td>" + tel +"</td></tr></table>"
					$('#result').append(table)
				}
				
			})
		})
		
		$('#b2').click(function() {
			$.ajax({
				url:"json2",
				dataType:"json",
				success: function(json){
					no=json.no
					writer=json.writer
					title=json.title
					content=json.content
					
					
					$('#result').append(no+" "+writer+" "+title+" "+content+"<br>")
				}
				
			})
		})
		
		$('#b3').click(function() {
			$.ajax({
				url: "json3",
				dataType : "json",
				success: function(json) {//[{}, {id: "", name: "", pw : "", tel: ""}]
					id1 = json[1].id
					name1 = json[1].name
					$('#result').append("json배열 중 2번째 것>> " + name1 + " " + id1 + "<br>")
					
				} //success
			}) //ajax
		})//b2
		$('#b4').click(function() {
			$.ajax({
				url: "json4",
				dataType : "json",
				success: function(json) {
					high1 = json[0].high
					low1 = json[0].low
					end1 = json[0].end
					
					high2 = json[1].high
					low2 = json[1].low
					end2 = json[1].end
					$('#result').append("어제 주가: " + high1 + " " + low1 + " " + end1 + "<br>")
					$('#result').append("오늘 주가: " + high2 + " " + low2 + " " + end2 + "<br>")
					
				} //success
			}) //ajax
		})//b4
		
	})
</script>
</head>
<body>
<button id="b1">컨트롤러에서 json 받아오기</button>
<button id="b2">컨트롤러에서 jsonArray 받아오기</button>
<button id="b3">컨트롤러에서 json3 받아오기</button>
<button id="b4">컨트롤러에서 jsonArray4 받아오기</button>
<hr color="red">
<div id="result"></div>
</body>
</html>