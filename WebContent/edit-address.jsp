<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
</head>
<body>
<form action = "editExistingListServlet" method="post">
Address Type: <input type ="text" name = "type" value="${addressToEdit.type}"><br />
Street address: <input type ="text" name = "address" value="${addressToEdit.address}"><br />
City: <input type ="text" name = "city" value="${addressToEdit.city}"> State:<input type ="text" name = "state" value="${addressToEdit.state}"> ZIP Code:<input type ="text" name = "zip" value="${addressToEdit.zip}"><br />
<br />
<input type = "submit" value="Edit contact and Edit address">
</form>
<a href = "index.html">Go to add new contact instead.</a>
</body>
</html>