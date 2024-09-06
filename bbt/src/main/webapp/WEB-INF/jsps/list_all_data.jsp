<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="menu.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DATA'S FROM DATABASE LEADS</title> 
</head>
<body>
<h2>LIST ALL LEADS</h2>
 
<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Delete</th>
<th>Update</th>
</tr>
<c:forEach var="leads" items="${leads}">
<tr >
<td>${leads.fname}</td>
<td>${leads.lname}</td>
<td>${leads.email}</td>
<td>${leads.mobile}</td>
<td><a href="deletelead?id=${leads.id}">Delete</a>
<td><a href="updatelead?id=${leads.id}">Update</a>
</tr>
</c:forEach>
</table>
</body>
</html>