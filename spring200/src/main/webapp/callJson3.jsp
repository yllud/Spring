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
				url:"bbsOne_json",
				data:{
					no:1
				},
				dataType:"json",
				success: function(json){
					no=json.no
					title=json.title
					writer=json.writer
					content=json.content
					$('#result').append(no+" "+title+" "+writer+" "+content+"<br>")
					
				}
				
			})
		})
		
		$('#b2').click(function() {
			$.ajax({
				url:"bbs_list_json",
				dataType:"json",
				success: function(json){
					no=json[1].no
					writer=json[1].writer
					title=json[1].title
					content=json[1].content
					
					
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
<button id="b1">컨트롤러에서 bbs json 받아오기</button>
<button id="b2">컨트롤러에서 bbs jsonArray 두번째 불러오기</button>
<button id="b3">컨트롤러에서 json3 받아오기</button>
<button id="b4">컨트롤러에서 jsonArray4 받아오기</button>
<hr color="red">
<div id="result"></div>
</body>
</html>