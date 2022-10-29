<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css">
</head>
<body>
	    <div class="container-fluid">
        <div class="container">
            <div class="row">
                <h1 class="text-grey">Register</h1>
            </div>  
            <form method="POST" action="${pageContext.request.contextPath}/register">
                <div class="row">
                    <input type="email" name="eMail" required placeholder="E-mail">  
                    <span></span>
                </div>
                <div class="row">
                    <input type="password" name="password" required placeholder="Password"> 
                    <span></span>
                </div>
                <div class="row">
                    <input type="password" name="repeatPassword" required placeholder="Repeat Password"> 
                    <span></span>
                </div>
                <div class="row">
                    <button type="submit">Register</button>
                </div>
            </form>
       	    <a href="${pageContext.request.contextPath}/jsps/login.jsp">Return to Login</a>
       
        </div>    
    </div>
    <div class=container>
    	<c:if test="${passwordError}">
    		<p>Passwords are not equal</p>
    	</c:if>
    	<c:if test="${passwordLengthError}">
    		<p>Password must contains minimum 8 characters</p>
    	</c:if>
        <c:if test="${sqlError}">
			<p>Error in insert. Please try again</p>    	
		</c:if>
		<c:if test="${createdUser}">
			<p>User Created Successfully</p>    	
		</c:if>
		<c:if test="${emailExistError}">
			<p>Email Already Exist</p>    	
		</c:if>
		
    </div> 
</body>
</html>