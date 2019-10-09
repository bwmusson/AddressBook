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