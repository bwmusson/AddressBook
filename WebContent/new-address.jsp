<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new address</title>
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
<h1>Add New Address</h1>
<form action = "createNewAddressServlet" method="post">
<table>
	<tr>
		<td>Type: </td>
		<td>
			<select name="type" required="required">
				<option value="Home">Home</option>
				<option value="Work">Work</option>
				<option value="School">School</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Street: </td>
		<td><input type ="text" name = "address" required="required"></td>
	</tr>
	<tr>
		<td>City: </td>
		<td><input type = "text" name = "city" required="required"></td>
	</tr>
	<tr>
		<td>State: </td>
		<td><input type = "text" name = "state" required="required"></td>
	</tr>
	<tr>
		<td>ZIP Code: </td>
		<td><input type = "text" name = "zip" required="required"></td>
	</tr>
	<tr>
		<td>Available Contacts: </td>
		<td>
			<select name="allContactsToAdd" multiple size="6" required="required">
				<c:forEach items="${requestScope.allContacts}" var="currentcontact">
   					<option value = "${currentcontact.contactId}">${currentcontact.firstName} ${currentcontact.lastName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type = "submit" value="Add Address"></td>
	</tr>
</table>
</form>
</body>
</html>