<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts List</title>
<link rel="stylesheet" href="site.css">
</head>
<body>
<div class="navbar">
  <a href="index.html">Home</a>
  <div class="dropdown">
    <button class="dropbtn">Contacts
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="viewAllContactsServlet">View All</a>
      <a href="#">Add New</a>
    </div>
   </div>
   <div class="dropdown">
    <button class="dropbtn">Addresses
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="viewAllAddressServlet">View All</a>
      <a href="addAddressForContactsServlet">Add New</a>
    </div>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Phones
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="viewAllPhonesServlet">View All</a>
      <a href="addAddressForPhonesServlet">Add New</a>
    </div>
  </div>
  <a href="viewAllDataServlet">View All Data</a>
</div>
<h1>All Contacts</h1>
<form method = "post" action = "contactNavigationServlet">
<table>
<tr>
<th></th>
<th>First Name</th>
<th>Last Name</th>
<th>Date of Birth</th>
</tr>
<c:forEach items="${requestScope.allContacts}" var="currentcontact">
<tr>
   <td><input type="radio" name="id" value="${currentcontact.contactId}"></td>
   <td>${currentcontact.firstName}</td>
   <td>${currentcontact.lastName}</td>
   <td>${currentcontact.dob}</td>
   </tr>
</c:forEach>
<tr>
<td></td>
<td><input type = "submit" value = "Edit" name="doThisToItem"></td>
<td><input type = "submit" value = "Delete" name="doThisToItem"></td>
<td><input type="submit" value = "Add New" name = "doThisToItem"></td>
</tr>
</table>
</form>
</body>
</html>