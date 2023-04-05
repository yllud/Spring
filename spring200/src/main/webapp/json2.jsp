<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//스크릿트릿 
	JSONObject json = new JSONObject();
	json.put("name", "hong"); //{name : hong}
	json.put("age", 100);
	json.put("id", "apple");

	JSONObject json2 = new JSONObject();
	json2.put("name", "song");
	json2.put("age", 500);
	json2.put("id", "song");

	//out.print(json.toJSONString());

	JSONArray array = new JSONArray();
	array.add(json);
	array.add(json2);
%><%=array.toJSONString()%>
