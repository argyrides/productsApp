<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Deleted</title>
</head>
<body>
	
	<p> Id : ${product.id}, Name: ${product.productName}, Price: ${product.price} </p>
	<a href="${pageContext.request.contextPath}/jsps/productsmenu.jsp">Return to Menu</a>
</body>
</html>