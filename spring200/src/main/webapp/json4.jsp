<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//스크릿트릿 
	JSONObject json = new JSONObject();
	json.put("high", "10000");
	json.put("low", "8000");
	json.put("end", "9000");

	//out.print(json.toJSONString());

	JSONObject json2 = new JSONObject();
	json2.put("high", "9000");
	json2.put("low", "70000");
	json2.put("end", "8000");

	JSONArray array = new JSONArray();
	array.add(json);
	array.add(json2);
%><%=array.toJSONString()%>