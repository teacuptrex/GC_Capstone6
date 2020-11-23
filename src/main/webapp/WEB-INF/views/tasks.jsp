<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
</head>
<body>

<h1>Tasks</h1>
<h2>Create Task</h2>
<form method="post" action="/addtask/${ userid }">
	
		Description: <input type="text" name="description" /><br />
		
		Due Date: <input type="text" name="duedate" /><br />
		
		Complete? : <input type="checkbox" name="complete" /><br />
		<input type="submit"/>
				
	</form>
	<table>
		<thead>
			<tr>
				<th>Description | </th>
				<th>Due Date | </th>
				<th>Complete? | </th>
				<th>Delete</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="task" items="${ tasks }">
				<tr>
					<td>${ task.description }</td>
					<td><fmt:formatDate value="${ task.duedate }" dateStyle="medium" /> </td>
					<td><form method="post" action="/update/${ task.getUser().getId() }/${ task.id }"> <input type="checkbox" name="markcomplete" checked="${ task.complete }" /> <input type="submit" /></form></td>
					<td><form method="post" action="/delete/${ task.getUser().getId() }/${ task.id }"><input type="checkbox" name="delete" /> <input type="submit" /></form></td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
	
	
	
</body>
</html>