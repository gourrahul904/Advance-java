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
		String fname = (String) session.getAttribute("fname");
	%>



	<table width="100%">


		<tr>
			<td>
				<%
					if (fname != null) {
				%> <a href="LoginCtl?operation=logout">Logout</a>

				<h3>
					Hi,<%=fname%>
				</h3> <%
 	} else {
 %>
				<h3>Hi,Guest</h3> <%
 	}
 %>
			
			<td width="90%"></td>
			<td rowspan="2"><img src="img/logo.png" height="100" /></td>
		<tr>


		</tr>
		<td>
			<%
				if (fname != null) {
			%>
		
		<td colspan="2"><a href="UserCtl"> AddUser</a> | <a
			href="UserListCtl.do">AddList</a></td>
		<%
			}
		%>
		</tr>
	</table>


	<hr>



</body>
</html>