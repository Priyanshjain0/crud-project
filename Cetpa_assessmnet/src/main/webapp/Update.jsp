<%@ page import="Entites.Registation" %>
<%@ page import="com.Servlet.loginServlet" %>
<%@ page import="com.service_implimentation.loginHandler_implimentation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cetpa Infotech Pvt. Ltd</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    height: 100vh;
}
header {
    background-color: #4CAF50;
    color: white;
    text-align: center;
    padding: 20px;
    position: relative;
}
header .logout {
    position: absolute;
    top: 20px;
    right: 20px;
}
header .logout button {
    background-color: #f44336;
    color: white;
    border: none;
    padding: 10px;
    cursor: pointer;
}
header .logout button:hover {
    background-color: #d32f2f;
}
.container {
    display: flex;
    flex: 1;
    overflow: hidden;
}
.left, .right {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: center;
}
.left {
    background-color: #f0f0f0;
    border-right: 2px solid #ddd;
}
.right {
    background-color: #fff;
    padding: 20px; /* Add padding to ensure content does not touch the edges */
}
.buttons {
    text-align: center;
}
.buttons button {
    display: block;
    width: 150px;
    margin: 10px auto;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
}
.buttons button:hover {
    background-color: #45a049;
}
.content-container {
    width: 100%;
    max-width: 600px; /* Limit maximum width */
    text-align: center;
}
form {
    display: flex;
    flex-direction: column;
    align-items: center;
}
form input, form button {
    margin: 10px 0;
    padding: 10px;
    width: 100%;
}
footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px;
}
</style>
</head>
<body>
<header>
    <% 
       long id = loginServlet.id;
       loginHandler_implimentation data = new loginHandler_implimentation();
    %>
    <h1>Cetpa Infotech Pvt. Ltd</h1>
    <h2>Welcome, <%= data.Name_conneted_with_id(id) %>!</h2>
    <form action="index.jsp" method="get" class="logout">
        <button type="submit">Logout</button>
    </form>
</header>
<div class="container">
    <div class="left">
        <div class="buttons">
            <form action="Update.jsp" method="post">
                <button type="submit" name="action" value="update">Update Data</button>
            </form>
            <form action="DeleteServlet" method="post">
                <button type="submit" name="action" value="delete">Delete Data</button>
            </form>
        </div>
    </div>
    <div class="right">
        <div class="content-container">
            <h3>Update Employee Data</h3>
            <% 
                Registation registrationData = data.getEmployeeById(id);
                if (registrationData != null) {
            %>
            <form action="UpdateServlet" method="post">
                <label for="emp_id">Employee Code:</label>
                <input type="text" id="emp_id" name="emp_id" value="<%= registrationData.getEmp_id() %>" readonly>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="<%= registrationData.getEmp_name() %>">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= registrationData.getEmp_email() %>">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="<%= registrationData.getEmp_address() %>">
                <label for="profile">Profile:</label>
                <input type="text" id="profile" name="profile" value="<%= registrationData.getEmp_profile() %>">
                <button type="submit">Update</button>
            </form>
            <% 
                } else { 
            %>
            <p>No registration data available.</p>
            <% 
                } 
            %>
        </div>
    </div>
</div>
<footer>&copy; 2024 Cetpa Infotech Pvt. Ltd</footer>
</body>
</html>
