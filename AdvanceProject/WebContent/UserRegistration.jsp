<%@page import="in.co.rays.been.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>

		<form action="UserCtl" method="post">

			<table>
				<%
					UserBean bean = (UserBean) request.getAttribute("bean");
				%>

				<%
					if (bean != null) {
				%>
				<tr>
					<td><input type="hidden" name="id" value="<%=bean.getId() %>"></td>
				</tr>

				<tr>
					<th>First Name :</th>

					<td><input type="text" name="fname"
						value=<%=bean.getFirstName()%> /></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lname"
						value=<%=bean.getLastName()%> /></td>
				</tr>
				<tr>
					<th>LoginId :</th>
					<td><input type="text" name="login"
						value=<%=bean.getLoginId()%> /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="text" name="pass"
						value=<%=bean.getPassword()%> /></td>
				</tr>
				<tr>
					<th>Mobile no :</th>
					<td><input type="text" name="no"
						value=<%=bean.getMobileNumber()%> /></td>

				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Update" name="operation" />
				</tr>


				<%
					} else {
				%>
				<tr>
					<th>First Name :</th>

					<td><input type="text" name="fname"  /></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lname"  /></td>
				</tr>
				<tr>
					<th>LoginId :</th>
					<td><input type="text" name="login"  /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="text" name="pass"  /></td>
				</tr>
				<tr>
					<th>Mobile no :</th>
					<td><input type="text" name="no"  /></td>

				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Add" name="operation" />
				</tr>



				<%
					}
				%>


			</table>
		</form>
	</center>

</body>
</html>