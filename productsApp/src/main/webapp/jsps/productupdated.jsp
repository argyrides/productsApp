<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Updated</title>
</head>
<body>
	<h1>Update Product</h1>
	<p>${product.productName}</p>
	<p>${product.price}</p>
	<a href="${pageContext.request.contextPath}/jsps/productsmenu.jsp">Return to Menu</a>
</body>
</html>