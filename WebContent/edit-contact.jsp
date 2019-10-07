<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
</head>
<body>
	<form action="editContactServlet" method="post">
		First Name: <input type="text" name="firstName"
			value="${contactToEdit.firstName}"> 
		Last Name: <input type="text" name="lastName"
		 value="${contactToEdit.lastName}">
		Date of Birth: <input type="text" name="month" placeholder="mm"
			size="4" value="${contactToEdit.dob.getMonthValue()}"> 
			<input type="text" name="day" placeholder="dd" size="4"
			value="${contactToEdit.dob.getDayOfMonth()}">, 
			<input type="text" name="year" placeholder="yyyy" size="4"
			value="${contactToEdit.dob.getYear()}"> 
		<input type="hidden" name="id" value="${contactToEdit.id}"> 
		<input type="submit" value="Save Edited Contact">
	</form>
</body>
</html>