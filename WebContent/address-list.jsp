<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book</title>
</head>
<body>
<body>
<form method = "post" action = "addressNavigationServlet">
<table>
<c:forEach items="${requestScope.allContacts}" var="currentcontact">
<tr>
   <td><input type="radio" name="id" value="${currentcontact.contactId}"></td>
   <td><h4>${currentcontact.firstName} ${currentcontact.lastName}</h4></td></tr>
      <c:forEach var = "listVal" items = "${currentcontact.contactAddresses}">
            <tr><td></td><td colspan="3">
                ${listVal.type}: ${listVal.address}, ${listVal.city}, ${listVal.state}, ${listVal.zip}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="addAddressForContactsServlet">Create a new address</a>
<a href="index.html">Insert a new contact</a>
</body>
</body>
</html>