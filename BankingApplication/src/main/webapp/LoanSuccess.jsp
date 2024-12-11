<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful</title>
</head>
<body>
	<%
	session = request.getSession();
	out.println("Dear"+session.getAttribute("name")+"Thank you for showing Your Interest");
	out.println("<br>");
	out.println("Our Manager will Contact Through Email");
	out.println(session.getAttribute("email"));	
	
	%>
</body>
</html>