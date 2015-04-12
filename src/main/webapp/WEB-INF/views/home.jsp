<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Mon Epicerie</title>
	</head>
	<body>
		<h1>Bienvenue a mon Epicerie.</h1>
		<table>
			<c:forEach items="${greetinglist}" var="greeting">
				<tr>
					<td>${greeting.greetingText}</td>
					<td><a href='<c:url value = "/home/editgreetings.html?id=${greeting.id}"/>'>Edit greeting</a></td>
					<td><a href='<c:url value = "/home/deletegreeting.html?id=${greeting.id}"/>'>Delete greeting</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="/epicerie/home/addgreeting.html">Add greeting</a><br/>
		<a href="/epicerie/home/greetings.html">Show all greetings</a><br/>
	</body>
</html>
