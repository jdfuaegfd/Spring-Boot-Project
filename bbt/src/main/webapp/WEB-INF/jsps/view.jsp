<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW LEAD</title>
</head>
<body>
<h2>NEW LEAD</h2>
<form action="savelead" method="post">
<pre>
First Name:<input type="text" name="fname"/>

Last Name :<input type="text" name="lname"/>

Email     :<input type="email" name="email"/>

Mobile    :<input type="number" name="mobile"/>

    <input type="submit" value="save"  />
</pre>
</form>
</body>
</html>