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
    height: calc(100vh - 140px); /* Full height minus header and footer */
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
    width: 80%;
    text-align: center;
}
footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px;
    position: absolute;
    bottom: 0;
    width: 100%;
}
</style>
<script>
function confirmDelete() {
    if (confirm("Are you sure you want to delete data?")) {
        document.getElementById("deleteForm").submit();
    }
}
</script>
</head>
<body>
<header>
    <% 
       long id = loginServlet.id;
       loginHandler_implimentation data = new loginHandler_implimentation();
    %>
    <h1>Cetpa Infotech Pvt. Ltd</h1>
    <h2>Welcome, <%= data.Name_conneted_with_id(id) %>!</h2>
    
</header>
<div class="container">
    <div class="left">
        <div class="buttons">
            <form action="Update.jsp" method="post">
                <button type="submit" name="action" value="update">Update Data</button>
            </form>
            <form id="deleteForm" action="DeleteServlet" method="post">
                <button type="button" name="action" value="delete" onclick="confirmDelete()">Delete Data</button>
            </form>
            <form action="index.jsp" method="get" class="logout">
            <button type="submit">Logout</button>
        </form>
        </div>
    </div>
    <div class="right">
        <div class="content-container">
            <h3>Employee Data</h3>
            <% 
                Registation registrationData = data.getEmployeeById(id);
                if (registrationData != null) {
            %>
            <p><strong>Name:</strong> <%= registrationData.getEmp_name() %></p>
            <p><strong>Employee Code:</strong> <%= registrationData.getEmp_id() %></p>
            <p><strong>Email:</strong> <%= registrationData.getEmp_email() %></p>
            <p><strong>Address:</strong> <%= registrationData.getEmp_address() %></p>
            <p><strong>Profile:</strong> <%= registrationData.getEmp_profile() %></p>
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
