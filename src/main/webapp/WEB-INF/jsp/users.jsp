<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Users</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Operations</th>
		</tr>	
		<c:forEach items="${users}" var="user">
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

	<a href="adduser.html">Add New user</a>
	
	

</body>
</html>
