<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	
		
			<a href="MyJsp.jsp">Simple Link</a>
		
		
		
		<%
			String enUrl = response.encodeURL("");
		%>
		<a href="<%=enUrl%>">Encoded Link</a>
		<a href="Welcome.jsp?jsessionid=<%=session.getId()%>">simple link</a>
		
		

		<form action="" method="get">
			<input type="hidden" name="jsessionid" value="<%=session.getId()%>">

			<input type="text" name="n"> <input type="submit">
		</form>

</body>
</html>