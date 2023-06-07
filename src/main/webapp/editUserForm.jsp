<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>
    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        Name: <input type="text" name="name" value="${user.name}">
        <br><br>
        Email: <input type="email" name="email" value="${user.email}">
        <br><br>
        Address: <input type="text" name="address" value="${user.address}">
        <br><br>
        <input type="submit" value="Save">
    </form>

</body>
</html>