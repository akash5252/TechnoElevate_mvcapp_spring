<%@page import="com.te.springmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="header.jsp" %>

<%
String msg = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errmsg");
int id = (int) request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1><%=msg%></h1>
	<%
	}
	%>
	<%
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<h1><%=errmsg%></h1>
	<%
	}
	%>
	<fieldset>
		<legend>Update employe details</legend>
		<form action="./update" method="post">
			<label>Id:<%=id%></label>
			<input hidden="" type="text" name="id" value="<%=id%>" required><br>
			<label>Name :</label><input type="text" name="name" required><br>
			<br> <label>BirdthDate :</label><input type="Date"
				name="birthdate"><br> <br> <label>
				Password :</label> <input type="password" name="password"><br>
			<br> <input type="submit" value="update">


		</form>
	</fieldset>
</body>
</html>