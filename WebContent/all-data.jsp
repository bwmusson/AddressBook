<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book List</title>
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
      <a href="index.html">Add New</a>
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
      <a href="viewAllAddressServlet">View All</a>
      <a href="addAddressForContactsServlet">Add New</a>
    </div>
  </div>
  <a href="viewAllDataServlet">View All Data</a>
</div>
<h1>All Data</h1>
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
</body>
</html>