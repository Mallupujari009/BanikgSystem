<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            padding: 20px;
            background-color: #f4f4f9;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #4CAF50;
        }
        p {
            font-size: 16px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
	<%
	session = request.getSession();
	out.println(session.getAttribute("sal"));
	out.println("<br>");
	out.println(session.getAttribute("ral"));
	out.println("<br>");
	out.println(session.getAttribute("al"));
	out.println("<br>");
	
	%>
</body>
</html>