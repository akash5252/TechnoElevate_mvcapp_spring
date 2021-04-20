<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String msg = (String) request.getAttribute("msg");
String empname=(String)request.getAttribute("cookie");
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
	<h1><%=msg %></h1>
	<%
	}
	%>
	<%if(empname!=null && !empname.isEmpty()){ %>
	<h1>EMP NAME :</h1><h1><%=empname %></h1>
	<%} %>
	<h1>
		<a href="./createCookie">create cookie</a>
	</h1>
	<h1>
		<a href="./showCookies">show cookie</a>
	</h1>
</body>
</html>