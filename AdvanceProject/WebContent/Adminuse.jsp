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

		String sname = request.getParameter("sname");
		String mo = request.getParameter("mo");
		String add = request.getParameter("add");
	%>

	<%=fname%>
	<%=sname%>
	<%=mo%>
	<%=add%>

</body>
</html>