<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errmsg");
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
		<legend>addEmp</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Id</td>
					<td>:</td>
					<td><input type="text" name="id"></td>


				</tr>
				<tr>
					<td>name</td>
					<td>:</td>
					<td><input type="text" name="name"></td>


				</tr>
				<tr>
					<td>DOB</td>
					<td>:</td>
					<td><input type="date" name="birthdate"></td>


				</tr>
				<tr>
					<td>password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>


				</tr>

				<tr>

					<td><input type="submit" value="addEmp"></td>


				</tr>



			</table>


		</form>

	</fieldset>

</body>
</html>