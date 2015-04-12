<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  		<title>Mon Epicerie</title>
	</head>
	<body>
		<h1>Mon Epicerie</h1>
		
		<c:if test="${not empty greetingList}">
			<c:forEach items="${greetingList}" var="greeting" >
				<br/><b>@Anonymous</b> says<br/>
				on <c:out value="<%= new java.util.Date() %>" /><br/>
				<c:out value="${greeting.greetingText}" /><br/>
			</c:forEach>
		</c:if>
		<c:if test="${empty greetingList}">
			There are no greetings yet.
		</c:if>
		
		<p><a href="/epicerie/home/addgreeting.html">Add greeting</a><br/>
		<a href="/epicerie/">Home</a>
		
	</body>
</html>