<!DOCTYPE html>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Friend</title>
</head>
<body>

	<form:form modelAttribute="friend">
		<label>Friend Email<form:input path="email" /></label>
	</form:form>
</body>
</html>