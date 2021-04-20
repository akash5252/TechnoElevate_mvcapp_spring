<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="empLogin.jsp" %>
    <%String msg=(String)request.getAttribute("err"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="color: red;font-size: 200%">
<% if(msg!=null && !msg.isEmpty()) {%>
<%=msg %>
<%} %>
</body>
</html>