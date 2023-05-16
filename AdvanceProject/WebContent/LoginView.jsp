f<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="Header.jsp"%>


	<center>
		<form action="LoginCtl" method="post">
			<%
				String msg = (String) request.getAttribute("msg");
				String uri = (String) request.getAttribute("uri");
				String succ = (String) request.getAttribute("success");
				String log = (String) request.getAttribute("log");
				String pass = (String) request.getAttribute("pass");
		%>					
			<% 	if (msg != null) {
			%>
			<h3>
				<%=msg%>
			</h3>

			<%
				} else {
			%>
			<%
				}
			%>
			<table>

				<td><input type="hidden" name="uri" value="<%=uri%>"></td>
				<tr>
					<h1>
						<font color="red"> Login<font>
					</h1>
				
						<%
							if (succ != null) {
						%>

						<h3><%=succ%></h3>
								<%
									} else {
								%>


								<%
									}
								%>
							
				
				</tr>

				<tr>
					<th>LoginId :</th>
					<td><input type="text" name="login" /></td>

					<%
						if (log != null) {
					%>
					<%=log%>

					<%
						} else {
					%>

					<%
						}
					%>
				</tr>
				
				<tr>
					<th>Password :</th>
					<td><input type="text" name="pass" /></td>


					<%
						if (pass != null) {
					%>
					<%=pass%>

					<%
						} else {
					%>

					<%
						}
					%>

				</tr>

				<tr>
					
					<th></th>
					<td><a href="LoginCtl"><input type="submit" value="SignIn"
							name="operation" /></a> <a href="LoginCtl"><input type="submit"
							value="SignUp" name="operation" /></a></td>
				</tr>

				<%
					String name = (String) request.getAttribute("name");
				%>
				<%
					if (name != null) {
				%><h3>
					<%=name%>
				</h3>

				


				<%
					}
				%>



			</table>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br>
			<hr>
			<%@ include file="Footer.jsp"%>
		</form>
	
	</center>

</body>
</html>