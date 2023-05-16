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

<jsp:useBean id="bean" scope="request" class="in.co.rays.been.UserBean"></jsp:useBean>

<jsp:setProperty name="bean" property="firstName" value="rahul"></jsp:setProperty>

Name  <jsp:getProperty property="firstName" name="bean"/>

<%if(bean!=null){ %>
<%=bean.getFirstName() %>

<%} %>

</body>  
</html>