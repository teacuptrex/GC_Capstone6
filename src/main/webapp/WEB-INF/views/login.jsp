<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1> Please Login or Create an Account:</h1>

Login:	<form method="post" action="/login">
	
		Email: <input type="text" name="email" /><br />
		
		Password: <input type="password" name="password" /><br />
		<input type="submit"/>
			
	
	</form>

	OR Create an Account:
	<form method="post" action="/register">
	
		Username: <input type="text" name="email" /><br />
		
		Password: <input type="password" name="password" /><br />
		
		<input type="submit"/>
			
	
	</form>

</body>
</html>