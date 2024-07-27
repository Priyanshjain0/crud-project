<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }
        .message {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            border-radius: 5px;
        }
    </style>
     <script>
        // Redirect to index.jsp after 5 seconds
        setTimeout(function(){
            window.location.href = 'index.jsp';
        }, 5000);
    </script>
</head>
<body>
    <div class="message">
        <h1><%= request.getAttribute("message") %></h1>
    </div>
</body>
</html>
