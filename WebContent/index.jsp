<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Details</title>
	</head>
	<body>
		<form method="post" name="userForm" id="userForm" action="SaveUserDetails">
			<table>
				<tr>
					<td>Name : <input type="text" id="userName" name="userName" value=""></td>
				</tr>
				<tr>
					<td>Phone Number : <input type="text" id="phoneNumber" name="phoneNumber" value=""></td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="saveUser" class="saveUser" value="Submit">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>