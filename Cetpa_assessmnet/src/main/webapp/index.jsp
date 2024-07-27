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

.form-container {
	width: 80%;
}

.form-group {
	margin: 10px 0;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
}

.form-group input {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
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
</head>
<body>
	<header>
		<h1>Cetpa Infotech Pvt. Ltd</h1>
	</header>
	<div class="container">
		<div class="left">
			<div class="buttons">
				<button onclick="showForm('login')">Login</button>
				<button onclick="showForm('registration')">Registration</button>
			</div>
		</div>
		<div class="right">
			<div class="form-container" id="form-container">
				<!-- Forms will be displayed here -->
			
	</div>
	<footer> &copy; 2024 Cetpa Infotech Pvt. Ltd </footer>

	<script>
        function showForm(type) {
            const formContainer = document.getElementById('form-container');
            if (type === 'login') {
                formContainer.innerHTML = `
                    <form action="loginServlet" method="post">
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type="text" id="username" name="username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" id="password" name="password">
                        </div>
                        <button type="submit">Submit</button>
                    </form>
                `;
            } else if (type === 'registration') {
                formContainer.innerHTML = `
                    <form action="SaveNoteServlet" method="post">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name">
                        </div>
                        <div class="form-group">
                            <label for="employeeCode">Employee Code:</label>
                            <input type="text" id="employeeCode" name="employeeCode">
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email">
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input type="text" id="address" name="address">
                        </div>
                        <div class="form-group">
                            <label for="profile">Profile:</label>
                            <input type="text" id="profile" name="profile">
                        </div>
                        <div class="form-group">
                        <label for="profile">Password:</label>
                        <input type="Password" id="profile" name="Password">
                    </div>
                        <button type="submit">Submit</button>
                    </form>
                `;
            }
        }
    </script>
</body>
</html>
