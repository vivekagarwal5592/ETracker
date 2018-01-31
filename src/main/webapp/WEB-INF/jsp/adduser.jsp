<!DOCTYPE html>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="user">
<label>Username:<form:input  path="username" /><form:errors path="username" /><br/></label>
<label>Password:<form:input  path= "password" /><form:errors path="password" /><br/></label>
<label>Phone:<form:input path ="phone" /><br/></label>
<label>Email:<form:input path= "email" /></label>
<input type="submit" value="Register"/>
</form:form>
</body>
</html>