<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
<jsp:include page="/WEB-INF/fragments/style-include.jsp" />

<title><tiles:getAsString name="title"/></title>
</head>

<body class="cm-no-transition cm-1-navbar">
	<header id="cm-header">
		<tiles:insertAttribute name="header" />
	</header>

	<div id="sidebar">
		<tiles:insertAttribute name="sidebar" />
	</div>

	<div id="global">
		<tiles:insertAttribute name="body" />
		<footer class="cm-footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
	<jsp:include page="/WEB-INF/fragments/js-include.jsp" />
</body>
</html>