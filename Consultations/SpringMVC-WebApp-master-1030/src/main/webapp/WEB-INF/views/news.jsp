<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News page</title>
</head>
<body>

	<h1>News page</h1>
	<hr>
	
	<c:forEach items="${newsModel}" var="news">
		<a href="${pageContext.request.contextPath}/news/${news}">Show info for ${news}</a> <br />
	</c:forEach>
	
</body>
</html>