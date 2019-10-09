<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
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
<h1>Edit Contact</h1>
<form action="editContactServlet" method="post">
<table>
	<tr>
		<td>First Name: </td>
		<td><input type="text" name="firstName" value="${contactToEdit.firstName}"></td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><input type="text" name="lastName" value="${contactToEdit.lastName}"></td>
	</tr>
	<tr>
		<td>Date of Birth: </td>
		<td>
			<input type="text" name="month" placeholder="mm" size="4" value="${contactToEdit.dob.getMonthValue()}"> / 
			<input type="text" name="day" placeholder="dd" size="4" value="${contactToEdit.dob.getDayOfMonth()}"> / 
			<input type="text" name="year" placeholder="yyyy" size="4" value="${contactToEdit.dob.getYear()}">
		</td>
	</tr>
	<tr>
		<td><input type="hidden" name="id" value="${contactToEdit.contactId}"></td>
		<td><input type="submit" value="Save Edited Contact"></td>
	</tr>
</table>	
</form>
</body>
</html>