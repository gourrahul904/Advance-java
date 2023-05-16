	
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.been.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="UserListCtl.do" method="post">


		<%
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
		%>


		<table>
			<tr>
				<td><a href="UserListCtl"></a>Name:<input type="text"
					name="name"> <input type="submit" value="search"
					name="operation"></td>
			</tr>
		</table>


		<table border="2" cellspacing="2" cellpadding="2"
			style="width: 1300px" bgcolor="equa">
			<tr style="text-align: center">
				<th>ID</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>MobileNo</th>
				<th>Edit</th>
			</tr>

			<%
				while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
			%>
			<tr style="text-align: center">
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getMobileNumber()%></td>
				<td><a href="UserCtl?id=<%=bean.getId()%>"> Edit</a></td>
			</tr>
			<%
				}
			%>
x`
			
		</table>
	</form>
	<%@ include file="Footer.jsp"%>


</body>
</html>