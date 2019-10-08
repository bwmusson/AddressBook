<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book List</title>
<style>
	table {
		padding: 5px;
		border-collapse: collapse;
	}
	td, th {
		border: 1px solid #ddd;
  		padding: 8px;
  		text-align: center;
	}
	tr:nth-child(even){
		background-color: #f2f2f2;
	}
	th {
		padding-top: 12px;
 	 	padding-bottom: 12px;
 	 	font-style: bold;
 	}
	
</style>
</head>
<body>
<table>
<tr>
 <th>Name</th>
 <th>Date of Birth</th>
 <th> </th>
 <th> </th>
</tr>
<c:forEach items="${requestScope.allContacts}" var="currentcontact">
 <tr>
   <td>${currentcontact.firstName} ${currentcontact.lastName}</td>
   <td>${currentcontact.dob}</td>
   <td> </td>
   <td> </td>
 </tr>
 <c:forEach items="${currentcontact.contactAddresses}" var="currentAddress">
 <tr>
  <td></td>
  <td></td>
  <td>${currentAddress.type} Address:</td>
  <td>${currentAddress.address}, ${currentAddress.city}, ${currentAddress.state} ${currentAddress.zip}</td>
  <td><a href="addressNavigationServlet?doThisToItem=delete&id=${currentAddress.addressId}&contId=${currentcontact.contactId}">Delete</a></td>
 </tr>
 </c:forEach>
  <c:forEach items="${currentcontact.contactPhones}" var="currentPhone">
 <tr>
  <td></td>
  <td></td>
  <td>${currentPhone.type} Phone:</td>
  <td>${currentPhone.number}</td>
  <td><a href="phoneNavigationServlet?doThisToItem=delete&id=${currentPhone.phoneId}&contId=${currentcontact.contactId}">Delete</a></td>
 </tr>
 </c:forEach>
</c:forEach>
</table>
<br>
<a href="index.html">Go Back Home</a>
</body>
</html>