<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(
			function() {
				$('#b1')
						.click(
								function() {
									$('#result').empty()
									$
											.ajax({
												url : "memberOne_json",
												data : {
													id : "apple"
												},
												dataType : "json",
												success : function(json) {
													id = json.id
													pw = json.pw
													name = json.name
													tel = json.tel
													//$('#result').append(no+" "+title+" "+writer+" "+content+"<br>")
													table = "<table><tr><td>항목명</td><td>값</td></tr>"
															+ "<tr><td>아이디</td><td>"
															+ id
															+ "</td></tr>"
															+ "<tr><td>패스워드</td><td>"
															+ pw
															+ "</td></tr>"
															+ "<tr><td>이름</td><td>"
															+ name
															+ "</td></tr>"
															+ "<tr><td>전화번호</td><td>"
															+ tel
															+ "</td></tr></table>"
													$('#result').append(table)

												}

											})
								})

				$('#b2').click(
						function() {
							$('#result').empty()
							$.ajax({
								url : "list_json",
								dataType : "json",
								success : function(json) {

									for (i = 0; i < json.length; i++) {
										no = json[i].id
										writer = json[i].pw
										title = json[i].name
										content = json[i].tel

										$('#result').append(
												no + " " + writer + " " + title
														+ " " + content
														+ "<br>")
									}
								}

							})
						})

				$('#b3')
						.click(
								function() {
									$('#result').empty()
									$
											.ajax({
												url : "list_json",
												dataType : "json",
												success : function(json) {
													table = "<table><tr><td> 아이디 </td><td> 비번 </td><td> 이름 </td><td> 번호 </td></tr>"
													//$('#result').append(table1)

													for (i = 0; i < json.length; i++) {
														id = json[i].id
														pw = json[i].pw
														name = json[i].name
														tel = json[i].tel
														table += "<tr><td>"
																+ id
																+ "</td><td>"
																+ pw
																+ "</td><td>"
																+ name
																+ "</td><td>"
																+ tel
																+ "</td></tr>"
													}
													table += "</table>"

													$('#result').append(table)
												}

											})
								})

				$('#b4').click(function() {
					$.ajax({
						url : "json4",
						dataType : "json",
						success : function(json) {

						} //success
					}) //ajax
				})//b4

			})
</script>
</head>
<body>
	<button id="b1">아이디 apple 받아오기</button>
	<button id="b2">모든 멤버 list 받아오기</button>
	<button id="b3">모든 멤버 list 테이블로 받아오기</button>
	<!-- 	<button id="b4">컨트롤러에서 jsonArray4 받아오기</button> -->
	<hr color="red">
	<div id="result"></div>



	
</body>
</html>
