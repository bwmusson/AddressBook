<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book</title>
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
<h1>All Phones</h1>
<form method = "post" action = "phoneNavigationServlet">
<table>
<c:forEach items="${requestScope.allContacts}" var="currentcontact">
<tr>
   <td></td>
   <td><strong>${currentcontact.firstName} ${currentcontact.lastName}</strong></td></tr>
      <c:forEach var = "listVal" items = "${currentcontact.contactPhones}">
            <tr>
            <td><input type="radio" name="id" value="${listVal.phoneId}" onclick="setContId(${currentcontact.contactId});"></td>
            <td colspan="3">
                ${listVal.type}: ${listVal.number}
                </td>
            </tr>
  </c:forEach>
</c:forEach>

<tr>
<td><select name="contId" id="contId" hidden="hidden">
<c:forEach items="${requestScope.allContacts}" var="currentcontact">
   <option value = "${currentcontact.contactId}">${currentcontact.firstName} ${currentcontact.lastName}</option>
</c:forEach>
</select></td>
<td><input type = "submit" value = "Edit" name="doThisToItem">
<input type = "submit" value = "Delete" name="doThisToItem">
<input type="submit" value = "Add New" name = "doThisToItem"></td>
</tr>
</table>
</form>
<script>
var sel = document.getElementById('contId');
function setContId(contId){
	var opts = sel.options;
	  for (var opt, j = 0; opt = opts[j]; j++) {
	    if (opt.value == contId) {
	      sel.selectedIndex = j;
	      break;
	    }
	  }
}
</script>
</body>
</html>