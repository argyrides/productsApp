<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>Id</th>
			    <th>Product Name</th>
				<th>Price</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.price}</td>
					<td><a href="${pageContext.request.contextPath}/delete?id=${product.id}&pName=${product.productName}&price=${product.price}">Delete</a></td>
					<td><a href="${pageContext.request.contextPath}/jsps/productupdate.jsp?id=${product.id}&pName=${product.productName}&price=${product.price}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div>
		<c:if test="${deleteAPIError}">
			<p>Something went wrong with Delete :(</p>
		</c:if>
	</div>
	
		<div>
		<c:if test="${updateAPIError}">
			<p>Something went wrong with Update :(</p>
		</c:if>
	</div>
	
</body>
</html>