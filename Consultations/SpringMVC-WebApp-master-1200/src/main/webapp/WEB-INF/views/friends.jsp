<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> ${title} </title>
</head>
<body>
	<h1>My Friends</h1>
	<hr>
	
	<c:forEach items="${friendsList}" var="friend">
		<a href="${pageContext.request.contextPath}/profile/${friend}">Show ${friend} profile</a><br />
	</c:forEach>
	
	<!-- 
		for(String friend : friends) {
			syso(friend);
		}
	 -->
	
</body>
</html>