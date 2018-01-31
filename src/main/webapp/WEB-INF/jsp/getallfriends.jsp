<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Operations</th>
		</tr>
		<c:forEach items="${friendList}" var="friendlist">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.email}</td>
				<td>${user.phone}</td>
				<td><a href="edituser.html?id=${user.id}">Edit User</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>