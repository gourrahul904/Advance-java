<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String fname = request.getParameter("fname");

		String lname = request.getParameter("lname");

		String login = request.getParameter("login");

		String pass = request.getParameter("pass");
	%>
	<%=fname%>
	<%=lname%>
	<%=login%>
	<%=pass%>

</body>
</html>