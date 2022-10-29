<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/productsmenu.css">
</head>
<body>
    <div class="center">
        
        <div class="search-wrapper">
	        <div class="bot-gap">
	            <span class="title">Products Search</span>
	        </div>
	        <div class="bot-gap">
	            <form method="GET" action="${pageContext.request.contextPath}/search">
	                <input name="productName" type="text" class="search rounded" placeholder="Insert product's name" autofocus/>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Search</button>
	            </form>
	        </div>
        </div>
        
        <div class="insert-wrapper">
	        <div class="bot-gap">
	            <span class="title">Products Insert</span>
	        </div>
	        <div class="bot-gap">
	            <form method="POST" action="${pageContext.request.contextPath}/insert">
	                <input name="productName" type="text" class="insert rounded" placeholder="Product Name" autofocus/><br>
	                <input name="productPrice" type="text" class="insert rounded" placeholder="Product Price" autofocus/>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Insert</button>
	            </form>
	        </div>
        </div>     
    </div>
    
    <div class="center">
    	<c:if test="${sqlError}">
    		<p>Error in insert. Please try again</p>
    	</c:if>
    </div>
    
     <div class="center">
    	<c:if test="${productsNotFound}">
    		<p>No products found</p>
    	</c:if>
    </div>
</body>
</html>
        
    