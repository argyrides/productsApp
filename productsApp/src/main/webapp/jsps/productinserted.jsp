<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserted Successfully</title>
</head>
<body>
	<h1>Product inserted successfully!</h1>
	<div>
	    <p>${insertedproduct.productName}</p>
		<p>${insertedproduct.price}</p>
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/jsps/productsmenu.jsp">Return to menu</a>
	</div>
</body>
</html>