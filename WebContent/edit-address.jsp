<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
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
<h1>Edit Address</h1>
<form action = "editExistingAddressServlet" method="post">
<table>
	<tr>
		<td>Type: </td>
		<td>
			<select name="type" required="required" value="${addressToEdit.type}">
				<option value="Home">Home</option>
				<option value="Work">Work</option>
				<option value="School">School</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Street: </td>
		<td><input type ="text" name = "address" required="required" value="${addressToEdit.address}"></td>
	</tr>
	<tr>
		<td>City: </td>
		<td><input type = "text" name = "city" required="required" value="${addressToEdit.city}"></td>
	</tr>
	<tr>
		<td>State: </td>
		<td><input type = "text" name = "state" required="required" value="${addressToEdit.state}"></td>
	</tr>
	<tr>
		<td>ZIP Code: </td>
		<td><input type = "text" name = "zip" required="required" value="${addressToEdit.zip}"></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" name="id" value="${addressToEdit.addressId}">
			<input type="hidden" name="contactId" value="${contactToEdit.contactId}">
		</td>
		<td><input type = "submit" value="Edit Address"></td>
	</tr>
</table>
</form>
</body>
</html>