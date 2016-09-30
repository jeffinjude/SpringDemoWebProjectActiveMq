<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.springdemo.models.UserDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
</head>
<body>
	<b>Successfully persisted the data.</b>
	<br>
	<b>User Details Table:</b>
	<table>
		<tr class="headingTr">
			<td><b>user_id</b></td>
			<td>&nbsp;</td>
			<td><b>user_name</b></td>
			<td>&nbsp;</td>
			<td><b>phone_number</b></td>
		</tr>
		<%
			List<UserDetails> userDetails = (List<UserDetails>)request.getAttribute("userDetails");
			if(!userDetails.isEmpty())
			{
				for(UserDetails data : userDetails) {
		%>
		<tr>
			<td><%=data.getUserId()%></td>
			<td>&nbsp;</td>
			<td><%=data.getUserName()%></td>
			<td>&nbsp;</td>
			<td><%=data.getPhoneNumber()%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
</body>
</html>