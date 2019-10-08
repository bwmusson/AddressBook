<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new address</title>
</head>
<body>
<form action = "createNewAddressServlet" method="post">
Address Type: <input type ="text" name = "type"><br />
Street address: <input type ="text" name = "address"><br />
City: <input type = "text" name = "city"> State:<input type = "text" name = "state"> ZIP Code:<input type = "text" name = "zip"><br />

Available Contacts:<br />

<select name="allContactsToAdd" multiple size="6">
<c:forEach items="${requestScope.allContacts}" var="currentcontact">
   <option value = "${currentcontact.contactId}">${currentcontact.firstName} ${currentcontact.lastName}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Contacts and Add Address">
</form>
<a href = "index.html">Go to add new contacts instead</a>
</body>
</html>